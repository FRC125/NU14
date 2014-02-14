/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.auto;

import com.nutrons.aerialassist.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author John
 */
public class AutoDriveTimeCmd extends CommandBase {

    double time;
    Timer timer = new Timer();

    public AutoDriveTimeCmd(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(dt);
        this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.reset();
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        dt.driveLR(.5, .5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > time;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
