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
//import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


import edu.wpi.first.cameraserver.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  //private Command m_autonomousCommand;
  public static OI oi;
  public ShuffleboardTab tab = Shuffleboard.getTab("Match Tab");

  Talon mFrontLeft = new Talon(RobotMap.mDriveLeftOnePort);
  Talon mFrontRight = new Talon(RobotMap.mDriveRightOnePort);
  Talon mBackLeft = new Talon(RobotMap.mDriveLeftTwoPort);
  Talon mBackRight = new Talon(RobotMap.mDriveRightTwoPort);

  SpeedControllerGroup m_left = new SpeedControllerGroup(mFrontLeft, mBackLeft);
  SpeedControllerGroup m_right = new SpeedControllerGroup(mFrontRight, mBackRight);
  //visionDrivePID = new PID(1, 0, 0, .02, .1);
  DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);

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
    SmartDashboard.putNumber("Current Shooter Servo Angle", 0);
    Robot.oi.smShooter.set(-SmartDashboard.getNumber("Current Shooter Servo Angle", 0.5));
    Robot.oi.smShooterTwo.set((SmartDashboard.getNumber("Current Shooter Servo Angle", 0.5)));
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    //oi.Drive(0.0, 0.0);

    m_drive.tankDrive(-Robot.oi.getDriverLeftY()*0.6, -Robot.oi.getDriverRightY()*0.6);
    
    int direction = Robot.oi.operatorController.getPOV(0);

    if (direction == 0) { // DPAD UP button is pressed
      SmartDashboard.putNumber("Current Shooter Servo Angle", SmartDashboard.getNumber("Current Shooter Servo Angle", 0.5) + 0.01);
    } else if (direction == 180) { // DPAD DOWN button is pressed
      SmartDashboard.putNumber("Current Shooter Servo Angle", SmartDashboard.getNumber("Current Shooter Servo Angle", 0.5) - 0.01);
    }

    Robot.oi.smShooter.set(SmartDashboard.getNumber("Current Shooter Servo Angle", 0.5));
    Robot.oi.smShooterTwo.set(-(SmartDashboard.getNumber("Current Shooter Servo Angle", 0.5)));
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
