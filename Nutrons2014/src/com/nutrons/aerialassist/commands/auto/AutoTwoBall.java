/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.auto;

import com.nutrons.aerialassist.commands.intake.*;
import com.nutrons.aerialassist.commands.shooter.ShooterFireCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterLoadCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterWindCmd;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 */
public class AutoTwoBall extends CommandGroup {

    public AutoTwoBall() {
        /*
         * addSequential(new ShooterFireCmd()); addSequential(new
         * ShooterWindCmd()); addSequential(new AcquireBallCmd());
         * addSequential(new WaitCommand(5)); addSequential(new
         * StopRollersCmd()); addSequential(new ShooterFireCmd());
         * addSequential(new AutoDriveTimeCmd(1)); addSequential(new
         * ShooterWindCmd());
         */
        addSequential(new DeployIntakeCmd());
        addSequential(new WaitCommand(1));
        addSequential(new RetractIntakesCmd());
        addSequential(new ActivateRollersTimeCmd(1));
        addSequential(new WaitCommand(1));
        addSequential(new ShooterFireCmd());
        addSequential(new ShooterLoadCmd());
        addSequential(new AcquireBallCmd());
        addSequential(new WaitCommand(1));
        addSequential(new StopIntakeCmd());
        addSequential(new WaitCommand(.5));
        addSequential(new ShooterFireCmd());
        addSequential(new ShooterLoadCmd());
        addParallel(new AutoDriveTimeCmd(0.75));
    }
}
