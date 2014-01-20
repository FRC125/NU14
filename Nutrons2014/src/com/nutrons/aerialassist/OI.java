
package com.nutrons.aerialassist;

import com.nutrons.aerialassist.commands.shooter.LongShotCmd;
import com.nutrons.aerialassist.commands.shooter.ShootCmd;
import com.nutrons.aerialassist.commands.shooter.ShortShotCmd;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import com.nutrons.lib.Utils;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    //Joysticks
    private final Joystick driverPad = new Joystick(RobotMap.PAD_DRIVER);
    private final Joystick operatorPad = new Joystick(RobotMap.PAD_OPERATOR);
    // TODO: Adjust values
    private final int DRIVE_LEFT_AXIS = 0;
    private final int DRIVE_RIGHT_AXIS = 0;
    
    private DriverStationEnhancedIO io = DriverStation.getInstance().getEnhancedIO();
    
    public Button longShooterButton = new JoystickButton(operatorPad,3);
    public Button shortShooterButton = new JoystickButton(operatorPad,4);
     
    public OI() {
        longShooterButton.whenPressed(new LongShotCmd());
        shortShooterButton.whenPressed(new ShortShotCmd());
    }
    
     private double capAndBand(double value) {
        value = Utils.deadband(value, .075, -1);
        value = Utils.deadband(value, .075, 0);
        value = Utils.deadband(value, .075, 1);
        return Utils.limit(value, -1, 1);
    }
     
    private double scaleAnalog(double voltageIn) {
        double normalized = (2 * voltageIn / 3.25) - 1;
        return normalized;
    }
    
    private double getIOAnalog(int port) {
        double in;
        try {
            in = io.getAnalogIn(port);
        }
        catch(EnhancedIOException ex) {
            return 0;
        }
        double refined = capAndBand(scaleAnalog(in));
        return refined;
    }
    
    private boolean getIODigital(int port) {
        boolean in = false;
        try {
            in = !io.getDigital(port); //active low
        }
        catch(EnhancedIOException ex) {
        }
        return in;
    }
    
    public double getDriveRight() {
        return driverPad.getRawAxis(DRIVE_RIGHT_AXIS);
    }
    
    public double getDriveLeft() {
        return driverPad.getRawAxis(DRIVE_LEFT_AXIS);
    }
    
    public double getDriveThrottle() {
        return getIOAnalog(1);
    }
    
    public double getDriveWheel() {
        return getIOAnalog(3);
    }
    
    public boolean getDriveQuickTurn() throws EnhancedIOException {
        return getIODigital(3);
    }
}

