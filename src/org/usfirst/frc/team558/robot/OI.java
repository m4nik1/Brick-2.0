package org.usfirst.frc.team558.robot;

import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team558.robot.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;


public class OI {
	
	XboxController driveStick = new XboxController(RobotMap.driveJoystickPort);
	Joystick operatorStick = new Joystick(RobotMap.operatorJoystickPort);
	
	
	
	public OI(){
		
		JoystickButton placeGearBtn = new JoystickButton(operatorStick, RobotMap.placeGearButton);
		JoystickButton brakeOnBtn = new JoystickButton(operatorStick, RobotMap.breakOnButton);
		JoystickButton brakeOffBtn = new JoystickButton(operatorStick, RobotMap.breakOffButton);
		
		placeGearBtn.toggleWhenPressed(new ToggleGearSol());
		brakeOnBtn.whenPressed(new SetBrakeOn());
		brakeOffBtn.whenPressed(new SetBrakeOff());
		
			
	}
		
	
	//Elm City Drive Methods
		public boolean GetQuickTurn(){
			return driveStick.getRawButton(RobotMap.quickTurnButton);
			
		}
		
		public double GetThrottle(){
			double reverse = driveStick.getRawAxis(RobotMap.throttleForwardAxis);
	    	double forward = driveStick.getRawAxis(RobotMap.throttleReverseAxis);

	    	if ((reverse > .1) && (forward >.1)){
	    		return 0;
	    	}
	    	else if (forward > .1){
	    		return forward;
	    	}
	    	else if (reverse > .1){
	    		return -reverse;
	    	}
	    	else
	    		return 0;
		}

		
		public double GetTurn(){
			return driveStick.getRawAxis(RobotMap.turnAxis);
		}
		
		public double GearInOut(){
			
			return operatorStick.getRawAxis(RobotMap.gearIntakeAxis);
		}
		
		public void rumble(double rumbleRight, double rumbleLeft){
			
			driveStick.setRumble(GenericHID.RumbleType.kLeftRumble, rumbleLeft);
			driveStick.setRumble(GenericHID.RumbleType.kRightRumble, rumbleRight);
			
		}
}
