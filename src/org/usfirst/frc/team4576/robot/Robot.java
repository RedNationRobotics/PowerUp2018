package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4576.robot.subsystems.Chassis;
import org.usfirst.frc.team4576.robot.subsystems.Elevator;
import org.usfirst.frc.team4576.robot.subsystems.Intaker;
import org.usfirst.frc.team4576.robot.subsystems.Pneumatics;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import redcore.BNO055;
import redcore.BNO055.reg_t;

//*******************************************************************
//Robot                            
//Last Edited: 2/28/2018 by RL
//This class contains central methods for periodic control of the bot during the match. 
//Here, we declare our subsystems and set the desired mode for autonomous.
//*******************************************************************
public class Robot extends IterativeRobot {

	public static final Chassis chassis = new Chassis();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Intaker intaker = new Intaker();
	public static final Elevator elevator = new Elevator();

	public static BNO055 imu;
	public static String gameData = DriverStation.getInstance().getGameSpecificMessage();

	public static OI oi;

	public static Joystick driveStick = new Joystick(0);
	public static Joystick secondaryStick = new Joystick(1);

	public int _iCurrentMotionIndex = 0;

	public static Timer t = new Timer();

	public double _CurrentLeftEncoderPosition;
	public double _CurrentRightEncoderPosition;
	public double _CurrentHeading;

	Command teleopCommand;
	Command autonomousCommand;

	final String autoDriveStraight = "DriveStraight";
	final String autoCrossBaseline = "CrossBaseline";
	final String autoLeftSwitch = "LeftSwitch";
	final String autoLeftScale = "LeftScale";
	final String autoRightSwitch = "RightSwitch";
	final String autoRightScale = "RightScale";
	final String autoMiddleSwitch1 = "MiddleSwitch1";
	final String autoMiddleSwitch2 = "MiddleSwitch2";
	final String autoPeriodicOnly = "RunStateMachine";
	final String autoMiddleScale = "MiddleScale";
	final String autoMiddleGear = "MiddleGear";

	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();

	public void robotInit() {

		/* choose the sensor and sensor direction */
		Robot.chassis.tsrxL.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, RobotMap.kPIDLoopIdx,RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.setSensorPhase(false);
		Robot.chassis.tsrxL.setInverted(false);

		Robot.chassis.tsrxR.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, RobotMap.kPIDLoopIdx,RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.setSensorPhase(false);
		Robot.chassis.tsrxR.setInverted(false);

		/* set the peak and nominal outputs, 12V means full */
		Robot.chassis.tsrxL.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);

