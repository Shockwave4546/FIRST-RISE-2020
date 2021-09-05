/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import java.util.ArrayList;
import com.revrobotics.ColorMatch;

/**
 * An example command that uses an example subsystem.
 */
public class rotationControl extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

  private ArrayList<String> colorSequence = new ArrayList<String>(4);

  private String startColor;
  private int sequenceIndex;

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch m_colorMatcher = new ColorMatch();
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  public rotationControl() {
  }

  private void sequencePlusOne() {
    if (sequenceIndex == 3) {
        sequenceIndex = 0;
    } else {
        sequenceIndex++;
    }
}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putNumber("Rotation Count", 0);
    colorSequence.add("Blue");
    colorSequence.add("Yellow");
    colorSequence.add("Red");
    colorSequence.add("Green");

    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);

    Color detectedColor = m_colorSensor.getColor();
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
    startColor = colorString;
    if (startColor == "Blue") {
        sequenceIndex = 0;
    } else if (startColor == "Yellow") {
        sequenceIndex = 1;
    } else if (startColor == "Red") {
        sequenceIndex = 2;
    } else if (startColor == "Green") {
        sequenceIndex = 3;
    }

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    

    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);

    Color detectedColor = m_colorSensor.getColor();
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

    //SmartDashboard.putNumber("Red", detectedColor.red);
    //SmartDashboard.putNumber("Green", detectedColor.green);
    //SmartDashboard.putNumber("Blue", detectedColor.blue);
    //SmartDashboard.putNumber("Confidence", match.confidence);
    //SmartDashboard.putString("Detected Color", colorString);
    String currentSequence = colorSequence.get(sequenceIndex);
    if (colorString == currentSequence){
      sequencePlusOne();
      SmartDashboard.putNumber("Rotation Count", SmartDashboard.getNumber("Rotation Count", 0)+1);
    }


    if (SmartDashboard.getNumber("Rotation Count", 0) < 24) {
      Robot.oi.mWheelOfFortune.rotateMotor(1);
    } else {
      Robot.oi.mWheelOfFortune.stopMotor();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (SmartDashboard.getNumber("Rotation Count", 0) >= 24) {
      return true;
    } else {
      return false;
    }

  }

}
