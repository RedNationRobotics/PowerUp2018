package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.Robot;
import org.usfirst.frc.team4576.robot.RobotMap;
import org.usfirst.frc.team4576.robot.commands.DriveWithJoysticks;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
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
		tsrxL3.follow(tsrxL);
		tsrxR3.follow(tsrxR);	
	}

	boolean manualOverride = false;
	
	//public AnalogGyro gyro = new AnalogGyro(1);
	
	public WPI_TalonSRX tsrxL = new WPI_TalonSRX(RobotMap.LEFT_MASTER);
	public WPI_TalonSRX tsrxR = new WPI_TalonSRX(RobotMap.RIGHT_MASTER);
	public WPI_TalonSRX tsrxL2 = new WPI_TalonSRX(RobotMap.LEFT_SLAVE);
	public WPI_TalonSRX tsrxR2 = new WPI_TalonSRX(RobotMap.RIGHT_SLAVE);
	public WPI_TalonSRX tsrxL3 = new WPI_TalonSRX(RobotMap.LEFT_SLAVE2);
	public WPI_TalonSRX tsrxR3 = new WPI_TalonSRX(RobotMap.RIGHT_SLAVE2);
	
	
	//Relay flashlight = new Relay(RobotMap.FLASHLIGHT_PWM);
	// private Value currentValue; 
	// This defines the talons used to drive.
	//RobotDrive drive = new RobotDrive(tsrxL, tsrxR);
	DifferentialDrive drive = new DifferentialDrive(tsrxL,tsrxR);
	
	
	public int absolutePositionL = tsrxL.getSelectedSensorPosition(RobotMap.kTimeoutMs) & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */	
	public int absolutePositionR = tsrxR.getSelectedSensorPosition(RobotMap.kTimeoutMs) & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */

	PowerDistributionPanel pdp = new PowerDistributionPanel();

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
	}

	// This defines whether a talon is on the right or left.
	public void setLeftRight(double left, double right) {
		tsrxL.set(ControlMode.PercentOutput, left);
		tsrxR.set(ControlMode.PercentOutput, right);

	}
	public void motionMagicStraight(double positionUnits) {
		tsrxL.set(ControlMode.MotionMagic, positionUnits);
		tsrxR.set(ControlMode.MotionMagic, -positionUnits);
	}

	public void disable() {
		tsrxL.disable();
		tsrxR.disable();

	}

	public void initAuto() {
		drive.setSafetyEnabled(false);
		tsrxL.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 1, 10);
		tsrxR.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 1, 10);
		
		tsrxL.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.CHASSIS_PID,RobotMap.kTimeoutMs);
		tsrxR.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.CHASSIS_PID,RobotMap.kTimeoutMs);

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
		tsrxL.configAllowableClosedloopError(0, RobotMap.CHASSIS_PID, RobotMap.kTimeoutMs);
		tsrxR.configAllowableClosedloopError(0, RobotMap.CHASSIS_PID, RobotMap.kTimeoutMs);
		/* set closed loop gains in slot0, typically kF stays zero. */
		tsrxL.config_kF(RobotMap.CHASSIS_PID, 0.0, RobotMap.kTimeoutMs);
		tsrxL.config_kP(RobotMap.CHASSIS_PID, 0.1, RobotMap.kTimeoutMs);
		tsrxL.config_kI(RobotMap.CHASSIS_PID, 0.0, RobotMap.kTimeoutMs);
		tsrxL.config_kD(RobotMap.CHASSIS_PID, 0.0, RobotMap.kTimeoutMs);
		
		tsrxR.config_kF(RobotMap.CHASSIS_PID, 0.0, RobotMap.kTimeoutMs);
		tsrxR.config_kP(RobotMap.CHASSIS_PID, 0.1, RobotMap.kTimeoutMs);
		tsrxR.config_kI(RobotMap.CHASSIS_PID, 0.0, RobotMap.kTimeoutMs);
		tsrxR.config_kD(RobotMap.CHASSIS_PID, 0.0, RobotMap.kTimeoutMs);
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
		tsrxL.setSelectedSensorPosition(absolutePositionL, RobotMap.CHASSIS_PID, RobotMap.kTimeoutMs);
		tsrxR.setSelectedSensorPosition(absolutePositionR, RobotMap.CHASSIS_PID, RobotMap.kTimeoutMs);
	}
        

	public void initTeleop() {
		drive.setSafetyEnabled(false);
	}

	// This declares that for driving only the assigned axes are used.
	public void normalDrive() {
	
		drive.arcadeDrive(Robot.driveStick.getRawAxis(RobotMap.FORWARD_AXIS), -Robot.driveStick.getRawAxis(RobotMap.TURN_AXIS));
	}
}