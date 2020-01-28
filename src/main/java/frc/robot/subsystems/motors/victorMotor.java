package frc.robot.subsystems.motors;

import frc.robot.subsystems.motors.Motor;

import edu.wpi.first.wpilibj.Victor;



public class victorMotor extends Motor{
    private Victor kMotor;



    // Initialization with default positive/negative scaling
    public victorMotor(final int port){
        super(port, 1, 1);
        kMotor = new Victor(port);
    }
    // Initialization with specified positive/negative scaling
    public victorMotor(final int port, final double pos, final double neg){
        super(port, pos, neg);
        kMotor = new Victor(port);
    }
    // Initialization  with default positive/negative scaling
    // and encoder
    public victorMotor(final int port, final int chaA, final int chaB){
        super(port, 1, 1, chaA, chaB);
        kMotor = new Victor(port);
    }
    // Initialization  with specified positive/negative scaling
    // and encoder
    public victorMotor(final int port, final double pos, final double neg, final int chaA, final int chaB){
        super(port, pos, neg, chaA, chaB);
        kMotor = new Victor(port);
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
}