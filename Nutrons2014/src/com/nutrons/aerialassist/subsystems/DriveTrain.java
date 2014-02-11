
package com.nutrons.aerialassist.subsystems;

import com.nutrons.aerialassist.RobotMap;
import com.nutrons.aerialassist.commands.drivetrain.DTManualTankCmd;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

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
    Ultrasonic ultrasonicSensor = new Ultrasonic(RobotMap.PING_CHANNEL, RobotMap.ECHO_CHANNEL);

    public DriveTrain() {
        leftEncoder.start();
        rightEncoder.start();
        ultrasonicSensor.setDistanceUnits(Ultrasonic.Unit.kInches);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DTManualTankCmd());
    }

    public double getDistance() {
        return ultrasonicSensor.getRangeInches();
    }

    private double[] filterDrive(double lPower, double rPower)
    {
        double leftForward = 1.25;
        double leftBackwards = 1.0;
        double rightForward = 1.0;
        double rightBackwards = 1.4;
        if(lPower > 0) {
            lPower *= leftForward;

        }

        if(lPower < 0) {
            lPower *= leftBackwards;

        }

        if(rPower > 0) {
            rPower *= rightForward;

        }

        if(rPower < 0) {
            rPower *= rightBackwards;
        }
        double powers[] = {lPower, rPower};
        return powers;
    }
    public void driveLR(double lPower, double rPower) {
        double powers[] = filterDrive(lPower, rPower);
        lPower = powers[0];
        rPower = powers[1];
        lMotor1.set(lPower);
        lMotor2.set(lPower);
        lMotor3.set(rPower);
        rMotor1.set(rPower);
        rMotor2.set(lPower);
        rMotor3.set(rPower);
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
            angularPower = Math.abs(throttle) * wheel * tSens;
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

