/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 */
public class SpitIntakeCmd extends CommandGroup {

    public SpitIntakeCmd() {
        addSequential(new DeployIntakeCmd());
        addSequential(new FireGateLatchesCmd());
        addSequential(new WaitCommand(0.5));
        addSequential(new RetractIntakeCmd());
        addSequential(new ReverseRollersCmd());
    }
}