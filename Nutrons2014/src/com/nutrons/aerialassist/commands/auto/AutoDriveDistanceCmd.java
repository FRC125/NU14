/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nutrons.aerialassist.commands.auto;

import com.nutrons.aerialassist.commands.CommandBase;

/**
 *
 * @author John
 */
public class AutoDriveDistanceCmd extends CommandBase {
    public final double Kp = 2.0;
    private double targetDistance;
    private double initDistance;
    private double ref;
    private double epsilon = 0.1;

    public AutoDriveDistanceCmd(double distance) {
        requires(dt);
        initDistance = dt.getDistance();
        targetDistance =  distance + initDistance;
        ref = distance;
        dt.resetEncoders();
        dt.startEncoders();
    }

    protected void initialize() {
    }

    protected void execute() {
        double pow = (targetDistance - dt.getDistance())/ref*Kp;
        dt.driveLR(pow, pow); // before: left was positive and right was positive too
    }

    protected boolean isFinished() {
        return Math.abs(targetDistance - dt.getDistance()) < epsilon;
    }

    protected void end() {
        dt.stop();
    }

    protected void interrupted() {
        end();
    }
}
