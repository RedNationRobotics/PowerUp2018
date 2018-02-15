package redcore;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class AxisButton1 extends Button { 
//This class makes axes like the sticks or triggers on our controller behave like buttons.
	Joystick joystick;
	int axis;
	double pressThreshold;
	double releaseThreshold;
	int reverseFactor;
	boolean wasPressed;
	
	public AxisButton1(Joystick joystick, int axis, double pressThreshold, double releaseThreshold, boolean reverse) {
		this.joystick = joystick;
		this.axis = axis;
		this.reverseFactor = reverse ? -1 : 1;
		this.pressThreshold = pressThreshold * reverseFactor;
		this.releaseThreshold = releaseThreshold * reverseFactor;
		this.wasPressed = false;
	}

	public AxisButton1(Joystick joystick, int axis, double pressThreshold, double releaseThreshold) {
		this(joystick, axis, pressThreshold, releaseThreshold, false);
	}
	
	@Override
	public boolean get() {
		double threshold = wasPressed ? releaseThreshold : pressThreshold;
		wasPressed = reverseFactor * joystick.getRawAxis(axis) > threshold; 
		return wasPressed;
	}

	
}