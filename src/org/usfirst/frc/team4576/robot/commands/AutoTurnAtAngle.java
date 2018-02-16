package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

//*******************************************************************
//AutoTurnAtAngle				Author: Gavin Pretorius
//								Last Edited: 2/15/2018 by GP
//This class is used to turn x amount of degrees during autonomous period. 
//This will allow us to accurately maneuver during the autonomous period
//*******************************************************************

public class AutoTurnAtAngle extends Command {
	 
	double setPoint;
	double heading = Robot.imu.getHeading();
	double _LTurn = heading - 45.0;
	double _RTurn = heading + 45.0;

	public AutoTurnAtAngle(double setPoint){
		setPoint would = 45.0;
	}


	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
