/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.lib;

/**
 *
 * @author Nutrons
 */
public class Utils {
    // If a value is within center +- deadband then it returns center. Else it returns the value.
    public static double deadband(double value, double deadband, double center) {
        return (value < (center + deadband) && value > (center - deadband)) ? center : value;
    }
    
    // Limits the number to be within min and max.
    public static double limit(double x, double min, double max) {
        return Math.max(Math.min(x, max), min);
    }
}
