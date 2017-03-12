package org.usfirst.frc.team558.robot.subsystems;

import org.usfirst.frc.team558.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;


public class GearIntakeMotor extends Subsystem {
	
	CANTalon intakeMotor1 = new CANTalon(RobotMap.gearIntakeChannel1);
    //CANTalon intakeMotor2 = new CANTalon(RobotMap.gearIntakeChannel2);
	
	public GearIntakeMotor(){
    	
    	intakeMotor1.changeControlMode(TalonControlMode.PercentVbus);
		//intakeMotor2.changeControlMode(TalonControlMode.PercentVbus);
    	
    }
    
    public void SetGearIntake(double speed){
    	
    	intakeMotor1.set(speed);
    	
    }
    
    public void GearIntakeStop(){
    	
    	intakeMotor1.set(0);
    	
    }
	

    public void initDefaultCommand() {
    	
    }
}

