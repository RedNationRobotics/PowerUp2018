package redcore;

public class Vector {
	public double _heading_deg;
	public double _distance_in;
	public boolean _IsRelative;
	
	public Vector() {
		_IsRelative = false;
	}
	
	public Vector(double heading_deg, double distance_in) {
		_IsRelative = false;
		_heading_deg = heading_deg;
		_distance_in = distance_in;
	}
	
	public Vector(double heading_deg, double distance_in, boolean IsRelative) {
		_IsRelative = IsRelative;
		_heading_deg = heading_deg;
		_distance_in = distance_in;
	}
	
	public void ShowSelf() {
		System.out.print("*********");
		if (_IsRelative) {
			System.out.print("Relative ");
		}
		else {
			System.out.print("Absoute ");			
			}
		System.out.print("Vector(" + _heading_deg + "deg," + _distance_in + "in)\n");

		}
	}

