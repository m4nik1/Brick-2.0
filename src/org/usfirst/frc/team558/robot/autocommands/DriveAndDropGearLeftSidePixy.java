package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;
import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;



public class DriveAndDropGearLeftSidePixy extends CommandGroup {

    public DriveAndDropGearLeftSidePixy() {

    	requires(Robot.driveTrain);
    	requires(Robot.gearIntakeMotors);
    	requires(Robot.gearIntakeSol);
    	requires(Robot.pixyCam);

    	addSequential(new DriveWithEncoder(85, .5, 2, RobotMap.drive85Gain));
    	addSequential(new TurnWithGyro(60, .5, RobotMap.turn60Gain));
    	addSequential(new DriveWithPixyAndEncoder(75, .5, 2, RobotMap.drive71Gain));
    	addSequential(new DropGear(.5));
        addSequential(new DriveWithEncoder(-15, .5, 2, RobotMap.drive71Gain));
        addSequential(new ResetGearIntake(.5));
        addSequential(new TurnWithGyro(-60, .5, RobotMap.turn60Gain));
        addSequential(new DriveWithEncoder(52, .6, 2, RobotMap.drive71Gain));     	
    	
     
    }
}
