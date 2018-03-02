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
import redcore.FieldDimensions;
import PowerUp2018.AutoStates.EAutoStates;
import PowerUp2018.MotionItem;
import PowerUp2018.AutoRecipes;



public class Robot extends IterativeRobot {

	public static final Chassis chassis = new Chassis();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Intaker intaker = new Intaker();
	public static final Elevator elevator = new Elevator();

	public static BNO055 imu;
	public static Joystick driveStick1  = new Joystick(4);
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
	final String autoLeftSwitch = "LeftSwitch";
    final String autoLeftScale = "LeftScale";
    final String autoMiddleSwitch = "MiddleSwitch";
    final String autoMiddleScale = "MiddleScale";
    final String autoRightSwitch = "RightSwitch";
    final String autoRightScale = "RightScale";
    final String autoTest = "AutoTest";

	
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	

	public void robotInit() {
		
		/* choose the sensor and sensor direction */
        Robot.chassis.tsrxL.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxL.setSensorPhase(false);
        Robot.chassis.tsrxL.setInverted(false);


        Robot.chassis.tsrxR.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxR.setSensorPhase(false);
        
        /* set the peak and nominal outputs, 12V means full */
        Robot.chassis.tsrxL.configNominalOutputForward(0, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxL.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxL.configPeakOutputForward(1, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxL.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);
        
        Robot.chassis.tsrxR.configNominalOutputForward(0, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxR.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxR.configPeakOutputForward(1, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxR.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);
        
        /* set the allowable closed-loop error,
         * Closed-Loop output will be neutral within this range.
         * See Table in Section 17.2.1 for native units per rotation. 
         */
        Robot.chassis.tsrxL.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs); /* always servo */
        Robot.chassis.tsrxR.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs); /* always servo */

        /* set closed loop gains in slot0 */
        Robot.chassis.tsrxL.config_kF(RobotMap.kPIDLoopIdx, 0.2, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxL.config_kP(RobotMap.kPIDLoopIdx, 1.4, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxL.config_kI(RobotMap.kPIDLoopIdx, 0.008, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxL.config_kD(RobotMap.kPIDLoopIdx, 0.07, RobotMap.kTimeoutMs); 
        
        Robot.chassis.tsrxR.config_kF(RobotMap.kPIDLoopIdx, 0.2, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxR.config_kP(RobotMap.kPIDLoopIdx, 1.4, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxR.config_kI(RobotMap.kPIDLoopIdx, 0.008, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxR.config_kD(RobotMap.kPIDLoopIdx, 0.07, RobotMap.kTimeoutMs);
        
        /* set acceleration and vcruise velocity - see documentation */
        Robot.chassis.tsrxL.configMotionCruiseVelocity(7500, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxL.configMotionAcceleration(7500, RobotMap.kTimeoutMs);
		 
		 Robot.chassis.tsrxR.configMotionCruiseVelocity(7500, RobotMap.kTimeoutMs);
		 Robot.chassis.tsrxR.configMotionAcceleration(7500, RobotMap.kTimeoutMs);
			/* zero the sensor */
		 Robot.chassis.tsrxL.setSelectedSensorPosition(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
		 Robot.chassis.tsrxR.setSelectedSensorPosition(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);

		System.out.println("RNR 2017 Robot Code Initializing...");
		oi = new OI();

		teleopCommand = new DriveWithJoysticks();

		// camera.setFPS(15);
		// camera.setResolution(320, 240);
		//CameraServer.getInstance().startAutomaticCapture("cam0", 0);
		
		imu = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_IMUPLUS,
				BNO055.vector_type_t.VECTOR_EULER);
		// CameraServer.getInstance().startAutomaticCapture("cam1",1);

		chooser.addDefault("Do Nothing.", null);
		chooser.addObject("LeftSide Switch", autoLeftSwitch);
		chooser.addObject("LeftSide Scale", autoLeftScale);
		chooser.addObject("Middle Switch", autoMiddleSwitch);
		chooser.addObject("Middle Scale", autoMiddleScale);
		chooser.addObject("Right Switch", autoRightSwitch);
		chooser.addObject("Right Scale", autoRightScale);
		chooser.addObject("Auto testing", autoTest);

		SmartDashboard.putData("Auto Choices", chooser);
		// chooser.addObject("Right Gear Auto", autoRightGear);

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
		_CurrentLeftEncoderPosition = -Robot.chassis.tsrxL.getSelectedSensorPosition(RobotMap.kPIDLoopIdx); 
		_CurrentRightEncoderPosition = Robot.chassis.tsrxR.getSelectedSensorPosition(RobotMap.kPIDLoopIdx); 
		_CurrentHeading = imu.getHeading();

		SmartDashboard.putNumber("BNO055 Heading :", _CurrentHeading);
		double dDistanceLeft_inches = FieldDimensions.dInchesPerClicks * _CurrentLeftEncoderPosition;
		double dDistanceRight_inches = FieldDimensions.dInchesPerClicks * _CurrentRightEncoderPosition;
		SmartDashboard.putNumber("Left Inches", dDistanceLeft_inches);
		SmartDashboard.putNumber("Right Inches", dDistanceRight_inches);
		SmartDashboard.putNumber("Left Encoder", _CurrentLeftEncoderPosition);
		SmartDashboard.putNumber("Right Encoder", _CurrentRightEncoderPosition);

	}



	// *************** FSM zone **********************************************************
	public EAutoStates _eCurrentAutoState; // current auto state
	public EAutoStates _ePreviousAutoState; // current auto state
	public double _TargetLeftEncoderPosition; 
	public double _TargetRightEncoderPosition;
	public MotionItem[] _Selected_AutoRecipe; // the current array of motion items selected at start of autoInit
	public MotionItem _CurrentMotionItem; // current position in the array
	int _iCurrentMotionItemIndex; // current position in the drive recipe
	public static final double _dMoveTolerance = 100.0;

	
	public void MoveToNextMotionItemInSelectedRecipe() {
		_iCurrentMotionItemIndex++; // move to the next motion item in the auto recipe
		_CurrentMotionItem = _Selected_AutoRecipe[_iCurrentMotionItemIndex];
		_eCurrentAutoState = _CurrentMotionItem.eAutoState;
	}
	
	public boolean IsCloseEnough() {
		double dLeftError = Math.abs(_TargetLeftEncoderPosition + _CurrentLeftEncoderPosition);	
		double dRightError = Math.abs(_TargetRightEncoderPosition - _CurrentRightEncoderPosition);	
		return (dLeftError >_dMoveTolerance && dRightError < _dMoveTolerance);
	}
	
	
	
	public void DriveToTargetEncoderPositions() {
		Robot.chassis.tsrxL.set(ControlMode.MotionMagic, -_TargetLeftEncoderPosition);
		Robot.chassis.tsrxR.set(ControlMode.MotionMagic, _TargetRightEncoderPosition);
	}
	
	
	
	public void SetTargetEncoderPositionsByInches(double dLeft_inch, double dRight_inch)  {
		_TargetLeftEncoderPosition = _CurrentLeftEncoderPosition  + (dLeft_inch * FieldDimensions.dClicksPerInch); 
		_TargetRightEncoderPosition = _CurrentRightEncoderPosition + (dRight_inch * FieldDimensions.dClicksPerInch); 
	}
	
	
	
	public void UpdateFSM() {
		if (_ePreviousAutoState != _eCurrentAutoState)
			System.out.println(_eCurrentAutoState.name());
		_ePreviousAutoState = _eCurrentAutoState;
		
		switch(_eCurrentAutoState){

			case eIdle: // do nothing
				break;


			case eDriveForward:
				{
					System.out.println("Hit eDriveForward");
					SetTargetEncoderPositionsByInches(_CurrentMotionItem.dParam1, _CurrentMotionItem.dParam1);
					DriveToTargetEncoderPositions();
					_eCurrentAutoState = EAutoStates.eChained_MoveWait; // chained event, first to move, then check
					System.out.println("Hit eDriveForward (" + _TargetLeftEncoderPosition + ", " + _TargetRightEncoderPosition + ")");
				}
				break;
			case eStoppedTurn:
				{
					double dWheelDrive_in = _CurrentMotionItem.dParam1 * FieldDimensions.dInchesPerDegree;
					SetTargetEncoderPositionsByInches(dWheelDrive_in, -dWheelDrive_in);
					DriveToTargetEncoderPositions();
					_eCurrentAutoState = EAutoStates.eChained_MoveWait; // chained event, first to move, then check
				}
				break;
				
			case eSlightlyDriftLeft:
			{
				_TargetLeftEncoderPosition = _CurrentLeftEncoderPosition  + _CurrentMotionItem.dParam1; 
				_TargetRightEncoderPosition = _CurrentRightEncoderPosition + _CurrentMotionItem.dParam1; 
				Robot.chassis.tsrxL.set(ControlMode.MotionMagic, -_TargetLeftEncoderPosition); // forward 
				Robot.chassis.tsrxR.set(ControlMode.MotionMagic, _TargetRightEncoderPosition); 
				_eCurrentAutoState = EAutoStates.eChained_MoveWait; // chained event, first to move, then check
				
			}
			break;
			
			case eTurnLeft:
			{
				_TargetLeftEncoderPosition = _CurrentLeftEncoderPosition  + _CurrentMotionItem.dParam1; 
				_TargetRightEncoderPosition = _CurrentRightEncoderPosition + _CurrentMotionItem.dParam1; 
				Robot.chassis.tsrxL.set(ControlMode.MotionMagic, _TargetLeftEncoderPosition); 
				Robot.chassis.tsrxR.set(ControlMode.MotionMagic, _TargetRightEncoderPosition); 
				_eCurrentAutoState = EAutoStates.eChained_MoveWait;
			}
			break;
			case eTurnRight:
			{
				_TargetLeftEncoderPosition = _CurrentLeftEncoderPosition  + _CurrentMotionItem.dParam1; 
				_TargetRightEncoderPosition = _CurrentRightEncoderPosition + _CurrentMotionItem.dParam1; 
				Robot.chassis.tsrxL.set(ControlMode.MotionMagic, -_TargetLeftEncoderPosition);
				Robot.chassis.tsrxR.set(ControlMode.MotionMagic, -_TargetRightEncoderPosition); 
				_eCurrentAutoState = EAutoStates.eChained_MoveWait;
			}
			break;

			case eChained_MoveWait:
				{
					if (IsCloseEnough()) {
						System.out.println("Hit eChained_MoveWait (" + _CurrentLeftEncoderPosition + ", " + _CurrentRightEncoderPosition + ")");
						MoveToNextMotionItemInSelectedRecipe();
					}
						System.out.print("Check the is Close enough method and see whats wrong because it didn't work :(");
				}
				break; 
			case eStopMotors:  
			{
				Robot.chassis.tsrxL.set(ControlMode.PercentOutput, 0);
				Robot.chassis.tsrxR.set(ControlMode.PercentOutput, 0);
				MoveToNextMotionItemInSelectedRecipe();
			}
			break;
			case eDriveForwardWithLift:  
			{ 
				_TargetLeftEncoderPosition = _CurrentLeftEncoderPosition  + _CurrentMotionItem.dParam1; 
				_TargetRightEncoderPosition = _CurrentRightEncoderPosition + _CurrentMotionItem.dParam1; 
				Robot.chassis.tsrxL.set(ControlMode.MotionMagic, -_TargetLeftEncoderPosition);
				Robot.chassis.tsrxR.set(ControlMode.MotionMagic, _TargetRightEncoderPosition);
				
				if(Robot.elevator.counter1.get() <= 0) {
					Robot.elevator.up();
				}
				else {
					Robot.elevator.stop();
					_eCurrentAutoState = EAutoStates.eChained_MoveWait; // chained event, first to move, then check
				}
			}
			break;
			case eReverse:  
			{ 
				Robot.intaker.release();
				Timer.delay(_CurrentMotionItem.dParam1);
				Robot.intaker.stop();
				if(Robot.elevator.counter2.get() <= 0) {
					
					Robot.elevator.down();
				}
				else {
					Robot.elevator.stop();
					MoveToNextMotionItemInSelectedRecipe();
				}
			}
			break;
			case eLiftUp:  
			{ 
				if(Robot.elevator.counter1.get() <= 0) {
					Robot.elevator.up();
				}
				else {
					Robot.elevator.stop();
					Robot.elevator.counter1.reset();
					MoveToNextMotionItemInSelectedRecipe();
				}
			}
			break;
			case eLiftDown:  
			{ 
				if(Robot.elevator.counter2.get() <= 0) {
					Robot.elevator.down();
				}
				else {
					Robot.elevator.stop();
					Robot.elevator.counter2.reset();
					MoveToNextMotionItemInSelectedRecipe();
				}
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



	public void InitializeAutoRecipe(MotionItem[] AutoRecipe) {
		System.out.println("Hit InitializeAutoRecipe");

		_Selected_AutoRecipe = AutoRecipe;

		_iCurrentMotionItemIndex = 0;  // We use this to keep track of the current motion item in the recipe
		_CurrentMotionItem = _Selected_AutoRecipe[_iCurrentMotionItemIndex];   // Set the current motion item from the selected drive recipe
		_eCurrentAutoState = _CurrentMotionItem.eAutoState; // Set the starting state from the drive recipe
	}
	// *************** End FSM zone **********************************************************

	


	// *************** Start Auto zone **********************************************************
	public void autonomousInit() {		
		_eCurrentAutoState = EAutoStates.eEmergencyStop; // just to make sure
		UpdateFSM();

		autoSelected = chooser.getSelected();
		System.out.println(autoSelected);
		switch (autoSelected) {
        case autoLeftSwitch:
        	if (Robot.gameData.charAt(0) == 'L') {
    			InitializeAutoRecipe(AutoRecipes._LeftSide_LeftSwitch);
    		}
    		if (Robot.gameData.charAt(0) == 'R') {
    			InitializeAutoRecipe(AutoRecipes._LeftSide_RightSwitch);
    		}
            break;
        case autoLeftScale:
    		if (Robot.gameData.charAt(1) == 'L') {
    			InitializeAutoRecipe(AutoRecipes._LeftSide_LeftScale);
    		}
    		if (Robot.gameData.charAt(1) == 'R') {
    			InitializeAutoRecipe(AutoRecipes._LeftSide_RightScale);
    		}
            break;
        case autoMiddleSwitch:
        	if (Robot.gameData.charAt(0) == 'L') {
    			InitializeAutoRecipe(AutoRecipes._MiddleSide_LeftSwitch);
    		}
    		if (Robot.gameData.charAt(0) == 'R') {
    			InitializeAutoRecipe(AutoRecipes._MiddleSide_RightSwitch);
    		}
           break;
        case autoMiddleScale:
        	if (Robot.gameData.charAt(1) == 'L') {
    			InitializeAutoRecipe(AutoRecipes._MiddleSide_LeftScale);
    		}
    		if (Robot.gameData.charAt(1) == 'R') {
    			InitializeAutoRecipe(AutoRecipes._MiddleSide_RightScale);
    		}
            break;
        case autoRightSwitch:
        	if (Robot.gameData.charAt(0) == 'L') {
    			InitializeAutoRecipe(AutoRecipes._RightSide_LeftSwitch);
    		}
    		if (Robot.gameData.charAt(0) == 'R') {
    			InitializeAutoRecipe(AutoRecipes._RightSide_RightSwitch);
    		}
            break;
        case autoRightScale:
        	if (Robot.gameData.charAt(1) == 'L') {
    			InitializeAutoRecipe(AutoRecipes._RightSide_LeftScale);
    		}
    		if (Robot.gameData.charAt(1) == 'R') {
    			InitializeAutoRecipe(AutoRecipes._RightSide_RightScale);
    		}
            break;
        case autoTest:
			InitializeAutoRecipe(AutoRecipes._Test_);
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
	// *************** End Auto zone **********************************************************



	// *************** Start Teleop zone **********************************************************
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

		//SmartDashboard.putNumber("Amperage", );
		SmartDashboard.putNumber("Accelerometer", reg_t.BNO055_ACCEL_DATA_X_LSB_ADDR.getVal());
		SmartDashboard.putNumber("Magnometer", reg_t.BNO055_MAG_DATA_X_LSB_ADDR.getVal());
		SmartDashboard.putNumber("Gyro", reg_t.BNO055_GYRO_DATA_X_LSB_ADDR.getVal());
		SmartDashboard.putNumber("Course: ", Robot.driveStick1.getRawAxis(4));
		//SmartDashboard.putBoolean("True = Compressor Low: ", pneumatics.c.getPressureSwitchValue());
		//SmartDashboard.putString("Compressor state: ", pneumatics.compressorState());
		//SmartDashboard.putData("Autoshift: ", new ToggleAutoShift());
		//SmartDashboard.putString("Shift state: ", pneumatics.shiftState());
		SmartDashboard.putNumber("Rpm left: ", Robot.chassis.tsrxL.getSelectedSensorVelocity(RobotMap.kPIDLoopIdx));
		SmartDashboard.putNumber("Rpm right: ", Robot.chassis.tsrxR.getSelectedSensorVelocity(RobotMap.kPIDLoopIdx));
		//SmartDashboard.putNumber("Psi: ", pneumatics.getPsi());
		//SmartDashboard.putString("Shift state: ", pneumatics.shiftState());
		SmartDashboard.putNumber("Counter Top: ", Robot.elevator.counter1.get());
		SmartDashboard.putNumber("Counter Bottom: ", Robot.elevator.counter2.get());

	}



	@SuppressWarnings("deprecation")
	public void testPeriodic() {
		LiveWindow.run();
	}
	// *************** End Teleop zone **********************************************************


}