package redcore;

public class WayPoint {
	public double _x_in;
	public double _y_in;
	
	public WayPoint() {
		
	}
	
	public WayPoint(double x_in, double y_in) {
		_x_in = x_in;
		_y_in = y_in;
	}
	
	public void ShowSelf() {
		System.out.println("WayPoint(" + _x_in + "in, " + _y_in + "in)");;
	}

}
