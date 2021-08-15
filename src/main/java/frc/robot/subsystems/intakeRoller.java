package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.motors.talonMotor;

public class intakeRoller extends SubsystemBase {
    private talonMotor mIntakeRoller;

    public intakeRoller() {
        mIntakeRoller = new talonMotor(RobotMap.mWheelOfFortunePort, RobotMap.mWheelOfFortunePos, RobotMap.mWheelOfFortuneNeg);
    }

    public void spinMotor(final double speed) {
        mIntakeRoller.rotateMotor(speed);
    }

    public void stopMotor(final double speed) {
        mIntakeRoller.rotateMotor(speed);
    }
}
