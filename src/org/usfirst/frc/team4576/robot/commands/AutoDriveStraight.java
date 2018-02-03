package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveStraight extends Command {

	public AutoDriveStraight() {
		requires(Robot.chassis);
	}

	protected void initialize() {
		Robot.chassis.initAuto();
		// Robot.chassis.gyro.reset();
	}

	public void driveStraightLeft(double distance) {
		double lencoder = Robot.chassis.absolutePositionL;
		while (lencoder < distance)

			Robot.chassis.tsrxL.set(-.3);
	}

	public void driveStraightRight(double distance) {
		double rencoder = Robot.chassis.absolutePositionR;
		while (rencoder < distance)

			Robot.chassis.tsrxR.set(.3);
	}

	@Override
	protected void execute() {
		// -,+ for forward, +,- for backwards
		// -,- to turn right, +,+ to turn left

		driveStraightLeft(500);
	    driveStraightRight(500);

	}

	protected void end() {
		Robot.chassis.setLeftRight(0, 0);

	}

	protected void interrupted() {

	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
