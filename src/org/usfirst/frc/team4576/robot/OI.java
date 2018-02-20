package org.usfirst.frc.team4576.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import org.usfirst.frc.team4576.robot.commands.Intake;
import org.usfirst.frc.team4576.robot.commands.Release;
import org.usfirst.frc.team4576.robot.commands.Shift;
import org.usfirst.frc.team4576.robot.commands.ToggleCompressor;

//*******************************************************************
//OI 	 						Author: Robert Lohmann
//								Last Edited: 2/14/2018 by RL
//This class is the glue that binds the controls on the physical operator
//interface to the commands and command groups that allow control of the robot.
//*******************************************************************
// Button Values:
// 1: A
// 2: B
// 3: X
// 4: Y
// 5: Left Bumper
// 6: Right Bumper
// 7: Back
// 8: Start
// 9: Left Joystick pressed down
// 10: Right Joystick pressed down
//
// Axis values:
// 1 - LeftX
// 2 - LeftY
// 3 - Triggers (Each trigger = 0 to 1, axis value = right - left)
// 4 - RightX
// 5 - RightY
// 6 - DPad Left/Right
public class OI {
	Button dsA = new JoystickButton(Robot.driveStick, 1);
	Button dsX = new JoystickButton(Robot.driveStick, 3);
	Button dsBACK = new JoystickButton(Robot.driveStick, 7);
	Button dsSTART = new JoystickButton(Robot.driveStick, 8);
	Button dsLB = new JoystickButton(Robot.driveStick, 5);
	Button dsRB = new JoystickButton(Robot.driveStick, 6);

	Button ssA = new JoystickButton(Robot.driveStick, 1);
	Button ssX = new JoystickButton(Robot.driveStick, 3);
	Button ssBACK = new JoystickButton(Robot.driveStick, 7);
	Button ssSTART = new JoystickButton(Robot.driveStick, 8);
	Button ssLB = new JoystickButton(Robot.driveStick, 5);
	Button ssRB = new JoystickButton(Robot.driveStick, 6);

	public static final String singleControl = "Single Operator Control:";
	public static final String dualControl = "Dual Operator Control:";
	public static SendableChooser<String> oichooser = new SendableChooser<>();
	// AxisButton RT = new AxisButton(Robot.secondaryStick, 3, 0.5, 0.5);
	public OI() {
		dsX.whenPressed(new Shift(true));
		dsA.whenPressed(new Shift(false));
		dsBACK.whenPressed(new ToggleCompressor(false));
		dsSTART.whenPressed(new ToggleCompressor(true));
		dsLB.whileHeld(new Intake(true));
		dsLB.whenReleased(new Intake(false));
		dsRB.whileHeld(new Release(true));
		dsRB.whenReleased(new Release(false));
		
}
}
