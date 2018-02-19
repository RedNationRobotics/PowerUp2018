package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
//*******************************************************************
//Intaker 						Author: Robert Lohmann
//								Last Edited: 2/12/2018 by RL
//This is where the methods called by the intaker commands live. 
//to change throttle, see robotMap
//*******************************************************************
public class Intaker extends Subsystem {
	WPI_VictorSPX intakeL = new WPI_VictorSPX(RobotMap.LEFT_INTAKE);
	WPI_VictorSPX intakeR = new WPI_VictorSPX(RobotMap.RIGHT_INTAKE);

	public Intaker() {
		intakeR.follow(intakeL);
	}

	public void intake() {

		intakeL.set(ControlMode.PercentOutput, .85);

	}

	public void release() {

		intakeL.set(ControlMode.PercentOutput, -.85);

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
