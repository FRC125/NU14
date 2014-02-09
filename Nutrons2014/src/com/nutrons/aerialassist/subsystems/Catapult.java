/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.subsystems;

import com.nutrons.aerialassist.RobotMap;
import com.nutrons.aerialassist.commands.shooter.ShooterStopCmd;
import com.nutrons.lib.DebouncedBoolean;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author NUTRONs
 */
public class Catapult extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private SpeedController motor1 = new Talon(RobotMap.WINCH);
    private SpeedController motor2 = new Talon(RobotMap.WINCH2);
    private DigitalInput isWound = new DigitalInput(RobotMap.WINCH_SENSOR);
    private DigitalInput isFired = new DigitalInput(RobotMap.FIRED_SENSOR);
    public final double FORWARDS = -0.5;


    private DebouncedBoolean ready = new DebouncedBoolean(1);
    private DebouncedBoolean fired = new DebouncedBoolean(1);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ShooterStopCmd());
    }
    public boolean isWound() {
        ready.feed(!isWound.get());
        return ready.get();
    }
    
    public boolean  isFired(){
        fired.feed(!isFired.get());
        return fired.get();
    }
    public void setSpeed(double speed)
    {
        motor1.set(speed);
        motor2.set(speed);
    }
}
