package PowerUp2018;

import PowerUp2018.AutoStates.EAutoStates;
import redcore.WayPoint;

public class MotionItem {
	public EAutoStates eAutoState;
	public double dParam1;	
	public WayPoint _WayPoint;

	// constructor to take two values
	public MotionItem(EAutoStates eTempAutoState, double dTempParam1) {
	   eAutoState = eTempAutoState;
	   dParam1 = dTempParam1;
	}
	public MotionItem(EAutoStates eTempAutoState, WayPoint NewWayPoint) {
		eAutoState = eTempAutoState;
		_WayPoint = NewWayPoint;
	}
	
	// constructor to take one value
	public MotionItem(EAutoStates eTempAutoState) {
		eAutoState = eTempAutoState;
		dParam1 = 0.0;

	}
	
}
 