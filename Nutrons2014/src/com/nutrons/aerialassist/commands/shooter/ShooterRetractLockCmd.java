/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nutrons.aerialassist.commands.shooter;

import com.nutrons.aerialassist.commands.CommandBase;

/**
 *
 * @author John
 */
public class ShooterRetractLockCmd extends CommandBase {

    public ShooterRetractLockCmd() {
        requires(catapult);
    }

    protected void initialize() {
    }

    protected void execute() {
        catapult.retractCandyCane();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {

    }

    protected void interrupted() {

    }

}
