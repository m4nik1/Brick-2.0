
package org.usfirst.frc.team558.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team558.robot.autocommands.*;
import org.usfirst.frc.team558.robot.subsystems.*;

public class Robot extends IterativeRobot {

	public static DriveTrain driveTrain = new DriveTrain();
	public static GearIntakeSol gearIntakeSol = new GearIntakeSol();
	public static GearIntakeMotor gearIntakeMotors = new GearIntakeMotor();
	public static Brake brake = new Brake();
	
	public static PixyCam pixyCam = new PixyCam();
	public static Gyro gyro = new Gyro();
	public static GearSensor irSensor = new GearSensor();
	
	public static Compressor pcm = new Compressor();
	public static Relay compressor = new Relay(0);
	
	public static OI oi;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<Command>();
	
	
	@Override
	public void robotInit() {
		oi = new OI();
		CameraServer.getInstance().startAutomaticCapture();
		
		
		chooser.addDefault("Do Nothing", new DoNothing());
		//chooser.addObject("CrossBaselineCenter", new CrossBaseline()); // Uncomment these if GearIntake doesn't at all
		//chooser.addObject("CrossBaselineStraight", new CrossBaselineStraight()); // ****WARNING THIS IS LAST RESORT
		chooser.addObject("DoubleGearAuto", new DoubleGearAuto());
		chooser.addObject("Robot On Straight Drop Gear" , new DriveDropGear());
		chooser.addObject("Robot On Right Drop Gear" , new DriveAndDropGearRightSide());
		chooser.addObject("Robot On Left Drop Gear" , new DriveAndDropGearLeftSide());
		chooser.addObject("PIXY Robot On Straight Drop Gear" , new DriveDropGearPixy());
		chooser.addObject("PIXY Robot On Right Drop Gear" , new DriveAndDropGearRightSidePixy());
		chooser.addObject("PIXY Robot On Left Drop Gear" , new DriveAndDropGearLeftSidePixy());
		
		
		SmartDashboard.putData("Auto mode", chooser);
	}


	@Override
	public void disabledInit() {
		
		Robot.oi.rumble(0, 0);

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
		autonomousCommand = (Command) chooser.getSelected();
		//autonomousCommand = new TurnWithGyro(60, .5, RobotMap.turn60Gain); //For Tuning Only
		Robot.driveTrain.resetEncoders();
		Robot.gyro.ResetGyro();
		Robot.driveTrain.EnableBrakeMode();
		Robot.brake.BrakeOff();
		
				if (autonomousCommand != null)
				autonomousCommand.start();
	}

	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		Robot.pixyCam.read();
		SmartDashboard.putNumber("Gyro Value", Robot.gyro.GetAngle());
		SmartDashboard.putNumber("Left Encoder", Robot.driveTrain.GetLeftEncoder());
		SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.GetRightEncoder());
		SmartDashboard.putNumber("Average Encoder", Robot.driveTrain.GetAverageEncoderDistance());
		SmartDashboard.putNumber("Pixy Offset" , Robot.pixyCam.getLastOffset());
	}

	@Override
	public void teleopInit() {
		
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		Robot.driveTrain.SetRampRate();
		Robot.gyro.ResetGyro();
		Robot.driveTrain.resetEncoders();
		Robot.driveTrain.DisableBrakeMode();
		Robot.brake.BrakeOff();
		
	}

	
	@Override
	public void teleopPeriodic() {
	Scheduler.getInstance().run();
		
		if (!pcm.getPressureSwitchValue()){
			compressor.set(Value.kForward);
		}
		else {
			compressor.set(Value.kOff);
		}
		Robot.pixyCam.read();
		SmartDashboard.putNumber("Left Encoder", Robot.driveTrain.GetLeftEncoder());
		SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.GetRightEncoder());
		SmartDashboard.putNumber("Average Encoder", Robot.driveTrain.GetAverageEncoderDistance());
		SmartDashboard.putNumber("Pixy Offset" , Robot.pixyCam.getLastOffset());
		SmartDashboard.putNumber("Gyro Value", Robot.gyro.GetAngle());
		SmartDashboard.putBoolean("High Sensor" , Robot.irSensor.ReadHighSensor());
		SmartDashboard.putBoolean("Low Sensor" , Robot.irSensor.ReadLowSensor());
		
	}

	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
