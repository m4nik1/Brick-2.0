package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearIntakeUp extends Command {

    public GearIntakeUp(double atime) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.actuateGear);
        
        setTimeout(atime);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.actuateGear.GearSolUp();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
