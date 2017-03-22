package org.usfirst.frc.team558.robot;


public class RobotMap {
	
	//Joysticks and Buttons
			//Joystick USB Ports
			public static int driveJoystickPort = 0;
			public static int operatorJoystickPort = 1;
			
			
			//Driver Joystick Axes and Buttons
			public static int quickTurnButton = 2;
			
			public static int turnAxis = 0;
			public static int throttleForwardAxis = 3;
			public static int throttleReverseAxis = 2;
			
			
			//Operator Joystick Axes and Buttons
			public static int breakOnButton = 6;
			public static int breakOffButton = 5;
			public static int placeGearButton = 1;
			
			public static int gearIntakeAxis = 1;
			
			
		//Speed Controllers
			
			//Drive TalonSRXs
			public static int leftDriveMaster = 1;
			public static int leftDriveSlave1 = 16;
			public static int leftDriveSlave2 = 2;
				
			public static int rightDriveMaster = 13;
			public static int rightDriveSlave1 = 14;
			public static int rightDriveSlave2 = 12;
			
						
			//Gear Intake TalonSRXs
			public static int gearIntakeChannel1 = 10;
			public static int gearIntakeChannel2= 11;
			
			
			
		//Solenoids
			
			//Climber Brake
			public static int breakSolenoidChannel1 = 0;
			public static int breakSolenoidChannel2 = 1;
			
			//Gear Placer
			public static int gearPlacerSolenoidChannel1 = 2;
			public static int gearPlacerSolenoidChannel2 = 3;
			
			
			
			
		// Digital Inputs
			
			//IR Gear Sensor
			public static int gearSensorChannel = 0;
			
			
			
		//Proportional Gains
			public static double turn90Gain = .0114;
			public static double turn59Gain = .0141;
			
			public static double drive72Gain = .018; //good for 60" and 48"
			public static double drive15Gain = .023;
			
	
}
