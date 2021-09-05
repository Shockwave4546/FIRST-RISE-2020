package frc.robot;

public class RobotMap {
    // Controllers //
    public static final double joystickDeadzone = 0.3;
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
    public static final int smShooterPort = 4;              // Right Side Servo
    public static final int smShooterTotalPositions = 3;
    public static final double smShooterPositionOne = 0;
    public static final double smShooterPositionTwo = .5;
    public static final double smShooterPositionThree = 1;

    public static final int smShooterTwoPort = 5;           // Left Side Servo
    public static final int smShooterTwoTotalPositions = 3;
    public static final double smShooterTwoPositionOne = 1;
    public static final double smShooterTwoPositionTwo = .5;
    public static final double smShooterTwoPositionThree = 0;
        // ---------- //

        // Camera Servos //
    public static final int smCamPanPort = 6;
    public static final int smCamTiltPort = 7;
    public static final double servoSensitivity = 1.0;
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
    public static final double mIntakePivotPos = 0.3;
    public static final double mIntakePivotNeg = 0.3;
        // ---------- //

        // Flywheel (Ball Shooter) //
    public static final int mFlywheelShooterOnePort = 13;   // Motor Controller  8 - Purple
    public static final double mFlywheelShooterOnePos = 1.0;
    public static final double mFlywheelShooterOneNeg = 1.0;

    public static final int mFlywheelShooterTwoPort = 14;   // Motor Controller  9 - Purple
    public static final double mFlywheelShooterTwoPos = 1.0;
    public static final double mFlywheelShooterTwoNeg = 1.0;

    public static final double mFlywheelShooterHighTarget = 1.0; // Flywheel spinning target values
    public static final double mFlywheelShooterLowTarget = 0.25;

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
    public static final int IsIntakeVerticalPort = 2;
    public static final int IsIntakeHorizontalPort = 3;
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