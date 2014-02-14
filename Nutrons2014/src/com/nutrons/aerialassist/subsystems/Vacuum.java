/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.nutrons.aerialassist.RobotMap;

/**
 *
 * @author NUTRONs
 */
public class Vacuum extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private SpeedController motor = new Talon(RobotMap.VACUUM);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void suck() {
        motor.set(1.0);
    }
    public void off() {
        motor.set(0.0);
    }
}
