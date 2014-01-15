
package com.nutrons.aerialassist.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.nutrons.aerialassist.RobotMap;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PIDController;

/**
 * @author Camilo
 */
public class DriveTrain extends Subsystem {
   
    private double tSens = 1;
    
    public final double LEFT_SCALE = 1.0;
    public final double RIGHT_SCALE = 1.0;

    // robot parts
    Talon lMotor = new Talon(RobotMap.DRIVE_LEFT);
    Talon rMotor = new Talon(RobotMap.DRIVE_RIGHT);
    Gyro gyro = new Gyro(RobotMap.DRIVETRAIN_GYRO);
    
    public void initDefaultCommand() {
    }
    
    public void driveLR(double lPower, double rPower) {
        lMotor.set(LEFT_SCALE * lPower);
        rMotor.set(RIGHT_SCALE * lPower);
        
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

