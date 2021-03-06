package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
//*******************************************************************
//Release						Author: Robert Lohmann
//								Last Edited: 2/12/2018 by RL
//This command Runs the intaker forward in order to spit out power cubes.
//*******************************************************************
public class SlowRelease extends Command {
	private boolean in = true;

	public SlowRelease(boolean in) {
		this.in = in;
		requires(Robot.intaker);
	}

	public SlowRelease() {
	
	}
	@Override
	protected void initialize() {
		if (in) {
			Robot.intaker.Slowrelease();
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
