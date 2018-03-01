package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeArm extends Command {

	public IntakeArm(){
		
		requires(Robot.pneumatics);
        
	}

	protected void initialize() {
		Robot.pneumatics.intakeArm();
		
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return true;
	}
}

