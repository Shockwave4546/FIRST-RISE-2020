package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.subsystems.motors.*;

public class DriveTrain{
    private talonMotor mForwardLeft, mForwardRight;
    //private talonMotor mBackwardLeft;
    //private talonMotor mBackwardRight;
    private double cDriveLeftY, cDriveRightX;
    private double integral, previousError, setPoint = 0;
    private double P = 1;
    private double I, D = 0;

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
        cDriveRightX = -inputX;
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


    private void setSetPoint(final double visionTarget){
        if(visionTarget > 0.01){
            setPoint = 0.125;
        }else if(visionTarget < -0.01){
            setPoint = -0.125;
        }else{
            setPoint = 0;
        }
    }

    private double PID(double number){
        double error = setPoint - number; // Error = Target - Actual
        this.integral += (error*.02); // Integral is increased by the error*time (which is .02 seconds using normal IterativeRobot)
        double derivative = (error - previousError) / .02;
        return (P*error + I*integral + D*derivative) * .7;
    }

    public void visionDrive(final double[] visionTarget){
        setSetPoint(visionTarget[1]);
        double temp = PID(visionTarget[1]);
        mForwardLeft.rotateMotor(temp);
        SmartDashboard.putNumber("visionMotor", temp);
        mForwardRight.rotateMotor(temp);
    }
}