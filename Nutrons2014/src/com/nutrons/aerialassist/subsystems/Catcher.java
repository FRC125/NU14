package com.nutrons.aerialassist.subsystems;

import com.nutrons.aerialassist.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author aschreiber
 */
public class Catcher extends Subsystem {
    private Solenoid wing = new Solenoid(RobotMap.WING);
    private boolean deployed = true;

    public void initDefaultCommand() {
    }
    
    public Catcher() {
    }
    
    public void deployWings() {
        wing.set(deployed);
    }
    
    public void retractWings() {
        wing.set(!deployed);
    }
}