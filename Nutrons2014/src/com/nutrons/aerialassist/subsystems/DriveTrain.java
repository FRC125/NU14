package com.nutrons.aerialassist.subsystems;

import com.nutrons.aerialassist.RobotMap;
import com.nutrons.aerialassist.commands.drivetrain.DTManualTankCmd;
import com.nutrons.lib.MultiMotor;
import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Camilo
 */
public class DriveTrain extends Subsystem {

    private double tSens = 1;

    public final double LEFT_SCALE = 1.0;
    public final double RIGHT_SCALE = -1.0;

    // robot parts
    Gyro gyro = new Gyro(RobotMap.DRIVETRAIN_GYRO);
    AnalogModule ultrasonic = new AnalogChannel(RobotMap.ULTRASONIC).getModule();

    MultiMotor lMotor = new MultiMotor(new int[]{RobotMap.DRIVE_LEFT_1, RobotMap.DRIVE_LEFT_2, RobotMap.DRIVE_LEFT_3});
    MultiMotor rMotor = new MultiMotor(new int[]{RobotMap.DRIVE_RIGHT_1, RobotMap.DRIVE_RIGHT_2, RobotMap.DRIVE_RIGHT_3});
    private final Encoder leftEncoder = new Encoder(RobotMap.DRIVE_LEFT_ENC_A, RobotMap.DRIVE_LEFT_ENC_B);
    private final Encoder rightEncoder = new Encoder(RobotMap.DRIVE_RIGHT_ENC_A, RobotMap.DRIVE_RIGHT_ENC_B);
    private final PIDController leftPID = new PIDController(RobotMap.DRIVE_KP, RobotMap.DRIVE_KI, RobotMap.DRIVE_KD, RobotMap.DRIVE_F, leftEncoder, lMotor);
    private final PIDController rightPID = new PIDController(RobotMap.DRIVE_KP, RobotMap.DRIVE_KI, RobotMap.DRIVE_KD, RobotMap.DRIVE_F, rightEncoder, rMotor);

    public DriveTrain() {
        leftEncoder.setPIDSourceParameter(PIDSource.PIDSourceParameter.kRate);
        rightEncoder.setPIDSourceParameter(PIDSource.PIDSourceParameter.kRate);
        final double distancePerPulse = 3.14 * 4 / 360.0 / 12.0;
        leftEncoder.setDistancePerPulse(distancePerPulse);
        rightEncoder.setDistancePerPulse(distancePerPulse);

        leftEncoder.start();
        rightEncoder.start();

        leftEncoder.setDistancePerPulse(4 * 3.14/360);
        rightEncoder.setDistancePerPulse(4 * 3.14/360);

        leftPID.enable();
        rightPID.enable();
        //gyro.reset();

    }

    public void initDefaultCommand() {
        setDefaultCommand(new DTManualTankCmd());
    }

    public double getRightDistance() {
        return rightEncoder.get();
    }

    public double getLeftDistance() {
        return leftEncoder.get();
    }

    public void driveLR(double lPower, double rPower) {
       getLeftVPID().setSetpoint(RobotMap.ROBOT_MAX_SPEED * lPower);
        getRightVPID().setSetpoint(RobotMap.ROBOT_MAX_SPEED * rPower);
        //System.out.println("R: " + rightEncoder.getRate()+ " L: " + leftEncoder.getRate());

//        lMotor.set(lPower);
//        rMotor.set(rPower);

    }

    public double mapJoystickToPowerOutput(double input) {
        if (Math.abs(input) < 0.05) {
            // Stop if joystick is near zero
            return 0.0;
        } else {
            double mapping;
            if (Math.abs(input) <= 0.75) {
                mapping = 0.95 * ((0.5 * MathUtils.pow(Math.abs(input), 2.0)) + 0.2);
                mapping = (input >= 0) ? mapping : -mapping; // Change to negative if the input was negative
                return mapping;
            } else {
                mapping = 2.16 * Math.abs(input) - 1.16;
                mapping = (input >= 0) ? mapping : -mapping; // Change to negative if the input was negative
                return mapping;
            }
        }
    }

    public void driveCheesy(double throttle, double wheel, boolean quickTurn) {
        double angularPower;
        double overPower;
        double rPower;
        double lPower;

        if (quickTurn) {
            overPower = 1.0;
            angularPower = wheel;
        } else {
            overPower = 0.0;
            angularPower = throttle * wheel * tSens;
        }
        rPower = throttle;
        lPower = throttle;
        lPower += angularPower;
        rPower -= angularPower;
        if (lPower > 1.0) {
            rPower -= overPower * (lPower - 1.0);
            lPower = 1.0;
        } else if (rPower > 1.0) {
            lPower -= overPower * (rPower - 1.0);
            rPower = 1.0;
        } else if (lPower < -1.0) {
            rPower += overPower * (-1.0 - rPower);
            lPower = -1.0;
        } else if (rPower < -1.0) {
            lPower += overPower * (-1.0 - rPower);
            rPower = -1.0;
        }
        driveLR(-lPower, rPower);
    }

    public void stop() {
        driveLR(0, 0);
    }

    public Encoder getLeftEncoder() {
        return leftEncoder;
    }

    public Encoder getRightEncoder() {
        return rightEncoder;
    }

    public void resetRightEncoder() {
        rightEncoder.reset();
    }

    public void resetLeftEncoder() {
        leftEncoder.reset();
    }

    public PIDController getLeftVPID() {
        return leftPID;
    }

    public PIDController getRightVPID() {
        return rightPID;
    }

    public void startEncoders() {
        leftEncoder.start();
        rightEncoder.start();
    }

    public void resetEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
    }
     public double convertToInches() {
        return (double)(ultrasonic.getAverageVoltage(4)*1000.0/9.4);
    }
}
