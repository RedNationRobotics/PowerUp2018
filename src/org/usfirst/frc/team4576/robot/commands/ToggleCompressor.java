package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

//*******************************************************************
//ToggleCompressor				Author: Robert Lohmann
//								Last Edited: 2/12/2018 by RL
//This command toggles the power for our robot's air compressor.
//*******************************************************************
public class ToggleCompressor extends Command {
	private boolean in = true;

	public ToggleCompressor(boolean in) {
		this.in = in;
		requires(Robot.pneumatics);
	}

	protected void initialize() {
		if (in) {
			Robot.pneumatics.startComp();
		} else {
			Robot.pneumatics.stopComp();
		}
		//Robot.pneumatics.toggleComp();
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}