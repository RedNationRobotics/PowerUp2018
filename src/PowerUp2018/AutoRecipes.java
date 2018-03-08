package PowerUp2018;

import PowerUp2018.AutoStates.EAutoStates;

public class AutoRecipes {

	public static MotionItem[] _Test_ = {	
			new MotionItem(EAutoStates.eStoppedTurn, 720.0),

			
	};
	public static MotionItem[] _ElevatorDown_Recipe_ = {	
			new MotionItem(EAutoStates.eSetLiftHeight, -73.0),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _ElevatorUp_Recipe_ = {	
			new MotionItem(EAutoStates.eSetLiftHeight, 73.0),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};
	

	public static MotionItem[] _LeftSide_LeftSwitch_1cube = { /*good*/	
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
	public static MotionItem[] _LeftSide_RightSwitch_1cube = { /*good*/
			new MotionItem(EAutoStates.eDriveForward,FieldDimensions.kCenterToMiddlePartOfSwitchLoading), 
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kPointAToCenterBackLoadingSwitch),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, 5.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -5.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle) 

		};
	public static MotionItem[] _LeftSide_LeftScale_1cube  = { /*good*/
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kStartingCenterToCenterLoadingScale),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _LeftSide_RightScale_1cube  = { /*good*/
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kCenterToPointA),
			new MotionItem(EAutoStates.eStoppedTurn, 90), 
			new MotionItem(EAutoStates.eDriveForward, 245.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, 95.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
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
	public static MotionItem[] _RightSide_LeftSwitch_1cube  = { /*good RECALL*/
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kCenterToPointA), 
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kPointAToCenterBackLoadingSwitch),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, 8.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -8.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _RightSide_RightSwitch_1cube  = { 
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kCenterToMiddlePartOfSwitchLoading), 
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 20.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -20.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _RightSide_LeftScale_1cube  = { /*good*/
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kCenterToPointA),
			new MotionItem(EAutoStates.eStoppedTurn, -90), 
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kPointAToScaleSide),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, 93.8),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, 4.3),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle) 
			
	}; 
	public static MotionItem[] _RightSide_RightScale_1cube  = { /*good*/
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kStartingCenterToCenterLoadingScale),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, -90), 
			new MotionItem(EAutoStates.eDriveForward, 7.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -7.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	
	public static MotionItem[] _LeftSide_LeftScale_2cubes = { /*good*/
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kLengthfromcenterOfRobotToCornerOfSwitch),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, 45.0),
			new MotionItem(EAutoStates.eDriveForward, 149.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -14.0),
			new MotionItem(EAutoStates.eStoppedTurn, 135.0), 
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eDriveForward, 41.53), 
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, 54.18),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveForward, 10.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -10.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, -54.18),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, 41.053),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, 45.0), 
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStoppedTurn, -45.0), 
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _RightSide_RightScale_2cubes = { /*good*/
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kLengthfromcenterOfRobotToCornerOfSwitch),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, -45.0),
			new MotionItem(EAutoStates.eDriveForward, 14.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -14.0),
			new MotionItem(EAutoStates.eStoppedTurn, -135.0), 
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eDriveForward, 41.53), 
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, 54.18),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveForward, 10.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -10.0),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, -54.18),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, 41.053),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, 45.0), 
			new MotionItem(EAutoStates.eDriveForward, 14.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStoppedTurn, 45.0), 
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _RightSide_RightScaleRightSwitch_2cubes = { /*good*/
			new MotionItem(EAutoStates.eStoppedTurn, -8.23),
			new MotionItem(EAutoStates.eDriveForward, 134.11),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch),
			new MotionItem(EAutoStates.eStoppedTurn, -82.11),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch),
			new MotionItem(EAutoStates.eDriveForward, 62.19),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 34.76),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveForward, 14.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eChained_WaitTimer, FieldDimensions.kTimerIntake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -14.0),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, -34.76),
			new MotionItem(EAutoStates.eStoppedTurn, 66.01),
			new MotionItem(EAutoStates.eDriveForward, 47.42),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, 23.99),
			new MotionItem(EAutoStates.eDriveForward, 5.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -10.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _LeftSide_LeftScaleLeftSwitch_2cubes = { /*good*/
			new MotionItem(EAutoStates.eStoppedTurn, 8.23),
			new MotionItem(EAutoStates.eDriveForward, 134.11),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch),
			new MotionItem(EAutoStates.eStoppedTurn, 82.11),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch),
			new MotionItem(EAutoStates.eDriveForward, 62.19),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, 34.76),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveForward, 14.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eChained_WaitTimer, FieldDimensions.kTimerIntake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -14.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, -34.76),
			new MotionItem(EAutoStates.eStoppedTurn, -66.01),
			new MotionItem(EAutoStates.eDriveForward, 47.42),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eStoppedTurn, -23.99),
			new MotionItem(EAutoStates.eDriveForward, 5.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -10.0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _LeftSide_LeftSwitchRightScale_2cubes = { /*not ready*/
			new MotionItem(EAutoStates.eDriveForward, 151.0), 
			new MotionItem(EAutoStates.eSetLiftHeight, 35.0), 
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, 20.0), 
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer,.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -20.0), 
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eSetLiftHeight, -35.0), 
			new MotionItem(EAutoStates.eDriveForward, 60.735),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, 39.56),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveForward, 20.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eStartTimer, 0.2),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, 35.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -20.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
	};
	

	
}