package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


//*******************************************************************
//AutoRightSwitch				Author: Gavin Pretorius
//								Last Edited: 2/19/2018 by GP
//This class allows the robot to go to either the left
// or right switch during autonomous from the right side
//*******************************************************************


public class AutoRightSwitch extends Command {

	public AutoRightSwitch() {
		
	}
	
	@Override
	protected void initialize() {
		Robot.chassis.initAuto();
	}
	
	AutoTurnAtAngle AutoTurnAtAngle = new AutoTurnAtAngle();

	
	@Override
	protected void execute() {
		// -,+ for forward, +,- for backwards
		// -,- to turn right, +,+ to turn left
		// charat 0 - your switch 1 - scale 2 - enemy switch
		if (Robot.gameData.charAt(0) == 'L') {


			Robot.chassis.setLeftRight(-.6, .6);
			Timer.delay(1.85);
			
			AutoTurnAtAngle.TurnLeft();
			
			Robot.chassis.setLeftRight(-.6, .6);
			Timer.delay(1.5);
			
			AutoTurnAtAngle.TurnLeft();
			
			Robot.chassis.setLeftRight(-.6, .6);
			Timer.delay(1.5);
			
			Timer.delay(1.5);
			new Release(true);
			Timer.delay(2);
			// addSequential(new DriveForward(longerDistance));
			// addSequential(new Rotate(90));
			// addSequential(new DriveForward(farDistance));
			// addSequential(new Rotate(90));
			// addSequential (new DriveForward(smallDistance));
			// addSequential(new PutCube());
		}
		
		if (Robot.gameData.charAt(0) == 'R') {
			
			Robot.chassis.setLeftRight(-.6, .6);
			Timer.delay(1.85);
			
			AutoTurnAtAngle.TurnLeft();
			
			Robot.chassis.setLeftRight(-.6, .6);
			Timer.delay(1.5);
			
			Timer.delay(1.5);
			new Release(true);
			Timer.delay(2);
			// addSequential(new DriveForward(distance));
			// addSequential(new Rotate(90));
			// addSequential(new DriveForward(smallDistance));
			// addSequential(new PutCube));
		}
	}


	@Override
	protected void end() {
		Robot.chassis.setLeftRight(0, 0);

		


	}

	@Override
	protected void interrupted() {

	}


	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}


