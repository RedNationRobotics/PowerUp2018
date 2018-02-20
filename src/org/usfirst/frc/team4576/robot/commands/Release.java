package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Release extends Command {
	private boolean in = true;

	public Release(boolean in) {
		this.in = in;
		requires(Robot.intaker);
	}

	public Release() {
	
	}
	@Override
	protected void initialize() {
		if (in) {
			Robot.intaker.release();
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
		return true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {

	}

}
