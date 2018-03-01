package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
//*******************************************************************
//AutoDriveStraight					Author: Robert Lohmann
//								Last Edited: 2/12/2018 by RL
//This autonomous command attempts to drive straight forward to a set position
//using the talonSRX MagEncoder
//*******************************************************************
public class AutoDriveStraight extends Command{
	
	public AutoDriveStraight() {
		// Use requires()here to declare subsystem dependencies
		requires(Robot.chassis);
	}

	protected void initialize() {
		// Robot.chassis.gyro.reset();
	}

	@Override
	protected void execute() {
		// -,+ for forward, +,- for backwards
		// -,- to turn right, +,+ to turn left
		//addSequential(new AutoDriveForward(5));
		new DriveStraightBNO(.5, .5);
		
	}

	protected void end() {
		Robot.chassis.setLeftRight(0, 0);

	}

	protected void interrupted() {

	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
}
