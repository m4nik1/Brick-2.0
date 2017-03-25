package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;
import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;




public class DriveDropGearPixy extends CommandGroup {

    public DriveDropGearPixy() {
    	requires(Robot.driveTrain);
    	requires(Robot.gearIntakeMotors);
    	requires(Robot.gearIntakeSol);
    	requires(Robot.pixyCam);

        addSequential(new DriveWithPixyAndEncoder(85, .5, 5, RobotMap.drive85Gain));
        addSequential(new DropGear(.5));  
        addSequential(new DriveWithEncoder(-25, .5, 2, RobotMap.drive71Gain));
        addSequential(new ResetGearIntake(.5));
        addSequential(new TurnWithGyro(90, .6, RobotMap.turn90Gain));
        addSequential(new DriveWithEncoder(60, .5, 3, RobotMap.drive85Gain));
        addSequential(new TurnWithGyro(90, .6, RobotMap.turn90Gain));
        addSequential(new DriveWithEncoder(80, .6, 3, RobotMap.drive85Gain));
        
        
    }
}
