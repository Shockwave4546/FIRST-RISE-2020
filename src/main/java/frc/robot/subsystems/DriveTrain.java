package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.subsystems.motors.*;

public class DriveTrain{
    private talonMotor mForwardLeft;
    private talonMotor mForwardRight;
    //private talonMotor mBackwardLeft;
    //private talonMotor mBackwardRight;
    private double cDriveLeftY;
    private double cDriveRightX;
    public DriveTrain(){
        mForwardLeft = new talonMotor(RobotMap.mForwardLeftPort);
        mForwardRight = new talonMotor(RobotMap.mForwardRightPort);
        //mBackwardLeft = new talonMotor(RobotMap.mBackwardLeftPort);
        //mBackwardRight = new talonMotor(RobotMap.mBackwardRightPort);
    }
    private void drivebaseControl() {
        cDriveLeftY = 0.0;
        cDriveRightX = 0.0;
        if (cDriveLeftY == 0) {
            mForwardLeft.rotateMotor(cDriveRightX);
            mForwardRight.rotateMotor(cDriveRightX);
        } else {
            mForwardLeft.rotateMotor(cDriveLeftY + cDriveRightX);
            mForwardRight.rotateMotor((cDriveLeftY - cDriveRightX) * -1);
        }
    }
    public void Drive(){
        drivebaseControl();
    }
}