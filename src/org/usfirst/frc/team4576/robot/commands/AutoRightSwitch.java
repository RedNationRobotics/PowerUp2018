package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

<<<<<<< HEAD:src/org/usfirst/frc/team4576/robot/commands/AutoRightSwitch.java
//*******************************************************************
//AutoRightSwitch				Author: Gavin Pretorius
//								Last Edited: 2/19/2018 by GP
//This class allows the robot to go to either the left
// or right switch during autonomous from the right side
//*******************************************************************
=======
public class AutoLeftSwitch extends Command {

	/* If the robot is on the left side this will do both of
	 *  the code for the switches left or right
	 *  Tell @kat if there are problems ;)*/
	
	public AutoLeftSwitch() {
>>>>>>> 0ac8b438278ac7549527fcf5c4d4479d1c54f825:src/org/usfirst/frc/team4576/robot/commands/AutoLeftSwitch.java

public class AutoRightSwitch extends Command {

	public AutoRightSwitch() {
		
	}
	
	@Override
	protected void initialize() {
		Robot.chassis.initAuto();
	}
	
	AutoTurnAtAngle AutoTurnAtAngle = new AutoTurnAtAngle();

<<<<<<< HEAD:src/org/usfirst/frc/team4576/robot/commands/AutoRightSwitch.java
	
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
=======
		protected void  execute() {
	        // -,+ for forward, +,- for backwards
	        // -,- to turn right, +,+ to turn left
	        // charat 0 - your switch 1 - scale 2 - enemy switch
	        if (Robot.gameData.charAt(0) == 'L') {

	        	AutoTurnAtAngle AutoTurnAtAngle = new AutoTurnAtAngle();

	    		Robot.chassis.setLeftRight(-.6, .6);
	    		Timer.delay(1.85);
	    		
	    		AutoTurnAtAngle.TurnRight();
	    		
	    		Robot.chassis.setLeftRight(-.6, .6);
	    		Timer.delay(0.5);
	    		
	    		Timer.delay(1.5);
	    		new Release(true);
	    		Timer.delay(2);
	            // addSequential(new DriveForward(distance));
	            // addSequential(new Rotate(90));
	            // addSequential(new DriveForward(smallDistance));
	            // addSequential(new PutCube));
	        }
	        if (Robot.gameData.charAt(0) == 'R') {
	            
	            AutoTurnAtAngle AutoTurnAtAngle = new AutoTurnAtAngle();
	            
	            Robot.chassis.setLeftRight(-.6, .6);
	            Timer.delay(2);
	            
	    		AutoTurnAtAngle.TurnRight();
	    		
	    		Robot.chassis.setLeftRight(-.6, .6);
	    		Timer.delay(1.85);
	    		
	    		AutoTurnAtAngle.TurnRight();
	    		
	    		Robot.chassis.setLeftRight(-.6, .6);
	    		Timer.delay(0.5);
	    		
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

	    }
>>>>>>> 0ac8b438278ac7549527fcf5c4d4479d1c54f825:src/org/usfirst/frc/team4576/robot/commands/AutoLeftSwitch.java


	@Override
	protected void end() {
		Robot.chassis.setLeftRight(0, 0);

		


	}

	@Override
	protected void interrupted() {

	}
<<<<<<< HEAD:src/org/usfirst/frc/team4576/robot/commands/AutoRightSwitch.java


	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

=======
>>>>>>> 0ac8b438278ac7549527fcf5c4d4479d1c54f825:src/org/usfirst/frc/team4576/robot/commands/AutoLeftSwitch.java
}


