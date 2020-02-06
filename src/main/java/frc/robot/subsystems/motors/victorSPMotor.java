package frc.robot.subsystems.motors;

import frc.robot.subsystems.motors.Motor;

import edu.wpi.first.wpilibj.VictorSP;



public class victorSPMotor extends Motor{
    private VictorSP kMotor;
    public victorSPMotor(final int port, final double pos, final double neg){
        super(port, pos, neg);
        kMotor = new VictorSP(port);
    }public victorSPMotor(final int port){
        super(port, 1, 1);
        kMotor = new VictorSP(port);
    }

    public victorSPMotor(final int port, final double pos, final double neg, final int chaA, final int chaB){
        super(port, pos, neg, chaA, chaB);
        kMotor = new VictorSP(port);
    }public victorSPMotor(final int port, final int chaA, final int chaB){
        super(port, 1, 1, chaA, chaB);
        kMotor = new VictorSP(port);
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