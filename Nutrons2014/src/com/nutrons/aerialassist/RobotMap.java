package com.nutrons.aerialassist;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;

    // TODO: Change the values below.
    public static final int DRIVE_LEFT = 1;
    public static final int DRIVE_RIGHT = 2;
    public static final int PAD_DRIVER = 1;
    public static final int INTAKE_MOTOR = 3;
    public static final int DRIVETRAIN_GYRO = 1;
    public static final int DRIVE_LEFT_ENC_A = 2;
    public static final int DRIVE_LEFT_ENC_B = 3;
    public static final int DRIVE_RIGHT_ENC_A = 4;
    public static final int DRIVE_RIGHT_ENC_B = 1;
    public static final int WINCH = 4;
    public static final int WINCH2 = 3;
}
