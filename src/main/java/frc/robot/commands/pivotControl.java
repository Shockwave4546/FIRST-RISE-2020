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
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.motors.*;
import edu.wpi.first.wpilibj.DigitalInput;


import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;


import java.util.ArrayList;

import com.revrobotics.ColorMatch;
//import edu.wpi.first.wpilibj.DriverStation;

//import frc.robot.subsystems.motors.talonMotor;

/**
 * An example command that uses an example subsystem.
 */
public class pivotControl extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    public boolean itisFinished = false;
    private talonMotor mPivot = new talonMotor(RobotMap.mPivotPort);
    private DigitalInput hLimit = new DigitalInput(RobotMap.hLimitPort);
    private DigitalInput vLimit = new DigitalInput(RobotMap.vLimitPort);

    public pivotControl() {
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        if(hLimit.get()){
            while(vLimit.get() == false){
                mPivot.set(-1*RobotMap.mPivotSpeed);
            }
        }
        else if(vLimit.get()){
      
            while(hLimit.get() == false){
                mPivot.set(RobotMap.mPivotSpeed);
            }
         }
        else{
            mPivot.set(0);
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
