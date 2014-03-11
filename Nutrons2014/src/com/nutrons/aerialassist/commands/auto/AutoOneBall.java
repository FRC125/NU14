/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.auto;

import com.nutrons.aerialassist.commands.auto.AutoDriveDistanceCmd;
import com.nutrons.aerialassist.commands.intake.*;
import com.nutrons.aerialassist.commands.shooter.ShooterFireCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterLoadCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterWindCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 */
public class AutoOneBall extends CommandGroup {

    public AutoOneBall() {
        addSequential(new WaitCommand(0.3));
        addSequential(new WaitForHotGoalCmd());
        addSequential(new DeployIntakeCmd());
        addSequential(new WaitCommand(1));
        addSequential(new RetractIntakesCmd());
        addSequential(new ActivateRollersTimeCmd(1));
        addSequential(new WaitCommand(1));
        addSequential(new ShooterFireCmd());
        addSequential(new ShooterLoadCmd());
        addParallel(new AutoDriveTimeCmd(0.75));
    }
}
