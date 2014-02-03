/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.lib;

import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 * @author aschreiber
 */
public class VelocityEncoder extends Encoder {

    public VelocityEncoder(DigitalSource aSource, DigitalSource bSource) {
        super(aSource, bSource);
    }

    public VelocityEncoder(DigitalSource aSource, DigitalSource bSource, boolean reverseDirection) {
        super(aSource, bSource, reverseDirection);
    }

    public VelocityEncoder(int aChannel, int bChannel, boolean reverseDirection) {
        super(aChannel, bChannel, reverseDirection);
    }

//    So we're going to override it such that .pidGet (as called by PIDController
//    will return the rate instead of position. 
    public double pidGet() {
        return super.getRate();
    }
}
