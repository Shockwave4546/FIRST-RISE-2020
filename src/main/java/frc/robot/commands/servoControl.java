/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;
//import edu.wpi.first.wpilibj.DriverStation;

//import frc.robot.subsystems.motors.talonMotor;

/**
 * An example command that uses an example subsystem.
 */
public class servoControl extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    public boolean itisFinished = false;
    Servo servo1 = new Servo(2);

    public servoControl() {

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        /*if(servo1.get() == 1.0){
            servo1.set(0.0);
        }
        else if(servo1.get() == 0.0){
            servo1.set(1.0);
        }
        else{
            servo1.set(0.0);
        }
        itisFinished = true;*/
        if(servo1.getAngle() == 180.0){
            servo1.setAngle(0.0);
        }
        else if(servo1.getAngle() == 0.0){
            servo1.setAngle(180.0);
        }
        else{
            servo1.setAngle(0.0);
        }
        SmartDashboard.putNumber("Current Servo Angle", servo1.getAngle());
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
