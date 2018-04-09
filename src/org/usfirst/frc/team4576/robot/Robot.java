package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4576.robot.subsystems.Chassis;
import org.usfirst.frc.team4576.robot.subsystems.Elevator;
import org.usfirst.frc.team4576.robot.subsystems.Intaker;
import org.usfirst.frc.team4576.robot.subsystems.Lights;
import org.usfirst.frc.team4576.robot.subsystems.Pneumatics;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import redcore.BNO055;
import redcore.BNO055.reg_t;
import redcore.Pose;
import PowerUp2018.AutoStates.EAutoStates;
import PowerUp2018.MotionItem;
import PowerUp2018.AutoRecipes;
import PowerUp2018.FieldDimensions;

public class Robot extends IterativeRobot {

	public static final Chassis chassis = new Chassis();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Intaker intaker = new Intaker();
	public static final Elevator elevator = new Elevator();
	public static final Lights lights = new Lights();
	public static final Pose _Pose = new Pose();

	public static BNO055 imu;
	public static String gameData;

	public static OI oi;

	public static Joystick driveStick = new Joystick(0);
	public static Joystick secondaryStick = new Joystick(1);

	public int _iCurrentMotionIndex = 0;

	public static Timer t = new Timer();

	public double _CurrentLeftEncoderPosition;
	public double _CurrentRightEncoderPosition;
	public double _CurrentLiftEncoderPosition;
	private double _CurrentLeftEncoderBeforeMove;
	private double _CurrentRightEncoderBeforeMove;
	private double _CurrentLeftEncoderAfterMove;
	private double _CurrentRightEncoderAfterMove;
	private double _ActualDistancetraveledAveragedBefore;
	private double _ActualDistancetraveledAveragedAfter;
	private double _FinalPoseClicks;
	private double _FinalPoseInchs;

	public double _CurrentHeading;
	private double _EndHeading;
	private double _PoseHeading;

	Command teleopCommand;
	Command autonomousCommand;
	//sets the starting pose for the grid of the field 
	final String startingPoseRight = "Right";
	final String startingPoseMiddle = "Middle";
	final String startingPoseLeft = "Left";

	//auto recipes 
	final String autoLeftScale = "LeftScale";
	final String autoLeftSwitch = "LeftSwitch";
	final String autoMiddleSwitch = "MiddleSwitch";
	final String autoMiddleScale = "MiddleScale";
	final String autoRightSwitch = "RightSwitch";
	final String autoRightScale = "RightScale";
	final String autoLeftScale2cubes = "LeftSwitch2cubes";
	final String autoRightScale2cubes = "RightSwitch2cubes";
	final String autoLeftSwitch2cubes = "autoLeftSwitch2cubes";
	final String autoRightSwitch2cubes = "autoRightSwitch2cubes";
	final String autoTest = "AutoTest";
	
	String startingPose;
	String autoSelected;
//	SendableChooser<String> chooser1 = new SendableChooser<>();
	SendableChooser<String> chooser = new SendableChooser<>();
	
	public double _kF = 0.0;
	public double _kP = 0.0;
	public double _kI = 0.0;
	public double _kD = 0.0;

	public void SetDrivePID() {
		//pid values that will be moved post SMR 2018
		_kP = SmartDashboard.getNumber("kP", 0.0);
		_kI = SmartDashboard.getNumber("kI", 0.0);
		_kD = SmartDashboard.getNumber("kD", 0.0);
		System.out.println("kP = " + _kP + " kI = " + _kI + " kD = " + _kD);
	}
	public void robotInit() {
		// For Testing purposes
		//game data
		imu = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_IMUPLUS, BNO055.vector_type_t.VECTOR_EULER);
		CameraServer.getInstance().startAutomaticCapture("cam0", 0);
		CameraServer.getInstance().startAutomaticCapture("cam1", 1);
		/* choose the sensor and sensor direction */
		
		Robot.elevator.tsrxE.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, RobotMap.kPIDLoopIdx,
				RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.setSensorPhase(true);

		Robot.chassis.tsrxL.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, RobotMap.kPIDLoopIdx,
				RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.setSensorPhase(false);

		Robot.chassis.tsrxR.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, RobotMap.kPIDLoopIdx,
				RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.setSensorPhase(false);

