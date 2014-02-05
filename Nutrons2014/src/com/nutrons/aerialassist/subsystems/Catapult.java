/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.subsystems;

import com.nutrons.aerialassist.RobotMap;
import com.nutrons.aerialassist.commands.WinchTestCmd;
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
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommantd(new MySpecialCommand());
        setDefaultCommand(new WinchTestCmd());
    }
    public void setSpeed(double speed)
    {
        motor1.set(speed);
        motor2.set(speed);
    }
}
