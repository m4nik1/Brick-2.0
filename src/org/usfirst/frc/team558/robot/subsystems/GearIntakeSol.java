package org.usfirst.frc.team558.robot.subsystems;

import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearIntakeSol extends Subsystem {
	
	DoubleSolenoid intakeSol = new DoubleSolenoid(RobotMap.gearPlacerSolenoidChannel1, RobotMap.gearPlacerSolenoidChannel2);
	
	public void PushGearOut(){
		
		intakeSol.set(DoubleSolenoid.Value.kForward);
		
	}
	
	public void ResetIntake(){
		
		intakeSol.set(DoubleSolenoid.Value.kReverse);
		
	}

    public void initDefaultCommand() {
    	
    }
}

