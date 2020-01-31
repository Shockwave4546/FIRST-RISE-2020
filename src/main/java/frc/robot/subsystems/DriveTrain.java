package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.subsystems.motors.*;

public class DriveTrain{
    private talonMotor mForwardLeft;
    private talonMotor mForwardRight;
    //private talonMotor mBackwardLeft;
    //private talonMotor mBackwardRight;
    private double cDriveLeftY;
    private double cDriveRightX;
    // Initializes all 4 drivetrain motors
    public DriveTrain(){
        mForwardLeft = new talonMotor(RobotMap.mForwardLeftPort);
        mForwardRight = new talonMotor(RobotMap.mForwardRightPort);
        //mBackwardLeft = new talonMotor(RobotMap.mBackwardLeftPort);
        //mBackwardRight = new talonMotor(RobotMap.mBackwardRightPort);
    }
    // Takes controller axis inputs to drive a tank based drivetrain
    private void drivebaseControl(final double inputY, final double inputX) {
        cDriveLeftY = inputY;
        cDriveRightX = inputX;
        if(cDriveLeftY == 0) {
            mForwardLeft.rotateMotor(cDriveRightX);
            SmartDashboard.putNumber("mForwardLeft", mForwardLeft.get());
            mForwardRight.rotateMotor(cDriveRightX);
            SmartDashboard.putNumber("mForwardRight", mForwardRight.get());
        }else{
            mForwardLeft.rotateMotor(cDriveLeftY + cDriveRightX);
            SmartDashboard.putNumber("mForwardLeft", mForwardLeft.get());
            mForwardRight.rotateMotor((cDriveLeftY - cDriveRightX) * -1);
            SmartDashboard.putNumber("mForwardRight", mForwardRight.get());
        }
    }
    public void userDrive(final double inputY, final double inputX){
        drivebaseControl(inputY, inputX);
    }
}