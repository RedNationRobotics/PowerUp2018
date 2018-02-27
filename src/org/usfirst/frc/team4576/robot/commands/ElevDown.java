package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevDown extends Command {
	private boolean in = true;

	public ElevDown(boolean in) {
		this.in = in;
		requires(Robot.elevator);
	}
	@Override
	protected void initialize() {
		if (in) {
			Robot.elevator.down();
		} else {
			Robot.elevator.stop();
		}
	}
	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
	       if (Robot.elevator.counter1.get() <= 0) {
	           return true;
	       }
	       else {
	           return false;
	       }

	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {

	}

}
