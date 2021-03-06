package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class InGear extends Command {

    public InGear(double atime) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.gearIntakeMotors);
        requires(Robot.gearIntakeSol);
        
        setTimeout(atime);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.gearIntakeMotors.SetGearIntake(.65);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.gearIntakeMotors.GearIntakeStop();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
