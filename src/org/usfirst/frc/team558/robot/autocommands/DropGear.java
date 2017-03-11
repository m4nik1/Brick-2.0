package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class DropGear extends Command {

    public DropGear(double atime) {
        requires(Robot.gearIntake);
        
        setTimeout(atime);
    }


    protected void initialize() {
    }

    
    protected void execute() {
    	
    	Robot.gearIntake.PutGearIn(-1);
    	
    }

    
    protected boolean isFinished() {
        return isTimedOut();
    }

 
    protected void end() {
    	
    	Robot.gearIntake.GearIntakeStop();
    	
    }

    
    
    protected void interrupted() {
    }
}
