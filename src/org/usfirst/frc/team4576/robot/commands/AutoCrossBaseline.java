package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoCrossBaseline extends Command {

	@Override
	protected void initialize() {
		Robot.chassis.initAuto();
	}

	@Override
	protected void execute() {
		//-,+ for forward, +,- for backwards
		//-,- to turn right, +,+ to turn left

		Robot.chassis.setLeftRight(-.6, .6);
		Timer.delay(1.85);
		new AutoTurnAtAngle(90);
		Robot.chassis.setLeftRight(-.5, .5);
		Timer.delay(1.5);
		new Release(true);
		Timer.delay(2);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		Robot.chassis.setLeftRight(0, 0);
		

	}

	@Override
	protected void interrupted() {

	}

}