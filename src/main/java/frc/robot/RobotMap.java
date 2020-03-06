package frc.robot;

public class RobotMap {
    // Controllers //
    public static final double joystickDeadzone = 0.2;
    public static final int cDriverPort = 0;
    public static final int cCoDriverPort = 1;

    // PWM //
        // DriveTrain //
    public static final int mForwardLeftPort = 5;
    public static final double mForwardLeftPos = 1.0;
    public static final double mForwardLeftNeg = 1.0;

    public static final int mForwardRightPort = 6;
    public static final double mForwardRightPos = 1.0;
    public static final double mForwardRightNeg = 1.0;

    public static final int mBackwardLeftPort = 7;
    public static final double mBackwardLeftPos = 1.0;
    public static final double mBackwardLeftNeg = 1.0;
    
    public static final int mBackwardRightPort = 8;
    public static final double mBackwardRightPos = 1.0;
    public static final double mBackwardRightNeg = 1.0;
        // ---------- //


    public static final int mSpinPort = 4;
    public static final double mSpinPos = 0.6;
    public static final double mSpinNeg = 0.6;

    public static final int mPivotPort = 5;
    public static final double mPivotSpeed = 0.5;

    // CAN Bus // 

    // Digital //
    public static final int hLimitPort = 0;
    public static final int vLimitPort = 1;

    // Misc //
    
}