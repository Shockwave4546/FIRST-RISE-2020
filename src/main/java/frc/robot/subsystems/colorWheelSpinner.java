package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.motors.talonMotor;

public class colorWheelSpinner extends SubsystemBase {
    private talonMotor mWheelOfFortune;

    public colorWheelSpinner() {
        mWheelOfFortune = new talonMotor(RobotMap.mWheelOfFortunePort, RobotMap.mWheelOfFortunePos, RobotMap.mWheelOfFortuneNeg);
    }

    public void spinMotor(final double speed) {
        mWheelOfFortune.rotateMotor(speed);
    }

    public void stopMotor(final double speed) {
        mWheelOfFortune.rotateMotor(speed);
    }
}
