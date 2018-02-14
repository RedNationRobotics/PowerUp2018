package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.AutoDriveStraight;
import org.usfirst.frc.team4576.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4576.robot.commands.ToggleCompressor;
import org.usfirst.frc.team4576.robot.subsystems.Chassis;
import org.usfirst.frc.team4576.robot.subsystems.Elevator;
import org.usfirst.frc.team4576.robot.subsystems.Intaker;
import org.usfirst.frc.team4576.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import redcore.BNO055;

//*******************************************************************
//Robot							Author: Robert Lohmann
//								Last Edited: 2/12/2018 by RL
//This class contains central methods for periodic control of the bot during the match. 
//Here, we declare our subsystems and set the choices for the autonomous.
//*******************************************************************
public class Robot extends IterativeRobot {

	public static final Chassis chassis = new Chassis();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Intaker intaker = new Intaker();
	public static final Elevator elevator = new Elevator();

	public static BNO055 imu;
	public static OI oi;

	public static Joystick driveStick = new Joystick(0);

	Command teleopCommand;
	Command autonomousCommand;

	final String autoDriveStraight = "DriveStraight";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();

	public void robotInit() {

		System.out.print("Red Nation Robotics 2018 Code Powering up....");
		oi = new OI();

		teleopCommand = new DriveWithJoysticks();

		// camera.setFPS(15);
		// camera.setResolution(320, 240);
		CameraServer.getInstance().startAutomaticCapture("cam0", 0);
		// CameraServer.getInstance().startAutomaticCapture("cam1",1);

		chooser.addDefault("Do Nothing.", null);
		chooser.addObject("Drive straight Encoders", autoDriveStraight);

		SmartDashboard.putData("Auto Selected:", chooser);
		
	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		autoSelected = chooser.getSelected();
	}

	public void autonomousInit() {
		Robot.chassis.initAuto();
		
		autoSelected = chooser.getSelected();

		switch (autoSelected) {
		case autoDriveStraight:
			autonomousCommand = new AutoDriveStraight();
			break;
		default:
			autonomousCommand = null;
			break;

		}

		System.out.println("Auto Selected: " + autoSelected);

		if (autonomousCommand != null)
			autonomousCommand.start();

	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();

	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		teleopCommand.start();

	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Left Encoder", Robot.chassis.tsrxL.getSelectedSensorPosition(RobotMap.kPIDLoopIdx));
		SmartDashboard.putNumber("Right Encoder", Robot.chassis.tsrxR.getSelectedSensorPosition(RobotMap.kPIDLoopIdx));
		SmartDashboard.putNumber("psensor rawVolts", Robot.pneumatics.rawVolts());
		SmartDashboard.putNumber("psensor PSI", Robot.pneumatics.getPsi());
		SmartDashboard.putNumber("BNO Heading", Robot.imu.getHeading());
		SmartDashboard.putString("Elevator PID", Robot.elevator.elevstring.toString());
	}

	public void testPeriodic() {
		LiveWindow.setEnabled(true);
	}
}
