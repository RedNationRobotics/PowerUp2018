package org.usfirst.frc.team4576.robot;

//*******************************************************************
//RobotMap						Author: Robert Lohmann
//								Last Edited: 2/12/2018 by RL
//The RobotMap is a mapping of constants for the ports, sensors, actuators on the robot. 
//These IDs are placed into into to a variable name. This simplifies wiring,configuring
//the talons, and significantly reduces the number of magic numbers floating around.
//*******************************************************************
// Button Values:
//
//1: A
//2: B
//3: X
//4: Y
//5: Left Bumper
//6: Right Bumper
//7: Back
//8: Start
//9: Left Joystick pressed down
//10: Right Joystick pressed down
//
//Axis values:
//
//1 - LeftX
//2 - LeftY
//3 - Triggers (Each trigger = 0 to 1, axis value = right - left)
//4 - RightX
//5 - RightY
//6 - DPad Left/Right
public class RobotMap {

	// Talon IDs:
	public static final int LEFT_MASTER = 0;
	public static final int RIGHT_MASTER = 1;
	public static final int LEFT_SLAVE = 2;
	public static final int RIGHT_SLAVE = 3;
	public static final int LEFT_INTAKE = 4;
	public static final int RIGHT_INTAKE = 5;
	public static final int ELEVATOR_TALON = 6;
	//Solenoid IDs:
	public static final int SHIFT_SOLENOID = 0;
	
	//Which PID slot to pull gains from:  Starting 2018, you can choose 
	//from 0,1,2 or 3.  Only the first two (0,1) are visible in web-based configuration.
	public static final int kSlotIdx = 0;
	
	//Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops.  
	//For now we just want the primary one.
	public static final int kPIDLoopIdx = 0;

	/*
	 * set to zero to skip waiting for confirmation, set to nonzero to wait
	 * and report to DS if action fails.
	 */
	public static final int kTimeoutMs = 10;

	/* choose so that Talon does not report sensor out of phase */
	public static boolean kSensorPhase = true;

	/* choose based on what direction you want to be positive,
		this does not affect motor invert. */
	public static boolean kMotorInvert = false;
	
}

