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
//    JOYSTICKS
    public static final int PAD_OP = 1;
    public static final int DRIVE_RIGHT_JOY = 3;
    public static final int DRIVE_LEFT_JOY = 2;
//    PWMS
    public static final int DRIVE_LEFT_1 = 4;
    public static final int DRIVE_LEFT_2 = 5;
    public static final int DRIVE_LEFT_3 = 2;
    public static final int DRIVE_RIGHT_1 = 1;
    public static final int DRIVE_RIGHT_2 = 6;
    public static final int DRIVE_RIGHT_3 = 3;
    public static final int INTAKE_MOTOR = 8;
    public static final int WINCH = 9;
    public static final int WINCH2 = 10;
    // public static final int VACUUM = 9;
    //    DIGITAL INPUTS
    public static final int AIR_PRESSURE = 1;
    public static final int DRIVE_LEFT_ENC_A = 7;
    public static final int DRIVE_LEFT_ENC_B = 8;
    public static final int DRIVE_RIGHT_ENC_A = 5;
    public static final int DRIVE_RIGHT_ENC_B = 6;
    public static final int WINCH_SENSOR = 2;
    public static final int INTAKE_BUMPER = 3;
    public static final int FIRED_SENSOR = 4;
    public static final int INTAKE_DEPLOYED = 9;
    public static final int BANNERED_SENSOR = 10;
//    Pneumatics
    public static final int INTAKE_PISTON = 7;
    public static final int INTAKE_UP_PISTON = 8;
    public static final int WING = 5;
//    Relays
    public static final int COMPRESSOR_PORT = 3;
//    ANALOG INPUTS
    public static final int DRIVETRAIN_GYRO = 4;
//    public static final int PING_CHANNEL = 1;
//    public static final int ECHO_CHANNEL = 2;
    public static final double ROBOT_MAX_SPEED = 7.0;
    public static double DRIVE_KP = 0.0;
    public static double DRIVE_KI = 0.0;
    public static double DRIVE_KD =  0.09;
    public static double DRIVE_F = 0.2;
    
}
