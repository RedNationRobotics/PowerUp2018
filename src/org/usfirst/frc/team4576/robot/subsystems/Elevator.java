package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Subsystem;

//*******************************************************************
//Elevator						Author: Robert Lohmann
//								Last Edited: 2/12/2018 by RL
//This is where the methods that are run by the Elevator commands live. also contains 
//methods to enable joystick trigger control. To change throttle, see robotMap
//*******************************************************************
public class Elevator extends Subsystem { // This system extends PIDSubsystem

	public StringBuilder elevstring = new StringBuilder();
	int _loops = 0;
	boolean _lastButton1 = false;
	boolean _lastButton2 = false;

	public WPI_TalonSRX tsrxE = new WPI_TalonSRX(RobotMap.ELEVATOR_TALON);
	/** save the target position to servo to */
	DigitalInput limitSwitchT = new DigitalInput(1);
	DigitalInput limitSwitchB = new DigitalInput(2);

	double targetPos1 = (double) (2.0000000 * 360.00000000);// change the value
															// in front of
															// *360.0000000
															// if you want
															// to mess with
															// turns
	double targetPos2 = (double) (10.0000000 * 360.00000000);// MAKE SURE TO
																// KEEP ALL THE
																// FLOATING
																// ZEROS!

	boolean firstRun = true;

	public Elevator() {
		// constants that are used when
		// computing the motor output
		// This stuff is for enabling a soft rotation limit so we don't break
		// our elevator
		tsrxE.configForwardSoftLimitEnable(true, RobotMap.kTimeoutMs);
		tsrxE.configReverseSoftLimitEnable(true, RobotMap.kTimeoutMs);

		tsrxE.configForwardSoftLimitThreshold(50, RobotMap.kTimeoutMs);
		tsrxE.configReverseSoftLimitThreshold(50, RobotMap.kTimeoutMs);

		/* choose the sensor and sensor direction */
		tsrxE.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.ELEVATOR_PID,
				RobotMap.kTimeoutMs);

		/* choose to ensure sensor is positive when output is positive */
		tsrxE.setSensorPhase(RobotMap.kSensorPhase);

		/*
		 * choose based on what direction you want forward/positive to be. This
		 * does not affect sensor phase.
		 */
		tsrxE.setInverted(RobotMap.kMotorInvert);

		/* set the peak and nominal outputs, 12V means full */
		tsrxE.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		tsrxE.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		tsrxE.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		tsrxE.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);
		/*
		 * set the allowable closed-loop error, Closed-Loop output will be
		 * neutral within this range. See Table in Section 17.2.1 for native
		 * units per rotation.
		 */
		tsrxE.configAllowableClosedloopError(0, RobotMap.ELEVATOR_PID, RobotMap.kTimeoutMs);

		/* set closed loop gains in slot0, typically kF stays zero. */
		tsrxE.config_kF(RobotMap.ELEVATOR_PID, 0.0, RobotMap.kTimeoutMs);
		tsrxE.config_kP(RobotMap.ELEVATOR_PID, 0.1, RobotMap.kTimeoutMs);
		tsrxE.config_kI(RobotMap.ELEVATOR_PID, 0.0, RobotMap.kTimeoutMs);
		tsrxE.config_kD(RobotMap.ELEVATOR_PID, 0.0, RobotMap.kTimeoutMs);

		/*
		 * lets grab the 360 degree position of the MagEncoder's absolute
		 * position, and intitally set the relative sensor to match.
		 */
		int absolutePosition = tsrxE.getSensorCollection().getPulseWidthPosition();
		/* mask out overflows, keep bottom 12 bits */
		absolutePosition &= 0xFFF;
		if (RobotMap.kSensorPhase)
			absolutePosition *= -1;
		if (RobotMap.kMotorInvert)
			absolutePosition *= -1;
		/* set the quadrature (relative) sensor to match absolute */
		tsrxE.setSelectedSensorPosition(absolutePosition, RobotMap.ELEVATOR_PID, RobotMap.kTimeoutMs);

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void elevatorTeleop(Joystick stick) {
		if (firstRun) {
			targetPos1 += tsrxE.getSelectedSensorPosition(RobotMap.ELEVATOR_PID);
			targetPos2 += tsrxE.getSelectedSensorPosition(RobotMap.ELEVATOR_PID);
			firstRun = !firstRun;
		}
		/* get gamepad axis */
		double motorOutput = tsrxE.getMotorOutputVoltage() / tsrxE.getBusVoltage();
		boolean button1 = stick.getRawButton(1);
		boolean button2 = stick.getRawButton(2);
		/* prepare line to print */
		// elevstring.append("45 is set to: " + targetPos1 + " which should be
		// .125 rotations from intial\n");
		elevstring.append("\tout:");
		elevstring.append(motorOutput);
		elevstring.append("\tpos:");
		elevstring.append(tsrxE.getSelectedSensorPosition(RobotMap.ELEVATOR_PID));
		/* on button1 press enter closed-loop mode on target position */
		if (!_lastButton1 && button1) {

			tsrxE.set(ControlMode.Position,
					targetPos1); /* 50 rotations in either direction */

		}
		if (!_lastButton2 && button2) {

			tsrxE.set(ControlMode.Position,
					targetPos2); /* 50 rotations in either direction */

		}
		// might be needed

		// if(tsrxE.getControlMode() == ControlMode.PercentOutput)
		// tsrxE.set(leftYstick);

		/* if Talon is in position closed-loop, print some more info */
		if (tsrxE.getControlMode() == ControlMode.Position) {
			/* append more signals to print when in speed mode. */
			elevstring.append("\terrNative:");
			elevstring.append(tsrxE.getClosedLoopError(_loops));
			elevstring.append("\ttrg:");
			elevstring.append(targetPos1);
		}
		/*
		 * print every ten loops, printing too much too fast is generally bad
		 * for performance
		 */
		elevstring.setLength(0);
		/* save button state for on press detect */
		_lastButton1 = button1;
		_lastButton2 = button2;
	}

	public void up() {
		// shooterElevR.set(-.5);
		tsrxE.set(.05);

	}

	public void down() {
		// shooterElevR.set(.5);
		tsrxE.set(-.05);

	}

	public void stop() {
		tsrxE.set(0);
	}

	// Axis values:
	// 1 - LeftX
	// 2 - LeftY
	// 3 - Triggers (Each trigger = 0 to 1, axis value = right - left)
	// 4 - RightX
	// 5 - RightY
	// 6 - DPad Left/Right
	@Deprecated
	public void gamePadControl(Joystick stick) {

		// System.out.println("gamepad control");
		// System.out.println(stick.getRawAxis(3) + " " + stick.getRawAxis(2));
		if (stick.getRawAxis(3) - stick.getRawAxis(2) < 0 && stick.getRawAxis(3) - stick.getRawAxis(2) > -0.1) {
			// shooterElevR.set(0);
			tsrxE.set(0);
			return;

		}
		tsrxE.set(stick.getRawAxis(3) - stick.getRawAxis(2));
		// shootertsrxE.set(stick.getRawAxis(3) - stick.getRawAxis(2));
	}

}