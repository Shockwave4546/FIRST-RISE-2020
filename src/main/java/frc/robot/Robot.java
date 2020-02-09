/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.RobotMap;
import frc.robot.subsystems.motors.talonMotor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.*;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Encoder;
//import frc.robot.commands.moveMotor;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  public static OI oi;
  // ENCODER DETAILS: 134.4 ppr
  public Encoder encoder;
  public double encoderValue;
  public static talonMotor motor1;
  public static talonMotor motor2;
  public ShuffleboardTab tab;
  public NetworkTableEntry speed;

  public static talonMotor encoderMotor1;
  public static talonMotor encoderMotor2;

  public static List<Double> averageRPMArr = new ArrayList<Double>();
  public static double averageRPM = 0;
  public static double RPM;
  public static double total;
  public static int i;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    oi = new OI();

    encoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    //encoder.setDistancePerPulse(360/2048);
    encoder.setMinRate(1);
    motor1 = new talonMotor(0);
    motor2 = new talonMotor(1);
    tab = Shuffleboard.getTab("Smartdashboard");
    speed = tab.add("Rotate Speed", 0).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", -1, "max", 1)).getEntry();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();

    RPM = ((encoder.getRate()/2048)*-60);
    averageRPMArr.add(RPM);
    total = total + averageRPMArr.get(i);
    averageRPM = (total / averageRPMArr.size());
    SmartDashboard.putNumber("RPM", averageRPM);
    if(i < 100){
      i++;
    }
    else{
      i = 0;
      averageRPMArr.clear();
      total = 0;
    }
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    motor1.rotateMotor(speed.getDouble(0.0));
    motor2.rotateMotor(speed.getDouble(0.0));

    /*
    //encoderValue = encoderMotor.sEncoder.getDistance();
    //System.out.println(encoderValue);
    // TO GET VALUE, DIVIDE ANGLE WANTED BY 2.68
    if(encoderValue < 0.175){ //NOTE: DIVIDE CALCULATED VALUE BY 4 TO GET PROPER VALUE
      System.out.println("forward");
      motor1.rotateMotor(-0.3);
      motor2.rotateMotor(-0.3);
    }
    else{
      System.out.println("stop");
      motor1.stopMotor();
      motor1.stopMotor();
    }
    */
  }
  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
