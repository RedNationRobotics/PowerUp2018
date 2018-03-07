package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import PowerUp2018.AutoRecipes;
import edu.wpi.first.wpilibj.command.Command;

public class ElevFast extends Command {
    private boolean in = true;

    public ElevFast(boolean in) {
        this.in = in;
    }
    @Override
    protected void initialize() {    	
    	if(in) {
			Robot.InitializeAutoRecipe(AutoRecipes._ElevatorDown_Recipe_);
		}
    	if(!in) {
			Robot.InitializeAutoRecipe(AutoRecipes._ElevatorUp_Recipe_);
    	}
    }
    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
    	return true;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {
    }
}