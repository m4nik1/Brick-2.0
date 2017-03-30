package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team558.robot.RobotMap;
import org.usfirst.frc.team558.robot.commands.DetectGearSensor;

import edu.wpi.first.wpilibj.DigitalInput;

public class GearSensor extends Subsystem {

    DigitalInput gearSensor = new DigitalInput(RobotMap.gearSensorChannel);
    DigitalInput intakeSensor = new DigitalInput(RobotMap.gearIntakeSensorChannel);
    
    public boolean IrRead(){
    	return intakeSensor.get() || gearSensor.get();
    	
    	
    }
    
    
    
    public void initDefaultCommand() {
        setDefaultCommand(new DetectGearSensor());
    	
    }
}

