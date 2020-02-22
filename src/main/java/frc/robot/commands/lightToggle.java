/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * An example command that uses an example subsystem.
 */
public class lightToggle extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    public boolean itisFinished = false;
    private final DigitalOutput rLimeLight = new DigitalOutput(RobotMap.rLimeLightPort);
    private boolean rLimeLightValue;


    public lightToggle() {
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        rLimeLight.set(false);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        rLimeLightValue = rLimeLight.get();
        if(rLimeLightValue == true){
            rLimeLight.set(false);
        }else if(rLimeLightValue == false){
            rLimeLight.set(true);
        }
        SmartDashboard.putBoolean("LimeLight", rLimeLightValue);
        itisFinished = true;
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