/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nutrons.aerialassist.subsystems;

import com.nutrons.aerialassist.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author johnpetryk
 */
public class Shooter extends Subsystem {

    Talon motor1 = new Talon(RobotMap.SHOOTER_MOTOR_1);
    Talon motor2 = new Talon(RobotMap.SHOOTER_MOTOR_2);

    Solenoid disengagePiston = new Solenoid(RobotMap.DISENGAGE_PISTON);
    Solenoid pawlPiston = new Solenoid(RobotMap.PAWL_PISTON);

    protected void initDefaultCommand() {

    }

    public void windUp() {
        
    }

    public void disengagePiston() {
        
    }

    public void engagePiston() {

    }
    
    public void retractPawl() {
        
    }
    
    public void extendPawl() {
        
    }
}
