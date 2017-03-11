package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossBaselineStraight extends CommandGroup {

    public CrossBaselineStraight() {
        // Add Commands here:
        addSequential(new DriveWithEncoder(-90, .6, 5, RobotMap.drive72Gain));
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
