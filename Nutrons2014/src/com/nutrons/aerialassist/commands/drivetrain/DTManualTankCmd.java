
package com.nutrons.aerialassist.commands.drivetrain;

import com.nutrons.aerialassist.commands.CommandBase;
import com.nutrons.aerialassist.subsystems.Intake;

/**
 *
 * @author camilo
 */
public class DTManualTankCmd extends CommandBase {

    public DTManualTankCmd() {
        requires(dt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        dt.driveLR(oi.getDriveLeft(), oi.getDriveRight());
        //System.out.println("Left Encoder: " + dt.getLeftEncoder().get() + " Right Encoder: " + dt.getRightEncoder().get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
