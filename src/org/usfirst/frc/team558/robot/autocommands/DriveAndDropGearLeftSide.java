package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;
import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;



public class DriveAndDropGearLeftSide extends CommandGroup {

    public DriveAndDropGearLeftSide() {

    	requires(Robot.driveTrain);
    	requires(Robot.gearIntakeSol);
    	requires(Robot.gearIntakeMotors);

    	addSequential(new DriveWithEncoder(-75.4, .6, 3, RobotMap.drive72Gain));
    	addSequential(new TurnWithGyro(59, .6, RobotMap.turn59Gain));
    	addSequential(new DriveWithEncoder(-58, .6, 3, RobotMap.drive72Gain)); //** past manik says you should change the distance value
    	addParallel(new DropGear(2)); // past manik says to ask Alan if we need this parallel code
        addSequential(new DriveWithEncoder(15, .6, 3, RobotMap.drive15Gain));
        addSequential(new ResetGearIntake(2));
        addSequential(new TurnWithGyro(-59, .6, RobotMap.turn59Gain));
        addSequential(new DriveWithEncoder(-30, .6, 3, RobotMap.drive15Gain));
     
    }
}
