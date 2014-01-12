/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;



/**
 *
 * @author Nutrons
 */
public class Intake extends Subsystem {
    
    Talon rollers = new Talon(RobotMap.ROLLER_MOTOR);
    Solenoid deploy = new Solenoid(RobotMap.ROLLER_DEPLOY);
    
   public void deployIntake() {
       deploy.set(true);
   }
   
   public void retractIntake() {
       deploy.set(false);
   }
   
   public void setRollers(float power) {
       rollers.set(power);
   }
   
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
