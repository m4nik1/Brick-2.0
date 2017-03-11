package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;
import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;




public class DriveDropGearPixy extends CommandGroup {

    public DriveDropGearPixy() {
    	requires(Robot.driveTrain);
    	requires(Robot.gearIntake);
    	requires(Robot.actuateGear);

        addSequential(new DriveWithPixyAndEncoder(-72, .6, 5, RobotMap.drive72Gain));
        addParallel(new DropGear(2)); 
        addSequential(new DropIntake(2)); 
        addSequential(new DriveWithEncoder(15, .6, 2, RobotMap.drive15Gain));
        addSequential(new GearIntakeUp(2));
        addSequential(new TurnWithGyro(90, .6, RobotMap.turn90Gain));
        addSequential(new DriveWithEncoder(60, .6, 5, RobotMap.drive72Gain));
        addSequential(new TurnWithGyro(90, .6, RobotMap.turn90Gain));
        addSequential(new DriveWithEncoder(60, .6, 5, RobotMap.drive72Gain));
        
        
    }
}
