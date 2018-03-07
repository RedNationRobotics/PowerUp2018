package PowerUp2018;

import PowerUp2018.AutoStates.EAutoStates;

public class AutoRecipes {

	public static MotionItem[] _Test_ = {	
			new MotionItem(EAutoStates.eDriveForward, 72.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eDriveForward, 41.0),
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 1.0),
			new MotionItem(EAutoStates.eDriveForward, 36.0),
			new MotionItem(EAutoStates.eGripper_SetArm, 0.0),
			new MotionItem(EAutoStates.eGripper_Intake),
			new MotionItem(EAutoStates.eStartTimer, 1.0),
			new MotionItem(EAutoStates.eGripper_Stop),
			new MotionItem(EAutoStates.eDriveForward, -36.0),
			new MotionItem(EAutoStates.eStartTimer, 0.25),
			new MotionItem(EAutoStates.eSetLiftHeight, 30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _ElevatorDown_Recipe_ = {	
			new MotionItem(EAutoStates.eSetLiftHeight, -73.0),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _ElevatorUp_Recipe_ = {	
			new MotionItem(EAutoStates.eSetLiftHeight, 73.0),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};
	

	public static MotionItem[] _LeftSide_LeftSwitch_1cube = { /*good*/	
			//Forward to the Middle area of the switch
			new MotionItem(EAutoStates.eDriveForward, 151.0), 
			//Right
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			//Raise lift to switch height
			new MotionItem(EAutoStates.eSetLiftHeight, 35.0),
			//Drive up to switch
			new MotionItem(EAutoStates.eDriveForward, 25.0),
			//Release Cube
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			//Back up, lower lift, and stop.
			new MotionItem(EAutoStates.eDriveForward, -25.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle) 
			
	};
	public static MotionItem[] _LeftSide_RightSwitch_1cube = { /*good*/
			//Forward until inbetween switch and scale
			new MotionItem(EAutoStates.eDriveForward, 214.735), 
			//Right
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			//Forward to opposite end of climb platform
			new MotionItem(EAutoStates.eDriveForward, 187.62),
			//Right
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			new MotionItem(EAutoStates.eDriveForward, 5.0),
			//Move Elevator up to Switch Height
			new MotionItem(EAutoStates.eSetLiftHeight, 35.0),
			//Release cube
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, .4),
			new MotionItem(EAutoStates.eGripper_Stop),
			//Back up, Lower Lift, then stop.
			new MotionItem(EAutoStates.eDriveForward, -5.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle) 

		};
	public static MotionItem[] _LeftSide_LeftScale_1cube  = { /*good*/
			//Forward until inbetween switch and scale
			new MotionItem(EAutoStates.eDriveForward, 310.0),
			//Right
			new MotionItem(EAutoStates.eStoppedTurn, 90), 
			//Drive up to scale, Raise elevator
			new MotionItem(EAutoStates.eDriveForward, 10.0),
			new MotionItem(EAutoStates.eSetLiftHeight,73.0),
			//Release Cube
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer,.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			//Back up, lower elevator, then stop.
			new MotionItem(EAutoStates.eDriveForward, -12.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -69.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _LeftSide_RightScale_1cube  = { /*good*/
			//Forward until between switch and scale
			new MotionItem(EAutoStates.eDriveForward, 214.735),
			//Right
			new MotionItem(EAutoStates.eStoppedTurn, 90), 
			//Forward to opposite end of climb platform
			new MotionItem(EAutoStates.eDriveForward, 210.125),
			//Left
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			//Forward to scale platform, Raise elevator
			new MotionItem(EAutoStates.eDriveForward, 109.265),
			new MotionItem(EAutoStates.eSetLiftHeight, 73.0),
			//Left
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			//Release Cube
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			//Right
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			//Back up, Lower Elevator, then stop.
			new MotionItem(EAutoStates.eSetLiftHeight, -69.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _MiddleSide_LeftSwitch_1cube  = { /*good*/
			//Forward until between cube pile and wall
			new MotionItem(EAutoStates.eDriveForward, 83.5),
			//Left
			new MotionItem(EAutoStates.eStoppedTurn, -90), 
			//Forward towards wall
			new MotionItem(EAutoStates.eDriveForward, 40.0),
			//Right
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			//Forward to middle of switch
			new MotionItem(EAutoStates.eDriveForward, 22.5),
			//Raise Elevator, Release cube
			new MotionItem(EAutoStates.eSetLiftHeight, 35.0),
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			//Back up, lower Elevator, then stop`
			new MotionItem(EAutoStates.eDriveForward, -22.5),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _MiddleSide_RightSwitch_1cube  = { /*good*/
			//Forward until between cube pile and wall
			new MotionItem(EAutoStates.eDriveForward, 83.5),
			//Right
			new MotionItem(EAutoStates.eStoppedTurn, 90), 
			//Forward towards wall
			new MotionItem(EAutoStates.eDriveForward, 40.0),
			//Left
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			//Forward to switch, Raise Elevator
			new MotionItem(EAutoStates.eDriveForward, 22.5),
			new MotionItem(EAutoStates.eSetLiftHeight, 35.0),
			//Release cube
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			//Back up, lower elevator, then stop.
			new MotionItem(EAutoStates.eDriveForward, -22.5),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _MiddleSide_LeftScale_1cube  = { /*good*/
			//Forward enough to turn
			new MotionItem(EAutoStates.eDriveForward, 81.0),
			//Left
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			//Forward to wall
			new MotionItem(EAutoStates.eDriveForward, 104.53),
			//Right
			new MotionItem(EAutoStates.eStoppedTurn, 90),
			//Forward to scale, raise elevator
			new MotionItem(EAutoStates.eDriveForward, 284.97),
			new MotionItem(EAutoStates.eSetLiftHeight, 73.0),
			//Right
			new MotionItem(EAutoStates.eStoppedTurn, 90),
			//Release cube
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			//Left
			new MotionItem(EAutoStates.eStoppedTurn, -90),
			//Lower Elevator, then stop
			new MotionItem(EAutoStates.eSetLiftHeight, -69.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _MiddleSide_RightScale_1cube  = { /*good*/
			//Forward enough to turn
			new MotionItem(EAutoStates.eDriveForward, 81.0),
			//Right
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			//Forward to wall
			new MotionItem(EAutoStates.eDriveForward, 104.53),
			//Left
			new MotionItem(EAutoStates.eStoppedTurn, -90),
			//Drive to scale, raise elevator.
			new MotionItem(EAutoStates.eDriveForward, 284.97),
			new MotionItem(EAutoStates.eSetLiftHeight, 73.0),
			//Left
			new MotionItem(EAutoStates.eStoppedTurn, -90),
			//Release cube
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			//Right
			new MotionItem(EAutoStates.eStoppedTurn, 90),
			//Lower elevator, then stop
			new MotionItem(EAutoStates.eSetLiftHeight, -69.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)

	};
	public static MotionItem[] _RightSide_LeftSwitch_1cube  = { /*good*/
			//Forward until between scale and switch
			new MotionItem(EAutoStates.eDriveForward, 214.735), 
			//Left
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			//Forward to opposite side of climb platform
			new MotionItem(EAutoStates.eDriveForward, 187.62),
			//Left
			new MotionItem(EAutoStates.eStoppedTurn, -90.0), 
			//Drive forward, raise elevator
			new MotionItem(EAutoStates.eDriveForward, 5.0),
			new MotionItem(EAutoStates.eSetLiftHeight, 35.0),
			//Release cube
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, .4),
			new MotionItem(EAutoStates.eGripper_Stop),
			//Back up, lower elevator, then stop
			new MotionItem(EAutoStates.eDriveForward, -5.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _RightSide_RightSwitch_1cube  = { /*good*/
			//Forward to middle of switch
			new MotionItem(EAutoStates.eDriveForward, 151.0), 
			//Raise elevator
			new MotionItem(EAutoStates.eSetLiftHeight, 35.0),
			//Left
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			//Drive up to switch
			new MotionItem(EAutoStates.eDriveForward, 25.0),
			//Release cube
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			//Back up, lower elevator, then stop
			new MotionItem(EAutoStates.eDriveForward, -25.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -30.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	public static MotionItem[] _RightSide_LeftScale_1cube  = { /*good*/
			//Forward to between switch and scale
			new MotionItem(EAutoStates.eDriveForward, 214.735),
			//Left
			new MotionItem(EAutoStates.eStoppedTurn, -90), 
			//Forward to opposite side of climb platform
			new MotionItem(EAutoStates.eDriveForward, 210.125),
			//Right
			new MotionItem(EAutoStates.eStoppedTurn, 90.0), 
			//Forward to scale, raise elevator
			new MotionItem(EAutoStates.eDriveForward, 109.265),
			new MotionItem(EAutoStates.eSetLiftHeight, 73.0),
			//Right
			new MotionItem(EAutoStates.eStoppedTurn, 90.0),
			//Release cube
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer, 0.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			//Left, lower elevator
			new MotionItem(EAutoStates.eStoppedTurn, -90.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -69.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle) 
			
	}; 
	public static MotionItem[] _RightSide_RightScale_1cube  = { /*good*/
			//Forward to scale, raise elevator
			new MotionItem(EAutoStates.eDriveForward, 310.0),
			new MotionItem(EAutoStates.eSetLiftHeight, 73.0),
			//Left
			new MotionItem(EAutoStates.eStoppedTurn, -90), 
			//forward up to scale
			new MotionItem(EAutoStates.eDriveForward, 10.0),
			//Release cube
			new MotionItem(EAutoStates.eGripper_Release),
			new MotionItem(EAutoStates.eStartTimer,.4),
			new MotionItem(EAutoStates.eGripper_Stop),
			//Back up, lower elevator, then stop
			new MotionItem(EAutoStates.eDriveForward, -12.0),
			new MotionItem(EAutoStates.eSetLiftHeight, -69.0),
			new MotionItem(EAutoStates.eStopMotors),
			new MotionItem(EAutoStates.eStopElevator),
			new MotionItem(EAutoStates.eIdle)
			
	};
	
	

	
}