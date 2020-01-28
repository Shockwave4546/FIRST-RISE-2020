package frc.robot.subsystems.motors;

import edu.wpi.first.wpilibj.Encoder;

public abstract class Motor{
    protected int mPort;
    protected double mPos;
    protected double mDefaultPos;
    protected double mNeg;
    protected double mDefaultNeg;
    private int channelA;
    private int channelB;
    public Encoder sEncoder;

    // Initialization with encoder
    public Motor(final int port, final double pos, final double neg, final int chaA, final int chaB){
        mPort = port;
        mPos = pos;
        mDefaultPos = mPos;
        mNeg = neg;
        mDefaultNeg = mNeg;
        channelA = chaA;
        channelB = chaB;
        sEncoder = new Encoder(channelA, channelB);
    }

    // Initialization without encoder
    public Motor(final int port, final double pos, final double neg){
        mPort = port;
        mPos = pos;
        mDefaultPos = mPos;
        mNeg = neg;
        mDefaultNeg = mNeg;
    }

    // Call to rotate motor clockwwise(positive)
    public abstract void rotateClockwise(final double rotate); 
    
    // Call to rotate motor counterclockwise(negative)
    public abstract void rotateCounterClockwise(final double rotate); 
    
    // Call to stop motor
    public abstract void stopMotor();

    // Call to rotate motor, use this for user motor control
    public abstract void rotateMotor(final double rotate);
    
    // Call to return most recent set value of motor
    public abstract double get();

    // Sets motor scalers to parameter inputs
    public void setMotorSpeeds(final double pos, final double neg){
        mPos = pos;
        mNeg = neg;
    }
    // Resets motor scalers to defaults
    public void resetMotorSpeeds(){
        mPos = mDefaultPos;
        mNeg = mDefaultNeg;
    }
}