package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.Robot;
import org.usfirst.frc.team4576.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {

	public Pneumatics() {
		s0 = new Solenoid(RobotMap.SHIFT_SOLENOID);/* Shifting */
		psensor = new AnalogInput(0);

	}

	private Compressor c;
	private Solenoid s0;
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

	public void shiftUp() {
		s0.set(true);

	}

	public void shiftDown() {
		s0.set(false);
	
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
