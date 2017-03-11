
package org.usfirst.frc.team558.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team558.robot.subsystems.*;

public class Robot extends IterativeRobot {

	public static DriveTrain driveTrain = new DriveTrain();
	public static PixyCam pixyCam = new PixyCam();
	public static GearIntake gearIntake = new GearIntake();
	public static SpeedGearIntake speedGearIntake = new SpeedGearIntake();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	
	@Override
	public void robotInit() {
		oi = new OI();
	}


	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		
		
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
