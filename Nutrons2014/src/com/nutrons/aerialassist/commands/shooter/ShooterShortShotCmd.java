/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 */
public class ShooterShortShotCmd extends CommandGroup {

    public ShooterShortShotCmd() {
        addSequential(new HardStopUnlockCmd());
        addSequential(new WaitCommand(1));
        addSequential(new HardStopRetractCmd());
        addSequential(new WaitCommand(1));
        addSequential(new HardStopLockCmd());
    }
}
