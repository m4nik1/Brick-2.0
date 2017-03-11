package org.usfirst.frc.team558.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team558.robot.commands.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick driveStick = new Joystick(0);
	Joystick operatorStick = new Joystick(1);
	XboxController AfterGlow = new XboxController(0);
	
	
	public OI(){
	
			
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
			return -driveStick.getRawAxis(RobotMap.turnAxis);
		}
		
		public void rumble(){
			
			if(driveStick.getRawAxis(3) > .1 || driveStick.getRawAxis(2) > .1){
				
				AfterGlow.setRumble(GenericHID.RumbleType.kLeftRumble, Robot.oi.GetThrottle());
				AfterGlow.setRumble(GenericHID.RumbleType.kRightRumble, Robot.oi.GetThrottle());
			}
			
			else{
				
				AfterGlow.setRumble(GenericHID.RumbleType.kLeftRumble, 0);
				AfterGlow.setRumble(GenericHID.RumbleType.kRightRumble, 0);
				
			}
		}
	
}
