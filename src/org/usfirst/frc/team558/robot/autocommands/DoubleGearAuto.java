package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class DoubleGearAuto extends CommandGroup {

    public DoubleGearAuto() {
    	addSequential(new DriveWithEncoder(85, .5, 5, RobotMap.drive85Gain));
        addSequential(new DropGear(.5));  
        addSequential(new DriveWithEncoder(-25, .5, 2, RobotMap.drive71Gain));
        addSequential(new ResetGearIntake(.5));
        addSequential(new TurnWithGyro(160, .6, RobotMap.turn90Gain));
        addParallel(new DriveWithEncoder(57, 1, 5, .0090));
        
    }
}
