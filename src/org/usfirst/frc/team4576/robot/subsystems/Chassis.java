package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.Robot;
import org.usfirst.frc.team4576.robot.RobotMap;
import org.usfirst.frc.team4576.robot.commands.DriveWithJoysticks;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//*******************************************************************
//Chassis subsystem				Author: Robert Lohmann
//								Last Edited: 2/12/2018 by RL
//This is where all the essential code for the drivetrain lives.
//includes encoders, talons, and normaldrive
//*******************************************************************
public class Chassis extends Subsystem {

	double rpm = 0;
	
	public Chassis() {
		tsrxL2.follow(tsrxL);
		tsrxR2.follow(tsrxR);	
	}

	boolean manualOverride = false;
	
	//public AnalogGyro gyro = new AnalogGyro(1);
	
	public WPI_TalonSRX tsrxL = new WPI_TalonSRX(RobotMap.LEFT_MASTER);
	public WPI_TalonSRX tsrxR = new WPI_TalonSRX(RobotMap.RIGHT_MASTER);
	public WPI_TalonSRX tsrxL2 = new WPI_TalonSRX(RobotMap.LEFT_SLAVE);
	public WPI_TalonSRX tsrxR2 = new WPI_TalonSRX(RobotMap.RIGHT_SLAVE);
	
	
	//Relay flashlight = new Relay(RobotMap.FLASHLIGHT_PWM);
	// private Value currentValue; 
	// This defines the talons used to drive.
	//RobotDrive drive = new RobotDrive(tsrxL, tsrxR);
	DifferentialDrive drive = new DifferentialDrive(tsrxL,tsrxR);
	// These lines declare the axes for turning
	public static final int FORWARD_AXIS = 1;
	public static final int TURN_AXIS = 4;
	
	public int absolutePositionL = tsrxL.getSelectedSensorPosition(RobotMap.kTimeoutMs) & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */	
	public int absolutePositionR = tsrxR.getSelectedSensorPosition(RobotMap.kTimeoutMs) & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */

	PowerDistributionPanel pdp = new PowerDistributionPanel();

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
	}

	// This defines whether a talon is on the right or left.
	public void setLeftRight(double left, double right) {
		tsrxL.set(left);
		tsrxR.set(right);

	}

	public void disable() {
		tsrxL.disable();
		tsrxR.disable();

	}

	public void initAuto() {
		drive.setSafetyEnabled(false);
		tsrxL.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.kPIDLoopIdx,RobotMap.kTimeoutMs);
		tsrxR.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.kPIDLoopIdx,RobotMap.kTimeoutMs);

		/* choose to ensure sensor is positive when output is positive */
		tsrxL.setSensorPhase(RobotMap.kSensorPhase);
		tsrxR.setSensorPhase(RobotMap.kSensorPhase);

		/* choose based on what direction you want forward/positive to be.
		 * This does not affect sensor phase. */ 
		tsrxL.setInverted(RobotMap.kMotorInvert);
		tsrxR.setInverted(RobotMap.kMotorInvert);


		/* set the peak and nominal outputs, 12V means full */
		tsrxL.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		tsrxL.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		tsrxL.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		tsrxL.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);
		
		tsrxR.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		tsrxR.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		tsrxR.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		tsrxR.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);
		/*
		 * set the allowable closed-loop error, Closed-Loop output will be
		 * neutral within this range. See Table in Section 17.2.1 for native
		 * units per rotation.
		 */
		tsrxL.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
		tsrxR.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
		/* set closed loop gains in slot0, typically kF stays zero. */
		tsrxL.config_kF(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		tsrxL.config_kP(RobotMap.kPIDLoopIdx, 0.1, RobotMap.kTimeoutMs);
		tsrxL.config_kI(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		tsrxL.config_kD(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		
		tsrxR.config_kF(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		tsrxR.config_kP(RobotMap.kPIDLoopIdx, 0.1, RobotMap.kTimeoutMs);
		tsrxR.config_kI(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		tsrxR.config_kD(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		/*
		 * lets grab the 360 degree position of the MagEncoder's absolute
		 * position, and intitally set the relative sensor to match.
		 */
		/* mask out overflows, keep bottom 12 bits */
		absolutePositionL &= 0xFFF;
		absolutePositionR &= 0xFFF;
		if (RobotMap.kSensorPhase)
			absolutePositionL *= -1;
			absolutePositionR *= -1;
		if (RobotMap.kMotorInvert)
			absolutePositionL *= -1;
			absolutePositionR *= -1;
		/* set the quadrature (relative) sensor to match absolute */
		tsrxL.setSelectedSensorPosition(absolutePositionL, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
		tsrxR.setSelectedSensorPosition(absolutePositionR, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
	}
        

	public void initTeleop() {
		drive.setSafetyEnabled(false);
	}

	// This declares that for driving only the assigned axes are used.
	public void normalDrive() {
	
		drive.arcadeDrive(Robot.driveStick.getRawAxis(FORWARD_AXIS), Robot.driveStick.getRawAxis(TURN_AXIS));
	}
}