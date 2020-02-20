/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.motors.*;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * An example command that uses an example subsystem.
 */
/*
public class pivotControl extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    public boolean itisFinished = false;
    private talonMotor mPivot = new talonMotor(RobotMap.mPivotPort);
    private DigitalInput hLimit = new DigitalInput(RobotMap.hLimitPort);
    private DigitalInput vLimit = new DigitalInput(RobotMap.vLimitPort);
    private int targetPosition = 2;
    boolean hLimitStatus;
    boolean vLimitStatus;

    public pivotControl() {
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        hLimitStatus = hLimit.get();
        vLimitStatus = vLimit.get();
        SmartDashboard.putBoolean("Horizontal Limit", hLimitStatus);
        SmartDashboard.putBoolean("Vertical Limit", vLimitStatus);

        if(targetPosition == 2){
            if(hLimitStatus == true){
                // Target: go to Vertical
                targetPosition = 0;
            }else if(vLimitStatus == true){
                // Target: go to Horizontal
                targetPosition = 1;
            }else{
                // If no limit switch values are found
                targetPosition = 2;
            }
            SmartDashboard.putNumber("Target Position", targetPosition);
        }
        if(targetPosition == 0){
            if(vLimitStatus == true){
                mPivot.stopMotor();
                SmartDashboard.putString("Pivot Position", "Vertical");
                itisFinished = true;
            }else{
                mPivot.rotateClockwise(RobotMap.mPivotSpeed);
            }
        }
        else if(targetPosition == 1){
            if(hLimitStatus == true){
                mPivot.stopMotor();
                SmartDashboard.putString("Pivot Position", "Horizontal");
                itisFinished = true;
            }else{
                mPivot.rotateCounterClockwise(RobotMap.mPivotSpeed);
            }
        }
        else{
            mPivot.stopMotor();
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        itisFinished = false;
        targetPosition = 2;
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
*/