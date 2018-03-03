package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lights extends Subsystem {
	  private Spark led0 = new Spark(0);
	  /**
	   * State of the LEDs running off of the Blinkin LED Driver (REV-11-1105-UM).
	   * @see https://www.revrobotics.com/content/docs/REV-11-1105-UM.pdf page 14
	   */
	  public static double RED = 0.61;
	  public static double BLUE = 0.81;
	  public static double GREEN = 0.71;
	  /**
	   * Set LED mode on controller 0.
	   * @param color A reference to the State enum from above.
	   */
	  public void setLedMode(double color) {
	    led0.set(color);
	  }
	  /**
	   * Initialize default command.
	   */
	  protected void initDefaultCommand() {}
	}