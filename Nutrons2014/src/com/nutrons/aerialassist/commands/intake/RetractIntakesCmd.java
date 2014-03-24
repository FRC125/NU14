package com.nutrons.aerialassist.commands.intake;
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
public class RetractIntakesCmd extends CommandGroup {

    public RetractIntakesCmd() {
        addSequential(new RetractIntakeCmd());
        addSequential(new WaitCommand(0.1));
        addSequential(new ActivateRollersCmd());
        addSequential(new WaitCommand(0.7));
        addSequential(new ClampsDownCmd());
        addSequential(new StopRollersCmd());
    }
}
