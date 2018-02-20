package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.Intake;
import org.usfirst.frc.team4576.robot.commands.Release;
import org.usfirst.frc.team4576.robot.commands.Shift;
import org.usfirst.frc.team4576.robot.commands.ToggleCompressor;
//import org.usfirst.frc.team4576.robot.commands.ToggleFlashlight;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

// Button Values:
//
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
//
// Axis values:
//
// 1 - LeftX
// 2 - LeftY
// 3 - Triggers (Each trigger = 0 to 1, axis value = right - left)
// 4 - RightX
// 5 - RightY
// 6 - DPad Left/Right
public class OI {
	Button dsY = new JoystickButton(Robot.driveStick, 4);
	Button dsA = new JoystickButton(Robot.driveStick, 1);
	Button dsX = new JoystickButton(Robot.driveStick, 3);
	Button dsLPRESS = new JoystickButton(Robot.driveStick, 9);
	Button dsRPRESS = new JoystickButton(Robot.driveStick,10);	
	Button dsLB = new JoystickButton(Robot.driveStick, 5);
	Button dsRB = new JoystickButton(Robot.driveStick, 6);

	
	
	public OI() {
		
		dsX.whenPressed(new Shift(true));
		dsA.whenPressed(new Shift(false));
		dsLPRESS.whenPressed(new ToggleCompressor(false));
		dsRPRESS.whenPressed(new ToggleCompressor(true));
	
		//dsLB.whileHeld(new Shoot(true));
		//dsLB.whenReleased(new Shoot(false));

		dsRB.whileHeld(new Release(true));
		dsRB.whenReleased(new Release(false));
		
		dsY.whileHeld(new Intake(true));

	}
}