package org.usfirst.frc.team558.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//Joysticks and Buttons
			//Joystick USB Ports
			public static int driveJoystickPort = 0;
			//public static int driveJoystick2Port = 1;
			public static int operatorJoystickPort = 1;
			
			
			//Driver Joystick Axes and Buttons
			public static int quickTurnButton = 2;
			public static int breakOnButton = 3;
			public static int breakOffButton = 4;
			
			public static int turnAxis = 0;
			public static int throttleForwardAxis = 3;
			public static int throttleReverseAxis = 2;
			
			
			//Operator Joystick Axes and Buttons
			public static int shooterOnButton = 7;
			public static int shooterOffButton = 8;
			public static int upDownGearButton = 4;
			public static int fuelIntakeOnButton = 2;
			public static int fuelIntakeReverseButton = 1;
			
			
			public static int feederAxis = 1;
			public static int gearIntakeAxis = 3;
			
			
		//Speed Controllers
			
			//Drive TalonSRXs
			public static int leftDriveMaster = 1;
			public static int leftDriveSlave1 = 16;
			public static int leftDriveSlave2 = 2;
				
			public static int rightDriveMaster = 13;
			public static int rightDriveSlave1 = 14;
			public static int rightDriveSlave2 = 12;
			
			
			//Shooter TalonSRXs
			public static int shooterMaster = 5;
			public static int shooterSlave1 = 6;
			//public static int shooterSlave2 = 7;
			
			//Shooter Target Speed
			public static int targetSpeed;
			
			//Feeder, Gear Intake, and Fuel Intake TalonSRXs
			public static int gearIntakeChannel1 = 10;
			public static int gearIntakeChannel2= 11;
			public static int feederChannel = 4;
			public static int fuelIntakeMaster = 15;
			public static int fuelIntakeSlave = 3;

			
			
		//Solenoids
			
			//Climber Brake
			public static int breakSolenoidChannel1 = 0;
			public static int breakSolenoidChannel2 = 1;
			
			//Gear Intake
			public static int gearIntakeSolenoidChannel1 = 2;
			public static int gearIntakeSolenoidChannel2 = 3;
			
			//Fuel Intake
			public static int fuelIntakeSolenoidChannel1 = 4;
			public static int fuelIntakeSolenoidChannel2 = 5;
					
			
			
		//Proportional Gains
			public static double turn90Gain = .0114;
			public static double turn59Gain = .0141;
			
			public static double drive72Gain = .018; //good for 60" and 48"
			public static double drive15Gain = .023;
			
	
}
