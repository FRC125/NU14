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
    private static DigitalInput isHot = new DigitalInput(RobotMap.BANNERED_SENSOR);
    public final double FORWARDS = -0.85;
    private DebouncedBoolean ready = new DebouncedBoolean(3);
    private DebouncedBoolean fired = new DebouncedBoolean(1);
    double scaling[] = {0.0, 0.0, 0.0, 0.0, 0.1, 0.1, 0.1, 0.2, 0.2, 0.2, 0.4, 0.4, 1};

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ShooterStopCmd());
    }

    public boolean isWound() {
        ready.feed(!isWound.get());
        return ready.get();
    }

    public boolean isFired() {
        fired.feed(!isFired.get());
        return fired.get();
    }

    public void setSpeed(double speed) {
        motor1.set(speed);
        motor2.set(speed);
    }

    public static boolean isHot() {
        return isHot.get();
    }

    public double scalingPowerForwards() {
        double pow = 0;
        for (int i = 0; i < 13; i++) {
            pow = scaling[i] * FORWARDS;
            System.out.println(pow);

            return pow;

        }
        System.out.println(pow);

        return pow;
    }
}