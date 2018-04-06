package redcore;

public class Pose {
	
	private final double _div180 = 1.0 / 180.0;
	private final double _PiDive2 = Math.PI * 0.5;
	private final double _OneDivePi = 1.0 / Math.PI;
	public double _JavaRadAngle;
	public double _radHeading;
	public double _Deltax;
	public double _Deltay;
	public double _x_in;
	public double _y_in;
	public double _heading_deg;
	
	public Pose() {
		
	}
	public void SetPose(double x_in, double y_in, double heading_deg) {
		_x_in = x_in;
		_y_in = y_in;
		_heading_deg = heading_deg;
	} 
	
	public Vector GetAbsoluteVector(WayPoint NewWayPoint) {
		double difX_in = NewWayPoint._x_in - _x_in;
		double difY_in = NewWayPoint._y_in - _y_in;
		
		//Pythagorean theorem a^2 + b^2 = c^2
		double distance_in = Math.sqrt((difX_in * difX_in) + (difY_in * difY_in));
		
		//trig
		double java_radians = Math.atan2(difY_in, difX_in);
		double heading_radians = _PiDive2 - java_radians;
		double heading_deg = (heading_radians * _OneDivePi) * 180;
		heading_deg = RangeCheckHeading(heading_deg);
		
		return new Vector(heading_deg, distance_in);
	}
	
	public double RangeCheckHeading(double heading_deg) {
		if (heading_deg < 0.0){
			heading_deg += 360.0;
		}
		if (heading_deg >= 360.0) {
			heading_deg -= 360.0;
		}
		return heading_deg;
	}
	
	public double RelativeRangeCheckHeading(double heading_deg) {
		if (heading_deg < -180.0) {
			heading_deg += 360.0;
		}
		if (heading_deg > 180.0) {
			heading_deg -= 360.0;
		}
		return heading_deg;
	}
	
	public Vector GetRelativeVector(WayPoint NewWayPoint) {
		Vector absoluteVector = GetAbsoluteVector(NewWayPoint);
		double relativeHeading_deg = absoluteVector._heading_deg - _heading_deg;
		absoluteVector.ShowSelf();
		relativeHeading_deg = RelativeRangeCheckHeading(relativeHeading_deg);
		Vector relativeVector = new Vector(relativeHeading_deg, absoluteVector._distance_in, true);
		return relativeVector;
	}
	
	public void DriveForward(double Distance_in) {
		_radHeading = _heading_deg * _div180 * Math.PI;
		_JavaRadAngle = _PiDive2 - _radHeading;
		_Deltax = Math.cos(_JavaRadAngle) * Distance_in;
		_Deltay = Math.sin(_JavaRadAngle) * Distance_in;
		_x_in += _Deltax;
		_y_in += _Deltay;
	}
	public void RelativeTurn(double HeadingChange_deg) {
		_heading_deg += HeadingChange_deg;
	}
	public void ShowSelf() {
			System.out.print("Pose(" + _x_in + "in, " + _y_in + "in, " + _heading_deg + "deg)\n");
			
		}
}
