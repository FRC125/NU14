/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.shooter;

import com.nutrons.aerialassist.commands.CommandBase;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 * @author NUTRONs
 */
public class ShooterUnwindCmd extends CommandBase {

    public ShooterUnwindCmd() {
        requires(catapult);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (!catapult.isWound()) {
            this.getGroup().cancel();
            this.end();
            
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        catapult.setSpeed(catapult.FORWARDS);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return catapult.isFired();
    }

    // Called once after isFinished returns true
    protected void end() {
        catapult.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        this.end();
    }
}
