/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.ArrayList;

/**
 * An example command that uses an example subsystem.
 */
public class shooterServoControl extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    public boolean itisFinished = false;
    Servo smShooter = new Servo(RobotMap.smShooterPort);
    private int targetSequence = 0;
    private ArrayList<Double> targetAngleSequence = new ArrayList<Double>(RobotMap.smShooterTotalAngles);
    public shooterServoControl() {

    }
    private void sequencePlusOne() {
        if (targetSequence == RobotMap.smShooterTotalAngles) {
            targetSequence = 0;
        } else {
            targetSequence++;
        }
    }
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        targetAngleSequence.add(RobotMap.smShooterAngleOne);
        targetAngleSequence.add(RobotMap.smShooterAngleTwo);
        targetAngleSequence.add(RobotMap.smShooterAngleThree);
        targetAngleSequence.add(RobotMap.smShooterAngleFour);
        smShooter.setAngle(targetAngleSequence.get(targetSequence));
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double currentAngle = smShooter.getAngle();
        double targetAngle = targetAngleSequence.get(targetSequence);
        if(currentAngle != targetAngle){
            smShooter.setAngle(targetAngle);
        }
        sequencePlusOne();
        SmartDashboard.putNumber("Current Shooter Servo Angle", smShooter.getAngle());
        itisFinished = true;
        //*/
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
