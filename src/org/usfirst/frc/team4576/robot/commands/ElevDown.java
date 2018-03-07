package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevDown extends Command {
    private boolean in = true;

    public ElevDown(boolean in) {
        this.in = in;
        requires(Robot.elevator);
    }
    @Override
    protected void initialize() {    	

    	Robot.elevator.counter1.reset();
    	
        if (in) {
               Robot.elevator.down();
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
    	if (Robot.elevator.counter2.get() > 0 || !in) {
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