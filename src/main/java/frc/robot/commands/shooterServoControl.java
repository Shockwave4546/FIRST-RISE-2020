/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
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
    private int targetSequence = 0;
    private ArrayList<Double> targetPositionSequence = new ArrayList<Double>(RobotMap.smShooterTotalPositions);
    private ArrayList<Double> targetPositionSequenceTwo = new ArrayList<Double>(RobotMap.smShooterTwoTotalPositions);

    public shooterServoControl() {

    }

    private void sequencePlusOne() {
        if (targetSequence == RobotMap.smShooterTotalPositions && targetSequence == RobotMap.smShooterTwoTotalPositions) {
            targetSequence = 0;
        } else {
            targetSequence++;
        }
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        targetPositionSequence.add(RobotMap.smShooterPositionOne);
        targetPositionSequence.add(RobotMap.smShooterPositionTwo);
        targetPositionSequence.add(RobotMap.smShooterPositionThree);
        Robot.oi.smShooter.setAngle(targetPositionSequence.get(targetSequence));

        targetPositionSequenceTwo.add(RobotMap.smShooterTwoPositionOne);
        targetPositionSequenceTwo.add(RobotMap.smShooterTwoPositionTwo);
        targetPositionSequenceTwo.add(RobotMap.smShooterTwoPositionThree);
        Robot.oi.smShooterTwo.setAngle(targetPositionSequenceTwo.get(targetSequence));
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double currentAngle = Robot.oi.smShooter.getAngle();
        double targetAngle = targetPositionSequence.get(targetSequence);
        double currentAngleTwo = Robot.oi.smShooter.getAngle();
        double targetAngleTwo = targetPositionSequenceTwo.get(targetSequence);
        if(currentAngle != targetAngle){
            Robot.oi.smShooter.setAngle(targetAngle);
        }
        if(currentAngleTwo != targetAngleTwo){
            Robot.oi.smShooterTwo.setAngle(targetAngleTwo);
        }
        sequencePlusOne();
        SmartDashboard.putNumber("Current Shooter Servo Angle", Robot.oi.smShooter.getAngle());
        SmartDashboard.putNumber("Current Shooter Servo Two Angle", Robot.oi.smShooterTwo.getAngle());
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