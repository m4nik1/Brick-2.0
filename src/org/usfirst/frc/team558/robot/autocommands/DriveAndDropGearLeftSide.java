package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;
import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;



public class DriveAndDropGearLeftSide extends CommandGroup {

    public DriveAndDropGearLeftSide() {

    	requires(Robot.driveTrain);
    	requires(Robot.gearIntake);
    	requires(Robot.actuateGear);

    	addSequential(new DriveWithEncoder(-75.4, .6, 3, RobotMap.drive72Gain));
    	addSequential(new TurnWithGyro(59, .6, RobotMap.turn59Gain));
    	addSequential(new DriveWithEncoder(-58, .6, 3, RobotMap.drive72Gain));
    	addParallel(new DropGear(2)); 
        addSequential(new DropIntake(2)); 
        addSequential(new DriveWithEncoder(15, .6, 3, RobotMap.drive15Gain));
        addSequential(new GearIntakeUp(1));
        addSequential(new TurnWithGyro(-59, .6, RobotMap.turn59Gain));
        addSequential(new DriveWithEncoder(-30, .6, 3, RobotMap.drive15Gain));     	
    	

     
    }
}
