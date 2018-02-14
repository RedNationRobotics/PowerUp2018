package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
//*******************************************************************
//AutoDriveStraight					Author: Robert Lohmann
//								Last Edited: 2/12/2018 by RL
//This autonomous command attempts to drive straight forward to a set position
//using the talonSRX MagEncoder
//*******************************************************************
public class AutoDriveStraight extends Command {

	public AutoDriveStraight() {
		// Use requires()here to declare subsystem dependencies
		requires(Robot.chassis);
	}

	protected void initialize() {
		Robot.chassis.initAuto();
		// Robot.chassis.gyro.reset();
	}

	public void driveStraightLeft(double distance) {
		double rencoder = Robot.chassis.absolutePositionR;	
		double targetpositionR  = (double) (distance / 360.00000000);
		while (rencoder < targetpositionR)
			Robot.chassis.tsrxR.set(ControlMode.Position, .05);
	}

	public void driveStraightRight(double distance) {
		double rencoder = Robot.chassis.absolutePositionR;	
		double targetpositionR  = (double) (distance / 360.00000000);
		while (rencoder < targetpositionR)
			Robot.chassis.tsrxR.set(ControlMode.Position, .05);
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
