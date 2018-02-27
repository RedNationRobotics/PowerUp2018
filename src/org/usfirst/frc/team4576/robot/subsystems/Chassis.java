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

	double gyroZero = 0;
	double lamps = 0;
	double ramps = 0;

	public Chassis() {
		tsrxL2.follow(tsrxL);
		tsrxR2.follow(tsrxR);
		tsrxL3.follow(tsrxL);
		tsrxR3.follow(tsrxR);
	}

	boolean manualOverride = false;

	public WPI_TalonSRX tsrxL = new WPI_TalonSRX(RobotMap.LEFT_MASTER);
	public WPI_TalonSRX tsrxR = new WPI_TalonSRX(RobotMap.RIGHT_MASTER);
	public WPI_TalonSRX tsrxL2 = new WPI_TalonSRX(RobotMap.LEFT_SLAVE);
	public WPI_TalonSRX tsrxR2 = new WPI_TalonSRX(RobotMap.RIGHT_SLAVE);
	public WPI_TalonSRX tsrxL3 = new WPI_TalonSRX(RobotMap.LEFT_SLAVE2);
	public WPI_TalonSRX tsrxR3 = new WPI_TalonSRX(RobotMap.RIGHT_SLAVE2);

	// This defines the talons used to drive.
	// RobotDrive drive = new RobotDrive(tsrxL, tsrxR);
	DifferentialDrive drive = new DifferentialDrive(tsrxL, tsrxR);
	
	public static PowerDistributionPanel pdp = new PowerDistributionPanel();

	public int absolutePositionL = tsrxL.getSelectedSensorPosition(0)
			& 0xFFF; /*
						 * mask out the bottom12 bits, we don't care about the
						 * wrap arounds
						 */
	public int absolutePositionR = tsrxR.getSelectedSensorPosition(0)
			& 0xFFF; /*
						 * mask out the bottom12 bits, we don't care about the
						 * wrap arounds
						 */

	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
	}

	//sets the left and right throttle (PercentOutput Mode)
	public void setLeftRight(double left, double right) {
		tsrxL.set(ControlMode.PercentOutput, left);
		tsrxR.set(ControlMode.PercentOutput, right);

	}
	//drives straight a set amount of encoder clicks. (PercentOutput Mode)

	public void motionMagicStraight(double positionUnits) {
		tsrxL.set(ControlMode.MotionMagic, -positionUnits);
		tsrxR.set(ControlMode.MotionMagic, positionUnits);
	}

	public void disable() {
		tsrxL.disable();
		tsrxR.disable();

	}

	public void initAuto() {
		drive.setSafetyEnabled(false);
	}

	public void initTeleop() {
		drive.setSafetyEnabled(false);
	}
	// ----------------- Encoders ------------------------------

	public void resetEncoders() {
		tsrxL.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);
		tsrxR.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);
	}

	public double averageEncoders() {
		return (Math.abs(Robot.chassis.tsrxL.getSelectedSensorPosition(RobotMap.CHASSIS_PID))
				+ Math.abs(Robot.chassis.tsrxR.getSelectedSensorPosition(RobotMap.CHASSIS_PID))) / 2;
	}

	public double getLeftSpeed() {
		return tsrxL.getSelectedSensorVelocity(0);
	}

	public double getRightSpeed() {
		return tsrxR.getSelectedSensorVelocity(0);
	}

	public double getSpeed() {
		return (getLeftSpeed() + getRightSpeed()) / 2.0; // average RPM
	}
	// ----------------- Gyro ------------------------------
	
	public double getAngle() {
		if (!Robot.imu.isInitialized())
			return -1;
		return Robot.imu.getHeading();
	}

	public void resetGyro() {
		this.gyroZero = this.getAngle();

	}

	public double getZero() {
		return gyroZero;
	}
    public double getLAmps() { 
    	return lamps = pdp.getCurrent(RobotMap.LEFT_PDPCHANNEL);
    }
    public double getRAmps() {
    	return ramps = pdp.getCurrent(RobotMap.RIGHT_PDPCHANNEL);
    }
	// This declares that for driving only the assigned axes are used.
	public void normalDrive() {

		drive.arcadeDrive(Robot.driveStick.getRawAxis(RobotMap.FORWARD_AXIS),
				-Robot.driveStick.getRawAxis(RobotMap.TURN_AXIS));
	}

	public void stop() {
		Robot.chassis.setLeftRight(0, 0);
	}
}
