package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
//*******************************************************************
//Intake						Author: Robert Lohmann
//								Last Edited: 2/12/2018 by RL
//This command Runs the intaker backward in order to pick up power cubes.
//*******************************************************************
public class Intake extends Command {
	private boolean in = true;

	public Intake(boolean in) {
		this.in = in;
		requires(Robot.intaker);
	}
	@Override
	protected void initialize() {
		if (in) {
			Robot.intaker.intake();
		} else {
			Robot.intaker.stop();
		}
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		// changed to true to check issues
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {

	}

}
