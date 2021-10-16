/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * An example command that uses an example subsystem.
 */

public class pivotIntakeControl extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    public boolean itisFinished = false;
    public DigitalInput hLimit = new DigitalInput(RobotMap.IsIntakeHorizontalPort);
    public DigitalInput vLimit = new DigitalInput(RobotMap.IsIntakeVerticalPort);
    boolean hLimitStatus, vLimitStatus;
    String startingPosition;

    public pivotIntakeControl() {
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        hLimitStatus = !(hLimit.get());
        vLimitStatus = !(vLimit.get());
        SmartDashboard.putBoolean("Horizontal Limit", hLimitStatus);
        SmartDashboard.putBoolean("Vertical Limit", vLimitStatus);

        if ((hLimitStatus == false) & (vLimitStatus == false)) {
            startingPosition = "Middle";
        }

        if (hLimitStatus == true) {
            startingPosition = "Horizontal";
        }

        if (vLimitStatus == true) {
            startingPosition = "Vertical";
        }
        System.out.println(hLimitStatus);
        System.out.println(vLimitStatus);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        hLimitStatus = !(hLimit.get());
        vLimitStatus = !(vLimit.get());
        SmartDashboard.putBoolean("Horizontal Limit", hLimitStatus);
        SmartDashboard.putBoolean("Vertical Limit", vLimitStatus);

        if (startingPosition == "Middle") {
            Robot.oi.mIntakePivot.rotateMotor(0.9);
            if ((hLimitStatus == true) || (vLimitStatus == true)) {
                Robot.oi.mIntakePivot.stopMotor();
                itisFinished = true;
            }
        }

        if (startingPosition == "Horizontal") {
            Robot.oi.mIntakePivot.rotateMotor(-0.9);
            if (vLimitStatus == true) {
                Robot.oi.mIntakePivot.stopMotor();
                itisFinished = true;
            }
        }

        if (startingPosition == "Vertical") {
            Robot.oi.mIntakePivot.rotateMotor(0.9);
            if (hLimitStatus == true) {
                Robot.oi.mIntakePivot.stopMotor();
                itisFinished = true;
            }
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        itisFinished = false;
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (itisFinished == true) {
            return true;
        } else {
            return false;
        }

    }
}