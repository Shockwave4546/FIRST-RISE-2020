package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
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
    private double actualtemp = 0;
    private double straightSpeedL = 0.0;
    private double straightSpeedR = 0.0;
    public NetworkTable visiontargettable;
    private PID visionDrivePID;

    // Initializes all 4 drivetrain motors
    public DriveTrain(){
        mForwardLeft = new talonMotor(RobotMap.mForwardLeftPort);
        mForwardRight = new talonMotor(RobotMap.mForwardRightPort);
        visionDrivePID = new PID(1, 0, 0, .02, .1);
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


    private double PID(double number){
        //PID LOOP USING PIXEL DIFFERENCE
        /*
        double error = (setPoint - number)*.25; // Error = Target - Actual
        this.integral += (error*.005); // Integral is increased by the error*time (which is .02 seconds using normal IterativeRobot)
        double derivative = (error - previousError) / .5;
        System.out.println(P*error + I*integral + D*derivative);
        return (P*error + I*integral + D*derivative);
        */

        //PID LOOP USING YAW DIFFERENCE
        visiontargettable = NetworkTableInstance.getDefault().getTable("chameleon-vision/USB Camera-B4.09.24.1");
        double tarNumber = visiontargettable.getEntry("targetYaw").getDouble(0.0);

        double error = (setPoint - tarNumber)*.02; // Error = Target - Actual
        this.integral += (error*.005); // Integral is increased by the error*time (which is .02 seconds using normal IterativeRobot)
        double derivative = (error - previousError) / .1;
        System.out.println(P*error + I*integral + D*derivative);
        return (-(P*error + I*integral + D*derivative));
    }

    public void visionDrive(final double[] visionTarget, double distance){
        //System.out.println(visionTarget[1]);
        double temp = (visionDrivePID.getCalculation(visionTarget[1]));
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
        //System.out.println(straightSpeedL);
        //System.out.println(actualtemp);
        mForwardLeft.rotateMotor(temp+straightSpeedL);
        SmartDashboard.putNumber("visionMotor", temp);
        mForwardRight.rotateMotor(temp+straightSpeedR);

        //System.out.println(temp);
    }
}