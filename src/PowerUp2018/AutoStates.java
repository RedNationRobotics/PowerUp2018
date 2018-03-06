package PowerUp2018;

public class AutoStates {

	public enum EAutoStates{
		eDriveForward,
		eStoppedTurn,
		eChained_MoveWait,
		eStartTimer,
		eChained_WaitTimer,
		eGripper_Intake,
		eGripper_Release,
		eGripper_SetArm,
		eStopElevator,
		eGripper_Stop,
		eSetLiftHeight,
		eChained_WaitLift,
		eStopMotors,
		eEmergencyStop,
		eIdle
/*
		eGripper,
		eSlightlyDriftLeft,
		eDriveForwardWithLift,
		eOutTakeThenLowerLift,
		eLiftUp,
		eLiftDown,
		eReverse,
		eIntake,
		eOutTake 
*/	
	}

}

