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
			


			//new MotionItem(EAutoStates.eSetLiftHeight, 4.0),
			//new MotionItem(EAutoStates.eChained_WaitLift),
			//new MotionItem(EAutoStates.eDriveForward, 120.0),
			//new MotionItem(EAutoStates.eChained_MoveWait),
			//new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			//new MotionItem(EAutoStates.eDriveForward, 50.0),
			//new MotionItem(EAutoStates.eChained_MoveWait),
			//new MotionItem(EAutoStates.eSetLiftHeight, 74.0),
			//new MotionItem(EAutoStates.eChained_WaitLift),
			//new MotionItem(EAutoStates.eGripper_Release),
			//new MotionItem(EAutoStates.eStartTimer, 0.2),
			//new MotionItem(EAutoStates.eChained_WaitTimer),
			//new MotionItem(EAutoStates.eGripper_Stop),
			//new MotionItem(EAutoStates.eSetLiftHeight, -65.0),
			//new MotionItem(EAutoStates.eChained_WaitLift),
			//new MotionItem(EAutoStates.eDriveForward, -50.0),
			//new MotionItem(EAutoStates.eChained_MoveWait),
			//new MotionItem(EAutoStates.eStoppedTurn, 720.0),
			
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _ElevatorDown_Recipe_ = {	
			new MotionItem(EAutoStates.eSetLiftHeight, -50.0),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _ElevatorUp_Recipe_ = {	
			new MotionItem(EAutoStates.eSetLiftHeight, 50.0),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _Just_Idle_ = {	
			new MotionItem(EAutoStates.eIdle)

	};
	
/*
	public static MotionItem[] _LeftSide_LeftSwitch = {	
			new MotionItem(EAutoStates.eDriveForwardWithLift, 45000000), // set encoder clicks in parameter
			new MotionItem(EAutoStates.eOutTake, 0.5), //set time for it to outtake in parameter
			new MotionItem(EAutoStates.eReverse, 50000),
			new MotionItem(EAutoStates.eLiftDown, 0.5),
			new MotionItem(EAutoStates.eIdle) //waits until autonomous period is over
			
	};
	public static MotionItem[] _LeftSide_RightSwitch = {
			new MotionItem(EAutoStates.eDriveForward, 40000000), // set encoder clicks in parameter
			new MotionItem(EAutoStates.eTurnLeft, 30000), 
			new MotionItem(EAutoStates.eDriveForward, 50000),
			new MotionItem(EAutoStates.eTurnRight, 30000), 
			new MotionItem(EAutoStates.eDriveForward, 50000),
			new MotionItem(EAutoStates.eTurnRight, 50000),
			new MotionItem(EAutoStates.eDriveForward, 150000),	
			new MotionItem(EAutoStates.eTurnRight, 50000),
			new MotionItem(EAutoStates.eLiftUp),
			new MotionItem(EAutoStates.eOutTakeThenLowerLift, 0.5),
			new MotionItem(EAutoStates.eIdle) //waits until autonomous period is over

		};
	public static MotionItem[] _LeftSide_LeftScale  = {
			new MotionItem(EAutoStates.eDriveForward, 40000000),
			new MotionItem(EAutoStates.eTurnRight, 30000), 
			new MotionItem(EAutoStates.eDriveForward, 50000),
			new MotionItem(EAutoStates.eTurnLeft, 30000), 
			new MotionItem(EAutoStates.eDriveForwardWithLift, 20000000),
			new MotionItem(EAutoStates.eOutTake, 0.5),
			new MotionItem(EAutoStates.eReverse, 50000),
			new MotionItem(EAutoStates.eLiftDown),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _LeftSide_RightScale  = {
			new MotionItem(EAutoStates.eDriveForward, 40000000),
			new MotionItem(EAutoStates.eTurnRight, 50000), 
			new MotionItem(EAutoStates.eDriveForward, 150000),	
			new MotionItem(EAutoStates.eTurnLeft, 50000), 
			new MotionItem(EAutoStates.eDriveForwardWithLift, 20000000),
			new MotionItem(EAutoStates.eOutTake, 0.5),
			new MotionItem(EAutoStates.eReverse, 50000),
			new MotionItem(EAutoStates.eLiftDown),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _MiddleSide_LeftSwitch  = {
			new MotionItem(EAutoStates.eDriveForward, 40000000),
			new MotionItem(EAutoStates.eTurnLeft, 50000), 
			new MotionItem(EAutoStates.eDriveForward, 50000),
			new MotionItem(EAutoStates.eTurnRight, 50000),
			new MotionItem(EAutoStates.eLiftUp),
			new MotionItem(EAutoStates.eOutTake, 0.5),
			new MotionItem(EAutoStates.eReverse, 50000),
			new MotionItem(EAutoStates.eLiftDown),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _MiddleSide_RightSwitch  = {
			new MotionItem(EAutoStates.eDriveForward, 40000000),
			new MotionItem(EAutoStates.eTurnRight, 50000), 
			new MotionItem(EAutoStates.eDriveForward, 50000),
			new MotionItem(EAutoStates.eTurnLeft, 50000),
			new MotionItem(EAutoStates.eLiftUp),
			new MotionItem(EAutoStates.eOutTake, 0.5),
			new MotionItem(EAutoStates.eReverse, 50000),
			new MotionItem(EAutoStates.eLiftDown),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _MiddleSide_LeftScale  = {
			new MotionItem(EAutoStates.eDriveForward, 20000),
			new MotionItem(EAutoStates.eTurnLeft, 50000),
			new MotionItem(EAutoStates.eDriveForward, 100000),
			new MotionItem(EAutoStates.eTurnRight, 50000),
			new MotionItem(EAutoStates.eDriveForwardWithLift, 40000000),
			new MotionItem(EAutoStates.eOutTake, 0.5),
			new MotionItem(EAutoStates.eReverse, 50000),
			new MotionItem(EAutoStates.eLiftDown),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _MiddleSide_RightScale  = {
			new MotionItem(EAutoStates.eDriveForward, 20000),
			new MotionItem(EAutoStates.eTurnRight, 50000),
			new MotionItem(EAutoStates.eDriveForward, 100000),
			new MotionItem(EAutoStates.eTurnLeft, 50000),
			new MotionItem(EAutoStates.eDriveForwardWithLift, 40000000),
			new MotionItem(EAutoStates.eOutTake, 0.5),
			new MotionItem(EAutoStates.eReverse, 50000),
			new MotionItem(EAutoStates.eLiftDown),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _RightSide_LeftSwitch  = {
			new MotionItem(EAutoStates.eDriveForward, 45000000),
			new MotionItem(EAutoStates.eTurnLeft, 50000),
			new MotionItem(EAutoStates.eDriveForward, 150000),
			new MotionItem(EAutoStates.eTurnLeft, 50000),
			new MotionItem(EAutoStates.eLiftUp),
			new MotionItem(EAutoStates.eOutTake, 0.5),
			new MotionItem(EAutoStates.eReverse, 50000),
			new MotionItem(EAutoStates.eLiftDown),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _RightSide_RightSwitch  = {
			new MotionItem(EAutoStates.eDriveForwardWithLift, 40000000),
			new MotionItem(EAutoStates.eOutTake, 0.5),
			new MotionItem(EAutoStates.eReverse, 50000),
			new MotionItem(EAutoStates.eLiftDown),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _RightSide_LeftScale  = {
			new MotionItem(EAutoStates.eDriveForward, 40000000),
			new MotionItem(EAutoStates.eTurnLeft, 50000),
			new MotionItem(EAutoStates.eDriveForward, 50000),
			new MotionItem(EAutoStates.eTurnRight, 50000),
			new MotionItem(EAutoStates.eDriveForwardWithLift, 2500000),			
			new MotionItem(EAutoStates.eOutTake, 0.5),
			new MotionItem(EAutoStates.eReverse, 50000),
			new MotionItem(EAutoStates.eLiftDown),
			new MotionItem(EAutoStates.eIdle) 
			
	}; 
	public static MotionItem[] _RightSide_RightScale  = {
			new MotionItem(EAutoStates.eDriveForward, 40000000),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			new MotionItem(EAutoStates.eDriveForward, 50000),
			new MotionItem(EAutoStates.eTurnRight, 50000), 
			new MotionItem(EAutoStates.eDriveForwardWithLift, 20000000),
			new MotionItem(EAutoStates.eOutTake, 0.5),
			new MotionItem(EAutoStates.eReverse, 50000),
			new MotionItem(EAutoStates.eLiftDown),
			new MotionItem(EAutoStates.eIdle)
			
	};
*/
	
}