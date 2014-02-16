
package com.nutrons.aerialassist.subsystems;

import com.nutrons.aerialassist.RobotMap;
import com.nutrons.aerialassist.commands.drivetrain.DTManualTankCmd;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.nutrons.lib.VelocityEncoder;
import edu.wpi.first.wpilibj.*;


/**
 * @author Camilo
 */
public class DriveTrain extends Subsystem {

    private double tSens = 1;

    public final double LEFT_SCALE = 1.0;
    public final double RIGHT_SCALE = -1.0;

    // robot parts
    SpeedController lMotor1 = new Talon(RobotMap.DRIVE_LEFT_1);
    SpeedController lMotor2 = new Talon(RobotMap.DRIVE_LEFT_2);
    SpeedController lMotor3 = new Talon(RobotMap.DRIVE_LEFT_3);
    SpeedController rMotor1 = new Talon(RobotMap.DRIVE_RIGHT_1);
    SpeedController rMotor2 = new Talon(RobotMap.DRIVE_RIGHT_2);
    SpeedController rMotor3 = new Talon(RobotMap.DRIVE_RIGHT_3);
    private final Encoder leftEncoder = new Encoder(RobotMap.DRIVE_LEFT_ENC_A, RobotMap.DRIVE_LEFT_ENC_B);
    private final Encoder rightEncoder = new Encoder(RobotMap.DRIVE_RIGHT_ENC_A, RobotMap.DRIVE_RIGHT_ENC_B);
    private PIDController leftVPID = new PIDController(RobotMap.DRIVE_KP, RobotMap.DRIVE_KI, RobotMap.DRIVE_KD, (VelocityEncoder)leftEncoder, lMotor1);
    private PIDController rightVPID = new PIDController(RobotMap.DRIVE_KP, RobotMap.DRIVE_KI, RobotMap.DRIVE_KD, (VelocityEncoder)rightEncoder, rMotor1);




    public DriveTrain() {
        leftEncoder.start();
        rightEncoder.start();
        //gyro.reset();
        leftVPID.enable();
        rightVPID.enable();
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DTManualTankCmd());
    }

    public double getDistance() {
        return 0.0;
    }




    public void driveLR(double lPower, double rPower) {
          leftVPID.setSetpoint(RobotMap.ROBOT_MAX_SPEED*lPower);
          rightVPID.setSetpoint(RobotMap.ROBOT_MAX_SPEED*rPower);
//        lMotor.set(lPower);
//        rMotor.set(rPower);

    }

    public void driveCheesy(double throttle, double wheel, boolean quickTurn) {
        double angularPower;
        double overPower;
        double rPower;
        double lPower;

        if(quickTurn) {
            overPower = 1.0;
            angularPower = wheel;
        }
        else {
            overPower = 0.0;
            angularPower = throttle * wheel * tSens;
        }
        rPower = throttle;
        lPower = throttle;
        lPower += angularPower;
        rPower -= angularPower;
        if(lPower > 1.0) {
           rPower -= overPower * (lPower - 1.0);
           lPower = 1.0;
        }
        else if(rPower > 1.0) {
          lPower -= overPower * (rPower - 1.0);
          rPower = 1.0;
        }
        else if(lPower < -1.0) {
            rPower += overPower * (-1.0 - rPower);
            lPower = -1.0;
        }
        else if (rPower < -1.0) {
            lPower += overPower * (-1.0 - rPower);
            rPower = -1.0;
        }
        driveLR(-lPower, rPower);
    }

    public void stop() {
        driveLR(0,0);
    }
}

