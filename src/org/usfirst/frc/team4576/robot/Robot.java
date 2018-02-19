package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.AutoCrossBaseline;
import org.usfirst.frc.team4576.robot.commands.AutoDriveStraight;
import org.usfirst.frc.team4576.robot.commands.AutoLeftSwitch;
import org.usfirst.frc.team4576.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4576.robot.subsystems.Chassis;
import org.usfirst.frc.team4576.robot.subsystems.Elevator;
import org.usfirst.frc.team4576.robot.subsystems.Intaker;
import org.usfirst.frc.team4576.robot.subsystems.Pneumatics;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import redcore.BNO055;
import redcore.Course;

//*******************************************************************
//Robot							
//								Last Edited: 2/12/2018 by RL
//This class contains central methods for periodic control of the bot during the match. 
//Here, we declare our subsystems and set the choices for the autonomous.
//*******************************************************************
public class Robot extends IterativeRobot {

	public static Joystick driveStick1 = new Joystick(4);
	public static final Chassis chassis = new Chassis();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Intaker intaker = new Intaker();
	public static final Elevator elevator = new Elevator();

	public static String gameData = DriverStation.getInstance().getGameSpecificMessage();


	public static BNO055 imu;
	public static OI oi;

	public static Joystick driveStick = new Joystick(0);
	public static Joystick secondaryStick = new Joystick(1);

	Command teleopCommand;
	Command autonomousCommand;

	final String autoDriveStraight = "DriveStraight";
	final String autoCrossBaseline = "CrossBaseline";
	final String autoLeftSwitch	= "LeftSwitch";
	String autoSelected;


	Course.RobotInterface _CourseRobotInterface = new Course.RobotInterface() {
		
		@Override
		public double FetchJoystickLeftRight() {
			
			return Robot.driveStick1.getRawAxis(4);
		}
		public double FetchHeading() {
			return imu.getHeading();
		}
	};
	
	public Course _Course = new Course(_CourseRobotInterface);
	

	public static String oiSelected;
	SendableChooser<String> chooser = new SendableChooser<>();

	public void robotInit() {
		Robot.chassis.tsrxL.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.setSensorPhase(true);
		Robot.chassis.tsrxR.setSensorPhase(true);

		/* set the peak, nominal outputs */
		Robot.chassis.tsrxL.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);

		Robot.chassis.tsrxR.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);

		/* set closed loop gains in slot0 */
		Robot.chassis.tsrxL.config_kF(RobotMap.CHASSIS_PID, 0.1097, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.config_kP(RobotMap.CHASSIS_PID, 0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.config_kI(RobotMap.CHASSIS_PID, 0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.config_kD(RobotMap.CHASSIS_PID, 0, RobotMap.kTimeoutMs);
		
		Robot.chassis.tsrxR.config_kF(RobotMap.CHASSIS_PID, 0.1097, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.config_kP(RobotMap.CHASSIS_PID, 0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.config_kI(RobotMap.CHASSIS_PID, 0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.config_kD(RobotMap.CHASSIS_PID, 0, RobotMap.kTimeoutMs);
		
		
		System.out.print("Red Nation Robotics 2018 Code Powering up....");
		imu= BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_IMUPLUS, BNO055.vector_type_t.VECTOR_EULER);
		teleopCommand = new DriveWithJoysticks();

		// camera.setFPS(15);
		// camera.setResolution(320, 240);
		CameraServer.getInstance().startAutomaticCapture("cam0", 0);
		// CameraServer.getInstance().startAutomaticCapture("cam1",1);

		chooser.addDefault("Do Nothing.", null);
		chooser.addObject("Drive straight Encoders", autoDriveStraight);

		
		chooser = new SendableChooser<>();

		chooser.addObject("Cross Baseline", autoCrossBaseline);
		chooser.addObject("Left Switch", autoLeftSwitch);

		SmartDashboard.putData("Auto Selected:", chooser);
	
		oi = new OI();

	}

	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		autoSelected = chooser.getSelected();
	}

	public void autonomousInit() {
		Robot.chassis.initAuto();
		
		//final String gameData = DriverStation.getInstance().getGameSpecificMessage(); 
    	//For Testing at the shop
		//gameData = "LLL";
		
		autoSelected = chooser.getSelected();

		switch (autoSelected) {
		case autoDriveStraight:
			autonomousCommand = new AutoDriveStraight();
			break;
		case autoCrossBaseline:
			autonomousCommand = new AutoCrossBaseline();
			break;
		case autoLeftSwitch:
			autonomousCommand = new AutoLeftSwitch();
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
		SmartDashboard.putNumber("Left Encoder", Robot.chassis.tsrxL.getSelectedSensorPosition(RobotMap.CHASSIS_PID));
		SmartDashboard.putNumber("Right Encoder", Robot.chassis.tsrxR.getSelectedSensorPosition(RobotMap.CHASSIS_PID));
		SmartDashboard.putNumber("psensor rawVolts", Robot.pneumatics.rawVolts());
		SmartDashboard.putNumber("psensor PSI", Robot.pneumatics.getPsi());
		SmartDashboard.putNumber("BNO Heading", imu.getHeading());
		SmartDashboard.putString("Elevator PID", Robot.elevator.elevstring.toString());
		SmartDashboard.putNumber("Elevator Encoder", Robot.elevator.tsrxE.getSelectedSensorPosition(RobotMap.ELEVATOR_PID));
	}

	public void testPeriodic() {
		LiveWindow.setEnabled(true);
	}
}