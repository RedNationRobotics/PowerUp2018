package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;
import org.usfirst.frc.team4576.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightBNO extends Command {
	public double xVal = 0;
    public double yVal = 0;
    public double throttle, seconds;
	double error = (Robot.chassis.getAngle() - Robot.chassis.getZero());
	  
public DriveStraightBNO(double throttle, double seconds) {
    requires(Robot.chassis);
  }

  @Override
  protected void initialize() {
    Robot.chassis.resetEncoders();
    Robot.chassis.resetGyro();
    Robot.chassis.stop();
}


@Override
  protected void execute() { 
	
	  	if (error > 30) {
	  	xVal =  throttle + error*RobotMap.kP0;
		yVal =  throttle + error*RobotMap.kP0;
	  	}
        if (error < 30) {
        xVal = throttle -error;
        yVal = throttle -error;
        }
    Robot.chassis.setLeftRight(-xVal, yVal);
    
  }

  @Override
  protected boolean isFinished() {
	  if(timeSinceInitialized() >= seconds) { 
		return true; }
      else 
    	return false;
  }

  @Override
  protected void end() {
    Robot.chassis.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }

}