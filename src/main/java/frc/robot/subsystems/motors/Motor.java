package frc.robot.subsystems.motors;

import edu.wpi.first.wpilibj.Encoder;

public abstract class Motor{
    protected int mPort;
    protected double mPos;
    protected double mNeg;
    private int channelA;
    private int channelB;
    public Encoder sEncoder;

    public Motor(final int port, final double pos, final double neg, final int chaA, final int chaB){
        mPort = port;
        mPos = pos;
        mNeg = neg;
        channelA = chaA;
        channelB = chaB;
        sEncoder = new Encoder(channelA, channelB);
    }

    public Motor(final int port, final double pos, final double neg){
        mPort = port;
        mPos = pos;
        mNeg = neg;
    }

    // Call to rotate motor clockwwise(positive)
    public abstract void rotateClockwise(final double rotate); 
    
    // Call to rotate motor counterclockwise(negative)
    public abstract void rotateCounterClockwise(final double rotate); 
    
    // Call to stop motor
    public abstract void stopMotor();

    // Call to rotate motor, use this for user motor control
    public abstract void rotateMotor(final double rotate);
}