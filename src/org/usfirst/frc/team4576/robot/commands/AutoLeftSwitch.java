package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
<<<<<<< HEAD

public class AutoLeftSwitch extends Command {
=======
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLeftSwitch extends Command {
	public AutoLeftSwitch() {

	}
>>>>>>> d281c4f7603b22b180c1fde38da4790f9eabf139

	@Override
	protected void initialize() {
		Robot.chassis.initAuto();
	}

<<<<<<< HEAD
		protected void execute() {
	        // -,+ for forward, +,- for backwards
	        // -,- to turn right, +,+ to turn left
	        // charat 0 - your switch 1 - scale 2 - enemy switch
	        if (Robot.gameData.charAt(0) == 'L') {


	    		Robot.chassis.setLeftRight(-.6, .6);
	    		Timer.delay(1.85);
	    		new AutoTurnAtAngle(90);
	    		Robot.chassis.setLeftRight(-.5, .5);
	    		Timer.delay(1.5);
	    		new Release(true);
	    		Timer.delay(2);
	            // addSequential(new DriveForward(distance));
	            // addSequential(new Rotate(90));
	            // addSequential(new DriveForward(smallDistance));
	            // addSequential(new PutCube));
	        }
	        if (Robot.gameData.charAt(0) == 'R') {
	            
	            Robot.chassis.setLeftRight(-.6, .6);
	            Timer.delay(1.85);
	            // addSequential(new DriveForward(longerDistance));
	            // addSequential(new Rotate(90));
	            // addSequential(new DriveForward(farDistance));
	            // addSequential(new Rotate(90));
	            // addSequential (new DriveForward(smallDistance));
	            // addSequential(new PutCube());
	        }

	    }

=======
	@Override
	protected void execute() {
		// -,+ for forward, +,- for backwards
		// -,- to turn right, +,+ to turn left
		// charat 0 - your switch 1 - scale 2 - enemy switch
		if (Robot.gameData.charAt(0) == 'L') {

			Robot.chassis.setLeftRight(-.6, .6);
			Timer.delay(1.85);
			// addSequential(new DriveForward(distance));
			// addSequential(new Rotate(90));
			// addSequential(new DriveForward(smallDistance));
			// addSequential(new PutCube));
		}
		if (Robot.gameData.charAt(0) == 'R') {
			
			Robot.chassis.setLeftRight(-.6, .6);
			Timer.delay(1.85);
			// addSequential(new DriveForward(longerDistance));
			// addSequential(new Rotate(90));
			// addSequential(new DriveForward(farDistance));
			// addSequential(new Rotate(90));
			// addSequential (new DriveForward(smallDistance));
			// addSequential(new PutCube());
		}
>>>>>>> d281c4f7603b22b180c1fde38da4790f9eabf139

	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		Robot.chassis.setLeftRight(0, 0);
<<<<<<< HEAD
		
=======
>>>>>>> d281c4f7603b22b180c1fde38da4790f9eabf139

	}

	@Override
	protected void interrupted() {

	}

<<<<<<< HEAD
=======
}
>>>>>>> d281c4f7603b22b180c1fde38da4790f9eabf139
