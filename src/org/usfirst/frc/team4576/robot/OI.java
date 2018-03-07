package org.usfirst.frc.team4576.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4576.robot.commands.ElevDown;
import org.usfirst.frc.team4576.robot.commands.ElevUp;
import org.usfirst.frc.team4576.robot.commands.Intake;
import org.usfirst.frc.team4576.robot.commands.IntakeArm;
import org.usfirst.frc.team4576.robot.commands.LEDMode;
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

	Button ssA = new JoystickButton(Robot.secondaryStick, 1);
	Button ssB = new JoystickButton(Robot.secondaryStick, 2);
	Button ssX = new JoystickButton(Robot.secondaryStick, 3);
	Button ssY = new JoystickButton(Robot.secondaryStick, 4);
	Button ssLB = new JoystickButton(Robot.secondaryStick, 5);
	Button ssRB = new JoystickButton(Robot.secondaryStick, 6);
	Button ssBACK = new JoystickButton(Robot.secondaryStick, 7);
	Button ssSTART = new JoystickButton(Robot.secondaryStick, 8);
	Button ssLSTICK = new JoystickButton(Robot.secondaryStick, 9);
	Button ssRSTICK = new JoystickButton(Robot.secondaryStick, 10);


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
		
		ssA.whenPressed(new LEDMode(16));
		ssB.whenPressed(new LEDMode(7));
		ssX.whenPressed(new LEDMode(6));
		ssY.whenPressed(new LEDMode(22));
		ssLB.whenPressed(new LEDMode(23));
		ssRB.whenPressed(new LEDMode(28));
		ssBACK.whenPressed(new LEDMode(33));
		ssSTART.whenPressed(new LEDMode(36));
		ssLSTICK.whenPressed(new LEDMode(72));
		ssRSTICK.whenPressed(new LEDMode(8));





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
		ssA.whenPressed(new ElevFast(false));
		ssB.whenPressed(new ElevFast(true));
		
		ssX.whenPressed(new LEDMode(6));	
		ssBACK.whenPressed(new LEDMode(33));
		ssSTART.whenPressed(new LEDMode(36));
		ssLSTICK.whenPressed(new LEDMode(72));
		ssRSTICK.whenPressed(new LEDMode(8));
		
		*/

}
}
