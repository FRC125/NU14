/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.auto;

import com.nutrons.aerialassist.commands.intake.ClampsDownCmd;
import com.nutrons.aerialassist.commands.intake.DeployIntakeCmd;
import com.nutrons.aerialassist.commands.intake.RetractIntakeCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterFireCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterLoadCmd;
import com.nutrons.aerialassist.subsystems.Catapult;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 */
public class AutoOneBall extends CommandGroup {

    public AutoOneBall() {
        addSequential(new WaitCommand(0.3));
        boolean hot = Catapult.isHot();
        addSequential(new DeployIntakeCmd());
        addSequential(new WaitCommand(0.5));
        addSequential(new RetractIntakeCmd());
        addSequential(new ClampsDownCmd());
        addSequential(new WaitCommand(0.5));
        addSequential(new AutoDriveTimeCmd(1.75)); // must change this to AutoDriveDistance()
        if(hot) {
            addSequential(new ShooterFireCmd());
            addSequential(new WaitCommand(.5));
            addSequential(new ShooterLoadCmd());
        }else {
            addSequential(new WaitCommand(3));
            addSequential(new ShooterFireCmd());
            addSequential(new WaitCommand(.5));
            addSequential(new ShooterLoadCmd());
        }
    }
}
