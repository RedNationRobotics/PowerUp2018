package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4576.robot.subsystems.Chassis;
import org.usfirst.frc.team4576.robot.subsystems.Elevator;
import org.usfirst.frc.team4576.robot.subsystems.Intaker;
import org.usfirst.frc.team4576.robot.subsystems.Pneumatics;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.CameraServer;
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

public class Robot extends IterativeRobot {

	public static final Chassis chassis = new Chassis();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Intaker intaker = new Intaker();
	public static final Elevator elevator = new Elevator();
	public static BNO055 imu;
	public static Joystick driveStick1  = new Joystick(4);
	
	public static OI oi;

	public static Joystick driveStick = new Joystick(0);
	public static Joystick secondaryStick = new Joystick(0);

	public static Timer t = new Timer();


	Command teleopCommand;
	Command autonomousCommand;

	final String autoCrossBaseline = "CrossBaseline";
	final String autoMiddleGear = "MiddleGear";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	

	public void robotInit() {
		/* choose the sensor and sensor direction */		
		
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
        Robot.chassis.tsrxL.config_kP(RobotMap.kPIDLoopIdx, 0.2, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxL.config_kI(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxL.config_kD(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs); 
        
        Robot.chassis.tsrxR.config_kF(RobotMap.kPIDLoopIdx, 0.2, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxR.config_kP(RobotMap.kPIDLoopIdx, 0.2, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxR.config_kI(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxR.config_kD(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
        
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
		CameraServer.getInstance().startAutomaticCapture("cam0", 0);
		
		imu = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_IMUPLUS,
				BNO055.vector_type_t.VECTOR_EULER);
		// CameraServer.getInstance().startAutomaticCapture("cam1",1);

		chooser.addDefault("Do Nothing.", null);
		chooser.addObject("Middle Gear Auto w/ gyro", autoMiddleGear);
		// chooser.addObject("Right Gear Auto", autoRightGear);

	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
        /* clear our buffer and put everything into a known state */
        Robot.chassis.tsrxL.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);
        Robot.chassis.tsrxR.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);
		autoSelected = chooser.getSelected();
	}
	
	public enum EAutoStates {
		eStartDriving,
		eCheckEncoderCount,
		eTurnRight,
		eCheckEncoderCount1,
		eStopMotors,
		eGoForwardRight,
		eCheckEncoderCount2,
		eStopMotors1
		
	}
	
	public EAutoStates _eAutoState;

	public void autonomousInit() {
		
		_eAutoState = EAutoStates.eStartDriving;

		autoSelected = chooser.getSelected();


		System.out.println("Auto selected: " + autoSelected);

		if (autonomousCommand != null)
			autonomousCommand.start();

	} 
	
	public double TargetPosL = -101000;
	public double TargetPosR = 100000;
	
	public void autonomousPeriodic() {
		double lencoder = Robot.chassis.tsrxL.getSelectedSensorPosition(RobotMap.kPIDLoopIdx); 
		double rencoder = Robot.chassis.tsrxR.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);
		
		switch(_eAutoState) {
		case eStartDriving:
		{
			Robot.chassis.tsrxL.set(ControlMode.MotionMagic, TargetPosL);
			Robot.chassis.tsrxR.set(ControlMode.MotionMagic, TargetPosR);
			//Robot.chassis.tsrxL.set(ControlMode.Velocity, VelocityL);
			//Robot.chassis.tsrxR.set(ControlMode.Velocity, VelocityR);
			_eAutoState = EAutoStates.eCheckEncoderCount;
		}
			break;
		case eCheckEncoderCount:
		{
			if(lencoder <= (TargetPosL +25) && rencoder >= (TargetPosR -25)) { 
				_eAutoState = EAutoStates.eTurnRight;
			}
		}
			break;
		case eTurnRight:
		{
			Robot.chassis.tsrxL.set(ControlMode.MotionMagic, TargetPosL - 36000);
			Robot.chassis.tsrxR.set(ControlMode.MotionMagic, TargetPosR - 36000);
			_eAutoState = EAutoStates.eCheckEncoderCount1;


		}
			break;
		case eCheckEncoderCount1: 
		{
			if(lencoder >= (TargetPosL +25) && rencoder >= (TargetPosR -25)) { 
				_eAutoState = EAutoStates.eStopMotors;
			}
		}
			break;
		case eStopMotors: 
		{
			Robot.chassis.tsrxL.set(ControlMode.PercentOutput, 0);
			Robot.chassis.tsrxR.set(ControlMode.PercentOutput, 0);
			_eAutoState = EAutoStates.eGoForwardRight;

		}
			break;
		case eGoForwardRight: 
		{
			Robot.chassis.tsrxL.set(ControlMode.MotionMagic, TargetPosL - 20000);
			Robot.chassis.tsrxR.set(ControlMode.MotionMagic, TargetPosR + 20000);
			_eAutoState = EAutoStates.eCheckEncoderCount2;

		}
			break;
		case eCheckEncoderCount2: 
		{
			if(lencoder >= (TargetPosL +25) && rencoder >= (TargetPosR -25)) { 
				_eAutoState = EAutoStates.eStopMotors1;
			}
		}
			break;
		case eStopMotors1: 
		{
			Robot.chassis.tsrxL.set(ControlMode.PercentOutput, 0);
			Robot.chassis.tsrxR.set(ControlMode.PercentOutput, 0);
		}
			break;
	}
		SmartDashboard.putNumber("BNO055 Heading :", imu.getHeading());
		SmartDashboard.putNumber("Left Encoder", lencoder);
		SmartDashboard.putNumber("Right Encoder", rencoder);
		/*
		switch(_eAutoState) {
		case eInit:
		{
			// grab time into member
			Timer.getFPGATimestamp();
			_eAutoState = EAutoStates.eStartDriveStraight;
		}
			break;
		case eStartDriveStraight:
		{
			// turn on motors forward
			Robot.chassis.setLeftRight(-0.2, 0.2);
			Timer.delay(2);
			_eAutoState = EAutoStates.eCheckStraightDriveTime;
		}
			break;
		case eCheckStraightDriveTime:
		{
			// get time
			  //Timer.getFPGATimestamp();... try this if t.get() doesnt work on monday.
			Robot.chassis.setLeftRight(-.4, -.4);
			Timer.delay(1);
			_eAutoState = EAutoStates.eAllStop;
		}
			break;
		case eAllStop:
		{
			// turn off motors
			_eAutoState = EAutoStates.eJustWait;
		}
			break;
		case eJustWait:
		{
			double timeLeft = Timer.getMatchTime();
			Timer.delay(timeLeft);
		}
			break;
		}
		*/
		Scheduler.getInstance().run();

	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		teleopCommand.start();

	}
	

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Left Encoder", Robot.chassis.tsrxL.getSelectedSensorPosition(RobotMap.CHASSIS_PID));
		SmartDashboard.putNumber("Right Encoder", Robot.chassis.tsrxR.getSelectedSensorPosition(RobotMap.CHASSIS_PID));
		SmartDashboard.putNumber("psensor PSI", Robot.pneumatics.getPsi());
		SmartDashboard.putNumber("BNO Heading", imu.getHeading());
		SmartDashboard.putNumber("Elevator Encoder", Robot.elevator.tsrxE.getSelectedSensorPosition(1));
		SmartDashboard.putNumber("Left Amps", Robot.chassis.getLAmps());
		SmartDashboard.putNumber("Right Amps", Robot.chassis.getRAmps());
		SmartDashboard.putNumber("Left Speed", Robot.chassis.getLeftSpeed());
		SmartDashboard.putNumber("Right Speed", Robot.chassis.getRightSpeed());
		
		//SmartDashboard.putNumber("Amperage", );
		SmartDashboard.putNumber("Accelerometer", reg_t.BNO055_ACCEL_DATA_X_LSB_ADDR.getVal());
		SmartDashboard.putNumber("Magnometer", reg_t.BNO055_MAG_DATA_X_LSB_ADDR.getVal());
		SmartDashboard.putNumber("Gyro", reg_t.BNO055_GYRO_DATA_X_LSB_ADDR.getVal());
		SmartDashboard.putNumber("Left Encoder", Robot.chassis.tsrxL.getSelectedSensorPosition(RobotMap.kPIDLoopIdx));
		SmartDashboard.putNumber("Right Encoder", Robot.chassis.tsrxR.getSelectedSensorPosition(RobotMap.kPIDLoopIdx));
		SmartDashboard.putNumber("Course: ", Robot.driveStick1.getRawAxis(4));
		//SmartDashboard.putBoolean("True = Compressor Low: ", pneumatics.c.getPressureSwitchValue());
		//SmartDashboard.putString("Compressor state: ", pneumatics.compressorState());
		//SmartDashboard.putData("Autoshift: ", new ToggleAutoShift());
		//SmartDashboard.putString("Shift state: ", pneumatics.shiftState());
		SmartDashboard.putNumber("Rpm left: ", Robot.chassis.tsrxL.getSelectedSensorVelocity(RobotMap.kPIDLoopIdx));
		SmartDashboard.putNumber("Rpm right: ", Robot.chassis.tsrxR.getSelectedSensorVelocity(RobotMap.kPIDLoopIdx));
		//SmartDashboard.putNumber("Psi: ", pneumatics.getPsi());
		SmartDashboard.putNumber("BNO055 Heading :", imu.getHeading());
		//SmartDashboard.putString("Shift state: ", pneumatics.shiftState());

	}

	@SuppressWarnings("deprecation")
	public void testPeriodic() {
		LiveWindow.run();
	}
}
