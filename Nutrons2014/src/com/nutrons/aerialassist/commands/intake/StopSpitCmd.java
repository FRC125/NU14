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
public class StopSpitCmd extends CommandGroup {

    public StopSpitCmd() {
        addSequential(new StopRollersCmd());
        addSequential(new DeployIntakeCmd());
        addSequential(new WaitCommand(0.5));
        addSequential(new RetractGateLatchesCmd());
        addSequential(new RetractIntakeCmd());
    }

}