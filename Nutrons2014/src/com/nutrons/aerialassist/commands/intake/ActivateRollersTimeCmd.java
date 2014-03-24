/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.intake;

import com.nutrons.aerialassist.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author NUTRONs
 */
public class ActivateRollersTimeCmd extends CommandBase {
    Timer timer;
    double time = 0;
    public ActivateRollersTimeCmd(double time) {
        requires(intake);
        this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer = new Timer();
        timer.reset();
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        intake.setMotorSpeed(intake.FORWARDS);
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
