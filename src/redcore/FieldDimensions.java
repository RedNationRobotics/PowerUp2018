package redcore;
/**
* Interface that holds all the field measurements 
*/

//https://www.chiefdelphi.com/forums/attachment.php?attachmentid=22877&d=1516118855

public class FieldDimensions 
{
	// dimensions of field components (in inches)
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


