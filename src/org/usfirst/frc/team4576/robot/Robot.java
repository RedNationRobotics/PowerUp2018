package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.AutoDriveStraight;
import org.usfirst.frc.team4576.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4576.robot.commands.ToggleCompressor;
import org.usfirst.frc.team4576.robot.subsystems.Chassis;
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

public class Robot extends IterativeRobot {

	public static final Chassis chassis = new Chassis();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Intaker intaker = new Intaker();
	
	public static BNO055 imu;
	public static OI oi;

	public static Joystick driveStick = new Joystick(0);

	Command teleopCommand;
	Command autonomousCommand;

	final String autoDriveStraight = "DriveStraight";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();

	public void robotInit() {
		
		Robot.chassis.tsrxL.setSensorPhase(true);

		Robot.chassis.tsrxL.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);

		Robot.chassis.tsrxL.config_kF(RobotMap.kPIDLoopIdx, 0.1097, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.config_kP(RobotMap.kPIDLoopIdx, 0.113333, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.config_kI(RobotMap.kPIDLoopIdx, 0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.config_kD(RobotMap.kPIDLoopIdx, 0, RobotMap.kTimeoutMs);
		
		Robot.chassis.tsrxR.setSensorPhase(true);

		Robot.chassis.tsrxR.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);

		Robot.chassis.tsrxR.config_kF(RobotMap.kPIDLoopIdx, 0.1097, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.config_kP(RobotMap.kPIDLoopIdx, 0.113333, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.config_kI(RobotMap.kPIDLoopIdx, 0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.config_kD(RobotMap.kPIDLoopIdx, 0, RobotMap.kTimeoutMs);

		Robot.chassis.tsrxL.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);

		System.out.println("RNR 2018 Robot Code Powering up...");
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
	}

	public void testPeriodic() {
		LiveWindow.setEnabled(true);
	}
}
