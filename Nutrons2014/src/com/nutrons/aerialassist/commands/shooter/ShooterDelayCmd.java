/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.shooter;

import com.nutrons.aerialassist.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author aschreiber
 */
public class ShooterDelayCmd extends CommandBase {
    Timer timer = new Timer();
    double delay = 5.0;
    
    public ShooterDelayCmd() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(catapult);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        timer.start();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > delay || catapult.isHot();
    }

    // Called once after isFinished returns true
    protected void end() {
        timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}