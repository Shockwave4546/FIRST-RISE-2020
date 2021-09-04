// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.RobotMap;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.CommandScheduler;

import java.util.Map;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Servo;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  //private Command m_autonomousCommand;
  public static OI oi;
  //public NetworkTable visiontargettable;
  //double[] visiontargetpos;
  //double[] defaultValue = new double[0];
  // public Servo servo1;
  // public Servo servo2;
  public ShuffleboardTab tab = Shuffleboard.getTab("Test Tab");
  // public NetworkTableEntry servoangle;

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
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

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
    //visiontargettable = NetworkTableInstance.getDefault().getTable("chameleon-vision/USB Camera-B4.09.24.1");

    // servo1 = new Servo(4);
    // servo2 = new Servo(5);
    SmartDashboard.putNumber("Current Shooter Servo Angle", 0.5);
    Robot.oi.smShooter.setAngle(SmartDashboard.getNumber("Current Shooter Servo Angle", 0.5));
    Robot.oi.smShooterTwo.setAngle(-(SmartDashboard.getNumber("Current Shooter Servo Angle", 0.5)));
    
    //servoangle = tab.add("Rotation Angle", 1).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", 0, "max", 180)).getEntry();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    //visiontargettable = NetworkTableInstance.getDefault().getTable("chameleon-vision/USB Camera-B4.09.24.1");
    //double[] visiontargetpos = visiontargettable.getEntry("targetPose").getDoubleArray(defaultValue);
    //double targetwidth = visiontargettable.getEntry("targetBoundingWidth").getDouble(0.0);
    //double tarNumber = visiontargettable.getEntry("targetYaw").getDouble(0.0);
    //oi.Drive(tarNumber,((38*516.315789)/targetwidth));

    //double vertAngle = visiontargettable.getEntry("targetPitch").getDouble(0.0);
    //System.out.println((38*516.315789)/targetwidth);
    // System.out.println((vertAngle/180));
    //servo1.set((vertAngle/180));
    //oi.Drive(tarNumber,((38*516.315789)/targetwidth));
    //servo1.set(servoangle/180);

    oi.Drive(0.0, 0.0);
    
    int direction = Robot.oi.operatorController.getPOV(0);

    if (direction == 0) { // DPAD UP button is pressed
      SmartDashboard.putNumber("Current Shooter Servo Angle", SmartDashboard.getNumber("Current Shooter Servo Angle", 0.5) + 0.05);
    } else if (direction == 180) { // DPAD DOWN button is pressed
      SmartDashboard.putNumber("Current Shooter Servo Angle", SmartDashboard.getNumber("Current Shooter Servo Angle", 0.5) - 0.05);
    }

    Robot.oi.smShooter.setAngle(SmartDashboard.getNumber("Current Shooter Servo Angle", 0.5));
    Robot.oi.smShooterTwo.setAngle(-(SmartDashboard.getNumber("Current Shooter Servo Angle", 0.5)));
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
