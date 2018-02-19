package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

//*******************************************************************
//AutoTurnAtAngle				Author: Gavin Pretorius
//								Last Edited: 2/19/2018 by GP
//This class is used to turn x amount of degrees during autonomous period. 
//This will allow us to accurately maneuver during the autonomous period
//*******************************************************************

public class AutoTurnAtAngle extends Command {
	
	double _heading = Robot.imu.getHeading();
	double _Lturn = _heading -90.0;
	double _Rturn = _heading +90.0;

	//Turn left 90 degrees
	public void TurnLeft() {
		
		while(_Lturn != Robot.imu.getHeading()) {
			Robot.chassis.tsrxL.set(.5);
			Robot.chassis.tsrxL.set(-.5);
		}
	}
	
	//Turn right 90 degrees
	public void TurnRight() {
		
		while(_Rturn != Robot.imu.getHeading()) {
			Robot.chassis.tsrxL.set(-.5);
			Robot.chassis.tsrxL.set(.5);
		}
	}	
	
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	 
}