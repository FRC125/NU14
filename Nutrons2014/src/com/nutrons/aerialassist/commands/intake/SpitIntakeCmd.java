/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class SpitIntakeCmd extends CommandGroup {

    public SpitIntakeCmd() {
        addSequential(new FireGateLatchesCmd());
        addSequential(new DeployIntakeCmd());
        addSequential(new ReverseRollersCmd());
    }
}
