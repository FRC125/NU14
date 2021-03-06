/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.aerialassist.commands.intake;

import com.nutrons.aerialassist.commands.CommandBase;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author NUTRONs
 */
public class ActivateRollersCmd extends CommandBase {

    Command pullBall = new StopIntakeCmd();
    double speed = intake.FORWARDS;

    public ActivateRollersCmd() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(intake);
    }

    public ActivateRollersCmd(double speed) {
        this.speed = speed;
        requires(intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        intake.retractClamp();
        intake.setMotorSpeed(speed);
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
        this.end();
    }
}
