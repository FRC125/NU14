/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.auto;

import com.nutrons.aerialassist.commands.CommandBase;

/**
 *
 * @author NUTRONs
 */
public class AutoDriveUltrasonic extends CommandBase {



    double targetDist, ref, dist;
    final double Kp = 1.0;
    final double epsilon = 2.0;

    public AutoDriveUltrasonic(double dist) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(dt);
        this.dist = dist;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        targetDist = Math.floor(dt.convertToInches()) - dist;
        ref = dist;
        System.out.println("target dist: " + targetDist + " dist: " + 10 + " actual dist: " + dt.convertToInches());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double pow = (dt.convertToInches() - targetDist)/ref * Kp;
        dt.driveLR(pow,pow);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(dt.convertToInches() - targetDist) < epsilon;
    }

    // Called once after isFinished returns true
    protected void end() {
        dt.driveLR(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}