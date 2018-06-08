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
import redcore.Pose;
import redcore.Vector;
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

	public static BNO055 imu = BNO055.Instance();
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
	public double _FieldHeadingOffset_deg;
	
	Command teleopCommand;
	Command autonomousCommand;
	//sets the starting pose for the grid of the field 
	final String startingPoseRight = "Right";
	final String startingPoseMiddle = "Middle";
	final String startingPoseLeft = "Left";
	//auto recipes 
	final String autoRightSwitchScale = "RightSwitchScale";
	final String autoLeftSwitch = "LeftSwitch";
	final String autoMiddleSwitch = "Middle switch";
	final String autoRightSwitch = "Right switch";
	final String autoRightScale = "RightScale";
	final String autoLeftScale = "LeftScale";
	
	
	
	String startingPose;
	String autoSelected;
	SendableChooser<String> chooser1 = new SendableChooser<>();
	SendableChooser<String> chooser = new SendableChooser<>();
	
	public double _kF = 0.0;
	public double _kP = 1.030;
	public double _kI = 0.000025;
	public double _kD = 0.00008;

	public void SetDrivePID() {
		_kP = SmartDashboard.getNumber("kP", 1.030);
		_kI = SmartDashboard.getNumber("kI", 0.000025);
		_kD = SmartDashboard.getNumber("kD", 0.00008);
	}
	public void robotInit() {
		//byte[] calibrationData = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (byte)0xe0, 1};
		//imu.SetCalibrationData(calibrationData);
		
		CameraServer.getInstance().startAutomaticCapture("cam0", 0);
		CameraServer.getInstance().startAutomaticCapture("cam1", 1);

		Robot.chassis.tsrxL.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, RobotMap.kPIDLoopIdx,
				RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.setSensorPhase(false);

		Robot.chassis.tsrxR.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, RobotMap.kPIDLoopIdx,
				RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.setSensorPhase(false);

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
		
		Robot.chassis.tsrxL.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx,
				RobotMap.kTimeoutMs); /* always servo */
		Robot.chassis.tsrxR.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx,
				RobotMap.kTimeoutMs); /* always servo */
		Robot.elevator.tsrxE.configAllowableClosedloopError(0, RobotMap.kPIDLoopIdx,
				RobotMap.kTimeoutMs); /* always servo */

		/* set acceleration and vcruise velocity - see documentation */
		Robot.chassis.tsrxL.configMotionCruiseVelocity(15000, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.configMotionAcceleration(15000, RobotMap.kTimeoutMs);

		Robot.chassis.tsrxR.configMotionCruiseVelocity(15000, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.configMotionAcceleration(15000, RobotMap.kTimeoutMs);

		Robot.elevator.tsrxE.configMotionCruiseVelocity(10000, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.configMotionAcceleration(10000, RobotMap.kTimeoutMs);
		/* zero the sensor */
		Robot.chassis.tsrxL.setSelectedSensorPosition(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.setSelectedSensorPosition(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.setSelectedSensorPosition(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);

		System.out.println("RNR 2018 Robot Code Powering Up...");
		oi = new OI();

		teleopCommand = new DriveWithJoysticks();

		//Auto selection
		chooser.addObject("Left Switch", autoLeftSwitch);
		chooser.addObject("Middle Switch", autoMiddleSwitch);
		chooser.addObject("Right switch", autoRightSwitch);
		chooser.addObject("Right Scale", autoRightScale);
		chooser.addObject("Left Scale", autoLeftScale);
		
		
		//Pose selection
		chooser1.addObject("Right Pose", startingPoseRight);
		chooser1.addObject("Left Pose", startingPoseLeft);
		chooser1.addDefault("Middle Pose", startingPoseMiddle);

		SmartDashboard.putData("Set starting pose", chooser1);
		SmartDashboard.putData("Auto Choices", chooser);

		startingPose = chooser1.getSelected();
		autoSelected = chooser.getSelected();

	}

	public void disabledInit() {
		SmartDashboard.putNumber("kP", _kP);
		SmartDashboard.putNumber("kI", _kI);
		SmartDashboard.putNumber("kD", _kD);
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		/* clear our buffer and put everything into a known state */
		Robot.chassis.tsrxL.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);

		autoSelected = chooser.getSelected();
		startingPose = chooser1.getSelected();
	}

	public void UpdateDriveCoreComponents() {
		_CurrentLeftEncoderPosition = -Robot.chassis.tsrxL.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);
		_CurrentRightEncoderPosition = Robot.chassis.tsrxR.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);
		_CurrentLiftEncoderPosition = Robot.elevator.tsrxE.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);

		double dDistanceLeft_inches = FieldDimensions.dInchesPerClicks * _CurrentLeftEncoderPosition;
	    double dDistanceRight_inches = FieldDimensions.dInchesPerClicks * _CurrentRightEncoderPosition;
		double dDistanceLift_inches = FieldDimensions.dLiftInchesPerClicks * _CurrentLiftEncoderPosition;
		
		SmartDashboard.putNumber("Left Inches", dDistanceLeft_inches);
		SmartDashboard.putNumber("Right Inches", dDistanceRight_inches);
		SmartDashboard.putNumber("Lift Inches", dDistanceLift_inches);
	}

	// *************** FSM zone
	// **********************************************************
	public static EAutoStates _eCurrentAutoState; 
	public EAutoStates _ePreviousAutoState; 
	public double _TargetLiftEncoderPosition;
	public double _TargetLeftEncoderPosition;
	public double _TargetRightEncoderPosition;
	public static MotionItem[] _Selected_AutoRecipe; // the current array of motion items selected at start of autoInit
	public static MotionItem _CurrentMotionItem; // current position in the array
	static int _iCurrentMotionItemIndex; // current position in the drive recipe
	public static final double _dMoveTolerance = 150.0;
	public static final double _dTurnTolerance = 150.0;
	public static final double _dLiftTolerance = 100.0;

	public double _dTimerEnd_sec;

	private static MotionItem[] insertMotionItem(MotionItem original[], MotionItem element, int index) {
        int length = original.length;
        MotionItem[] destination = new MotionItem[length + 1];
        System.arraycopy(original, 0, destination, 0, index);
        destination[index] = element;
        System.arraycopy(original, index, destination, index + 1, length - index);
        return destination;
    }
	
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
	
	public boolean IsTurnCloseEnough() {
		double dTurnLError = Math.abs(_TargetLeftEncoderPosition - _CurrentLeftEncoderPosition);
		double dTurnRError = Math.abs(_TargetRightEncoderPosition - _CurrentRightEncoderPosition);
		System.out.print("Is Turn Close Enough:" + "dTurnLError: " + dTurnLError + "dTurnRError: " + dTurnRError);
		return (dTurnLError < _dTurnTolerance && dTurnRError < _dTurnTolerance);
	}

	public void DriveToTargetPosition() {
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
		_TargetLiftEncoderPosition = _CurrentLiftEncoderPosition + (dLift_Height_inch * FieldDimensions.dLiftClicksPerInch);
		System.out.println("Target Lift Encoder" + _TargetLiftEncoderPosition);
	}

	public void UpdateFSM() {
		if (_ePreviousAutoState != _eCurrentAutoState)
			_ePreviousAutoState = _eCurrentAutoState;
			//System.out.println(_eCurrentAutoState.name());
		
		switch(_eCurrentAutoState){

			case eIdle: 
			{
				
			}
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
			case eDriveToWayPoint: 
			{
				System.out.print("Pose(" + _Pose._x_in + "in, " + _Pose._y_in + "in, " + _Pose._heading_deg + "deg)\n");				
				Vector MagicArrow = _Pose.GetRelativeVector(_CurrentMotionItem._WayPoint);
				MagicArrow.ShowSelf();
				MotionItem turn = new MotionItem(EAutoStates.eStoppedTurn, MagicArrow._heading_deg);
				MotionItem drive = new MotionItem(EAutoStates.eDriveForward, MagicArrow._distance_in);
				_Selected_AutoRecipe = insertMotionItem(_Selected_AutoRecipe, turn, _iCurrentMotionItemIndex + 1);
				_Selected_AutoRecipe = insertMotionItem(_Selected_AutoRecipe, drive, _iCurrentMotionItemIndex + 2);
				MoveToNextMotionItemInSelectedRecipe();
			}
			break;
			case eAbsoluteTurn: 
			{
				double RelativeAmount = _CurrentMotionItem.dParam1 - _Pose._heading_deg;
				System.out.println("RelativeAmount = " + _CurrentMotionItem.dParam1 + " - " + _Pose._heading_deg + " = " + RelativeAmount);
				MotionItem turn = new MotionItem(EAutoStates.eStoppedTurn, RelativeAmount);
				RelativeAmount = _Pose.RelativeRangeCheckHeading(RelativeAmount);
				_Selected_AutoRecipe = insertMotionItem(_Selected_AutoRecipe, turn, _iCurrentMotionItemIndex + 1);
				MoveToNextMotionItemInSelectedRecipe();
			}
			break;
			case eDriveForward:
			{
				_CurrentLeftEncoderBeforeMove = -Robot.chassis.tsrxL.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);
				_CurrentRightEncoderBeforeMove = Robot.chassis.tsrxR.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);				
				SetTargetEncoderPositionsByInches(_CurrentMotionItem.dParam1, _CurrentMotionItem.dParam1);
				DriveToTargetPosition();
				_eCurrentAutoState = EAutoStates.eChained_DriveWait; // chained event, first to move, then check
				System.out.println("Hit eDriveForward (" + _TargetLeftEncoderPosition + ", " + _TargetRightEncoderPosition + ")");
			}
			break;
			case eStoppedTurn:
			{
				double dWheelDrive_in = _CurrentMotionItem.dParam1 * FieldDimensions.dInchesPerDegree;
				SetTargetEncoderPositionsByInches(dWheelDrive_in, -dWheelDrive_in);
				DriveToTargetPosition();
				_eCurrentAutoState = EAutoStates.eChained_TurnWait; // chained event, first to move, then check
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
			case eChained_DriveWait:
			{
				if (IsCloseEnough()) {
				_CurrentLeftEncoderAfterMove = -Robot.chassis.tsrxL.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);
				_CurrentRightEncoderAfterMove = Robot.chassis.tsrxR.getSelectedSensorPosition(RobotMap.kPIDLoopIdx);
				_ActualDistancetraveledAveragedBefore = (_CurrentLeftEncoderBeforeMove + _CurrentRightEncoderBeforeMove) * 0.5;
				_ActualDistancetraveledAveragedAfter = (_CurrentLeftEncoderAfterMove + _CurrentRightEncoderAfterMove) * 0.5;
				_FinalPoseClicks = _ActualDistancetraveledAveragedAfter - _ActualDistancetraveledAveragedBefore;
				_FinalPoseInchs = _FinalPoseClicks / FieldDimensions.dClicksPerInch;
				_Pose.DriveForward(_FinalPoseInchs);
				MoveToNextMotionItemInSelectedRecipe();
				}
			}
			break; 
			case eChained_TurnWait: 
			{
				if (IsTurnCloseEnough()) {
					_Pose.SetAbsoluteHeading(imu.Heading() - _FieldHeadingOffset_deg);
					System.out.println("Heading: " + _Pose._heading_deg);
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
				Robot.intaker.Fastrelease();
				MoveToNextMotionItemInSelectedRecipe();
			}
			break;
			case eStartLift: 
			{
				Robot.elevator.tsrxE.set(1);
				MoveToNextMotionItemInSelectedRecipe();

			}
			break;
			case eStopLift: 
			{
				Robot.elevator.tsrxE.set(0);
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
				if (Robot.imu.Heading() + targetHeading > targetHeading){
						Robot.chassis.setLeftRight(-.25, .25);
				}
				if (Robot.imu.Heading() + targetHeading < targetHeading){
						Robot.chassis.setLeftRight(.25, -.25);
				}
				else if (Robot.imu.Heading() == targetHeading){
					_eCurrentAutoState = EAutoStates.eChained_DriveWait;
				}
			}
			break;
			case eEmergencyStop:
			default: 
				System.out.print(_eCurrentAutoState.name());
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
	// *************** End FSM zone *************** //

	// *************** Start Auto zone *************** //
	
	public void autonomousInit() {		
		_FieldHeadingOffset_deg = imu.Heading();
		SetDrivePID();
		
		Robot.chassis.tsrxL.config_kF(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.config_kP(RobotMap.kPIDLoopIdx, 1.0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.config_kI(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxL.config_kD(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		
		Robot.chassis.tsrxR.config_kF(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.config_kP(RobotMap.kPIDLoopIdx, 1.0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.config_kI(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		Robot.chassis.tsrxR.config_kD(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		
		Robot.elevator.tsrxE.config_kF(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.config_kP(RobotMap.kPIDLoopIdx, 0.1, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.config_kI(RobotMap.kPIDLoopIdx, 0.0005, RobotMap.kTimeoutMs);
		Robot.elevator.tsrxE.config_kD(RobotMap.kPIDLoopIdx, 0.0, RobotMap.kTimeoutMs);
	
		gameData = DriverStation.getInstance().getGameSpecificMessage(); 
		 
		_eCurrentAutoState = EAutoStates.eEmergencyStop; 
		UpdateFSM();
		
		startingPose = chooser1.getSelected();
		autoSelected = chooser.getSelected();

		switch (autoSelected) {
		case autoRightSwitchScale: 
		{
			if (Robot.gameData.charAt(0) == 'R' && Robot.gameData.charAt(1) == 'L') {
				InitializeAutoRecipe(AutoRecipes._RightSwitchLeftScale_RightSide);
			}
			else if (Robot.gameData.charAt(0) == 'L' && Robot.gameData.charAt(1) == 'L') {
			}
			else if (Robot.gameData.charAt(0) == 'R' && Robot.gameData.charAt(1) == 'R') {
			}
			else if (Robot.gameData.charAt(0) == 'L' && Robot.gameData.charAt(1) == 'R') {
			}
		}
		break;
		case autoMiddleSwitch: 
		{
			if (Robot.gameData.charAt(0) == 'L') {
				InitializeAutoRecipe(AutoRecipes._LeftSwitch_MiddleSide);
			}
			else if (Robot.gameData.charAt(0) == 'R') {
				InitializeAutoRecipe(AutoRecipes._RightSwitch_MiddleSide);
			}
		}
		break;
		case autoRightSwitch: 
		{
			if (Robot.gameData.charAt(0) == 'L') {
				InitializeAutoRecipe(AutoRecipes._LeftSwitch_RightSide);
			}
			else if (Robot.gameData.charAt(0) == 'R') {
				InitializeAutoRecipe(AutoRecipes._RightSwitch_RightSide);
			}
		}
		break;
		case autoLeftSwitch: 
		{
			if (Robot.gameData.charAt(0) == 'L') {
				InitializeAutoRecipe(AutoRecipes._LeftSwitch_LeftSide);
			}
			else if (Robot.gameData.charAt(0) == 'R') {
				InitializeAutoRecipe(AutoRecipes._RightSwitch_LeftSide);
			}
		}
		break;
		
		case autoRightScale: 
		{
			if (Robot.gameData.charAt(0) == 'L') {
				InitializeAutoRecipe(AutoRecipes._RightScale_LeftSide);
			}
			else if (Robot.gameData.charAt(0) == 'R') {
				InitializeAutoRecipe(AutoRecipes._RightScale_RightSide);
			}
		}
		break;
		
		case autoLeftScale: 
		{
			if (Robot.gameData.charAt(0) == 'L') {
				InitializeAutoRecipe(AutoRecipes._LeftScale_LeftSide);
			}
			else if (Robot.gameData.charAt(0) == 'R') {
				InitializeAutoRecipe(AutoRecipes._LeftScale_RightSide);
			}
		}
		break;
		
		
		default:
			{
				InitializeAutoRecipe(AutoRecipes._Baseline_drop);
			}
			break;
		}
		switch (startingPose) {
		case startingPoseLeft: {
			_Pose.SetPose(-110.0, 20.0, 0.0);
		}
			break;
		case startingPoseMiddle:  {
			_Pose.SetPose(0.0, 20.0, 0.0);
		}
			break;
		case startingPoseRight: {
			_Pose.SetPose(110.0, 20.0, 0.0);
		}
			break;
		default: {
			_Pose.SetPose(0.0, 20.0, 0.0);
		}
		break;
	}

		if (autonomousCommand != null)
			autonomousCommand.start();
	}
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		UpdateDriveCoreComponents();
		UpdateFSM();
		
		System.out.print(_Pose._Deltax + ", " + _Pose._y_in );
		startingPose = chooser1.getSelected();
		autoSelected = chooser.getSelected();
	}
	
	// *************** End Auto zone *************** //

	// *************** Start Teleop zone *************** //
	
	public void teleopInit() {
		_eCurrentAutoState = EAutoStates.eEmergencyStop;
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
		SmartDashboard.putNumber("Heading", imu.Heading());
		SmartDashboard.putNumber("Pitch", imu.Pitch());
		SmartDashboard.putNumber("Roll", imu.Roll());
		SmartDashboard.putNumber("Pose Heading: ", _Pose._heading_deg);
		SmartDashboard.putString("Calibration data", imu.getCalibrationStatusString());

	}

	public void testPeriodic() {
		LiveWindow.setEnabled(true);
	}
	
	// *************** End Teleop zone *************** //

}