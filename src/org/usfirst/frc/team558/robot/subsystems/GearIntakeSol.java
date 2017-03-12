package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearIntakeSol extends Subsystem {
	
	DoubleSolenoid intakeSol = new DoubleSolenoid(0, 1);
	
	public void PushGearOut(){
		
		intakeSol.set(DoubleSolenoid.Value.kForward);
		
	}
	
	public void ResetIntake(){
		
		intakeSol.set(DoubleSolenoid.Value.kReverse);
		
	}

    public void initDefaultCommand() {
    	
    }
}

