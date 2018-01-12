package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.Robot;
import org.usfirst.frc.team4576.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Chassis extends Subsystem {

	double rpm = 0;

	public Chassis() {
		tsrxL2.follow(tsrxL);
		tsrxR2.follow(tsrxR);
	}

	boolean manualOverride = false;

	// public AnalogGyro gyro = new AnalogGyro(1);

	public WPI_TalonSRX tsrxL = new WPI_TalonSRX(RobotMap.LEFT_MASTER);
	public WPI_TalonSRX tsrxR = new WPI_TalonSRX(RobotMap.RIGHT_MASTER);
	public WPI_TalonSRX tsrxL2 = new WPI_TalonSRX(RobotMap.LEFT_SLAVE);
	public WPI_TalonSRX tsrxR2 = new WPI_TalonSRX(RobotMap.RIGHT_SLAVE);

	// Relay flashlight = new Relay(RobotMap.FLASHLIGHT_PWM);
	// private Value currentValue;
	// This defines the talons used to drive.
	// RobotDrive drive = new RobotDrive(tsrxL, tsrxR);
	DifferentialDrive drive = new DifferentialDrive(tsrxL, tsrxR);
	// These lines declare the axes for turning
	public static final int FORWARD_AXIS = 1;
	public static final int TURN_AXIS = 4;
=======
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.AnalogGyro;
//import edu.wpi.first.wpilibj.BuiltInAccelerometer;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem {
	
	double rpm = 0;
	private AnalogGyro gyro = new AnalogGyro(1);
	public Chassis() {
		tsrxL2.changeControlMode(CANTalon.TalonControlMode.Follower);
		tsrxL2.set(tsrxL.getDeviceID());
		tsrxL.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		tsrxR2.changeControlMode(CANTalon.TalonControlMode.Follower);
		tsrxR2.set(tsrxR.getDeviceID());
		tsrxR.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	tsrxR.configEncoderCodesPerRev(768);
		tsrxL.configEncoderCodesPerRev(768);
		/*
		tsrxR.configPeakOutputVoltage(6, -6);
		tsrxL.configPeakOutputVoltage(6, -6);
		tsrxR.configNominalOutputVoltage(0,0);
		tsrxL.configNominalOutputVoltage(0, 0);
		*/
		
		tsrxL.setAllowableClosedLoopErr(0);
		tsrxL.reverseOutput(true);
		tsrxL.reverseSensor(true);
		tsrxR.setAllowableClosedLoopErr(0);
		
		
		//******Commented out encoder to troubleshoot******
		//System.out.println("quadEncoderPos" + quadEncoderPos);
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	boolean manualOverride = false;

	public CANTalon tsrxL = new CANTalon(RobotMap.LEFT_MASTER);
	public CANTalon tsrxR = new CANTalon(RobotMap.RIGHT_MASTER);
	public CANTalon tsrxL2 = new CANTalon(RobotMap.LEFT_SLAVE);
	public CANTalon tsrxR2 = new CANTalon(RobotMap.RIGHT_SLAVE);
	// ******Commented out encoder to troubleshoot******
	// double quadEncoderPos = tsrxR.getEncPosition();

	// This defines the talons used to drive.
	RobotDrive drive = new RobotDrive(tsrxL, tsrxR);
	// These 2 lines declare the axes for turning	
	public static final int FORWARD_AXIS = 1;
	public static final int TURN_AXIS = 4;
	// Encoder right = new Encoder(1,2);


	PowerDistributionPanel pdp = new PowerDistributionPanel();

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.

		// setDefaultCommand(new MySpecialCommand());
	}

	// This defines whether a talon is on the right or left.
	public void setLeftRight(double left, double right) {
		tsrxL.set(left);

		tsrxR.set(right);

	}

	public void disable() {
		tsrxL.disable();
		tsrxR.disable();
=======
		// tsrxL2.set(left);
		tsrxR.set(right);
		// tsrxR2.set(right);

	}
	
	public void resetGyro()
	{
		gyro.reset();
	}
	public double getAngle()
	{
		return gyro.getAngle();
	}
	public void setFPID(double f, double p, double i, double d)
	{
		tsrxL.setF(f);
		tsrxR.setF(f);
		tsrxL.setPID(p, i, d);
		tsrxR.setPID(p, i, d);
		
	}
	public void disable() {
		tsrxR.disable();
		// tsrxR2.disable();
		tsrxL.disable();
		// tsrxL2.disable();

	}

	public void initAuto() {
		drive.setSafetyEnabled(false);
		/*
		 * lets grab the 360 degree position of the MagEncoder's absolute
		 * position
		 */
		int absolutePositionL = tsrxL.getSelectedSensorPosition(RobotMap.kTimeoutMs)
				& 0xFFF; /*
							 * mask out the bottom12 bits, we don't care about the
							 * wrap arounds
							 */
		int absolutePositionR = tsrxR.getSelectedSensorPosition(RobotMap.kTimeoutMs)
				& 0xFFF; /*
							 * mask out the bottom12 bits, we don't care about the
							 * wrap arounds
							 */

		/* use the low level API to set the quad encoder signal */
		tsrxL.setSelectedSensorPosition(absolutePositionL, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);

		tsrxR.setSelectedSensorPosition(absolutePositionR, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);

		/* choose the sensor and sensor direction */
		tsrxL.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
		tsrxL.setSensorPhase(true);

		tsrxR.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
		tsrxR.setSensorPhase(true);

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
		tsrxL.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx,
				RobotMap.kTimeoutMs); /* always servo */
		tsrxR.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx,
				RobotMap.kTimeoutMs); /* always servo */

		/* set closed loop gains in slot0 */
		tsrxL.config_kF(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		tsrxL.config_kP(RobotMap.kPIDLoopIdx, 0.1, RobotMap.kTimeoutMs);
		tsrxL.config_kI(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		tsrxL.config_kD(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);

		tsrxR.config_kF(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		tsrxR.config_kP(RobotMap.kPIDLoopIdx, 0.1, RobotMap.kTimeoutMs);
		tsrxR.config_kI(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		tsrxR.config_kD(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);

	}

	public void initTeleop() {
		drive.setSafetyEnabled(false);
		tsrxL.setEncPosition(0);
		tsrxR.setEncPosition(0);
		tsrxL.setPosition(0);
		tsrxR.setPosition(0);
		
		tsrxL.changeControlMode(TalonControlMode.Position);
		tsrxR.changeControlMode(TalonControlMode.Position);
		/*
		tsrxL.enableControl();
		tsrxR.enableControl();
		*/
		//tsrxL.setVoltageRampRate(10000);
		//tsrxR.setVoltageRampRate(10000);
		drive.setExpiration(20000);
	}

	public String getPositions()
	{
		return tsrxL.getEncPosition() + " " + tsrxR.getEncPosition();
	}
	
	public double getRightPosition()
	{
		return tsrxR.getEncPosition();
	}
	public double getLeftPosition()
	{
		return tsrxL.getEncPosition();
	}
	public void initTeleop() {
		drive.setSafetyEnabled(true);
		tsrxL.changeControlMode(TalonControlMode.PercentVbus);
		tsrxR.changeControlMode(TalonControlMode.PercentVbus);
		drive.setExpiration(drive.DEFAULT_SAFETY_EXPIRATION);
		tsrxL.setEncPosition(0);
		tsrxR.setEncPosition(0);
		tsrxL.setPosition(0);
		tsrxR.setPosition(0);
	}

	// This declares that for driving only the assigned axes are used.
	public void normalDrive() {

		drive.arcadeDrive(Robot.driveStick.getRawAxis(FORWARD_AXIS), Robot.driveStick.getRawAxis(TURN_AXIS));
	}
}
		SmartDashboard.putNumber("RPM", rpm);
		drive.arcadeDrive(Robot.driveStick.getRawAxis(FORWARD_AXIS), Robot.driveStick.getRawAxis(TURN_AXIS));
	}
	
	
	public void setPositionLeftRight(double left, double right)
	{
		tsrxL.setPosition(left);
		tsrxR.setPosition(right);
	}
	
	

/*	public void encoders() {
		tsrxL.changeControlMode(TalonControlMode.Position);
		tsrxR.changeControlMode(TalonControlMode.Position);

		Robot.chassis.tsrxL.setEncPosition(0);
		Robot.chassis.tsrxR.setEncPosition(0);
	}
	public void teleopMode() {
		tsrxL.changeControlMode(TalonControlMode.PercentVbus);
		tsrxR.changeControlMode(TalonControlMode.PercentVbus);
	}

	//
	 * public void encoders() {
	 * tsrxL.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	 * tsrxR.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	 * tsrxL.changeControlMode(TalonControlMode.Position);
	 * tsrxR.changeControlMode(TalonControlMode.Position);
	 * tsrxL.configEncoderCodesPerRev(768); tsrxR.configEncoderCodesPerRev(768);
	 * tsrxL.setPosition(0); tsrxR.setPosition(0);
	 */
}
