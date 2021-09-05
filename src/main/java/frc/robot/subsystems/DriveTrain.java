package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.subsystems.motors.*;

public class DriveTrain{
    private victorSPMotor mFrontLeft, mFrontRight, mBackLeft, mBackRight;
    private double cDriveLeftY, cDriveRightY;
    /*private double integral, previousError, setPoint = 0;
    private double P = 1;
    private double I, D = 0;
    private double actualtemp = 0;*/
    //private double straightSpeedL = 0.0;
    //private double straightSpeedR = 0.0;
    //private PID visionDrivePID;
    //private double motorPIDinput;

    // Initializes all 4 drivetrain motors and PID class for vision drive
    public DriveTrain(){
        mFrontLeft = new victorSPMotor(RobotMap.mDriveLeftOnePort);
        mFrontRight = new victorSPMotor(RobotMap.mDriveRightOnePort);
        mBackLeft = new victorSPMotor(RobotMap.mDriveLeftTwoPort);
        mBackRight = new victorSPMotor(RobotMap.mDriveRightTwoPort);
        //visionDrivePID = new PID(1, 0, 0, .02, .1);
    }

    // Takes controller axis inputs to drive (tank based drivetrain)
    private void drivebaseControl(final double inputLY, final double inputRY) {
        cDriveLeftY = inputLY;
        cDriveRightY = inputRY;
        // if(cDriveLeftY == 0) {
        //     mForwardLeft.rotateMotor(cDriveRightX);
        //     SmartDashboard.putNumber("mForwardLeft", mForwardLeft.get());
        //     mForwardRight.rotateMotor(cDriveRightX);
        //     SmartDashboard.putNumber("mForwardRight", mForwardRight.get());
        // }else{
        //     mForwardLeft.rotateMotor(cDriveLeftY + cDriveRightX);
        //     SmartDashboard.putNumber("mForwardLeft", mForwardLeft.get());
        //     mForwardRight.rotateMotor((cDriveLeftY - cDriveRightX) * -1);
        //     SmartDashboard.putNumber("mForwardRight", mForwardRight.get());
        // }
        mFrontLeft.rotateMotor(cDriveLeftY);
        mFrontRight.rotateMotor(cDriveRightY);
        mBackLeft.rotateMotor(cDriveLeftY);
        mBackRight.rotateMotor(cDriveRightY);

    }

    // Called from OI for user drive control
    public void userDrive(final double inputLY, final double inputRY){
        drivebaseControl(inputLY, inputRY);
    }


    /*private double PID(double number){
        //PID LOOP USING PIXEL DIFFERENCE
        
        double error = (setPoint - number)*.25; // Error = Target - Actual
        this.integral += (error*.005); // Integral is increased by the error*time (which is .02 seconds using normal IterativeRobot)
        double derivative = (error - previousError) / .5;
        System.out.println(P*error + I*integral + D*derivative);
        return (P*error + I*integral + D*derivative);
        
        ******MOVED TO PID.java******

        //PID LOOP USING YAW DIFFERENCE
        visiontargettable = NetworkTableInstance.getDefault().getTable("chameleon-vision/USB Camera-B4.09.24.1");
        double tarNumber = visiontargettable.getEntry("targetYaw").getDouble(0.0);

        double error = (setPoint - tarNumber)*.02; // Error = Target - Actual
        this.integral += (error*.005); // Integral is increased by the error*time (which is .02 seconds using normal IterativeRobot)
        double derivative = (error - previousError) / .1;
        System.out.println(P*error + I*integral + D*derivative);
        return (-(P*error + I*integral + D*derivative));
    }
    */

    // // Called from OI for software(vision) control
    // public void visionDrive(double visionTarget, double distance){
    //     motorPIDinput = -(visionDrivePID.getCalculation(visionTarget));
    //     //System.out.println(visionTarget);
    //     if (distance > 63){
    //         straightSpeedL = 0.25;
    //         straightSpeedR = -0.25;
    //     }else if ((distance < 57) && (distance > 5)){
    //         straightSpeedL = -0.25;
    //         straightSpeedR = 0.25;
    //     }else if (distance <= 5.0){
    //         straightSpeedL = 0.0;
    //         straightSpeedR = 0.0;
    //     }else{
    //         straightSpeedL = 0.0;
    //         straightSpeedR = 0.0; 
    //     }
    //     SmartDashboard.putNumber("visionMotor", motorPIDinput);

    //     mForwardLeft.rotateMotor(motorPIDinput + straightSpeedL);
    //     SmartDashboard.putNumber("mForwardLeft", mForwardLeft.get());
        
    //     mForwardRight.rotateMotor(motorPIDinput + straightSpeedR);
    //     SmartDashboard.putNumber("mForwardRight", mForwardRight.get());
    // }
}