/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class ShooterLoadCmd extends CommandGroup {

    public ShooterLoadCmd() {
        //addSequential(new WaitCommand(1.0));
        addSequential(new ShooterWindCmd());
        addSequential(new ShooterExtendLockCmd());
    }
}
