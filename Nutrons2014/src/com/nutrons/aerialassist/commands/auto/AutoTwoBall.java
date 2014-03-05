/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.auto;

import com.nutrons.aerialassist.commands.intake.AcquireBallCmd;
import com.nutrons.aerialassist.commands.intake.ClampsDownCmd;
import com.nutrons.aerialassist.commands.intake.ClampsUpCmd;
import com.nutrons.aerialassist.commands.intake.DeployIntakeCmd;
import com.nutrons.aerialassist.commands.intake.RetractIntakeCmd;
import com.nutrons.aerialassist.commands.intake.StopRollersCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterFireCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterLoadCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterWindCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 */
public class AutoTwoBall extends CommandGroup {

    public AutoTwoBall() {
        /*
        addSequential(new ShooterFireCmd());
        addSequential(new ShooterWindCmd());
        addSequential(new AcquireBallCmd());
        addSequential(new WaitCommand(5));
        addSequential(new StopRollersCmd());
        addSequential(new ShooterFireCmd());
        addSequential(new AutoDriveTimeCmd(1));
        addSequential(new ShooterWindCmd());
        */
        addSequential(new DeployIntakeCmd());
        addSequential(new RetractIntakeCmd());
        addSequential(new ShooterFireCmd());
        addSequential(new ShooterLoadCmd());
        addSequential(new AcquireBallCmd());
        addSequential(new WaitCommand(1));
        addSequential(new RetractIntakeCmd());
        addSequential(new ShooterFireCmd());
        addSequential(new ShooterLoadCmd());
        addParallel(new AutoDriveTimeCmd(0.75));       
    }
}
