package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team558.robot.RobotMap;
import org.usfirst.frc.team558.robot.commands.ElmCityDrive;

import com.ctre.*;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	CANTalon leftDriveMaster = new CANTalon(RobotMap.leftDriveMaster);
	CANTalon leftDriveSlave1 = new CANTalon(RobotMap.leftDriveSlave1);
	CANTalon leftDriveSlave2 = new CANTalon(RobotMap.leftDriveSlave2);
	CANTalon rightDriveMaster = new CANTalon(RobotMap.rightDriveMaster);
	CANTalon rightDriveSlave1 = new CANTalon(RobotMap.rightDriveSlave1);
	CANTalon rightDriveSlave2 = new CANTalon(RobotMap.rightDriveSlave2);

	
	public DriveTrain(){
		
		// DriveTrain Master
		this.leftDriveMaster.changeControlMode(TalonControlMode.PercentVbus);
		this.rightDriveMaster.changeControlMode(TalonControlMode.PercentVbus);
		
		// DriveTrain Encoders
		this.leftDriveMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		this.leftDriveMaster.reverseSensor(false);
		this.rightDriveMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		this.rightDriveMaster.reverseSensor(true);
		this.leftDriveMaster.configEncoderCodesPerRev((int)(128/1.1616));
		this.rightDriveMaster.configEncoderCodesPerRev((int)(128/1.1616));
		
		// Slave DriveTrain
		this.leftDriveSlave1.changeControlMode(TalonControlMode.Follower);
		this.leftDriveSlave1.set(this.leftDriveMaster.getDeviceID());
		this.leftDriveSlave2.changeControlMode(TalonControlMode.Follower);
		this.leftDriveSlave2.set(this.leftDriveMaster.getDeviceID());
		
		this.rightDriveSlave1.changeControlMode(TalonControlMode.Follower);
		this.rightDriveSlave1.set(this.rightDriveMaster.getDeviceID());
		this.rightDriveSlave2.changeControlMode(TalonControlMode.Follower);
		this.rightDriveSlave2.set(this.rightDriveMaster.getDeviceID());
		
	}
	
	public void drive(double leftPower, double rightPower){
		this.leftDriveMaster.set(-leftPower);
		this.rightDriveMaster.set(rightPower);
	}
   
    public void initDefaultCommand() {
       setDefaultCommand(new ElmCityDrive());
    }
    
    public double GetLeftEncoder(){
    	return this.leftDriveMaster.getPosition();
    }
    
    public double GetRightEncoder(){
    	return this.rightDriveMaster.getPosition();
    }
    
    public double GetAverageEncoderDistance(){
    	return ((this.leftDriveMaster.getPosition() + this.rightDriveMaster.getPosition())/2);
    }
    
    public void resetEncoders() {
    	this.leftDriveMaster.setPosition(0.0);
    	this.rightDriveMaster.setPosition(0.0);
    }
    
    public double GetLeftDrive(){
    	
    	return this.leftDriveMaster.get();
    	
    }
    
    public double GetRightDrive(){
    	
    	return this.rightDriveMaster.get();
    	
    }
    
    public void SetRampRate(){
    	this.leftDriveMaster.setVoltageRampRate(60);
		this.rightDriveMaster.setVoltageRampRate(60);
		
    }
}

