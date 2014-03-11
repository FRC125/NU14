package com.nutrons.aerialassist.commands.auto;
import com.nutrons.aerialassist.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NUTRONs
 */
public class WaitForHotGoalCmd extends CommandBase {

    double time;
    Timer timerAuto;
    boolean state;

    public WaitForHotGoalCmd() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timerAuto = new Timer();
        state = false;
        time = 4.0;
        timerAuto.reset();
        timerAuto.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (timerAuto.get() >= time || catapult.isHot() == true) {
            state = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return state;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
