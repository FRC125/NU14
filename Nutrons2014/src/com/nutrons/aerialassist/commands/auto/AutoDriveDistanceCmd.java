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

    public final double Kp = 1.0;
    private double targetDistance;
    private double initDistance;
    private double epsilon = 0.1;

    public AutoDriveDistanceCmd(double distance) {
        requires(dt);
        initDistance = dt.getDistance();
        targetDistance = distance + initDistance;
    }

    protected void initialize() {
    }

    protected void execute() {
        dt.driveLR((targetDistance-dt.getDistance())*Kp, (targetDistance-dt.getDistance())*Kp);
    }

    protected boolean isFinished() {
        return Math.abs(dt.getDistance() - targetDistance) < epsilon;
    }

    protected void end() {
        dt.stop();
    }

    protected void interrupted() {
        end();
    }




}
