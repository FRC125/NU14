/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.subsystems;

import com.nutrons.aerialassist.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author NUTRONs
 */
public class Intake extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public final double FORWARDS = 1.0;
    private SpeedController intakeMotor = new Talon(RobotMap.INTAKE_MOTOR);
    private DoubleSolenoid dropDown = new DoubleSolenoid(RobotMap.INTAKE_PISTON, RobotMap.INTAKE_UP_PISTON);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void setMotorSpeed(double speed){
        intakeMotor.set(speed);
    }

    public void deploy()
    {
        dropDown.set(DoubleSolenoid.Value.kForward);
    }
    public void retract()
    {
        dropDown.set(DoubleSolenoid.Value.kReverse);
    }
}
