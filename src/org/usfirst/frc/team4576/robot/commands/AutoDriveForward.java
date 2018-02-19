package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveForward extends Command {
	private double distance;
	private double targetPosition;
	private double encoderPositionAverage;
    public AutoDriveForward(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	targetPosition = distance;
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.tsrxL.setSelectedSensorPosition(0, 0, 0);
    	Robot.chassis.tsrxL.setSelectedSensorPosition(0, 0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double lSpeed, rSpeed;
    	double lPosition, rPosition;
    	
    	lSpeed	= Robot.chassis.tsrxL.get();
    	rSpeed	= Robot.chassis.tsrxR.get();

    	System.out.println(this.getClass().getName() + "isFinished() : motorSpeeds [bl, br, fl, fr] ["+ lSpeed + ", " + rSpeed + ", " + ']');
    	
    	lPosition	= Robot.chassis.tsrxL.getSelectedSensorPosition(0);
    	rPosition	= Robot.chassis.tsrxR.getSelectedSensorPosition(0);
      	System.out.println(this.getClass().getName() + "isFinished() : motorPositions [bl, br, fl, fr] ["
				+ lPosition + ", "
				+ rPosition + ", " + ']');
      	
    	encoderPositionAverage = (Math.abs(Robot.chassis.tsrxL.getSelectedSensorPosition(0)) +
    	Math.abs(Robot.chassis.tsrxR.getSelectedSensorPosition(0))) / 2;
    	System.out.println(this.getClass().getName() + "Encoder Position Av: " + encoderPositionAverage);
    	System.out.println(this.getClass().getName() + "Target Pos {" + targetPosition + "}");
    	Robot.chassis.motionMagicStraight(targetPosition);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(targetPosition >= encoderPositionAverage )
        	return false;
        else 
        	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}