package org.usfirst.frc.team4576.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import redcore.AxisButton;

import org.usfirst.frc.team4576.robot.commands.ElevDown;
import org.usfirst.frc.team4576.robot.commands.ElevUp;
import org.usfirst.frc.team4576.robot.commands.Intake;
import org.usfirst.frc.team4576.robot.commands.IntakeArm;
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
	Button dsB = new JoystickButton(Robot.driveStick, 2);
	Button dsX = new JoystickButton(Robot.driveStick, 3);
	Button dsY = new JoystickButton(Robot.driveStick, 4);
	Button dsLB = new JoystickButton(Robot.driveStick, 5);
	Button dsRB = new JoystickButton(Robot.driveStick, 6);
	Button dsBACK = new JoystickButton(Robot.driveStick, 7);
	Button dsSTART = new JoystickButton(Robot.driveStick, 8);
	Button dsLSTICK = new JoystickButton(Robot.driveStick, 9);
	Button dsRSTICK = new JoystickButton(Robot.driveStick, 10);

	


//	AxisButton rTrigger = new AxisButton(Robot.secondaryStick, 3, 0, 0, false);
//	AxisButton lTrigger = new AxisButton(Robot.secondaryStick, 2, 0, 0, false);
	Button ssY = new JoystickButton(Robot.secondaryStick, 4);
	Button ssLB = new JoystickButton(Robot.secondaryStick, 5);
	Button ssRB = new JoystickButton(Robot.secondaryStick, 6);

	// AxisButton RT = new AxisButton(Robot.secondaryStick, 3, 0.5, 0.5);
	public OI() {
		/*Single Operator Control*/
		dsX.whenPressed(new Shift(true));
		dsA.whenPressed(new Shift(false));
		dsBACK.whenPressed(new ToggleCompressor(false));
		dsSTART.whenPressed(new ToggleCompressor(true));
		dsY.whileHeld(new Intake(true));
		dsY.whenReleased(new Intake(false));
		dsB.whileHeld(new Release(true));
		dsB.whenReleased(new Release(false));
		dsLB.whileHeld(new ElevUp(true));
		dsLB.whenReleased(new ElevUp(false));
		dsRB.whileHeld(new ElevDown(true));
		dsRB.whenReleased(new ElevUp(false));
		dsRSTICK.whenPressed(new IntakeArm());
		/**/
		
		/*Dual Operator Control
		dsX.whenPressed(new Shift(true));
		dsA.whenPressed(new Shift(false));
		dsBACK.whenPressed(new ToggleCompressor(false));
		dsSTART.whenPressed(new ToggleCompressor(true));
		dsLB.whileHeld(new Intake(true));
		dsLB.whenReleased(new Intake(false));
		
		ssLB.whileHeld(new ElevDown(true));
		ssLB.whenReleased(new ElevDown(false));
		ssRB.whileHeld(new ElevUp(true));
		ssRB.whenReleased(new ElevUp(false));
		ssY.whileHeld(new Release(true));
		ssY.whenReleased(new Release(false));
		*/

}
}
