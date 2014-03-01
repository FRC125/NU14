/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.auto;

import com.nutrons.aerialassist.commands.intake.AcquireBallCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterFireCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterWindCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author camilogonzalez
 */
public class AutoThreeBall extends CommandGroup {
    
    public AutoThreeBall() {
        addSequential(new ShooterFireCmd());
        addSequential(new ShooterWindCmd());
        addSequential(new AcquireBallCmd());
        addSequential(new WaitCommand(1));
        addSequential(new ShooterFireCmd());
        addSequential(new AutoDriveTimeCmd(1, -0.75));
        addSequential(new AutoDriveTimeCmd(1, 0.75));
        addSequential(new ShooterFireCmd());
        
    }
}
