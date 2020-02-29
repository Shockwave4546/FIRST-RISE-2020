package frc.robot;

import frc.robot.RobotMap;
import frc.robot.commands.*;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.motors.*;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	public victorSPXMotor mWheelOfFortune = new victorSPXMotor(RobotMap.mWheelOfFortunePort, RobotMap.mWheelOfFortunePos, RobotMap.mWheelOfFortuneNeg);
	private static final int LEFT_HORIZ_AXIS = 0;
	private static final int LEFT_VERT_AXIS = 1;
	private static final int RIGHT_HORIZ_AXIS = 4;
	private static final int RIGHT_VERT_AXIS = 5;
	private static final int LEFT_Z_AXIS = 3;
	private static final int RIGHT_Z_AXIS = 2;

	private static final double STICK_DEADZONE = RobotMap.joystickDeadzone;
	private static final double STICK_MAX = 1;

	// DriveTrain
	private DriveTrain driveTrain = new DriveTrain();

	// driver controller setup
	private Joystick driverController = new Joystick(RobotMap.cDriverPort);
	private Button driverButtonA = new JoystickButton(driverController, 1);
	private Button driverButtonB = new JoystickButton(driverController, 2);
	private Button driverButtonX = new JoystickButton(driverController, 3);
	private Button driverButtonY = new JoystickButton(driverController, 4);
	private Button driverButtonLeftBumper = new JoystickButton(driverController, 5);
	private Button driverButtonRightBumper = new JoystickButton(driverController, 6);
	private Button driverButtonBack = new JoystickButton(driverController, 7);
	private Button driverButtonStart = new JoystickButton(driverController, 8);
	private Button driverButtonLeftAxisPress = new JoystickButton(driverController, 9);
	private Button driverButtonRightAxisPress = new JoystickButton(driverController, 10);

	// operator controller setup
	private Joystick operatorController = new Joystick(RobotMap.cOperatorPort);
	private Button operatorButtonA = new JoystickButton(operatorController, 1);
	private Button operatorButtonB = new JoystickButton(operatorController, 2);
	private Button operatorButtonX = new JoystickButton(operatorController, 3);
	private Button operatorButtonY = new JoystickButton(operatorController, 4);
	private Button operatorButtonLeftBumper = new JoystickButton(operatorController, 5);
	private Button operatorButtonRightBumper = new JoystickButton(operatorController, 6);
	private Button operatorButtonBack = new JoystickButton(operatorController, 7);
	private Button operatorButtonStart = new JoystickButton(operatorController, 8);
	private Button operatorButtonLeftAxisPress = new JoystickButton(operatorController, 9);
	private Button operatorButtonRightAxisPress = new JoystickButton(operatorController, 10);

	public OI() {
		//// TRIGGERING COMMANDS WITH BUTTONS
		// Once you have a button, it's trivial to bind it to a button in one of
		// three ways:

		// button.whenPressed(new ExampleCommand());
		//    Start the command when the button is pressed and let it run the command
		//    until it is finished as determined by it's isFinished method.

		// button.whileHeld(new ExampleCommand());
		//    Run the command while the button is being held down and interrupt it once
		//    the button is released.

		// button.whenReleased(new ExampleCommand());
		//    Start the command when the button is released and let it run the command
		//    until it is finished as determined by it's isFinished method.

		// Add these commands here

		// Driver Buttons // ------------------------------------------ //
		driverButtonA.whenPressed(new pivotIntakeControl());
		//driverButtonA.whenReleased();
		//driverButtonA.whileHeld();

		//driverButtonB.whenPressed();
		//driverButtonB.whenReleased();
		//driverButtonB.whileHeld();

		//driverButtonX.whenPressed();
		//driverButtonX.whenReleased();
		//driverButtonX.whileHeld();

		//driverButtonY.whenPressed();
		//driverButtonY.whenReleased();
		//driverButtonY.whileHeld();

		//driverButtonLeftBumper.whenPressed();  // Used as vision drive toggle in Drive()
		//driverButtonLeftBumper.whenReleased();
		driverButtonLeftBumper.whileHeld(new lightToggle());

		//driverButtonRightBumper.whenPressed();
		//driverButtonRightBumper.whenReleased();
		//driverButtonRightBumper.whileHeld();

		//driverButtonBack.whenPressed();
		//driverButtonBack.whenReleased();
		//driverButtonBack.whileHeld();

		//driverButtonStart.whenPressed();
		//driverButtonStart.whenReleased();
		//driverButtonStart.whileHeld();

		//driverButtonLeftAxisPress.whenPressed();
		//driverButtonLeftAxisPress.whenReleased();
		//driverButtonLeftAxisPress.whileHeld();

		//driverButtonRightAxisPress.whenPressed();
		//driverButtonRightAxisPress.whenReleased();
		//driverButtonRightAxisPress.whileHeld();
		// Driver Buttons // ------------------------------------------ //
		


		// Operator Buttons // ------------------------------------------ //

		operatorButtonA.whenPressed(new shooterServoControl());
		//operatorButtonA.whenReleased();
		//operatorButtonA.whileHeld();

		//operatorButtonB.whenPressed();
		//operatorButtonB.whenReleased();
		//operatorButtonB.whileHeld();

		operatorButtonX.whenPressed(new positionControl());
		//operatorButtonX.whenReleased();
		//operatorButtonX.whileHeld();

		operatorButtonY.whenPressed(new rotationControl());
		//operatorButtonY.whenReleased();
		//operatorButtonY.whileHeld();

		//operatorButtonLeftBumper.whenPressed();
		//operatorButtonLeftBumper.whenReleased();
		//operatorButtonLeftBumper.whileHeld();

		//operatorButtonRightBumper.whenPressed();
		//operatorButtonRightBumper.whenReleased();
		//operatorButtonRightBumper.whileHeld();

		//operatorButtonBack.whenPressed();
		//operatorButtonBack.whenReleased();
		//operatorButtonBack.whileHeld();

		//operatorButtonStart.whenPressed();
		//operatorButtonStart.whenReleased();
		//operatorButtonStart.whileHeld();

		//operatorButtonLeftAxisPress.whenPressed();
		//operatorButtonLeftAxisPress.whenReleased();
		//operatorButtonLeftAxisPress.whileHeld();

		//operatorButtonRightAxisPress.whenPressed();
		//operatorButtonRightAxisPress.whenReleased();
		//operatorButtonRightAxisPress.whileHeld();
		// Operator Buttons // ------------------------------------------ //
	}


	// Utility functions //

	// Driver Axies // ------------------------------------------ //
	public double getDriverLeftY() {
		double leftY = driverController.getRawAxis(LEFT_VERT_AXIS);
		if(-STICK_DEADZONE <= leftY && leftY <= STICK_DEADZONE){
			return 0;
		}else{
			return -leftY;
		}
	}

	public double getDriverLeftX() {
		double leftX = driverController.getRawAxis(LEFT_HORIZ_AXIS);
		if(-STICK_DEADZONE <= leftX && leftX <= STICK_DEADZONE){
			return 0;
		}else{
			return leftX;
		}
	}

	public double getDriverRightY() {
		double rightY = driverController.getRawAxis(RIGHT_VERT_AXIS);
		if(-STICK_DEADZONE <= rightY && rightY <= STICK_DEADZONE){
            return 0;
        }else{
            return rightY;
        }
	}

	public double getDriverRightX() {
		double rightX = driverController.getRawAxis(RIGHT_HORIZ_AXIS);
		if(-STICK_DEADZONE <= rightX && rightX <= STICK_DEADZONE){
			return 0;
		}else{
			return -rightX;
		}
	}

	public double getDriverLeftTrigger() {
		return driverController.getRawAxis(LEFT_Z_AXIS);
	}

	public double getDriverRightTrigger() {
		return driverController.getRawAxis(RIGHT_Z_AXIS);
	}

	public double getDriverZ() {
		return driverController.getRawAxis(LEFT_Z_AXIS) - driverController.getRawAxis(RIGHT_Z_AXIS);
	}
	// Driver Axies // ------------------------------------------ //

	// Driver Rumble // ------------------------------------------ //
	public void rumbleDriver(double rumble) {
		driverController.setRumble(RumbleType.kLeftRumble, rumble);
		driverController.setRumble(RumbleType.kRightRumble, rumble);
	}

	public void rumbleDriverLeft(double rumble) {
		driverController.setRumble(RumbleType.kLeftRumble, rumble);
	}

	public void rumbleDriverRight(double rumble) {
		driverController.setRumble(RumbleType.kRightRumble, rumble);
	}
	// Driver Rumble // ------------------------------------------ //



	// Operator Axies // ------------------------------------------ //
	public double getOperatorLeftY() {
		double leftY = operatorController.getRawAxis(LEFT_VERT_AXIS);
		if(-STICK_DEADZONE <= leftY && leftY <= STICK_DEADZONE){
			return 0;
		}else{
			return leftY;
		}
	}

	public double getOperatorLeftX() {
		double leftX = operatorController.getRawAxis(LEFT_HORIZ_AXIS);
		if(-STICK_DEADZONE <= leftX && leftX <= STICK_DEADZONE){
			return 0;
		}else{
			return leftX;
		}
	}
	
	public double getOperatorRightY() {
		double rightY = operatorController.getRawAxis(RIGHT_VERT_AXIS);
		if(-STICK_DEADZONE <= rightY && rightY <= STICK_DEADZONE){
            return 0;
        }else{
            return rightY;
        }
	}

	public double getOperatorRightX() {
		double rightX = operatorController.getRawAxis(RIGHT_HORIZ_AXIS);
		if(-STICK_DEADZONE <= rightX && rightX <= STICK_DEADZONE){
			return 0;
		}else{
			return rightX;
		}
	}

	public double getOperatorLeftTrigger() {
		return operatorController.getRawAxis(LEFT_Z_AXIS);
	}

	public double getOperatorRightTrigger() {
		return operatorController.getRawAxis(RIGHT_Z_AXIS);
	}

	public double getOperatorZ() {
		return operatorController.getRawAxis(LEFT_Z_AXIS) - operatorController.getRawAxis(RIGHT_Z_AXIS);
	}
	// Operator Axies // ------------------------------------------ //

	// Operator Rumble // ------------------------------------------ //
	public void rumbleOperator(double rumble) {
		operatorController.setRumble(RumbleType.kLeftRumble, rumble);
		operatorController.setRumble(RumbleType.kRightRumble, rumble);
	}

	public void rumbleOperatorLeft(double rumble) {
		operatorController.setRumble(RumbleType.kLeftRumble, rumble);
	}

	public void rumbleOperatorRight(double rumble) {
		operatorController.setRumble(RumbleType.kRightRumble, rumble);
	}
	// Operator Rumble // ------------------------------------------ //



	// Miscellaneous utilities // ------------------------------------------ //
	public double applyDeadZone(double value) {
		if (Math.abs(value) < STICK_DEADZONE) {
			return 0.0;
		} else if (value > 0) {
			value = (value - STICK_DEADZONE) / (1 - STICK_DEADZONE);
		} else {
			value = (value + STICK_DEADZONE) / (1 - STICK_DEADZONE);
		}

		return value;
	}

	public double applyMaxValue(double value){
		if(value >= STICK_MAX){
			return 1.0;
		}
		else if (value <= -STICK_MAX){
			return -1.0;
		}
		else{
			return value;
		}
	}

	public double applySquare(double value) {
		double output;
		output = (value == 0.0 ? 0.0 : Math.pow(value, 3)/Math.abs(value));
		return (Math.abs(output) < 0.05 ? 0.0 : output);
	}
	// Miscellaneous utilities // ------------------------------------------ //



	// Drive train // ------------------------------------------ //
	public void Drive(double visionTarget, double distance){
		if(driverButtonLeftBumper.get() == false){
			driveTrain.userDrive(getDriverLeftY(), getDriverRightX());
		}else if(driverButtonLeftBumper.get() == true){
			driveTrain.visionDrive(visionTarget, distance);
		}
	}
	// Drive train // ------------------------------------------ //
}
