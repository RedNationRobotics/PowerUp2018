package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevUp extends Command {
    private boolean in = true;

    public ElevUp(boolean in) {
        this.in = in;
        requires(Robot.elevator);
    }
    @Override
    protected void initialize() {
    	Robot.elevator.counter2.reset();
    	
        if (in) {
               Robot.elevator.up();
        	}
        	
         else {
            Robot.elevator.stop();
        }
    }
 
    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        // changed to true to check issues
    	if (Robot.elevator.counter1.get() > 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    @Override
    protected void end() {
    	Robot.elevator.stop();
    }

    @Override
    protected void interrupted() {
    }

}