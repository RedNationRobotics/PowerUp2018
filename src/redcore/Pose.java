package redcore;

public class Pose {
	private final double _div180 = 1.0 / 180.0;
	private final double _pidive2 = Math.PI * 0.5;
	public double _JavaRadAngle;
	public double _radHeading;
	public double _Deltax;
	public double _Deltay;
	public double _x;
	public double _y;
	public double _heading_deg;
	
	public void SetPose(double x, double y, double heading_deg) {
		_x = x;
		_y = y;
		_heading_deg = heading_deg;
	}
	public void DriveForward(double Distance_in) {
		_radHeading = _heading_deg * _div180 * Math.PI;
		_JavaRadAngle = _pidive2 - _radHeading;
		_Deltax = Math.cos(_JavaRadAngle) * Distance_in;
		_Deltay = Math.sin(_JavaRadAngle) * Distance_in;
		_x += _Deltax;
		_y += _Deltay;
	}
	public void RelativeTurn(double HeadingChange_deg) {
		_heading_deg += HeadingChange_deg;
	}
}
