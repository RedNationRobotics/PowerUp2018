package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Subsystem;

//*******************************************************************
//Elevator						Author: Robert Lohmann
//								Last Edited: 2/12/2018 by RL
//This is where the methods that are run by the Elevator commands live. also contains 
//methods to enable joystick trigger control. To change throttle, see robotMap
//*******************************************************************
public class Elevator extends Subsystem {
	public WPI_TalonSRX tsrxE = new WPI_TalonSRX(RobotMap.ELEVATOR_TALON);
	static DigitalInput limitSwitchTop = new DigitalInput(RobotMap.TOPDIO);
	static DigitalInput limitSwitchBot = new DigitalInput(RobotMap.BOTDIO);
	public Counter counter1 = new Counter(limitSwitchTop);
	public Counter counter2 = new Counter(limitSwitchBot);


	public Elevator() {
		tsrxE.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 1, RobotMap.kTimeoutMs);
	}
	public void initCounter() {
		counter1.reset();
		counter2.reset();
	}
	public void up() {

		tsrxE.set(ControlMode.PercentOutput, RobotMap.ELEVSPEEDUP);
	}

	public void down() {

		tsrxE.set(ControlMode.PercentOutput, RobotMap.ELEVSPEEDDOWN);
		
	}
	/*
	 * public void Shoot() { tsrxS.set(targetSpeed); /* 1500 RPM in either
	 * direction
	 */

	public void stop() {
		tsrxE.set(ControlMode.PercentOutput, 0);
	}

	protected void initDefaultCommand() {
		/* get gamepad axis */

	}

}