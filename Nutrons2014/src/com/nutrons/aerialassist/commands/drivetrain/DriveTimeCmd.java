/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.drivetrain;

import com.nutrons.aerialassist.commands.CommandBase;

/**
 *
 * @author NUTRONs
 */
public class DriveTimeCmd extends CommandBase {

    double cmd_start;
    double time;
    public DriveTimeCmd(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        this.time = time;
        requires(dt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        cmd_start = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        dt.driveLR(0.75, -0.75);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() - cmd_start >= time * 1000.0;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
