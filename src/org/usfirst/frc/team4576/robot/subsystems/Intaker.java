package org.usfirst.frc.team4576.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
//*******************************************************************
//Intaker 						Author: Robert Lohmann
//								Last Edited: 2/12/2018 by RL
//This is where the methods called by the intaker commands live. 
//to change throttle, see robotMap
//*******************************************************************
public class Intaker extends Subsystem {
	WPI_TalonSRX tsrxIL = new WPI_TalonSRX(4);
	WPI_TalonSRX tsrxIR = new WPI_TalonSRX(5);

	public Intaker() {
		tsrxIR.follow(tsrxIL);
	}

	public void intake() {

		tsrxIL.set(ControlMode.PercentOutput, .85);

	}

	public void release() {

		tsrxIL.set(ControlMode.PercentOutput, -.85);

	}
	/*
	 * public void Shoot() { tsrxS.set(targetSpeed); /* 1500 RPM in either
	 * direction
	 */

	public void stop() {
		tsrxIL.set(0);
	}

	protected void initDefaultCommand() {
		/* get gamepad axis */

	}

}
