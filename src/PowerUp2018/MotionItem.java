package PowerUp2018;

import PowerUp2018.AutoStates.EAutoStates;

public class MotionItem {
	public EAutoStates eAutoState;
	public double dParam1;

	// constructor to take two values
	public MotionItem(EAutoStates eTempAutoState, double dTempParam1) {
	   eAutoState = eTempAutoState;
	   dParam1 = dTempParam1;
	}
	
	// constructor to take one value
	public MotionItem(EAutoStates eTempAutoState) {
		eAutoState = eTempAutoState;
		dParam1 =0.0;
	}
	
}
 