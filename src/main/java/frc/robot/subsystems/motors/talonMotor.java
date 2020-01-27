package frc.robot.subsystems.motors;

import frc.robot.subsystems.motors.Motor;

import edu.wpi.first.wpilibj.Talon;



public class talonMotor extends Motor{
    private Talon kMotor;
    public int channelA;
    public int channelB;

    public talonMotor(final int port, final double pos, final double neg){
        super(port, pos, neg);
        kMotor = new Talon(port);
    }
    public talonMotor(final int port){
        super(port, 1, 1);
        kMotor = new Talon(port);
    }

    public talonMotor(final int port, final double pos, final double neg, final int chaA, final int chaB){
        super(port, pos, neg, chaA, chaB);
        kMotor = new Talon(port);
        channelA = chaA;
        channelB = chaB;
    }
    public talonMotor(final int port, final int chaA, final int chaB){
        super(port, 1, 1, chaA, chaB);
        kMotor = new Talon(port);        
        channelA = chaA;
        channelB = chaB;
    }

    public int getAChannel(){
        return channelA;
    }

    public int getBChannel(){
        return channelB;
    }

    public void rotateClockwise(final double rotate){
        kMotor.set(rotate * mPos);
    }

    public void rotateCounterClockwise(final double rotate){
        kMotor.set(rotate * -mNeg);
    }

    public void stopMotor(){
        kMotor.set(0);
    }
    
    public void rotateMotor(final double rotate){
        if(rotate > 0){
            kMotor.set(rotate * mPos);
        }else{
            kMotor.set(rotate * mNeg);
        }
    }
}