		/* set the peak and nominal outputs, 12V means full */
		Robot.chassis.tsrxL.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);

		Robot.chassis.tsrxR.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);

		Robot.elevator.tsrxE.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);
		/*
		 * set the allowable closed-loop error, Closed-Loop output will be
		 * neutral within this range. See Table in Section 17.2.1 for native
		 * units per rotation.
		 */
		Robot.chassis.tsrxL.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx,
				RobotMap.kTimeoutMs); /* always servo */
		Robot.chassis.tsrxR.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx,
				RobotMap.kTimeoutMs); /* always servo */
		Robot.elevator.tsrxE.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx,
				RobotMap.kTimeoutMs); /* always servo */

		/* set acceleration and vcruise velocity - see documentation */
		Robot.chassis.tsrxL.configMotionCruiseVelocity(15000, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.configMotionAcceleration(9500, RobotMap.kTimeoutMs);

		Robot.chassis.tsrxR.configMotionCruiseVelocity(15000, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configMotionAcceleration(9500, RobotMap.kTimeoutMs);

		Robot.elevator.tsrxE.configMotionCruiseVelocity(7500, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.configMotionAcceleration(7500, RobotMap.kTimeoutMs);
		/* zero the sensor */
		Robot.chassis.tsrxL.setSelectedSensorPosition(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.setSelectedSensorPosition(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.setSelectedSensorPosition(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);

		System.out.println("RNR 2018 Robot Code Powering Up...");
		oi = new OI();

		teleopCommand = new DriveWithJoysticks();

		//Auto selection
		chooser.addObject("LeftSide Scale 2 Cubes", autoLeftScale2cubes);
		chooser.addObject("RightSide Scale 2 Cubes", autoRightScale2cubes);
		chooser.addObject("Left Switch", autoLeftSwitch);
		chooser.addObject("Right Switch", autoRightSwitch);
		chooser.addObject("Right Switch 2 cubes", autoRightSwitch2cubes);
		chooser.addObject("Left Switch 2 cubes", autoLeftSwitch2cubes);

		chooser.addDefault("Default", autoTest);
	
		//Pose selection
	//	chooser.addObject("Right Pose", startingPoseRight);
	//	chooser.addObject("Left Pose", startingPoseLeft);
	//	chooser.addDefault("Middle Pose", startingPoseMiddle);


	//	SmartDashboard.putData("Set starting pose", chooser1);
		SmartDashboard.putData("Auto Choices", chooser);

	//	startingPose = chooser1.getSelected();
		autoSelected = chooser.getSelected();

	}

	public void disabledInit() {
		SmartDashboard.putNumber("kP", _kP);
		SmartDashboard.putNumber("kI", _kI);
		SmartDashboard.putNumber("kD", _kD);
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
		//lights.setLights(77);
		/* clear our buffer and put everything into a known state */
		Robot.chassis.tsrxL.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);

		autoSelected = chooser.getSelected();
		//startingPose = chooser1.getSelected();
	}

	public void UpdateDriveCoreComponents() {
		_CurrentLiftEncoderPosition = Robot.elevator.tsrxE.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);

		_CurrentLeftEncoderPosition = -Robot.chassis.tsrxL.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);
		_CurrentRightEncoderPosition = Robot.chassis.tsrxR.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);

		double dDistanceLeft_inches = FieldDimensions.dInchesPerClicks * _CurrentLeftEncoderPosition;
	    double dDistanceRight_inches = FieldDimensions.dInchesPerClicks * _CurrentRightEncoderPosition;
		double dDistanceLift_inches = FieldDimensions.dLiftInchesPerClicks * _CurrentLiftEncoderPosition;
		SmartDashboard.putNumber("Left Inches", dDistanceLeft_inches);
		SmartDashboard.putNumber("Right Inches", dDistanceRight_inches);
		SmartDashboard.putNumber("Lift Inches", dDistanceLift_inches);
	}

	// *************** FSM zone
	// **********************************************************
	public static EAutoStates _eCurrentAutoState; // current auto state
	public EAutoStates _ePreviousAutoState; // current auto state
	public double _TargetLiftEncoderPosition;
	public double _TargetLeftEncoderPosition;
	public double _TargetRightEncoderPosition;
	public static MotionItem[] _Selected_AutoRecipe; // the current array of
														// motion items selected
														// at start of autoInit
	public static MotionItem _CurrentMotionItem; // current position in the
													// array
	static int _iCurrentMotionItemIndex; // current position in the drive recipe
	public static final double _dMoveTolerance = 500.0;
	public static final double _dLiftTolerance = 500.0;

	public double _dTimerEnd_sec;

	public void MoveToNextMotionItemInSelectedRecipe() {
		_iCurrentMotionItemIndex++; // move to the next motion item in the auto
									// recipe
		_CurrentMotionItem = _Selected_AutoRecipe[_iCurrentMotionItemIndex];
		_eCurrentAutoState = _CurrentMotionItem.eAutoState;
	}

	public boolean IsCloseEnough() {
		double dLeftError = Math.abs(_TargetLeftEncoderPosition - _CurrentLeftEncoderPosition);
		double dRightError = Math.abs(_TargetRightEncoderPosition - _CurrentRightEncoderPosition);
		return (dLeftError < _dMoveTolerance && dRightError < _dMoveTolerance);
	}

	public void DriveToTargetEncoderPositions() {
		Robot.chassis.tsrxL.set(ControlMode.MotionMagic, -_TargetLeftEncoderPosition);
		Robot.chassis.tsrxR.set(ControlMode.MotionMagic, _TargetRightEncoderPosition);
	}

	public void SetTargetEncoderPositionsByInches(double dLeft_inch, double dRight_inch) {
		_TargetLeftEncoderPosition = _CurrentLeftEncoderPosition + (dLeft_inch * FieldDimensions.dClicksPerInch);
		_TargetRightEncoderPosition = _CurrentRightEncoderPosition + (dRight_inch * FieldDimensions.dClicksPerInch);
	}

	public boolean IsLiftCloseEnough() {
		double dLiftError = Math.abs(_TargetLiftEncoderPosition - _CurrentLiftEncoderPosition);
		System.out.println(_TargetLiftEncoderPosition + " - " + _CurrentLiftEncoderPosition + " - " + dLiftError);
		return (dLiftError < _dLiftTolerance);
	}

	public void MoveLiftToTargetLiftPosition() {
		Robot.elevator.tsrxE.set(ControlMode.MotionMagic, _TargetLiftEncoderPosition);
	}

	public void SetTargetLiftPositionByInches(double dLift_Height_inch) {
		_TargetLiftEncoderPosition = _CurrentLiftEncoderPosition
				+ (dLift_Height_inch * FieldDimensions.dLiftClicksPerInch);
		System.out.println("Target Lift Encoder" + _TargetLiftEncoderPosition);
	}

	public void UpdateFSM() {
		if (_ePreviousAutoState != _eCurrentAutoState)
			System.out.println(_eCurrentAutoState.name());
		_ePreviousAutoState = _eCurrentAutoState;
		
		switch(_eCurrentAutoState){

			case eIdle: // do nothing
				break;

			case eSetLiftHeight:
			{
				SetTargetLiftPositionByInches(_CurrentMotionItem.dParam1);
				MoveLiftToTargetLiftPosition();
				_eCurrentAutoState = EAutoStates.eChained_WaitLift;
			}
			break;
			case eChained_WaitLift:
			{
				if (IsLiftCloseEnough()) {
					Robot.elevator.tsrxE.set(ControlMode.PercentOutput, 0);
					MoveToNextMotionItemInSelectedRecipe();
				}
			}
			break;
			case eDriveForward:
			{
				_CurrentLeftEncoderBeforeMove = -Robot.chassis.tsrxL.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);
				_CurrentRightEncoderBeforeMove = Robot.chassis.tsrxR.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);
				System.out.println("Left before: " + _CurrentLeftEncoderBeforeMove + " Right before: " +_CurrentRightEncoderBeforeMove);
				
				SetTargetEncoderPositionsByInches(_CurrentMotionItem.dParam1, _CurrentMotionItem.dParam1);
				DriveToTargetEncoderPositions();
				_eCurrentAutoState = EAutoStates.eChained_MoveWait; // chained event, first to move, then check
				System.out.println("Hit eDriveForward (" + _TargetLeftEncoderPosition + ", " + _TargetRightEncoderPosition + ")");
			}
			break;
			case eStoppedTurn:
			{
				double dWheelDrive_in = _CurrentMotionItem.dParam1 * FieldDimensions.dInchesPerDegree;
				SetTargetEncoderPositionsByInches(dWheelDrive_in, -dWheelDrive_in);
				_CurrentHeading = Robot.imu.getHeading();
				DriveToTargetEncoderPositions();
				_eCurrentAutoState = EAutoStates.eChained_MoveWait; // chained event, first to move, then check
			}
			break;		
			case eStartTimer: 
			{
				_dTimerEnd_sec = _CurrentMotionItem.dParam1 + Timer.getFPGATimestamp();
				_eCurrentAutoState = EAutoStates.eChained_WaitTimer;
			}
			break;
			case eChained_WaitTimer: 
			{
				if (Timer.getFPGATimestamp() >= _dTimerEnd_sec) {
					MoveToNextMotionItemInSelectedRecipe();
				}
			}
			break;
			case eChained_MoveWait:
			{
				if (IsCloseEnough()) {
					_CurrentLeftEncoderAfterMove = -Robot.chassis.tsrxL.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);
					_CurrentRightEncoderAfterMove = Robot.chassis.tsrxR.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);
					_EndHeading = Robot.imu.getHeading();
					_PoseHeading = _EndHeading - _CurrentHeading;
					_Pose.RelativeTurn(_PoseHeading);
					System.out.println("Starting Heading: "+ _CurrentHeading + " End heading: " + _EndHeading + " Pose Heading: " + _PoseHeading); 
					System.out.println("Left After: " + _CurrentLeftEncoderAfterMove + " Right After: " +_CurrentRightEncoderAfterMove);

					//System.out.println("Hit eChained_MoveWait (" + _CurrentLeftEncoderPosition + ", " + _CurrentRightEncoderPosition + ")");
					_ActualDistancetraveledAveragedBefore = (_CurrentLeftEncoderBeforeMove + _CurrentRightEncoderBeforeMove) * 0.5;
					_ActualDistancetraveledAveragedAfter = (_CurrentLeftEncoderAfterMove + _CurrentRightEncoderAfterMove) * 0.5;
					System.out.println("Before Averaged: " + _ActualDistancetraveledAveragedBefore + " After Averaged: " + _ActualDistancetraveledAveragedAfter);

					_FinalPoseClicks = _ActualDistancetraveledAveragedAfter - _ActualDistancetraveledAveragedBefore;
					_FinalPoseInchs = _FinalPoseClicks / FieldDimensions.dClicksPerInch;
					System.out.println("Final Pose Clicks: " + _FinalPoseClicks);
					System.out.println("Final Pose Inches: " + _FinalPoseInchs);
					System.out.println("X: " + _Pose._x + "Y: " + _Pose._y);
					_Pose.DriveForward(_FinalPoseInchs);
					MoveToNextMotionItemInSelectedRecipe();
				}
			}
			break; 
			case eStopMotors:  
			{
				Robot.chassis.tsrxL.set(ControlMode.PercentOutput, 0);
				Robot.chassis.tsrxR.set(ControlMode.PercentOutput, 0);

				MoveToNextMotionItemInSelectedRecipe();
			}
			break;
			case eStopElevator:  
			{
				Robot.elevator.tsrxE.set(ControlMode.PercentOutput, 0);
				MoveToNextMotionItemInSelectedRecipe();
			}
			break;
			case eGripper_Stop:
			{
				Robot.intaker.stop();
				MoveToNextMotionItemInSelectedRecipe();
			}
			break;
			case eGripper_Intake:
			{
				Robot.intaker.intake();
				MoveToNextMotionItemInSelectedRecipe();
			}
			break;
			case eGripper_Release:
			{
				Robot.intaker.release();
				MoveToNextMotionItemInSelectedRecipe();
			}
			break;
			case eGripper_SetArm:
			{
				Robot.pneumatics.setPositionIntakeArm(_CurrentMotionItem.dParam1 >= 1.0);
				MoveToNextMotionItemInSelectedRecipe();
			}
			break;
			case eBNOTurn:
			{
				double targetHeading = _CurrentMotionItem.dParam1;
				if (Robot.imu.getHeading() + targetHeading > targetHeading){
						Robot.chassis.setLeftRight(-.25, .25);
				}
				if (Robot.imu.getHeading() + targetHeading < targetHeading){
						Robot.chassis.setLeftRight(.25, -.25);
				}
				else if (Robot.imu.getHeading() == targetHeading){
					_eCurrentAutoState = EAutoStates.eChained_MoveWait;
				}
			}
			break;
			case eEmergencyStop:
			default: // unknown, bad things without this .. when in doubt, idle
				System.out.print(_eCurrentAutoState.name());
				// emergency stop
				Robot.elevator.tsrxE.set(ControlMode.PercentOutput, 0);
				Robot.chassis.tsrxL.set(ControlMode.PercentOutput, 0);
				Robot.chassis.tsrxR.set(ControlMode.PercentOutput, 0);
				_eCurrentAutoState = EAutoStates.eIdle;
				break;
	}
}

	public static void InitializeAutoRecipe(MotionItem[] AutoRecipe) {
		System.out.println("Hit InitializeAutoRecipe");

		_Selected_AutoRecipe = AutoRecipe;

		_iCurrentMotionItemIndex = 0; // We use this to keep track of the
										// current motion item in the recipe
		_CurrentMotionItem = _Selected_AutoRecipe[_iCurrentMotionItemIndex];
		_eCurrentAutoState = _CurrentMotionItem.eAutoState;
	}
	// *************** End FSM zone
	// **********************************************************

	// *************** Start Auto zone
	// **********************************************************
	public void autonomousInit() {		
		System.out.println("Hit Auto Init!!!!!!!!");
		SetDrivePID();
		/* set closed loop gains in slot0 */
		Robot.chassis.tsrxL.config_kF(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.config_kP(RobotMap.kPIDLoopIdx, _kP, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.config_kI(RobotMap.kPIDLoopIdx, _kI, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.config_kD(RobotMap.kPIDLoopIdx, _kD, RobotMap.kTimeoutMs);

		Robot.chassis.tsrxR.config_kF(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.config_kP(RobotMap.kPIDLoopIdx, _kP, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.config_kI(RobotMap.kPIDLoopIdx, _kI, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.config_kD(RobotMap.kPIDLoopIdx, _kD, RobotMap.kTimeoutMs);

		Robot.elevator.tsrxE.config_kF(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.config_kP(RobotMap.kPIDLoopIdx, 0.05, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.config_kI(RobotMap.kPIDLoopIdx, 0.0005, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.config_kD(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);

		
		gameData = DriverStation.getInstance().getGameSpecificMessage(); // get game data after sent
		 
		_eCurrentAutoState = EAutoStates.eEmergencyStop; // just to make sure
		UpdateFSM();
		
		//startingPose = chooser1.getSelected();
		autoSelected = chooser.getSelected();

		switch (autoSelected) {
		case autoLeftSwitch2cubes: /*new*/
			if (Robot.gameData.charAt(0) == 'R') {
				InitializeAutoRecipe(AutoRecipes._LeftSide_RightSwitch_2cubes);
			}
			else if (Robot.gameData.charAt(0) == 'L') {
				InitializeAutoRecipe(AutoRecipes._LeftSide_LeftSwitch_2cube);
			}
			break;
			
		case autoRightSwitch2cubes: /*new*/
			if (Robot.gameData.charAt(0) == 'L') {
				InitializeAutoRecipe(AutoRecipes._RightSide_LeftSwitch_2cube);
			}
			else if (Robot.gameData.charAt(0) == 'R') {
				InitializeAutoRecipe(AutoRecipes._RightSide_RightSwitch_2cube);
			}
			break;
			
		case autoLeftScale2cubes:
			if (gameData.charAt(1) == 'L' && Robot.gameData.charAt(0) == 'R') {
				InitializeAutoRecipe(AutoRecipes._LeftSide_LeftScale_2cubes);
			}
			else if  (Robot.gameData.charAt(0) == 'L' && gameData.charAt(1) == 'L') {
				InitializeAutoRecipe(AutoRecipes._LeftSide_LeftScaleLeftSwitch_2cubes);
			}
			break;
			
		case autoRightScale2cubes:
			if (gameData.charAt(1) == 'R' && Robot.gameData.charAt(0) == 'L') {
				InitializeAutoRecipe(AutoRecipes._RightSide_RightScale_2cubes);
			}
			else if (gameData.charAt(1) == 'R' && Robot.gameData.charAt(0) == 'R') {
				InitializeAutoRecipe(AutoRecipes._RightSide_RightScaleRightSwitch_2cubes);
			}
			break;
			
		case autoRightSwitch:
			if (Robot.gameData.charAt(0) == 'R') {
				InitializeAutoRecipe(AutoRecipes._RightSide_RightSwitch_1cube);
			}
			else if (Robot.gameData.charAt(0) == 'L') {
				InitializeAutoRecipe(AutoRecipes._RightSide_LeftSwitch_1cube);
			}
			break;
			
		case autoLeftSwitch:
			if (Robot.gameData.charAt(0) == 'L') {
				InitializeAutoRecipe(AutoRecipes._LeftSide_LeftSwitch_1cube);
			}
			else if (Robot.gameData.charAt(0) == 'R') {
				InitializeAutoRecipe(AutoRecipes._LeftSide_RightSwitch_1cube);
			}
			break;
			
		case autoTest:
			InitializeAutoRecipe(AutoRecipes._Baseline_);

			break;
		default:
			InitializeAutoRecipe(AutoRecipes._Baseline_);
			break;

		}
		System.out.println("Auto selected: " + autoSelected);

		if (autonomousCommand != null)
			autonomousCommand.start();
	}
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		UpdateDriveCoreComponents();
		UpdateFSM();
		//startingPose = chooser1.getSelected();
		autoSelected = chooser.getSelected();
		SmartDashboard.putNumber("X", _Pose._x);
		SmartDashboard.putNumber("Y", _Pose._y);
		SmartDashboard.putNumber("Heading", _Pose._heading_deg);
		SmartDashboard.putNumber("Heading BNO", Robot.imu.getHeading());

	}
	// *************** End Auto zone
	// **********************************************************

	// *************** Start Teleop zone
	// **********************************************************
	public void teleopInit() {
		_eCurrentAutoState = EAutoStates.eEmergencyStop; // just to make sure
		UpdateFSM();
		SetDrivePID();
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		teleopCommand.start();

	}
       public void teleopPeriodic()  {
		Scheduler.getInstance().run();
		UpdateDriveCoreComponents(); // shared with auto
		UpdateFSM();

		SmartDashboard.putNumber("Left Encoder", _CurrentLeftEncoderPosition);
		SmartDashboard.putNumber("Right Encoder", _CurrentRightEncoderPosition);
		SmartDashboard.putBoolean("Compressor on", pneumatics.c.enabled());
		SmartDashboard.putNumber("Rpm left", chassis.getLeftSpeed());
		SmartDashboard.putNumber("Rpm right", chassis.getRightSpeed());
		SmartDashboard.putNumber("PSI", pneumatics.getPsi());
		SmartDashboard.putBoolean("High Gear", pneumatics.getShift());
		SmartDashboard.putNumber("Heading", imu.getHeading());
		SmartDashboard.putBoolean("Calibration", imu.isCalibrated());
		//SmartDashboard.putNumber("Pitch", imu.Picth());
		//SmartDashboard.putNumber("Roll", imu.Roll());

		SmartDashboard.putNumber("Lift Encoder", _CurrentLiftEncoderPosition);

		// SmartDashboard.putNumber("Amperage", );
		// SmartDashboard.putNumber("Accelerometer",
		// reg_t.BNO055_ACCEL_DATA_X_LSB_ADDR.getVal());
		// SmartDashboard.putNumber("Magnometer",
		// reg_t.BNO055_MAG_DATA_X_LSB_ADDR.getVal());
		// SmartDashboard.putNumber("Gyro",
		// reg_t.BNO055_GYRO_DATA_X_LSB_ADDR.getVal());
		// SmartDashboard.putNumber("Psensor RawVolts", pneumatics.rawVolts());
	}

	public void testPeriodic() {
		LiveWindow.setEnabled(true);
	}
	// *************** End Teleop zone
	// **********************************************************

}