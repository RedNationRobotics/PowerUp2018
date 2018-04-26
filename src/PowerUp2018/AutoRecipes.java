package PowerUp2018;

import PowerUp2018.AutoStates.EAutoStates;
import redcore.WayPoint;

public class AutoRecipes {

	public static MotionItem[] _Baseline_drop = { 
			new MotionItem(EAutoStates.eStartTimer, 10.0),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(0, 100)),
	        new MotionItem(EAutoStates.eStopMotors),
	        new MotionItem(EAutoStates.eStopElevator),
	        new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _Baseline_ = {	
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),

			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(63, 100)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(63, 120)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, .5),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(40, 53)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 180),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(40, 45)),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
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
	public static MotionItem[] _LeftSide_LeftSwitch_1cube = {
			  new MotionItem(EAutoStates.eDriveForward, 75),
			  new MotionItem(EAutoStates.eDriveForward, 75),
	          new MotionItem(EAutoStates.eStoppedTurn, 90),
			  new MotionItem(EAutoStates.eDriveForward, 28.0),
			  new MotionItem(EAutoStates.eStartLift),
		   	  new MotionItem(EAutoStates.eStartTimer, 1.0),
			  new MotionItem(EAutoStates.eStopLift),		      
			  new MotionItem(EAutoStates.eGripper_Release),
		      new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
	          new MotionItem(EAutoStates.eGripper_Stop),
	          new MotionItem(EAutoStates.eStopMotors),
	          new MotionItem(EAutoStates.eStopElevator),
	          new MotionItem(EAutoStates.eIdle)
	};
	
	public static MotionItem[] _LeftSide_RightSwitch_1cube = {  /*Finalized working used*/
			new MotionItem(EAutoStates.eDriveForward, 115),
			new MotionItem(EAutoStates.eDriveForward, 115),
			new MotionItem(EAutoStates.eStoppedTurn, 90),
			new MotionItem(EAutoStates.eDriveForward, 87.5),
			new MotionItem(EAutoStates.eDriveForward, 87.5),
			new MotionItem(EAutoStates.eStoppedTurn, 90),
			new MotionItem(EAutoStates.eDriveForward, 10),
			new MotionItem(EAutoStates.eStartLift),
		    new MotionItem(EAutoStates.eStartTimer, 1.0),
			new MotionItem(EAutoStates.eStopLift),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
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
			new MotionItem(EAutoStates.eSetLiftHeight, 40.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -39.0),
			new MotionItem(EAutoStates.eDriveForward, 8.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, 40.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, -39.0),
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
	public static MotionItem[] _MiddleSide_LeftSwitch_1cube_delay  = { 
			new MotionItem(EAutoStates.eStartDelay, 3.0),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(60, 100)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 0), 
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _MiddleSide_LeftSwitch_1cube  = { 
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(60, 100)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 0), 
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _MiddleSide_RightSwitch_1cube_delay = { 
			new MotionItem(EAutoStates.eStartDelay, 3.0),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-60, 100)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 0), 
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _MiddleSide_RightSwitch_1cube = {
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-60, 100)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 0), 
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
	};

	/*public static MotionItem[] _MiddleSide_LeftScale_1cube  = {
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
*/
	public static MotionItem[] _RightSide_LeftSwitch_1cube = { /*Finalized working*/
			new MotionItem(EAutoStates.eDriveForward, 115),
			new MotionItem(EAutoStates.eDriveForward, 115),
			new MotionItem(EAutoStates.eStoppedTurn, -90),
			new MotionItem(EAutoStates.eDriveForward, 87.5),
			new MotionItem(EAutoStates.eDriveForward, 87.5),
			new MotionItem(EAutoStates.eStoppedTurn, -90),
			new MotionItem(EAutoStates.eDriveForward, 10),
			new MotionItem(EAutoStates.eStartLift),
		    new MotionItem(EAutoStates.eStartTimer, 1.0),
			new MotionItem(EAutoStates.eStopLift),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _LeftSide_LeftSwitch_2cube  = { /*Finalized working used*/
			new MotionItem(EAutoStates.eDriveForward, 224.0), 
			new MotionItem(EAutoStates.eStoppedTurn, 90), 
			new MotionItem(EAutoStates.eDriveForward, 46.72), 
			new MotionItem(EAutoStates.eStoppedTurn, 90), 
			new MotionItem(EAutoStates.eDriveForward, 7.0), 
			new MotionItem(EAutoStates.eSetLiftHeight, 40.0), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop), 
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0), 
			new MotionItem(EAutoStates.eSetLiftHeight, -39.0), 
			new MotionItem(EAutoStates.eDriveForward, 5.0), 
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0), 
			new MotionItem(EAutoStates.eGripper_Intake), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, 40.0), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),
	};
	public static MotionItem[] _RightSide_RightSwitch_2cube  = { /*Finalized working used*/
			new MotionItem(EAutoStates.eDriveForward, 224.0), 
			new MotionItem(EAutoStates.eStoppedTurn, -90), 
			new MotionItem(EAutoStates.eDriveForward, 46.72), 
			new MotionItem(EAutoStates.eStoppedTurn, -90), 
			new MotionItem(EAutoStates.eDriveForward, 7.0), 
			new MotionItem(EAutoStates.eSetLiftHeight, 40.0), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop), 
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0), 
			new MotionItem(EAutoStates.eSetLiftHeight, -39.0), 
			new MotionItem(EAutoStates.eDriveForward, 5.0), 
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0), 
			new MotionItem(EAutoStates.eGripper_Intake), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, 40.0), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),


	};
	public static MotionItem[] _RightSide_LeftSwitch_2cube  = { /*Finalized working used*/
			new MotionItem(EAutoStates.eDriveForward, 220.0), 
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 186.7),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, 5.0),
			new MotionItem(EAutoStates.eSetLiftHeight, 40.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -39.0),
			new MotionItem(EAutoStates.eDriveForward, 8.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, 40.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, -39.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)  
			
	};
	
	public static MotionItem[] _RightSide_RightSwitch_1cube = { /*Finalized working*/
			 new MotionItem(EAutoStates.eDriveForward, 75),
			  new MotionItem(EAutoStates.eDriveForward, 75),
	          new MotionItem(EAutoStates.eStoppedTurn, -90),
			  new MotionItem(EAutoStates.eDriveForward, 28.0),
			  new MotionItem(EAutoStates.eStartLift),
		   	  new MotionItem(EAutoStates.eStartTimer, 1.0),
			  new MotionItem(EAutoStates.eStopLift),		      
			  new MotionItem(EAutoStates.eGripper_Release),
		      new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake),
	          new MotionItem(EAutoStates.eGripper_Stop),
	          new MotionItem(EAutoStates.eSetLiftHeight, -30.0),	         
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
			new MotionItem(EAutoStates.eDriveForward, FieldDimensions.kLengthfromcenterOfRobotToCornerOfScale),
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