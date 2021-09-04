package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class colorWheelSpinner extends SubsystemBase {

    public colorWheelSpinner() {
    }

    public void spinMotor(final double speed) {
        Robot.oi.mWheelOfFortune.rotateMotor(speed);
    }

    public void stopMotor(final double speed) {
        Robot.oi.mWheelOfFortune.rotateMotor(speed);
    }
}
