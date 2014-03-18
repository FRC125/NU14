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
    private double targetRightDistance, targetLeftDistance;
    private double initRightDistance, initLeftDistance;
    private double ref;
    private double epsilon = 0.1;

    public AutoDriveDistanceCmd(double distance) {
        requires(dt);
        initRightDistance = dt.getRightDistance();
        initLeftDistance= dt.getLeftDistance();
        targetRightDistance =  distance + initRightDistance;
        targetLeftDistance = distance + initLeftDistance;
        ref = distance;
        dt.resetEncoders();
        dt.startEncoders();
    }

    protected void initialize() {
        System.out.println("Target Distance: " + targetRightDistance);
    }

    protected void execute() {
        double lPow = (targetLeftDistance - dt.getLeftDistance())/ref*Kp;
        double rPow = (targetRightDistance - dt.getRightDistance())/ref*Kp;
        dt.driveLR(lPow, rPow); // before: left was positive and right was positive too
    }

    protected boolean isFinished() {
        return Math.abs(targetRightDistance - dt.getRightDistance()) < epsilon && Math.abs(targetLeftDistance - dt.getLeftDistance()) < epsilon;
    }

    protected void end() {
        dt.stop();
    }

    protected void interrupted() {
        end();
    }
}
