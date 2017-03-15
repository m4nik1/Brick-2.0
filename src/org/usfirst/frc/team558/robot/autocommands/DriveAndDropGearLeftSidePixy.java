package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;
import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;



public class DriveAndDropGearLeftSidePixy extends CommandGroup {

    public DriveAndDropGearLeftSidePixy() {

    	requires(Robot.driveTrain);
    	requires(Robot.gearIntakeMotors);
    	requires(Robot.gearIntakeSol);

    	addSequential(new DriveWithEncoder(-79.4, .6, 5, RobotMap.drive72Gain));
    	addSequential(new TurnWithGyro(59, .6, RobotMap.turn59Gain));
    	addSequential(new DriveWithPixyAndEncoder(-48, .6, 5, RobotMap.drive72Gain));
    	addParallel(new DropGear(2)); 
        addSequential(new DriveWithEncoder(15, .6, 3, RobotMap.drive15Gain));
        addSequential(new ResetGearIntake(2));
        addSequential(new TurnWithGyro(-59, .6, RobotMap.turn59Gain));
        addSequential(new DriveWithEncoder(-30, .6, 5, RobotMap.drive15Gain));     	
    	
     
    }
}
