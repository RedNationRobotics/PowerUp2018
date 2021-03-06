package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
//*******************************************************************
//Intaker 						Author: Robert Lohmann
//								Last Edited: 2/12/2018 by RL
//This is where the methods called by the intaker commands live. 
//to change throttle, see robotMap
//*******************************************************************
public class Intaker extends Subsystem {
	public WPI_VictorSPX intakeL = new WPI_VictorSPX(RobotMap.LEFT_INTAKE);
	public WPI_VictorSPX intakeR = new WPI_VictorSPX(RobotMap.RIGHT_INTAKE);

	public Intaker() {
		intakeR.follow(intakeL);
	}

	public void intake() {
	//-.9
		intakeL.set(RobotMap.INTAKE_IN_SPEED);

	}

	public void Slowrelease() {
		
		intakeL.set(RobotMap.INTAKE_OUT_SPEED_SLOW);
		
	}
		
	public void Fastrelease() {
	// .4
		intakeL.set(RobotMap.INTAKE_OUT_SPEED_FAST);

	}
	/*
	 * public void Shoot() { tsrxS.set(targetSpeed); /* 1500 RPM in either
	 * direction
	 */

	public void stop() {
		intakeL.set(0);
	}

	protected void initDefaultCommand() {
		/* get gamepad axis */

	}

}
