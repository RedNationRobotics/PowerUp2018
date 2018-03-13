package PowerUp2018;

import PowerUp2018.AutoStates.EAutoStates;

public class AutoRecipes {

	public static MotionItem[] _Baseline_ = {	
			new MotionItem(EAutoStates.eDriveForward, 150.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle) 
			
	};
	public static MotionItem[] _Test_1 = {	
			new MotionItem(EAutoStates.eDriveForward, 150.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

			
	};
	public static MotionItem[] _ElevatorDown_Recipe_ = {	
			new MotionItem(EAutoStates.eSetLiftHeight, -20.0),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle) 

	};
	public static MotionItem[] _ElevatorUp_Recipe_ = {	
			new MotionItem(EAutoStates.eSetLiftHeight, 20.0),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle) 

	};
	

	public static MotionItem[] _LeftSide_LeftSwitch_1cube = {	/*Finalized working used*/
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kCenterToMiddlePartOfSwitchLoading), 
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch),
			new MotionItem(EAutoStates.eDriveForward, 8.0), 
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eDriveForward, -8.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle) 
			
	};
	
	public static MotionItem[] _LeftSide_RightSwitch_1cube = { /*Finalized working used*/
			new MotionItem(EAutoStates.eDriveForward,FieldDimensions.kCenterToPointA), 
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kPointAToCenterBackLoadingSwitch),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, 5.0),
			new MotionItem(EAutoStates.eSetLiftHeight, 45.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle) 

		};
	public static MotionItem[] _LeftSide_RightSwitch_2cubes = { /*Finalized working used*/
			new MotionItem(EAutoStates.eDriveForward, 220.0), 
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, 186.7),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, 5.0),
			new MotionItem(EAutoStates.eSetLiftHeight, 45.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, -42.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveForward, 8.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, 45.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, -40.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle) 

		};
		
	public static MotionItem[] _LeftSide_LeftScale_1cube  = { /*Finalized working*/
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kStartingCenterToCenterLoadingScale),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, -5),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, 60.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	
	public static MotionItem[] _LeftSide_RightScale_1cube  = { /*Finalized working*/
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kCenterToPointA),
			new MotionItem(EAutoStates.eStoppedTurn, 90), 
			new MotionItem(EAutoStates.eDriveForward, 245.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, 95.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, -60.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	
	public static MotionItem[] _MiddleSide_LeftSwitch_1cube  = { 
			new MotionItem(EAutoStates.eDriveForward, 83.5),
			new MotionItem(EAutoStates.eStoppedTurn, -90), 
			new MotionItem(EAutoStates.eDriveForward, 40.0),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, 22.5),
			new MotionItem(EAutoStates.eSetLiftHeight, 35.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -22.5),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _MiddleSide_RightSwitch_1cube  = { 
			new MotionItem(EAutoStates.eDriveForward, 83.5),
			new MotionItem(EAutoStates.eStoppedTurn, 90), 
			new MotionItem(EAutoStates.eDriveForward, 40.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 22.5),
			new MotionItem(EAutoStates.eSetLiftHeight, 35.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -22.5),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _MiddleSide_LeftScale_1cube  = {
			new MotionItem(EAutoStates.eDriveForward, 81.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 104.53),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, 284.97),
			new MotionItem(EAutoStates.eSetLiftHeight, 73.0),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -69.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _MiddleSide_RightScale_1cube  = { 
			new MotionItem(EAutoStates.eDriveForward, 81.0),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, 104.53),
			new MotionItem(EAutoStates.eStoppedTurn, -90),
			new MotionItem(EAutoStates.eDriveForward, 284.97),
			new MotionItem(EAutoStates.eSetLiftHeight, 73.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStoppedTurn, 90),
			new MotionItem(EAutoStates.eSetLiftHeight, -69.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};

	public static MotionItem[] _RightSide_LeftSwitch_1cube  = { /*Finalized working*/
			new MotionItem(EAutoStates.eDriveForward, 220.0), 
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 180.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, 5.0),
			new MotionItem(EAutoStates.eSetLiftHeight, 45.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _LeftSide_LeftSwitch_2cube  = { /*Finalized working used*/
			new MotionItem(EAutoStates.eDriveForward, 224.0), 
			new MotionItem(EAutoStates.eStoppedTurn, -90), 
			new MotionItem(EAutoStates.eDriveForward, 46.72), 
			new MotionItem(EAutoStates.eStoppedTurn, -90), 
			new MotionItem(EAutoStates.eDriveForward, 7.0), 
			new MotionItem(EAutoStates.eStoppedTurn, 28.0),
			new MotionItem(EAutoStates.eSetLiftHeight, 54.0), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop), 
			new MotionItem(EAutoStates.eStoppedTurn, -27.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -52.0), 
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0), 
			new MotionItem(EAutoStates.eDriveForward, 5.0), 
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0), 
			new MotionItem(EAutoStates.eGripper_Intake), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, 56.0), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),
	};
	public static MotionItem[] _RightSide_RightSwitch_2cube  = { /*Finalized working used*/
			new MotionItem(EAutoStates.eDriveForward, 224.0), 
			new MotionItem(EAutoStates.eStoppedTurn, 90), 
			new MotionItem(EAutoStates.eDriveForward, 46.72), 
			new MotionItem(EAutoStates.eStoppedTurn, 90), 
			new MotionItem(EAutoStates.eDriveForward, 7.0), 
			new MotionItem(EAutoStates.eStoppedTurn, -28.0),
			new MotionItem(EAutoStates.eSetLiftHeight, 54.0), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop), 
			new MotionItem(EAutoStates.eStoppedTurn, 27.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -52.0), 
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0), 
			new MotionItem(EAutoStates.eDriveForward, 5.0), 
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0), 
			new MotionItem(EAutoStates.eGripper_Intake), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, 56.0), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),


	};
	public static MotionItem[] _RightSide_LeftSwitch_2cube  = { /*Finalized working used*/
			new MotionItem(EAutoStates.eDriveForward, 220.0), 
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 180.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, 5.0),
			new MotionItem(EAutoStates.eSetLiftHeight, 45.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, -42.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveForward, 8.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, 45.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, -40.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle) 
			
	};
	
	public static MotionItem[] _RightSide_RightSwitch_1cube  = { /*Finalized working*/
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kCenterToMiddlePartOfSwitchLoading), 
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 10.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	
	public static MotionItem[] _RightSide_LeftScale_1cube  = { /*Finalized working*/
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kCenterToPointA),
			new MotionItem(EAutoStates.eStoppedTurn, -90), 
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kPointAToScaleSide),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, 93.8),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, 4.3),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle) 
			
	}; 
	public static MotionItem[] _RightSide_RightScale_1cube  = {  /*Finalized working*/
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kStartingCenterToCenterLoadingScale),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, -5.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	
	public static MotionItem[] _LeftSide_LeftScale_2cubes = { /*Finalized working*/
			new MotionItem(EAutoStates.eDriveForward, 253.5),
			new MotionItem(EAutoStates.eStoppedTurn, 45.0),
			new MotionItem(EAutoStates.eDriveForward, 6.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eDriveForward, -6.0),
			new MotionItem(EAutoStates.eStoppedTurn, 135.0), 
			new MotionItem(EAutoStates.eDriveForward, 40.0), 
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, 45.324),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveForward, 5.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -5.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, -45.324),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, 40.0),
			new MotionItem(EAutoStates.eStoppedTurn, 45.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale - 5),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, -45.0), 
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _RightSide_RightScale_2cubes = { /*good new*/
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kLengthfromcenterOfRobotToCornerOfSwitch),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, -45.0),
			new MotionItem(EAutoStates.eDriveForward, 6.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eDriveForward, -6.0),
			new MotionItem(EAutoStates.eStoppedTurn, -135.0), 
			new MotionItem(EAutoStates.eDriveForward, 40.0), 
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, 45.324),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveForward, 5.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -5.0),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, -45.324),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, 40.0),
			new MotionItem(EAutoStates.eStoppedTurn, 45.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale - 5),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, 45.0), 
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _RightSide_RightScaleRightSwitch_2cubes = { /*good new*/
			new MotionItem(EAutoStates.eDriveForward, 147.8),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 12.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch),
			new MotionItem(EAutoStates.eDriveForward, 70.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 38.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),//
			new MotionItem(EAutoStates.eDriveForward, 7.3),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eChained_WaitTimer, FieldDimensions.kTimerIntake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -7.3),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, -38.0),
			new MotionItem(EAutoStates.eStoppedTurn, 57.38),
			new MotionItem(EAutoStates.eDriveForward, 39.172),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, 32.62),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStoppedTurn, -32.62),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _LeftSide_LeftScaleLeftSwitch_2cubes = { /*good*/
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, 12.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch),
			new MotionItem(EAutoStates.eDriveForward, 70.0),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, 38.0),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),//
			new MotionItem(EAutoStates.eDriveForward, 7.3),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eChained_WaitTimer, FieldDimensions.kTimerIntake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -7.3),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, -38.0),
			new MotionItem(EAutoStates.eStoppedTurn, -57.38),
			new MotionItem(EAutoStates.eDriveForward, 39.172),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, -32.62),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStoppedTurn, 32.62),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _BaseLineOnly = { /*ready new */
			new MotionItem(EAutoStates.eDriveForward, 5.0), 
			new MotionItem(EAutoStates.eStoppedTurn, -17.45), 
			new MotionItem(EAutoStates.eDriveForward, 101.0), 
			new MotionItem(EAutoStates.eStoppedTurn, 107.45), 
			new MotionItem(EAutoStates.eDriveForward, 30.5),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};	
	public static MotionItem[] _LeftSide_RightScale_2cubes = { /*ready new */
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kCenterToPointA - 4.0),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, 212.79),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStoppedTurn, -102.8),
			new MotionItem(EAutoStates.eDriveForward, 44.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, 12.8),			
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eDriveForward, -38.4),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 15.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveForward, 3.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -3.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 15.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 38.9),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _RightSide_LeftScale_2cubes = { /*ready new */
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kCenterToPointA - 4.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 212.79),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStoppedTurn, 102.8),
			new MotionItem(EAutoStates.eDriveForward, 44.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, -12.8),			
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eDriveForward, -38.4),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, 15.0),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveForward, 3.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -3.0),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, 15.0),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, 38.9),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
	};
}