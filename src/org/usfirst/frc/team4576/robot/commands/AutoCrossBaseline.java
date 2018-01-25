package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class AutoCrossBaseline extends Command {

	@Override
	protected void initialize() {
		Robot.chassis.initAuto();
		//Robot.chassis.gyro.reset();
	}

	@Override
	protected void execute() {
		//-,+ for forward, +,- for backwards
		//-,- to turn right, +,+ to turn left
		
				//Forward, open gear
	Robot.chassis.tsrxL.set(ControlMode.Position, 500);
	Robot.chassis.tsrxR.set(ControlMode.Position, 500);
	

				
	}

	
	/*private void driveCorrective(double setPoint,long milliseconds)
	{
		long timeStamp = System.currentTimeMillis();
		//This runs this loop for 3000 milliseconds (3 seconds)
		while(timeStamp >= System.currentTimeMillis() - 3000)
		{
	//	double angle = Robot.chassis.gyro.getAngle(); // get current heading
		
		//if the robot is correcting itself to the wrong direction
		//change the "0.3 - (angle/100)" to "0.3 + (angle/100)"
		Robot.chassis.setLeftRight(-0.3, 0.3 - ((angle+setPoint)/100));
		Timer.delay(0.004);
		}
		*/
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