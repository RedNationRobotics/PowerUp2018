package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LEDMode extends Command {

	  int selectedrow, row;

		public LEDMode(int selectedrow) {
				requires(Robot.lights);
				row = selectedrow;
				
			}
			@Override
			protected void initialize() {
				Robot.lights.setLights(row);
			}

			@Override
			protected void execute() {
			//	Robot.lights.setLights(row);
			}

			@Override
			protected boolean isFinished() {
				// changed to true to check issues
				return false;
			}

			@Override
			protected void end() {
			}

			@Override
			protected void interrupted() {

			}

		}
