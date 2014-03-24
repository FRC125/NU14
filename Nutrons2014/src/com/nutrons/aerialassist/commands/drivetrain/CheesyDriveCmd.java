/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.drivetrain;

import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;
import com.nutrons.aerialassist.commands.CommandBase;

/**
 *
 * @author Nutrons
 */
public class CheesyDriveCmd extends CommandBase {

    public CheesyDriveCmd() {
        requires(dt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println(-oi.getDriveWheel());
        try {
            dt.driveCheesy(oi.getDriveThrottle(),-oi.getDriveWheel(), oi.getDriveQuickTurn());
        } catch (EnhancedIOException ex) {
        }
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
