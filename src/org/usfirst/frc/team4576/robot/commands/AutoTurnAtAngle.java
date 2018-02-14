package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

//*******************************************************************
//AutoTurnAtAngle				Author: Gavin Pretorius
//								Last Edited: 2/14/2018 by GP
//This class is used to turn x amount of degrees during autonomous period. 
//This will allow us to accurately maneuver during the autonomous period
//*******************************************************************

public class AutoTurnAtAngle {
	 
	public void Loop() {
		

		//we can choose to turn left or right
		double _LTurn = Robot.imu.getHeading() - 90.0;
		double _RTurn = Robot.imu.getHeading() + 90.0;
		
		Robot.chassis.tsrxL();
		
		}

}
