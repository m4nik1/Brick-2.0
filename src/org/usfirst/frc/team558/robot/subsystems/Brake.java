package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.*;

public class Brake extends Subsystem {

	public DoubleSolenoid brake = new DoubleSolenoid(RobotMap.breakSolenoidChannel1,RobotMap.breakSolenoidChannel2); 

	
    public void initDefaultCommand() {
    
    }
    
    public void BrakeOn(){
    	brake.set(DoubleSolenoid.Value.kForward);
    }
    
    public void BrakeOff(){
    	brake.set(DoubleSolenoid.Value.kReverse);
    }
}

