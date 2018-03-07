package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.Robot;
import org.usfirst.frc.team4576.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
//*******************************************************************
//Pneumatics					Author: Robert Lohmann
//								Last Edited: 2/12/2018 by RL
//This subsystem contains all the methods for commands controlling
//our compressor, solenoids, and pressure sensor
//*******************************************************************
public class Pneumatics extends Subsystem {

	public Pneumatics() {
		s0 = new Solenoid(RobotMap.SHIFT_SOLENOID);/* Shifting */
		s1 = new Solenoid(RobotMap.INTAKE_ARM);/* Shifting */
		psensor = new AnalogInput(0);

	}

	public Compressor c;
	private Solenoid s0;
	private Solenoid s1;
	public AnalogInput psensor;
	protected void initDefaultCommand() {
		c = new Compressor();
	}

	public void setAutoEnabled() {

		c.setClosedLoopControl(true);
	}
	
	// Shifting
	public void setShift(boolean closed) {
		s0.set(closed);
	}
	public boolean getShift() {
		if (s0.get() == true) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

	public void shiftUp() {
		setShift(true);
	}

	public void shiftDown() {
		setShift(false);
	
	}
	public void setIntakeArm(boolean closed) {
		s1.set(closed);
	}
	public void setPositionIntakeArm(boolean bClose) {
		s1.set(bClose);
	}

	public void intakeArm() {
		s1.set(!s1.get());

	}

	// Compressor Toggle
/*	public void toggleComp() {
		if (c.enabled())
			c.stop();
		else
			c.start();
	}
*/
	public void startComp() {
		c.start();
	}
	public void stopComp() {
		c.stop();
	}

	public double rawVolts() {
		return psensor.getAverageVoltage();
	}
	
	public double getPsi()	{
		double pressure = 0;
		pressure = (250* (Robot.pneumatics.rawVolts()/5)-25);
		return pressure;
		
	}

}
