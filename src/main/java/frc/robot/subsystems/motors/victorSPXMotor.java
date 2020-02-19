package frc.robot.subsystems.motors;

import frc.robot.subsystems.motors.Motor;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;



public class victorSPXMotor extends Motor{
    private VictorSPX kMotor;



    // Initialization with default positive/negative scaling
    public victorSPXMotor(final int port){
        super(port, 1, 1);
        kMotor = new VictorSPX(port);
    }
    // Initialization with specified positive/negative scaling
    public victorSPXMotor(final int port, final double pos, final double neg){
        super(port, pos, neg);
        kMotor = new VictorSPX(port);
    }
    

    // Rotates motor clockwise(positive), use for non user input
    public void rotateClockwise(final double rotate){
        kMotor.set(VictorSPXControlMode.Velocity, rotate * mPos);
    }
    // Rotates motor counterclockwise(negative), use for non user input
    public void rotateCounterClockwise(final double rotate){
        kMotor.set(VictorSPXControlMode.Velocity, rotate * -mNeg);
    }
    // Stops motor
    public void stopMotor(){
        kMotor.set(VictorSPXControlMode.Velocity, 0);
    }
    // Rotates motor based on (user)input, asigns proper scale variables automatically
    public void rotateMotor(final double rotate){
        if(rotate > 0){
            kMotor.set(VictorSPXControlMode.Velocity, rotate * mPos);
        }else if(rotate < 0){
            kMotor.set(VictorSPXControlMode.Velocity, rotate * mNeg);
        }else{
            stopMotor();
        }
    }
    
    
    // Disabled function
    public double get(){
        return 0.0;
    }
}