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
import frc.robot.subsystems.motors.*;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

/**
 * An example command that uses an example subsystem.
 */

public class pivotIntakeControl extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    public boolean itisFinished = false;
    private DigitalInput hLimit = new DigitalInput(RobotMap.IsIntakeHorizontalPort);
    private DigitalInput vLimit = new DigitalInput(RobotMap.IsIntakeVerticalPort);
    private int targetPosition = 2;
    boolean hLimitStatus, vLimitStatus;

    public pivotIntakeControl() {
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        hLimitStatus = hLimit.get();
        vLimitStatus = vLimit.get();
        SmartDashboard.putBoolean("Horizontal Limit", hLimitStatus);
        SmartDashboard.putBoolean("Vertical Limit", vLimitStatus);

        if ((hLimitStatus == false) & (vLimitStatus == false)) {
            Robot.oi.mIntakePivot.rotateCounterClockwise(1);
        }

        if (hLimitStatus == true) {
            Robot.oi.mIntakePivot.rotateCounterClockwise(1);
            Timer.delay(0.5);
        }

        if (vLimitStatus == true) {
            Robot.oi.mIntakePivot.rotateClockwise(0.1);
            Timer.delay(0.5);
        }
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        hLimitStatus = hLimit.get();
        vLimitStatus = vLimit.get();
        SmartDashboard.putBoolean("Horizontal Limit", hLimitStatus);
        SmartDashboard.putBoolean("Vertical Limit", vLimitStatus);

        if ((hLimitStatus == true) || (vLimitStatus == true)) {
            Robot.oi.mIntakePivot.stopMotor();
            itisFinished = true;
        }

        // if(targetPosition == 2){
        //     if(hLimitStatus == true){
        //         // Target: go to Vertical
        //         targetPosition = 0;
        //     }else if(vLimitStatus == true){
        //         // Target: go to Horizontal
        //         targetPosition = 1;
        //     }else{
        //         // If no limit switch values are found
        //         targetPosition = 2;
        //     }
        //     SmartDashboard.putNumber("Target Position", targetPosition);
        // }
        // if(targetPosition == 0){
        //     if(vLimitStatus == true){
        //         Robot.oi.mIntakePivot.stopMotor();
        //         SmartDashboard.putString("Pivot Position", "Vertical");
        //         itisFinished = true;
        //     }else{
        //         Robot.oi.mIntakePivot.rotateClockwise(0.2);
        //     }
        // }
        // else if(targetPosition == 1){
        //     if(hLimitStatus == true){
        //         Robot.oi.mIntakePivot.stopMotor();
        //         SmartDashboard.putString("Pivot Position", "Horizontal");
        //         itisFinished = true;
        //     }else{
        //         Robot.oi.mIntakePivot.rotateCounterClockwise(0.2);
        //     }
        // }
        // else{
        //     Robot.oi.mIntakePivot.stopMotor();
        // }
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