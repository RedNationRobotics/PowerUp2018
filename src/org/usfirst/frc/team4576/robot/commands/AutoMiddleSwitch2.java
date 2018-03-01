package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoMiddleSwitch2 extends Command {

	//*******************************************************************
	//AutoMiddleSwitch2				Author: Gavin Pretorius
	//								Last Edited: 2/19/2018 by GP
	//This class allows the robot to go to the end of either the left 
	//or right ends of the switch during autonomous mode.
	//*******************************************************************
	
	public AutoMiddleSwitch2() {
		
	}
	
	@Override
	protected void initialize() {
		Robot.chassis.initAuto();
	}
	
	AutoTurnAtAngle AutoTurnAtAngle = new AutoTurnAtAngle();

	
	@Override
	protected void execute() {
		 // +,+ for forward, -,- for backwards
        // +,- to turn right, -,+ to turn left
        // charat 0 - your switch 1 - scale 2 - enemy switch
		if (Robot.gameData.charAt(0) == 'L') {


			Robot.chassis.setLeftRight(-.6, .6);
			Timer.delay(.76176);
			
			AutoTurnAtAngle.TurnLeft();
			
			Robot.chassis.setLeftRight(-.6, .6);
			Timer.delay(1.85);
			
			AutoTurnAtAngle.TurnRight();
			
			Robot.chassis.setLeftRight(-.6, .6);
			Timer.delay(.9794);
			
			AutoTurnAtAngle.TurnRight();
			
			Timer.delay(1.5);
			new Release(true);
			Timer.delay(2);
			// addSequential(new DriveForward(smallDistance));
			// addSequential(new Rotate(90));
			// addSequential(new DriveForward(farDistance));
			// addSequential(new Rotate(90));
			// addSequential(new DriveForward(smallDistance));
			// add Sequential(new Rotate(90))
			// addSequential(new PutCube());
		}
		
		if (Robot.gameData.charAt(0) == 'R') {
			
			Robot.chassis.setLeftRight(-.6, .6);
			Timer.delay(.76176);
			
			AutoTurnAtAngle.TurnRight();
			
			Robot.chassis.setLeftRight(-.6, .6);
			Timer.delay(1.85);
			
			AutoTurnAtAngle.TurnLeft();
			
			Robot.chassis.setLeftRight(-.6, .6);
			Timer.delay(.9794);
			
			AutoTurnAtAngle.TurnLeft();
			
			Timer.delay(1.5);
			new Release(true);
			Timer.delay(2);
			// addSequential(new DriveForward(smallDistance));
			// addSequential(new Rotate(90));
			// addSequential(new DriveForward(farDistance));
			// addSequential(new Rotate(90));
			// addSequential(new DriveForward(smallDistance));
			// add Sequential(new Rotate(90))
			// addSequential(new PutCube());
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

