package org.usfirst.frc.team558.robot.subsystems;

import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.*;
import com.ctre.CANTalon.TalonControlMode;


public class SpeedGearIntake extends Subsystem {

    CANTalon intakeMotor1 = new CANTalon(RobotMap.gearIntakeChannel1);
    //CANTalon intakeMotor2 = new CANTalon(RobotMap.gearIntakeChannel2);
    
    public SpeedGearIntake(){
    	
    	intakeMotor1.changeControlMode(TalonControlMode.PercentVbus);
		//intakeMotor2.changeControlMode(TalonControlMode.PercentVbus);
    	
    }
    
    public void SetGearIntake(double speed){
    	
    	intakeMotor1.set(speed);
    	
    }
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

