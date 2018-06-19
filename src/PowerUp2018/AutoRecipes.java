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
	public static MotionItem[] _LeftSwitchLeftScale_MiddleSide = { //review
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
	public static MotionItem[] _RightSwitchLeftScale_RightSide = { //review
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
	public static MotionItem[] _LeftSwitchRightScale_LeftSide = { // review
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
	public static MotionItem[] _LeftScale_RightSide = { //plan written
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(110, 25)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(115, 235)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-120, 235)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-120, 315)),
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
	public static MotionItem[] _LeftScale_LeftSide = {//plan written
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-110, 25)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-120, 315)),
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
	public static MotionItem[] _RightScale_LeftSide = { //plan written
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-110, 25)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-115, 235)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(120,235)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(120, 315)),
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
	public static MotionItem[] _RightScale_RightSide = { //plan written
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(110, 25)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(120, 315)),
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
	public static MotionItem[] _RightSwitch_LeftSide = { //plan written
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-110, 25)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-115  , 75)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-115, 235)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(100 , 235)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(100 , 165)),
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
	public static MotionItem[] _LeftSwitch_LeftSide = { //plan written
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-110, 25)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-115, 75)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-100, 145)),
			new MotionItem(EAutoStates.eAbsoluteTurn, 75.7),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch), 
		    new MotionItem(EAutoStates.eStopMotors),
		    new MotionItem(EAutoStates.eStopElevator),
		    new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _LeftSwitch_RightSide = { //plan written
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(110, 25)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(115  , 75)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(115, 235)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-100 , 235)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-100 , 165)),
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
	public static MotionItem[] _RightSwitch_RightSide = { //plan written
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(110, 25)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(115  , 75)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(100, 145)),
			new MotionItem(EAutoStates.eAbsoluteTurn, -75.7),
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMaxLiftHeightSwitch), 
			new MotionItem(EAutoStates.eGripper_Release), 
			new MotionItem(EAutoStates.eStartTimer, FieldDimensions.kTimerOuttake), 
			new MotionItem(EAutoStates.eGripper_Stop), 
			new MotionItem(EAutoStates.eSetLiftHeight, FieldDimensions.kMinLiftHeightSwitch), 
		    new MotionItem(EAutoStates.eStopMotors),
		    new MotionItem(EAutoStates.eStopElevator),
		    new MotionItem(EAutoStates.eIdle)
	};
	public static MotionItem[] _RightSwitch_MiddleSide = { //certified
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
	public static MotionItem[] _LeftSwitch_MiddleSide = { //certified
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
		    new MotionItem(EAutoStates.eIdle),
	};
	public static MotionItem[] _LeftScale_MiddleSide = {
			 
	};
	public static MotionItem[] _RightScale_MiddleSide = {
			
	};
		    
	public static MotionItem[] _BaselineLeft = {
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-110, 25)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-130, 50)),
			new MotionItem(EAutoStates.eDriveToWayPoint, new WayPoint(-130, 130)),
			new MotionItem(EAutoStates.eStopMotors),
		    new MotionItem(EAutoStates.eStopElevator),
		    new MotionItem(EAutoStates.eIdle),
	 };		    
}