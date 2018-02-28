package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;
import org.usfirst.frc.team4576.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoLeftScale extends Command {

	/* If the robot is on the left side this will do both of
	 *  the scale sides left or right
	 *  Tell @kat if there are problems ;)*/
	
	public AutoLeftScale() {

	}

	@Override
	protected void initialize() {
		Robot.chassis.initAuto();
	}

		protected void  execute() {
	        // +,+ for forward, -,- for backwards
	        // +,- to turn right, -,+ to turn left
	        // charat 0 - your switch 1 - scale 2 - enemy switch
	        if (Robot.gameData.charAt(0) == 'L') {

	        	AutoTurnAtAngle AutoTurnAtAngle = new AutoTurnAtAngle();
	        	Elevator Elevator = new Elevator();
	    		Robot.chassis.setLeftRight(-.6, .6);
	    		Timer.delay(3.56397);
	    		
	    		AutoTurnAtAngle.TurnRight();
	    		
	    		//not sure if we need this move yet
	    		
	    		Robot.chassis.setLeftRight(-.6, .6);
	    		Timer.delay(0.2);
	    		
	    		Elevator.up();
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
	            Elevator Elevator = new Elevator();
	            
	            Robot.chassis.setLeftRight(-.6, .6);
	            Timer.delay(1.541666);
	            
	    		AutoTurnAtAngle.TurnRight();
	    		
	    		Robot.chassis.setLeftRight(-.6, .6);
	    		Timer.delay(1.541666);
	    		
	    		AutoTurnAtAngle.TurnLeft();
	    		
	    		Robot.chassis.setLeftRight(-.6, .6);
	    		Timer.delay(0.7708);
	    		
	    		AutoTurnAtAngle.TurnLeft();
	    		
	    		// not sure if we need this move yet
	    		
	    		Robot.chassis.setLeftRight(-.6, .6);
	    		Timer.delay(0.2);
	    		
	    		Elevator.up();
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


