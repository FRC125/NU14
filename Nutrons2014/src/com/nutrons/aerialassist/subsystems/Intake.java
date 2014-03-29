/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.subsystems;

import com.nutrons.aerialassist.RobotMap;
import edu.wpi.first.wpilibj.*;
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
    private DigitalInput sensor = new DigitalInput(RobotMap.INTAKE_BUMPER);
    public DigitalInput deployedSensor = new DigitalInput(RobotMap.INTAKE_DEPLOYED);
    private Solenoid clamps = new Solenoid(RobotMap.CLAMPS);
    private Solenoid gateLatches = new Solenoid(RobotMap.GATE_LATCHES);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void setMotorSpeed(double speed) {
        intakeMotor.set(speed);
    }
    public void deploy() {
        dropDown.set(DoubleSolenoid.Value.kReverse);
    }
    public void retract() {
        dropDown.set(DoubleSolenoid.Value.kForward);
    }
    public boolean isBallAcquired() {
        return !sensor.get();
    }

    public boolean isDeployed() {
        System.out.println("Intake Deployed: " + deployedSensor.get());
        return !deployedSensor.get();
    }

    public void deployClamp() {
        clamps.set(true);
    }

    public void retractClamp() {
        clamps.set(false);
    }

    public void fireGateLatches() {
        gateLatches.set(true);
    }

    public void releaseGateLatches() {
        gateLatches.set(false);
    }
}
