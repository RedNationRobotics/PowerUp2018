package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;
import org.usfirst.frc.team4576.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoMiddleSwitch1 extends Command {

	/* This will go to the switch side parallel of the alliance wall and release the box
	 * any problems tell @kat she wrote it*/	
	
	public AutoMiddleSwitch1() {

	}

	@Override
	protected void initialize() {
		Robot.chassis.initAuto();
	}
	
	Elevator Elevator = new Elevator();

		protected void  execute() {
			 // +,+ for forward, -,- for backwards
	        // +,- to turn right, -,+ to turn left
	        // charat 0 - your switch 1 - scale 2 - enemy switch
	        if (Robot.gameData.charAt(0) == 'L') {

	        	AutoTurnAtAngle AutoTurnAtAngle = new AutoTurnAtAngle();

	    		Robot.chassis.setLeftRight(.6, .6);
	    		Timer.delay(0.76176);
	    		
	    		AutoTurnAtAngle.TurnLeft();
	    		
	    		Robot.chassis.setLeftRight(.6, .6);
	    		Timer.delay(0.65294);
	    		
	    		AutoTurnAtAngle.TurnRight();
	    		
	    		Robot.chassis.setLeftRight(.6, .6);
	    		Timer.delay(0.65294);
	    		
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
	            
	            Robot.chassis.setLeftRight(.6, .6);
	            Timer.delay(0.76176);
	            
	    		AutoTurnAtAngle.TurnRight();
	    		
	    		Robot.chassis.setLeftRight(.6, .6);
	    		Timer.delay(0.65294);
	    		
	    		AutoTurnAtAngle.TurnLeft();
	    		
	    		Robot.chassis.setLeftRight(.6, .6);
	    		Timer.delay(0.62294);
	    		
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


