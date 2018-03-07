package PowerUp2018;

import PowerUp2018.AutoStates.EAutoStates;

public class AutoRecipes {

	public static MotionItem[] _Test_ = {	
			new MotionItem(EAutoStates.eDriveForward, 72.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 41.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveForward, 36.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eStartTimer, 1.0),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -36.0),
			new MotionItem(EAutoStates.eStartTimer, 0.25),
			new MotionItem(EAutoStates.eSetLiftHeight, 30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
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
			new MotionItem(EAutoStates.eDriveForward, 151.0), 
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eSetLiftHeight, 35.0),
			new MotionItem(EAutoStates.eDriveForward, 25.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			new MotionItem(EAutoStates.eDriveForward, -25.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle) 
			
	};
	public static MotionItem[] _LeftSide_RightSwitch_1cube = { /*good*/
			new MotionItem(EAutoStates.eDriveForward, 214.735), 
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eDriveForward, 187.62),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, 5.0),
			new MotionItem(EAutoStates.eSetLiftHeight, 35.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, .4),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -5.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle) 

		};
	public static MotionItem[] _LeftSide_LeftScale_1cube  = { /*good*/
			new MotionItem(EAutoStates.eDriveForward, 310.0),
			new MotionItem(EAutoStates.eStoppedTurn, 90), 
			new MotionItem(EAutoStates.eDriveForward, 10.0),
			new MotionItem(EAutoStates.eSetLiftHeight,73.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer,.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -12.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -69.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _LeftSide_RightScale_1cube  = { /*good*/
			new MotionItem(EAutoStates.eDriveForward, 214.735),
			new MotionItem(EAutoStates.eStoppedTurn, 90), 
			new MotionItem(EAutoStates.eDriveForward, 210.125),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, 109.265),
			new MotionItem(EAutoStates.eSetLiftHeight, 73.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -69.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _MiddleSide_LeftSwitch_1cube  = { /*good*/
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
	public static MotionItem[] _MiddleSide_RightSwitch_1cube  = { /*good*/
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
	public static MotionItem[] _MiddleSide_LeftScale_1cube  = { /*good*/
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
	public static MotionItem[] _MiddleSide_RightScale_1cube  = { /*good*/
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
	public static MotionItem[] _RightSide_LeftSwitch_1cube  = { /*good*/
			new MotionItem(EAutoStates.eDriveForward, 214.735), 
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 187.62),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, 5.0),
			new MotionItem(EAutoStates.eSetLiftHeight, 35.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, .4),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -5.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _RightSide_RightSwitch_1cube  = { /*good*/
			new MotionItem(EAutoStates.eDriveForward, 151.0), 
			new MotionItem(EAutoStates.eSetLiftHeight, 35.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 25.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -25.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _RightSide_LeftScale_1cube  = { /*good*/
			new MotionItem(EAutoStates.eDriveForward, 214.735),
			new MotionItem(EAutoStates.eStoppedTurn, -90), 
			new MotionItem(EAutoStates.eDriveForward, 210.125),
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, 109.265),
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
	public static MotionItem[] _RightSide_RightScale_1cube  = { /*good*/
			new MotionItem(EAutoStates.eDriveForward, 310.0),
			new MotionItem(EAutoStates.eSetLiftHeight, 73.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90), 
			new MotionItem(EAutoStates.eDriveForward, 10.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer,.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -12.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -69.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	
	public static MotionItem[] _LeftSide_Scale_2cubes = { 
			new MotionItem(EAutoStates.eDriveForward, 274),
			new MotionItem(EAutoStates.eSetLiftHeight, 73.0),
			new MotionItem(EAutoStates.eStoppedTurn, 45.0), 
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer,.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -12.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -69.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	

	
}