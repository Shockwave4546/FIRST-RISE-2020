package frc.robot.subsystems.motors;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Talon;

public class DualMotorEncoder{

    private Talon kMotor1;
    private Talon kMotor2;
    private Encoder eEncoder;
    private double mPos;
    private double mNeg;
    private int ePPR;

    public ShuffleboardTab tab;
    public NetworkTableEntry speed;

    public static double averageRPM = 0;
    public static List<Double> averageRPMArr = new ArrayList<Double>();
    public static double RPM;
    public static double total;
    public static int i;
    
    public DualMotorEncoder(final int port1, final int port2, final int ePort1, final int ePort2, final int PPR){
        kMotor1 = new Talon(port1);
        kMotor2 = new Talon(port2);
        eEncoder = new Encoder(ePort1, ePort2, false, Encoder.EncodingType.k4X);
        ePPR = PPR;
        mPos = 1;
        mNeg = 1;
    }

    public DualMotorEncoder(final int port1, final int port2, final double pos, final double neg, final int ePort1, final int ePort2, final int PPR){
        kMotor1 = new Talon(port1);
        kMotor2 = new Talon(port2);
        eEncoder = new Encoder(ePort1, ePort2, false, Encoder.EncodingType.k4X);
        ePPR = PPR;
        mPos = pos;
        mNeg = neg;
    }

    public DualMotorEncoder(final int port1, final int port2){
        kMotor1 = new Talon(port1);
        kMotor2 = new Talon(port2);
        mPos = 1;
        mNeg = 1;
    }

    public DualMotorEncoder(final int port1, final int port2, final double pos, final double neg){
        kMotor1 = new Talon(port1);
        kMotor2 = new Talon(port2);
        mPos = pos;
        mNeg = neg;
    }

    // Rotates motor clockwise(positive), use for non user input
    public void rotateClockwise(final double rotate){
        kMotor1.set(rotate * mPos);
        kMotor2.set(rotate * mPos);
    }
    // Rotates motor counterclockwise(negative), use for non user input
    public void rotateCounterClockwise(final double rotate){
        kMotor1.set(rotate * -mNeg);
        kMotor2.set(rotate * -mNeg);
    }
    // Stops motor
    public void stopMotors(){
        kMotor1.set(0);
        kMotor2.set(0);
    }
    // Rotates motor based on (user)input, asigns proper scale variables automatically
    public void rotateMotors(final double rotate){
        if(rotate > 0){
            kMotor1.set(rotate * mPos);
            kMotor2.set(rotate * mPos);
        }else if(rotate < 0){
            kMotor1.set(rotate * mNeg);
            kMotor2.set(rotate * mNeg);
        }else{
            stopMotors();
        }
    }

    public double getRPM(){
        try{
            RPM = ((eEncoder.getRate()/ePPR)*-60);
            averageRPMArr.add(RPM);
            total = total + averageRPMArr.get(i);
            averageRPM = (total / averageRPMArr.size());
            SmartDashboard.putNumber("RPM", averageRPM);
            if(i < 100){
                i++;
            }
            else{
                i = 0;
                averageRPMArr.clear();
                total = 0;
            }
            return averageRPM;
        }
        catch(Exception e){
            return 0;
        }
    }

}