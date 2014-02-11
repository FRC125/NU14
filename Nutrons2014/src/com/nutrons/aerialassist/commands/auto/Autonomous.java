/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.nutrons.aerialassist.commands.auto.AutoDriveDistanceCmd;
import com.nutrons.aerialassist.commands.intake.AcquireBallCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterFireCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterLoadCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterWindCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class Autonomous extends CommandGroup {

    public Autonomous() {
        addSequential(new ShooterFireCmd());
        addSequential(new ShooterLoadCmd());
        addSequential(new AutoDriveDistanceCmd(5));
        addSequential(new AcquireBallCmd());
        addSequential(new AutoDriveDistanceCmd(-10));
        addSequential(new AutoDriveDistanceCmd(5));
        addSequential(new ShooterFireCmd());
    }
}
