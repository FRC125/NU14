/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.intake;

import com.nutrons.aerialassist.commands.CommandBase;

/**
 *
 * @author NUTRONs
 */
public class VacuumCmd extends CommandBase {
    private boolean on;

    public VacuumCmd(boolean on) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.on = on;
    }

    public VacuumCmd() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(on) {
            vacuum.suck();
        }else {
            vacuum.off();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
