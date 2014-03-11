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
public class AcquireBallCmd extends CommandGroup {

    public AcquireBallCmd() {
        addParallel(new ClampsUpCmd());
        addParallel(new DeployIntakeCmd());
        addParallel(new ActivateRollersCmd());
    }
}
