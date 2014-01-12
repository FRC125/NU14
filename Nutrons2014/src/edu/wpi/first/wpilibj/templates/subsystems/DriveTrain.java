
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 */
public class DriveTrain extends Subsystem {
   
    private double tSens = 1;
    
    public final double LEFT_SCALE = 1.0;
    public final double RIGHT_SCALE = 1.0;
    
    // robot parts
    Talon lMotor1 = new Talon(RobotMap.DRIVE_LEFT_MOTOR_1);
    Talon lMotor2 = new Talon(RobotMap.DRIVE_LEFT_MOTOR_2);
    Talon lMotor3 = new Talon(RobotMap.DRIVE_LEFT_MOTOR_2);    
    Talon rMotor1 = new Talon(RobotMap.DRIVE_RIGHT_MOTOR_1);
    Talon rMotor2 = new Talon(RobotMap.DRIVE_RIGHT_MOTOR_2);
    Talon rMotor3 = new Talon(RobotMap.DRIVE_RIGHT_MOTOR_3);
    
    public void initDefaultCommand() {
    }
    
    public void driveLR(double lPower, double rPower) {
        lMotor1.set(LEFT_SCALE * lPower);
        lMotor2.set(LEFT_SCALE * lPower);
        lMotor3.set(LEFT_SCALE * lPower);
        rMotor1.set(RIGHT_SCALE * rPower);
        rMotor2.set(RIGHT_SCALE * rPower);
        rMotor3.set(RIGHT_SCALE * rPower);
        System.out.println("Left Drivetrain: " + (LEFT_SCALE * lPower));
        System.out.println("Right Drivetrain: " + (RIGHT_SCALE * lPower));
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
        driveLR(lPower, rPower);   
    }
    
    public void stop() {
        driveLR(0,0);
    }
}

