/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.subsystems;

import com.nutrons.aerialassist.RobotMap;
import com.nutrons.aerialassist.commands.WinchTestCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterTestCmd;
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
    private DigitalInput sensor = new DigitalInput(RobotMap.WINCH_SENSOR);
    private boolean readyToFire = false;
    public final int FORWARDS = 1;

    private DebouncedBoolean ready = new DebouncedBoolean(3);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommantd(new MySpecialCommand());
        setDefaultCommand(new ShooterTestCmd());
    }
    public boolean isWound() {
        ready.feed(!sensor.get());
        return ready.get();
    }
    public boolean isReady() {
        return readyToFire;
    }
    public void setReady(boolean ready) {
        readyToFire = ready;
    }
    public void setSpeed(double speed)
    {
        motor1.set(speed);
        motor2.set(speed);
    }
}
