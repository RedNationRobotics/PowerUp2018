package PowerUp2018;

import PowerUp2018.AutoStates.EAutoStates;

public class AutoRecipes {

	public static MotionItem[] _Test_ = {	
			new MotionItem(EAutoStates.eDriveForward, 100000),
			new MotionItem(EAutoStates.eTurnLeft, 30000),
			new MotionItem(EAutoStates.eTurnRight, 30000),
			//new MotionItem(EAutoStates.eOutTake, 0.5),
			//new MotionItem(EAutoStates.eReverse, 50000),
			//new MotionItem(EAutoStates.eLiftDown, 0.5),
			//new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _LeftSide_LeftSwitch = {	
			new MotionItem(EAutoStates.eDriveForwardWithLift, 45000000/*to the scale*/), // set encoder clicks in parameter
			new MotionItem(EAutoStates.eOutTake, 0.5), //set time for it to outtake in parameter
			new MotionItem(EAutoStates.eReverse, 50000),
			new MotionItem(EAutoStates.eLiftDown, 0.5),
			new MotionItem(EAutoStates.eIdle) //waits until autonomous period is over
			
	};
	public static MotionItem[] _LeftSide_RightSwitch = {
			new MotionItem(EAutoStates.eDriveForward, 40000000/*to the scale*/), // set encoder clicks in parameter
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
			new MotionItem(EAutoStates.eTurnLeft, 50000), 
			new MotionItem(EAutoStates.eDriveForward, 50000),
			new MotionItem(EAutoStates.eTurnRight, 50000), 
			new MotionItem(EAutoStates.eDriveForwardWithLift, 20000000),
			new MotionItem(EAutoStates.eOutTake, 0.5),
			new MotionItem(EAutoStates.eReverse, 50000),
			new MotionItem(EAutoStates.eLiftDown),
			new MotionItem(EAutoStates.eIdle)
			
	};

	
}