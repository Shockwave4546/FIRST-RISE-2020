package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.motors.talonMotor;

public class colorWheelSpinner extends SubsystemBase {
    private talonMotor mSpinner;

    public colorWheelSpinner() {
        mSpinner = new talonMotor(RobotMap.mSpinPort, RobotMap.mSpinPos, RobotMap.mSpinNeg);
    }

    public void spinMotor(final double speed) {
        mSpinner.rotateMotor(1);
    }

    public void stopMotor(final double speed) {
        mSpinner.rotateMotor(0);
    }
}
