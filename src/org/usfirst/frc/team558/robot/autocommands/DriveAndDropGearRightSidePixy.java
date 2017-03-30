package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;
import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class DriveAndDropGearRightSidePixy extends CommandGroup {

    public DriveAndDropGearRightSidePixy() {

    	requires(Robot.gearIntakeMotors);
    	requires(Robot.driveTrain);
    	requires(Robot.gearIntakeSol);
    	requires(Robot.pixyCam);
    	
    	addSequential(new DriveWithEncoder(85, .6, 2, RobotMap.drive85Gain));
    	addSequential(new TurnWithGyro(-60, .5, RobotMap.turn60Gain));
    	addSequential(new DriveWithPixyAndEncoder(75, .6, 2, RobotMap.drive71Gain));
    	addSequential(new DropGear(.5));
        addSequential(new DriveWithEncoder(-15, .5, 2, RobotMap.drive71Gain));
        addSequential(new ResetGearIntake(.5));
        addSequential(new TurnWithGyro(60, .5, RobotMap.turn60Gain));
        addSequential(new DriveWithEncoder(30, .6, 2, RobotMap.drive71Gain));    	
    	

        
    }
}
