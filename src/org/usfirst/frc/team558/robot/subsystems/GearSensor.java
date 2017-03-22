package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

public class GearSensor extends Subsystem {

    DigitalInput irSensor = new DigitalInput(0);

    public boolean IrRead(){
    	return irSensor.get();
    }
    
    
    
    public void initDefaultCommand() {
        
    	
    }
}

