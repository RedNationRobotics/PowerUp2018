package Pixyrio;

public class PixyObject {
	protected static final double _DegPerPixel = 1.0/4.2333;
	
	public int _Checksum;
	public int _Signature;
	public int _X;
	public int _Y;
	public int _Width;
	public int _Height;
	
	
	
	public double GetObjectCourse() {
		return (_X - 160.0) * _DegPerPixel; 
	}
	
	
	public String GetObjectType() {
		switch(_Signature) {
		case 1:
			return "Cube";
		case 2:
			return "Red Portal";
		case 3:
			return "Blue Portal";
		default:
			return "Unkown";
		}
	}
	
	
}
