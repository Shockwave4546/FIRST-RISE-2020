package frc.robot;

public class RobotMap {
    // Controllers //
    public static final double joystickDeadzone = 0.2;
    public static final int cDriverPort = 0;
    public static final int cOperatorPort = 1;

    // PWM // ------------------------------------------ //
        // DriveTrain //
    public static final int mDriveLeftOnePort = 0;          // Motor Controller  1 - Red
    public static final double mDriveLeftOnePos = 1.0;
    public static final double mDriveLeftOneNeg = 1.0;

    public static final int mDriveLeftTwoPort = 1;          // Motor Controller  2 - Red
    public static final double mDriveLeftTwoPos = 1.0;
    public static final double mDriveLeftTwoNeg = 1.0;

    public static final int mDriveRightOnePort = 2;         // Motor Controller  3 - Red w/ stripes
    public static final double mDriveRightOnePos = 1.0;
    public static final double mDriveRightOneNeg = 1.0;
    
    public static final int mDriveRightTwoPort = 3;         // Motor Controller  4 - Red w/ stripes
    public static final double mDriveRightTwoPos = 1.0;
    public static final double mDriveRightTwoNeg = 1.0;
        // ---------- //

        // Shooter Servo //
    public static final int smShooterPort = 4;
        // ---------- //

        // Camera Servos //
    public static final int smCamPan = 5;
    public static final int smCamTilt = 6;
        // ---------- //
    // PWM // ------------------------------------------ //


    // CAN Bus // ------------------------------------------ //
        // Wheel Of Fortune //
    public static final int mWheelOfFortunePort = 10;       // Motor Controller  5 - Yellow
    public static final double mWheelOfFortunePos = 0.6;
    public static final double mWheelOfFortuneNeg = 0.6;
        // ---------- //

        // Intake //
    public static final int mIntakeRollerPort = 11;         // Motor Controller  6 - Green
    public static final double mIntakeRollerPos = 1.0;
    public static final double mIntakeRollerNeg = 1.0;

    public static final int mIntakePivotPort = 12;          // Motor Controller  7 - Green
    public static final double mIntakePivotPos = 0.6;
    public static final double mIntakePivotNeg = 0.6;
        // ---------- //

        // Flywheel (Ball Shooter) //
    public static final int mFlywheelShooterOnePort = 13;   // Motor Controller  8 - Purple
    public static final double mFlywheelShooterOnePos = 1.0;
    public static final double mFlywheelShooterOneNeg = 1.0;

    public static final int mFlywheelShooterTwoPort = 14;   // Motor Controller  9 - Purple
    public static final double mFlywheelShooterTwoPos = 1.0;
    public static final double mFlywheelShooterTwoNeg = 1.0;

    public static final int mFlywheelFeederPort = 15;       // Motor Controller 10 - Purple w/ stripes
    public static final double mFlywheelFeederPos = 1.0;
    public static final double mFlywheelFeederNeg = 1.0;
        // ---------- //

        // Climb //
    public static final int mClimbPort = 16;                // Motor Controller 11 - Blue
    public static final double mClimbPos = 1.0;
    public static final double mClimbNeg = 1.0;
        // ---------- //
    // CAN Bus // ------------------------------------------ //


    // DIO // ------------------------------------------ //
        // Flywheel Encoder //
    public static final int eFlywheelEncoderPortOne = 0;
    public static final int eFlywheelEncoderPortTwo = 1;
        // ---------- //

        // Intake Pivot //
    public static final int lsIntakeVerticalPort = 2;
    public static final int lsIntakeHorizontalPort = 3;
        // ---------- //

        // Vision LimeLight //
    public static final int rLimeLightPort = 4;
        // ---------- //
    // DIO // ------------------------------------------ //


    // Misc // ------------------------------------------ //
        // //
        // ---------- //
    // Misc // ------------------------------------------ //
}