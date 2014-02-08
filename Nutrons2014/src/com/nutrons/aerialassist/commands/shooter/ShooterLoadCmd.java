/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.shooter;

import com.nutrons.aerialassist.commands.intake.DeployIntakeCmd;
import com.nutrons.aerialassist.commands.intake.RetractIntakeCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 */
public class ShooterLoadCmd extends CommandGroup {

    public ShooterLoadCmd() {
        addSequential(new DeployIntakeCmd());
        addSequential(new WaitCommand(1.5));
        addSequential(new ShooterWindCmd());
        addSequential(new RetractIntakeCmd());
    }
}
