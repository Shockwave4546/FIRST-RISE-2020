package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.RobotMap;
import frc.robot.subsystems.motors.*;

public class DriveTrain{
    private victorSPXMotor mDriveLeftOne, mDriveLeftTwo, mDriveRightOne, mDriveRightTwo;
    private double cDriveLeftY, cDriveRightX;
    private double straightSpeedL = 0.0;
    private double straightSpeedR = 0.0;
    private PID visionDrivePID;
    private double motorPIDinput;

    // Initializes all 4 drivetrain motors and PID class for vision drive
    public DriveTrain(){
        mDriveLeftOne = new victorSPXMotor(RobotMap.mDriveLeftOnePort);
        mDriveLeftTwo = new victorSPXMotor(RobotMap.mDriveLeftTwoPort);
        mDriveRightOne = new victorSPXMotor(RobotMap.mDriveRightOnePort);
        mDriveRightTwo = new victorSPXMotor(RobotMap.mDriveRightTwoPort);
        visionDrivePID = new PID(1, 0, 0, .02, .1);
    }


    // Takes controller axis inputs to drive (tank based drivetrain)
    private void drivebaseControl(final double inputY, final double inputX) {
        cDriveLeftY = inputY;
        cDriveRightX = -inputX;
        if(cDriveLeftY == 0) {
            mDriveLeftOne.rotateMotor(cDriveRightX);
            mDriveLeftTwo.rotateMotor(cDriveRightX);

            mDriveRightOne.rotateMotor(cDriveRightX);
            mDriveRightTwo.rotateMotor(cDriveRightX);
        }else{
            mDriveLeftOne.rotateMotor(cDriveLeftY + cDriveRightX);
            mDriveLeftTwo.rotateMotor(cDriveLeftY + cDriveRightX);

            mDriveRightOne.rotateMotor((cDriveLeftY - cDriveRightX) * -1);
            mDriveRightTwo.rotateMotor((cDriveLeftY - cDriveRightX) * -1);
        }
    }
    
    // Called from OI for user drive control
    public void userDrive(final double inputY, final double inputX){
        drivebaseControl(inputY, inputX);
    }


    // Called from OI for software(vision) control
    public void visionDrive(double visionTarget, double distance){
        motorPIDinput = -(visionDrivePID.getCalculation(visionTarget));
        //System.out.println(visionTarget);
        if (distance > 63){
            straightSpeedL = 0.25;
            straightSpeedR = -0.25;
        }else if ((distance < 57) && (distance > 5)){
            straightSpeedL = -0.25;
            straightSpeedR = 0.25;
        }else if (distance <= 5.0){
            straightSpeedL = 0.0;
            straightSpeedR = 0.0;
        }else{
            straightSpeedL = 0.0;
            straightSpeedR = 0.0; 
        }
        SmartDashboard.putNumber("visionInput", motorPIDinput);

        mDriveLeftOne.rotateMotor(motorPIDinput + straightSpeedL);
        mDriveLeftTwo.rotateMotor(motorPIDinput + straightSpeedL);
        
        mDriveRightOne.rotateMotor(motorPIDinput + straightSpeedR);
        mDriveRightTwo.rotateMotor(motorPIDinput + straightSpeedR);
    }
}