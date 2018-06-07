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
	public static MotionItem[] _LeftSwitchLeftScale_MiddleSide = { 
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-60, 110)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),
            new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-100, 110)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-100, 230)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-70, 230)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 180),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-70, 210)),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-120, 310)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 90),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale), 
		    new MotionItem(EAutoStates.eStopMotors),
		    new MotionItem(EAutoStates.eStopElevator),
		    new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _RightSwitchLeftScale_RightSide = {
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(110, 160)),
			new MotionItem(EAutoStates.eAbsoluteTurn, -90),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),
            new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch),
            new MotionItem(EAutoStates.eAbsoluteTurn, 0),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(110, 230)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(70, 230)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 180),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(70, 220)),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-90, 230)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-90, 270)),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale), 
		    new MotionItem(EAutoStates.eStopMotors),
		    new MotionItem(EAutoStates.eStopElevator),
		    new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _LeftSwitchRightScale_LeftSide = { // not ready //
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(110, 160)),
			new MotionItem(EAutoStates.eAbsoluteTurn, -90),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),
            new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch),
            new MotionItem(EAutoStates.eAbsoluteTurn, 0),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(110, 230)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(70, 230)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 180),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(70, 220)),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerIntake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-90, 230)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-90, 270)),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale), 
		    new MotionItem(EAutoStates.eStopMotors),
		    new MotionItem(EAutoStates.eStopElevator),
		    new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _LeftScale_RightSide = { 
		   
			
			
	};
	public static MotionItem[] _LeftScale_LeftSide = {
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-115, 295)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 90),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale), 
		    new MotionItem(EAutoStates.eStopMotors),
		    new MotionItem(EAutoStates.eStopElevator),
		    new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _RightScale_LeftSide = {


			
	};
	public static MotionItem[] _RightScale_RightSide = {
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(115, 295)),
			new MotionItem(EAutoStates.eAbsoluteTurn, -90),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightScale), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightScale), 
		    new MotionItem(EAutoStates.eStopMotors),
		    new MotionItem(EAutoStates.eStopElevator),
		    new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _RightSwitch_LeftSide = {

	};
	public static MotionItem[] _LeftSwitch_LeftSide = {
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-115, 75)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-100, 145)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 90),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch), 
		    new MotionItem(EAutoStates.eStopMotors),
		    new MotionItem(EAutoStates.eStopElevator),
		    new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _LeftSwitch_RightSide = {

	};
	public static MotionItem[] _RightSwitch_RightSide = {
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(115, 75)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(100, 145)),
			new MotionItem(EAutoStates.eAbsoluteTurn, -90),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch), 
		    new MotionItem(EAutoStates.eStopMotors),
		    new MotionItem(EAutoStates.eStopElevator),
		    new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _RightSwitch_MiddleSide = {
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(0, 60)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(60, 110)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch), 
		    new MotionItem(EAutoStates.eStopMotors),
		    new MotionItem(EAutoStates.eStopElevator),
		    new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _LeftSwitch_MiddleSide = {
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(0, 40)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-60, 110)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 0),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch), 
		    new MotionItem(EAutoStates.eStopMotors),
		    new MotionItem(EAutoStates.eStopElevator),
		    new MotionItem(EAutoStates.eIdle)
	};
}