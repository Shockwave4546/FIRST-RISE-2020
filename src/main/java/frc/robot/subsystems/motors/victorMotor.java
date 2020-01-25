package frc.robot.subsystems.motors;

import frc.robot.subsystems.motors.Motor;

import edu.wpi.first.wpilibj.Victor;



public class victorMotor extends Motor{
    private Victor kMotor;
    public victorMotor(final int port, final double pos, final double neg){
        super(port, pos, neg);
        kMotor = new Victor(port);
    }
    public victorMotor(final int port){
        super(port, 1, 1);
        kMotor = new Victor(port);
    }
    
    public victorMotor(final int port, final double pos, final double neg, final int chaA, final int chaB){
        super(port, pos, neg, chaA, chaB);
        kMotor = new Victor(port);
    }
    public victorMotor(final int port, final int chaA, final int chaB){
        super(port, 1, 1, chaA, chaB);
        kMotor = new Victor(port);
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

    public double get(){
        return kMotor.get();
    }
}
