/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.auto;

import com.nutrons.aerialassist.commands.auto.AutoDriveDistanceCmd;
import com.nutrons.aerialassist.commands.drivetrain.DriveTimeCmd;
import com.nutrons.aerialassist.commands.intake.AcquireBallCmd;
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
        addSequential(new ShooterFireCmd());
        //addSequential(new ShooterLoadCmd());
        addSequential(new AutoDriveTimeCmd(2.0));
        addSequential(new WaitCommand(0.1));
        addParallel(new ShooterWindCmd());
    }
}
