/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.auto;

import com.nutrons.aerialassist.commands.drivetrain.DriveTimeCmd;
import com.nutrons.aerialassist.commands.intake.AcquireBallCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterFireCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterWindCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class AutoTwoBall extends CommandGroup {

    public AutoTwoBall() {
        addSequential(new ShooterFireCmd());
        addSequential(new ShooterWindCmd());
        addSequential(new AcquireBallCmd());
        addSequential(new ShooterFireCmd());
        addSequential(new DriveTimeCmd(1));
    }
}
