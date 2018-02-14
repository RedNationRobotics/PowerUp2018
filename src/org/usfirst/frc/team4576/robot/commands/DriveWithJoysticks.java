package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
//*******************************************************************
//DriveWithJoysticks			Author: Gavin Pretorius
//								Last Edited: 2/12/2018 by RL
//DriveWithJoysticks is called in teleopPeriodic in the robot class. 
//it enables joystick control and its axes can be modified in the chassis subsystem.
//*******************************************************************
public class DriveWithJoysticks extends Command {

	public DriveWithJoysticks() {

		requires(Robot.chassis);
		requires(Robot.elevator);
		Robot.chassis.initTeleop();

	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.chassis.normalDrive();
		Robot.elevator.elevatorTeleop(Robot.driveStick);
		Robot.elevator.gamePadControl(Robot.driveStick);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
