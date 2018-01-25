package org.usfirst.frc.team4576.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
//<<<<<<< HEAD

	// Talon IDs:
	public static int LEFT_MASTER = 0;
	public static int RIGHT_MASTER = 1;
	public static int LEFT_SLAVE = 2;
	public static int RIGHT_SLAVE = 3;
	
	public static int SHIFT_SOLENOID = 0;
	
	/**
	 * Which PID slot to pull gains from.  Starting 2018, you can choose 
	 * from 0,1,2 or 3.  Only the first two (0,1) are visible in web-based configuration.
	 */
	public static final int kSlotIdx = 0;
	
	/* Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops.  
	 * For now we just want the primary one.
	 */
	public static final int kPIDLoopIdx = 0;

	/*
	 * set to zero to skip waiting for confirmation, set to nonzero to wait
	 * and report to DS if action fails.
	 */
	public static final int kTimeoutMs = 10;

=======
	
	public static final int SHIFT_SOLENOID = 0;
	
>>>>>>> 741e3260c5eee36a95f1a3419adcbbbbbca873c7
}