		Robot.chassis.tsrxR.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);

		/*
		 * set the allowable closed-loop error, Closed-Loop output will be
		 * neutral within this range. See Table in Section 17.2.1 for native
		 * units per rotation.
		 */
		Robot.chassis.tsrxL.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx,RobotMap.kTimeoutMs); /* always servo */
		Robot.chassis.tsrxR.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx,RobotMap.kTimeoutMs); /* always servo */

		/* set closed loop gains in slot0 */
		Robot.chassis.tsrxL.config_kF(RobotMap.kPIDLoopIdx, RobotMap.kF0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.config_kP(RobotMap.kPIDLoopIdx, RobotMap.kP0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.config_kI(RobotMap.kPIDLoopIdx, RobotMap.kI0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.config_kD(RobotMap.kPIDLoopIdx, RobotMap.kD0, RobotMap.kTimeoutMs);

		Robot.chassis.tsrxR.config_kF(RobotMap.kPIDLoopIdx, RobotMap.kF0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.config_kP(RobotMap.kPIDLoopIdx, RobotMap.kP0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.config_kI(RobotMap.kPIDLoopIdx, RobotMap.kI0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.config_kD(RobotMap.kPIDLoopIdx, RobotMap.kD0, RobotMap.kTimeoutMs);

		/* set acceleration and vcruise velocity - see documentation */
		Robot.chassis.tsrxL.configMotionCruiseVelocity(7500, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.configMotionAcceleration(7500, RobotMap.kTimeoutMs);

		Robot.chassis.tsrxR.configMotionCruiseVelocity(7500, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configMotionAcceleration(7500, RobotMap.kTimeoutMs);
		/* zero the sensor */
		Robot.chassis.tsrxL.setSelectedSensorPosition(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.setSelectedSensorPosition(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);

		System.out.println("RNR 2018 Robot Code Powering Up...");
		oi = new OI();

		teleopCommand = new DriveWithJoysticks();

		// camera.setFPS(15);
		// camera.setResolution(320, 240);
		CameraServer.getInstance().startAutomaticCapture("cam0", 0);
		// CameraServer.getInstance().startAutomaticCapture("cam1",1);

		imu = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_IMUPLUS, BNO055.vector_type_t.VECTOR_EULER);

		chooser.addDefault("Do Nothing.", null);
		chooser.addObject("Finite State Machine", autoCrossBaseline);
		chooser.addObject("Other thing", autoLeftSwitch);

		SmartDashboard.putData("Auto Choices", chooser);
	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		/* clear our buffer and put everything into a known state */
		Robot.chassis.tsrxL.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);

		autoSelected = chooser.getSelected();
	}

	public void UpdateDriveCoreComponents() {
		_CurrentLeftEncoderPosition = Robot.chassis.tsrxL.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);
		_CurrentRightEncoderPosition = Robot.chassis.tsrxR.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);
		_CurrentHeading = imu.getHeading();

		SmartDashboard.putNumber("BNO055 Heading :", _CurrentHeading);
		SmartDashboard.putNumber("Left Encoder", _CurrentLeftEncoderPosition);
		SmartDashboard.putNumber("Right Encoder", _CurrentRightEncoderPosition);
	}




	// *************** FSM zone ***************
	// ****************************************
	public enum EAutoStates {
		eDriveForward, eTurnRight, eChained_MoveWait, eStopMotors, eEmergencyStop, eIdle, eTurn90Degrees, eCheckFieldColor
		}

	public EAutoStates _eCurrentAutoState; // current auto state

	public class MotionItem {
		public EAutoStates eAutoState;
		public double dParam1;

		// constructor to take two values
		public MotionItem(EAutoStates eTempAutoState, double dTempParam1) {
			eAutoState = eTempAutoState;
			dParam1 = dTempParam1;

		}

		// constructor to take one value
		public MotionItem(EAutoStates eTempAutoState) {
			eAutoState = eTempAutoState;
			dParam1 = 0.0;
		}

	}

	public double _TargetLeftEncoderPosition;
	public double _TargetRightEncoderPosition;

	public MotionItem[] _Selected_AutoRecipe; // the current array of motion items selected at start of autoInit
	public MotionItem _CurrentMotionItem; // current position in the array
	int _iCurrentMotionItemIndex; // current position in the drive recipe

	// drive move recipe
	public MotionItem[] _CrossBaseline_AutoRecipe = { new MotionItem(EAutoStates.eDriveForward, 50000),
			new MotionItem(EAutoStates.eStopMotors), new MotionItem(EAutoStates.eIdle) };

	// another drive recipe
	public MotionItem[] _Silly_AutoRecipe = {
		new MotionItem(EAutoStates.eTurnRight, 50000),
		new MotionItem(EAutoStates.eStopMotors), 
		new MotionItem(EAutoStates.eIdle) 
	};
	
	public MotionItem[] _LeftStation_LeftSwitch = {
		new MotionItem(EAutoStates.eDriveForward, 10000),
		new MotionItem(EAutoStates.eTurn90Degrees, 30000),
		new MotionItem(EAutoStates.eDriveForward, 50000), 
		new MotionItem(EAutoStates.eCheckFieldColor), 
		new MotionItem(EAutoStates.eStopMotors), 
		new MotionItem(EAutoStates.eIdle)

	};
	public static final double _dMoveTolerance = 25.0;

	public void MoveToNextMotionItemInSelectedRecipe() {
		_iCurrentMotionItemIndex++; // move to the next motion item in the auto recipe
		_CurrentMotionItem = _Selected_AutoRecipe[_iCurrentMotionItemIndex];
		_eCurrentAutoState = _CurrentMotionItem.eAutoState;
	}

	public boolean IsCloseEnough() {
		double dLeftError = Math.abs(_TargetLeftEncoderPosition - _CurrentLeftEncoderPosition);
		double dRightError = Math.abs(_TargetRightEncoderPosition - _CurrentRightEncoderPosition);
		return (dLeftError < _dMoveTolerance && dRightError < _dMoveTolerance);
	}

	public void UpdateFSM() {
		switch(_eCurrentAutoState){

			case eIdle: // do nothing
				break;


			case eDriveForward:
				{
					System.out.println("Hit eDriveForward");
					_TargetLeftEncoderPosition = _CurrentLeftEncoderPosition  + _CurrentMotionItem.dParam1; 
					_TargetRightEncoderPosition = _CurrentRightEncoderPosition + _CurrentMotionItem.dParam1; 
					Robot.chassis.tsrxL.set(ControlMode.MotionMagic, _TargetLeftEncoderPosition);
					Robot.chassis.tsrxR.set(ControlMode.MotionMagic, _TargetRightEncoderPosition);
					_eCurrentAutoState = EAutoStates.eChained_MoveWait; // chained event, first to move, then check
					System.out.println("Hit eDriveForward (" + _TargetLeftEncoderPosition + ", " + _TargetRightEncoderPosition + ")");
				}
				
			case eTurn90Degrees:
			{
				_TargetLeftEncoderPosition = _CurrentLeftEncoderPosition  + _CurrentMotionItem.dParam1; 
				_TargetRightEncoderPosition = _CurrentRightEncoderPosition + _CurrentMotionItem.dParam1;
				Robot.chassis.tsrxL.set(ControlMode.MotionMagic, _TargetLeftEncoderPosition); // forward 
				Robot.chassis.tsrxR.set(ControlMode.MotionMagic, -_TargetRightEncoderPosition);// back
				MoveToNextMotionItemInSelectedRecipe();

			}
				
				break;
			case eCheckFieldColor:
			{
			
				if (Robot.gameData.charAt(0) == 'L')/* need the left driverstation left switch data, go on the first website*/ {
					
					_eCurrentAutoState = EAutoStates.eDriveForward; // chained event, first to move, then check
				}
				if (Robot.gameData.charAt(0) == 'R')/*need the left driverstation right switch data, go on the first website*/ {
					
				}
				MoveToNextMotionItemInSelectedRecipe();

			}
			break;

			case eChained_MoveWait:
				{
					if (IsCloseEnough()) {
						System.out.println("Hit eChained_MoveWait (" + _CurrentLeftEncoderPosition + ", " + _CurrentRightEncoderPosition + ")");
						MoveToNextMotionItemInSelectedRecipe();
					}
				}
				break; 
			case eStopMotors:  
			{
				Robot.chassis.tsrxL.set(ControlMode.PercentOutput, 0);
				Robot.chassis.tsrxR.set(ControlMode.PercentOutput, 0);
		switch (_eCurrentAutoState) {

		case eIdle: // do nothing
			break;

		case eDriveForward: {
			System.out.println("Hit eDriveForward");
			_TargetLeftEncoderPosition = _CurrentLeftEncoderPosition + _CurrentMotionItem.dParam1;
			_TargetRightEncoderPosition = _CurrentRightEncoderPosition + _CurrentMotionItem.dParam1;
			Robot.chassis.tsrxL.set(ControlMode.MotionMagic, -_TargetLeftEncoderPosition);
			Robot.chassis.tsrxR.set(ControlMode.MotionMagic, _TargetRightEncoderPosition);
			_eCurrentAutoState = EAutoStates.eChained_MoveWait; // chained
																// event, first
																// to move, then
																// check
			System.out.println(
					"Hit eDriveForward (" + _TargetLeftEncoderPosition + ", " + _TargetRightEncoderPosition + ")");
		}
			break;

		case eChained_MoveWait: {
			if (IsCloseEnough()) {
				System.out.println("Hit eChained_MoveWait (" + _CurrentLeftEncoderPosition + ", "
						+ _CurrentRightEncoderPosition + ")");
				MoveToNextMotionItemInSelectedRecipe();
			}
		}
			break;
		case eStopMotors: {
			Robot.chassis.tsrxL.set(ControlMode.PercentOutput, 0);
			Robot.chassis.tsrxR.set(ControlMode.PercentOutput, 0);
			MoveToNextMotionItemInSelectedRecipe();
		}
			break;

		case eEmergencyStop:
		default: // unknown, bad things without this .. when in doubt, idle
			// emergency stop
			Robot.chassis.tsrxL.set(ControlMode.PercentOutput, 0);
			Robot.chassis.tsrxR.set(ControlMode.PercentOutput, 0);
			_eCurrentAutoState = EAutoStates.eIdle;
			break;
		}
		}
		}
	}

	public void InitializeAutoRecipe(MotionItem[] AutoRecipe) {
		System.out.println("Hit InitializeAutoRecipe");

		_Selected_AutoRecipe = AutoRecipe;

		_iCurrentMotionItemIndex = 0; // We use this to keep track of the current motion item in the recipe
		
		_CurrentMotionItem = _Selected_AutoRecipe[_iCurrentMotionItemIndex]; // Set the current motion item from the selected drive recipe
															
		_eCurrentAutoState = _CurrentMotionItem.eAutoState; // Set the starting state from the drive recipe
	}
	// *************** End FSM zone ***************
	// ********************************************

	// *************** Start Auto zone ***************
	// ***********************************************
	public void autonomousInit() {
		_eCurrentAutoState = EAutoStates.eEmergencyStop; // just to make sure
		UpdateFSM();

		autoSelected = chooser.getSelected();
		System.out.println(autoSelected);
		switch (autoSelected) {
		case autoDriveStraight:
			break;
		case autoCrossBaseline:
			System.out.println("Hit autoCrossBaseline");
			InitializeAutoRecipe(_CrossBaseline_AutoRecipe);
			break;
		case autoLeftSwitch:
			break;
		case autoLeftScale:
			break;
		case autoRightSwitch:
			break;
		case autoRightScale:
			break;
		case autoMiddleSwitch1:
			break;
		case autoMiddleSwitch2:
			break;
		case autoPeriodicOnly:
			break;
		case autoMiddleScale:
			break;
		default:
			break;

		}

		System.out.println("Auto selected: " + autoSelected);

		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		UpdateDriveCoreComponents();
		UpdateFSM();
	}
	// *************** End Auto zone ***************
	// *********************************************

	// *************** Start Teleop zone ***************
	// *************************************************
	public void teleopInit() {
		_eCurrentAutoState = EAutoStates.eEmergencyStop; // just to make sure
		UpdateFSM();

		if (autonomousCommand != null)
			autonomousCommand.cancel();
		teleopCommand.start();

	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		UpdateDriveCoreComponents(); // shared with auto
		UpdateFSM();

		SmartDashboard.putNumber("Accelerometer", reg_t.BNO055_ACCEL_DATA_X_LSB_ADDR.getVal());
		SmartDashboard.putNumber("Magnometer", reg_t.BNO055_MAG_DATA_X_LSB_ADDR.getVal());
		SmartDashboard.putNumber("Gyro", reg_t.BNO055_GYRO_DATA_X_LSB_ADDR.getVal());
		//SmartDashboard.putNumber("Course: ", Robot.driveStick.getRawAxis(4));
		SmartDashboard.putBoolean("True = Compressor Low: ", pneumatics.c.getPressureSwitchValue());
		// SmartDashboard.putData("Autoshift: ", new ToggleAutoShift());
		SmartDashboard.putBoolean("True = High gear, False = Low gear", pneumatics.getShift());
		SmartDashboard.putNumber("Elevator Encoder", Robot.elevator.tsrxE.getSelectedSensorPosition(1));
		SmartDashboard.putNumber("Rpm left: ", Robot.chassis.getLeftSpeed());
		SmartDashboard.putNumber("Rpm right: ", Robot.chassis.getRightSpeed());
		SmartDashboard.putNumber("Left Amps", Robot.chassis.getLAmps());
		SmartDashboard.putNumber("Right Amps", Robot.chassis.getRAmps());
		SmartDashboard.putNumber("Psi: ", pneumatics.getPsi());
		// SmartDashboard.putString("Shift state: ", pneumatics.shiftState());

	}

	public void testPeriodic() {
		LiveWindow.setEnabled(true);
	}
	// *************** End Teleop zone
	// **********************************************************

}