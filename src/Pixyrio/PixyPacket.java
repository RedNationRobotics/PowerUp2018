package Pixyrio;

public class PixyPacket {
	
	public int _Checksum;
	public int _Signature;
	public int _X;
	public int _Y;
	public int _Width;
	public int _Height;
	
	
	public String GetObjectType() {
		switch(_Signature) {
		case 1:
			return " Power Cube";
		case 2:
			return "Red Portal";
		case 3:
			return "Blue Portal";
		default:
			return "Unkown";
		}
		
	}
	
}

