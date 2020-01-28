package frc.robot.subsystems.motors;

import frc.robot.subsystems.motors.Motor;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class sparkMax extends Motor {
    private CANSparkMax kMotor;
    private CANEncoder kMotorEncoder;
    private double kMotorEncoderValuePos;
    private double kMotorEncoderValueVel;
    // Initialization with default positive/negative scaling
    public sparkMax(final int port){
        super(port, 1, 1);
        kMotor = new CANSparkMax(port, MotorType.kBrushless);
        kMotorEncoder = kMotor.getEncoder();
    }
    // Initialization with specified positive/negative scaling
    public sparkMax(final int port, final double pos, final double neg){
        super(port, pos, neg);
        kMotor = new CANSparkMax(port, MotorType.kBrushless);
        kMotorEncoder = kMotor.getEncoder();
    }


    // Rotates motor clockwise(positive), use for non user input
    public void rotateClockwise(final double rotate){
        kMotor.set(rotate * mPos);
    }
    // Rotates motor counterclockwise(negative), use for non user input
    public void rotateCounterClockwise(final double rotate){
        kMotor.set(rotate * -mNeg);
    }
    // Stops motor
    public void stopMotor(){
        kMotor.set(0);
    }
    // Rotates motor based on (user)input, asigns proper scale variables automatically
    public void rotateMotor(final double rotate){
        if(rotate > 0){
            kMotor.set(rotate * mPos);
        }else{
            kMotor.set(rotate * mNeg);
        }
    }


    // Returns most recent set value of motor
    public double get(){
        return kMotor.get();
    }

    // Returns current encoder position
    public double getEncoderPosition(){
        kMotorEncoderValuePos = kMotorEncoder.getPosition();
        return kMotorEncoderValuePos;
    }
    // Returns current encoder velocity
    public double getEncoderVelocity(){
        kMotorEncoderValueVel = kMotorEncoder.getVelocity();
        return kMotorEncoderValueVel;
    }
}