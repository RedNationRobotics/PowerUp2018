package PowerUp2018;
/**
* Interface that holds all the field measurements 
*/

//https://www.chiefdelphi.com/forums/attachment.php?attachmentid=22877&d=1516118855

public class FieldDimensions 
{
	
	public static final double dLiftClicksPerInch = 465.6;
	public static final double dLiftInchesPerClicks = 1.0/dLiftClicksPerInch;
	
	public static final double dClicksPerInch = 1653;
	public static final double dInchesPerClicks = 1.0/dClicksPerInch;
    
	public static final double dWheelCentersWidth = 25.0;
	public static final double dWheelTurnCircumference = (dWheelCentersWidth * 1.13) * Math.PI;
	public static final double dInchesPerDegree = dWheelTurnCircumference / 360.0;
	
	// dimensions of field components (in inches)
	public static double kLengthfromcenterOfRobotToCornerOfScale = 288.0;
	public static double kMaxLiftHeightScale = 73.0;
	public static double kMinLiftHeightScale = -68.0;
	public static double kMaxLiftHeightSwitch = 31.0;
	public static double kMinLiftHeightSwitch = -26.0;
	public static double kCenterToLineInfrontOfBaseLine = 98.0;
	public static double kCenterToMiddlePartOfSwitchLoading = 151.5;
	public static double kCornerOfPortalToSwitchSpaceBetweenXWall = 55.56;
	public static double kLengthOfSpaceBetweenCenterofRobotStartToSwitchEdge = 41.56;
	public static double kCenterToPointA = 208.0;
	public static double kPointAToScaleSide = 241.66;
	public static double kStartingCenterToCenterLoadingScale = 303.5;
	public static double kTimerOuttake = 0.3;
	public static double kTimerIntake = 0.2;
	public static double kPointAToCenterBackLoadingSwitch = 174.0;

	public static double kFieldLengthX = 648;
	public static double kAllianceStationLengthY = 264;
	public static double kScalePlatformLengthX = 82;
	public static double kPowerCubeZoneLengthX = 42;

	public static double kSwitchLengthX = 56;
	public static double kSwitchLengthY = 153.5;
	
	public static double kScaleLengthX = 48;
	public static double kScaleLengthY = 180;
	
	// field distances with Center Start as origin
	public static double kAutoLineFromCenterStartDistX = 120;
	
	public static double kSwitchCenterFromCenterStartDistX = 140;
	public static double kLeftSwitchFromCenterStartDistX = kSwitchCenterFromCenterStartDistX + (kSwitchLengthX/2); // to center of switch
	public static double kLeftSwitchFromCenterStartDistY = kSwitchLengthY/2; // to y end of switch
	public static double kRightSwitchFromCenterStartDistX = kLeftSwitchFromCenterStartDistX;
	public static double kRightSwitchFromCenterStartDistY = -kLeftSwitchFromCenterStartDistY;
	
	public static double kScaleFromCenterStartDistX = kFieldLengthX/2;
	public static double kLeftScaleFromCenterStartDistX = kScaleFromCenterStartDistX; // to center of scale
	public static double kLeftScaleFromCenterStartDistY = kScaleLengthY/2; // to y end of scale
	public static double kRightScaleFromCenterStartDistX = kLeftScaleFromCenterStartDistX;
	public static double kRightScaleFromCenterStartDistY = -kLeftScaleFromCenterStartDistY;
	
	public static double kScaleLeftEndXFromCenterStartDistX = 299.65;
	public static double kSwitchRightEndXFromCenterStartDistX = 196;
	public static double kPlatFormLeftEndXFromSwitchCenterDistX = (kFieldLengthX/2) - kSwitchCenterFromCenterStartDistX - (kScalePlatformLengthX/2);
	public static double kScaleFromSwitchOffsetY = (kScaleLengthY/2) - (kSwitchLengthY/2);
	
	public static double kPowerCubeZoneFromCenterStartDistX = 98;
	
}


