/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nutrons.aerialassist.commands.shooter;
import com.nutrons.aerialassist.commands.intake.ClampsDownCmd;
import com.nutrons.aerialassist.commands.intake.ClampsUpCmd;
import com.nutrons.aerialassist.commands.intake.DeployIntakeCmd;
import com.nutrons.aerialassist.commands.intake.RetractIntakeCmd;
//import com.nutrons.aerialassist.commands.intake.VacuumCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterUnwindCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 */
public class ShooterFireCmd extends CommandGroup {

    public ShooterFireCmd() {
        addSequential(new ClampsUpCmd());
        //addSequential(new DeployIntakeCmd());
        //addSequential(new WaitCommand(1.0));
        addSequential(new ShooterUnwindCmd());
        addSequential(new WaitCommand(0.75));
//        addSequential(new ShooterLoadCmd());
        addSequential(new ClampsDownCmd());

    }
}
