package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;
import org.usfirst.frc.team4576.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import redcore.BNO055;

public class AutonDriveForward extends Command{
	
	private static BNO055 imu;
	
	leftEncoder = Robot.chassis.tsrxL.getSelectedSensorPosition();

	
	public void driveStraight(double distance)
	{
		while (Robot.chassis.tsrxL.getSelectedSensorPosition(RobotMap.kPIDLoopIdx) < distance)
		
			Robot.chassis.setLeftRight(.3, 0);
		}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
