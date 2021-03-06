/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.auto;

import com.nutrons.aerialassist.commands.intake.*;
import com.nutrons.aerialassist.commands.shooter.ShooterFireCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterLoadCmd;
import com.nutrons.aerialassist.subsystems.Catapult;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 */
public class AutoTwoBall extends CommandGroup {

    public AutoTwoBall() {
       //addSequential(new WaitCommand(0.3));
       boolean hot = Catapult.isHot();
       addSequential(new DeployIntakeCmd());
       addSequential(new WaitCommand(0.4));
       addSequential(new ActivateRollersCmd()); // tune this
       addSequential(new ClampsDownCmd());
       addSequential(new WaitCommand(0.4));
       addSequential(new AutoDriveTimeCmd(1.85));
       addSequential(new RollerStopCmd());
       addSequential(new ClampsUpCmd());
       addSequential(new WaitCommand(0.7));
       addSequential(new ClampsDownCmd());
       addSequential(new WaitCommand(0.5)); // this value may have to change it's the delay after we stop driving
       addSequential(new ShooterFireCmd());
       addSequential(new WaitCommand(0.3));
       addSequential(new ShooterLoadCmd());
       addSequential(new DeployIntakeCmd());
       addSequential(new ActivateRollersCmd());
       addSequential(new WaitCommand(1.1));
       addSequential(new RollerStopCmd());
       addSequential(new RetractIntakesCmd());
       addSequential(new ClampsDownCmd());
       addSequential(new WaitCommand(.6));
       addSequential(new ShooterFireCmd());
       addSequential(new WaitCommand(0.5));
       addSequential(new ShooterLoadCmd());
    }
}
