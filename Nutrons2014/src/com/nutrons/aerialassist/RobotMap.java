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
    public static final int DRIVE_RIGHT_JOY = 2;
    public static final int DRIVE_LEFT_JOY = 3;
//    PWMS
    public static final int DRIVE_LEFT = 1;
    public static final int DRIVE_RIGHT = 2;
    public static final int INTAKE_MOTOR = 5;
    public static final int WINCH = 4;
    public static final int WINCH2 = 3;
//    DIGITAL INPUTS
    public static final int AIR_PRESSURE = 1;
    public static final int WINCH_SENSOR = 2;
    public static final int INTAKE_BUMPER = 3;
    public static final int FIRED_SENSOR = 4;
    public static final int DRIVE_LEFT_ENC_A = 15;
    public static final int DRIVE_LEFT_ENC_B = 14;
    public static final int DRIVE_RIGHT_ENC_A = 13;
    public static final int DRIVE_RIGHT_ENC_B = 12;
    
    
//    Pneumatics
    public static final int INTAKE_PISTON = 7;
    public static final int INTAKE_UP_PISTON = 8;
    
    
    

//    Relays
    public static final int COMPRESSOR_PORT = 3;
    
//    ANALOG INPUTS
        public static final int DRIVETRAIN_GYRO = 4;

}
