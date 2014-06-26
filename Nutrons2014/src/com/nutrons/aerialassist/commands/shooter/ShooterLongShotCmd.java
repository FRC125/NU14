package com.nutrons.aerialassist.commands.shooter;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 */
public class ShooterLongShotCmd extends CommandGroup {

    public ShooterLongShotCmd() {
        addSequential(new HardStopUnlockCmd());
        addSequential(new WaitCommand(1));
        addSequential(new HardStopDeployCmd());
        addSequential(new WaitCommand(1));
        addSequential(new HardStopLockCmd());
        addSequential(new WaitCommand(1));
    }
}
