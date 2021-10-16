// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
// import frc.robot.commands.pivotIntakeControl;
import frc.robot.commands.positionControl;
import frc.robot.commands.rotationControl;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;

import edu.wpi.first.cameraserver.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI oi;
  public ShuffleboardTab tab = Shuffleboard.getTab("Match Tab");

  Talon mFrontLeft = new Talon(RobotMap.mDriveLeftOnePort);
  Talon mFrontRight = new Talon(RobotMap.mDriveRightOnePort);
  Talon mBackLeft = new Talon(RobotMap.mDriveLeftTwoPort);
  Talon mBackRight = new Talon(RobotMap.mDriveRightTwoPort);

  SpeedControllerGroup m_left = new SpeedControllerGroup(mFrontLeft, mBackLeft);
  SpeedControllerGroup m_right = new SpeedControllerGroup(mFrontRight, mBackRight);
  DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);

  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  private double leftDriveValue;
  private double rightDriveValue;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    oi = new OI();
    CameraServer.getInstance().startAutomaticCapture();
    m_right.setInverted(true);

    SmartDashboard.putNumber("Current Shooter Servo Angle", 0.01);
    SmartDashboard.putNumber("Flywheel Speed", 0.5);
    // Robot.oi.smShooter.set(-SmartDashboard.getNumber("Current Shooter Servo Angle", 0));
    // Robot.oi.smShooterTwo.set(SmartDashboard.getNumber("Current Shooter Servo Angle", 0));

    SmartDashboard.putData("Position - Wheel of Fortune", new positionControl());

    SmartDashboard.putData("Rotation - Wheel of Fortune", new rotationControl());

    SmartDashboard.putNumber("Left Forward Constant", 0.85);
    SmartDashboard.putNumber("Right Forward Constant", 0.8);

    SmartDashboard.putNumber("Left Backward Constant", 0.8);
    SmartDashboard.putNumber("Right Backward Constant", 0.82);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    // m_autoSelected = m_chooser.getSelected();
    // // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    // System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    // switch (m_autoSelected) {
    //   case kCustomAuto:
    //     // Put custom auto code here
    //     break;
    //   case kDefaultAuto:
    //   default:
    //     // Put default auto code here
    //     break;
    // }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    // SmartDashboard.putNumber("Current Shooter Servo Angle", 0.01);
    // SmartDashboard.putNumber("Flywheel Speed", 0.5);
    // // Robot.oi.smShooter.set(-SmartDashboard.getNumber("Current Shooter Servo Angle", 0));
    // // Robot.oi.smShooterTwo.set(SmartDashboard.getNumber("Current Shooter Servo Angle", 0));

    // SmartDashboard.putData("Position - Wheel of Fortune", new positionControl());

    // SmartDashboard.putData("Rotation - Wheel of Fortune", new rotationControl());

    // SmartDashboard.putNumber("Left Forward Constant", 0.85);
    // SmartDashboard.putNumber("Right Forward Constant", 0.8);

    // SmartDashboard.putNumber("Left Backward Constant", 0.8);
    // SmartDashboard.putNumber("Right Backward Constant", 0.82);
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    //oi.Drive(0.0, 0.0);

    SmartDashboard.getNumber("Left Forward Constant", 1);
    SmartDashboard.getNumber("Right Forward Constant", 0.95);

    SmartDashboard.getNumber("Left Backward Constant", 1);
    SmartDashboard.getNumber("Right Backward Constant", 0.95);

    if (Robot.oi.getDriverLeftY() > 0) {
      leftDriveValue = (Robot.oi.getDriverLeftY() * SmartDashboard.getNumber("Left Forward Constant", 1));
    } else if (Robot.oi.getDriverLeftY() < 0) {
      leftDriveValue = (Robot.oi.getDriverLeftY() * SmartDashboard.getNumber("Left Backward Constant", 1));
    } else {
      leftDriveValue = 0;
    }

    if (Robot.oi.getDriverRightY() > 0) {
      rightDriveValue = (Robot.oi.getDriverRightY() * SmartDashboard.getNumber("Right Backward Constant", 1));
    } else if (Robot.oi.getDriverRightY() < 0) {
      rightDriveValue = (Robot.oi.getDriverRightY() * SmartDashboard.getNumber("Right Forward Constant", 1));
    } else {
      rightDriveValue = 0;
    }

    m_drive.tankDrive(-leftDriveValue, -rightDriveValue);
    
    // int direction = Robot.oi.operatorController.getPOV(0);

    // if (direction == 0) { // DPAD UP button is pressed
    //   if ((SmartDashboard.getNumber("Current Shooter Servo Angle", 0.5) + 0.01) <= 0.3) {
    //     SmartDashboard.putNumber("Current Shooter Servo Angle", SmartDashboard.getNumber("Current Shooter Servo Angle", 0) + 0.01);
    //   }
    // } else if (direction == 180) { // DPAD DOWN button is pressed
    //   if ((SmartDashboard.getNumber("Current Shooter Servo Angle", 0.5) - 0.01) >= 0.01) {
    //     SmartDashboard.putNumber("Current Shooter Servo Angle", SmartDashboard.getNumber("Current Shooter Servo Angle", 0) - 0.01);
    //   }
    // }

    Robot.oi.smShooter.set(SmartDashboard.getNumber("Current Shooter Servo Angle", 0));
    Robot.oi.smShooterTwo.set(-(SmartDashboard.getNumber("Current Shooter Servo Angle", 0)));
    
    final ColorMatch m_colorMatcher = new ColorMatch();
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);

    Color detectedColor = Robot.oi.m_colorSensor.getColor();
    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
        colorString = "Red";
    } else if (match.color == kGreenTarget) {
        colorString = "Green";
    } else if (match.color == kYellowTarget) {
        colorString = "Yellow";
    } else {
        colorString = "Unknown";
    }

    SmartDashboard.putString("Current Color Sensor Color", colorString);

    SmartDashboard.putNumber("Red", Robot.oi.m_colorSensor.getRed());
    SmartDashboard.putNumber("Green", Robot.oi.m_colorSensor.getGreen());
    SmartDashboard.putNumber("Blue", Robot.oi.m_colorSensor.getBlue());
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
