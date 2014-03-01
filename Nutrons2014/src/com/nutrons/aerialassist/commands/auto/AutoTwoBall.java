/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.auto;

import com.nutrons.aerialassist.commands.intake.AcquireBallCmd;
import com.nutrons.aerialassist.commands.intake.StopRollersCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterFireCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterWindCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 */
public class AutoTwoBall extends CommandGroup {

    public AutoTwoBall() {
        addSequential(new ShooterFireCmd());
        addSequential(new ShooterWindCmd());
        addSequential(new AcquireBallCmd());
        addSequential(new WaitCommand(5));
        addSequential(new StopRollersCmd());
        addSequential(new ShooterFireCmd());
        addSequential(new AutoDriveTimeCmd(1));
        addSequential(new ShooterWindCmd());
    }
}
