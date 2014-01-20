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
 * @author camilo
 */
public class Shooter extends Subsystem {
   
    
   Solenoid launch = new Solenoid(RobotMap.LAUNCH);
   Talon holder = new Talon(RobotMap.HOLDER);
     
    protected void initDefaultCommand() {
        
    }
    
    public void load() {
        holder.set(1); // TODO: adjust this
    }
    
    public void shoot() {
        holder.set(0); // TODO: adjust this
    }
      
    public void hardStop() {
        launch.set(true);
    }
    
    public void softStop() {
        launch.set(false);
    }
}
