/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class AutoDriveDistanceOnly extends CommandGroup {

    public AutoDriveDistanceOnly() {
        addParallel(new AutoDriveDistanceCmd(6));
    }
}
