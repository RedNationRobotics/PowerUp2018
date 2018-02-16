package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

//*******************************************************************
//AutoTurnAtAngle				Author: Gavin Pretorius
//								Last Edited: 2/15/2018 by GP
//This class is used to turn x amount of degrees during autonomous period. 
//This will allow us to accurately maneuver during the autonomous period
//*******************************************************************

public class AutoTurnAtAngle {
	 
	double heading = Robot.imu.getHeading();
	
	public void TurnLeft() {
				
		double _LTurn = heading - 45.0;
		
		while(_LTurn != Robot.imu.getHeading()) {
			Robot.chassis.tsrxL.set(-.125);
			Robot.chassis.tsrxR.set(.125);
		}
	}
	
	
	public void TurnRight() {
		double _RTurn = heading + 45.0;
		
		while(_RTurn != Robot.imu.getHeading()) {
			Robot.chassis.tsrxL.set(.125);
			Robot.chassis.tsrxR.set(-.125);
		}
	}

}
