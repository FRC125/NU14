/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nutrons.aerialassist.subsystems;

import com.nutrons.aerialassist.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author johnpetryk
 */
public class Shooter extends Subsystem {
    
    private static final int LOW_POSITION = 1;
    private static final int HIGH_POSITION = 2;
    
    Talon motor1 = new Talon(RobotMap.SHOOTER_MOTOR_1);
    Talon motor2 = new Talon(RobotMap.SHOOTER_MOTOR_2);

    Solenoid disengagePiston = new Solenoid(RobotMap.DISENGAGE_PISTON);
    Solenoid pawlPiston = new Solenoid(RobotMap.PAWL_PISTON);

    DigitalInput lowWindUpLimit = new DigitalInput(RobotMap.LOW_WIND_UP_LIMIT);
    DigitalInput highWindUpLimit = new DigitalInput(RobotMap.HIGH_WIND_UP_LIMIT);
    
    protected void initDefaultCommand() {

    }

    public void windUp(int pos) {
        if(pos == LOW_POSITION) {
            if(!lowWindUpLimit.get()) {
               motor1.set(1);
               motor2.set(1);
            }
            else {
                motor1.set(0);
                motor2.set(0);
            }
        }
        else {
            if(!highWindUpLimit.get()) {
               motor1.set(1);
               motor2.set(1);
            }
            else {
                motor1.set(0);
                motor2.set(0);
            }
        }
    }

    public void disengagePiston() {
        disengagePiston.set(false);
    }

    public void engagePiston() {
        disengagePiston.set(true);
    }
    
    public void retractPawl() {
        pawlPiston.set(false);
    }
    
    public void extendPawl() {
        pawlPiston.set(true);
    }
}
