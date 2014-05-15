
package com.nutrons.aerialassist;

import com.nutrons.aerialassist.commands.GetDistanceCmd;
import com.nutrons.aerialassist.commands.auto.AutoDriveDistanceCmd;
import com.nutrons.aerialassist.commands.catcher.CatchCmd;
import com.nutrons.aerialassist.commands.catcher.RetractCatcherCmd;
import com.nutrons.aerialassist.commands.intake.*;
import com.nutrons.aerialassist.commands.shooter.ShooterFireCmd;
import com.nutrons.aerialassist.commands.shooter.ShooterLoadCmd;
import com.nutrons.lib.Utils;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
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
    // button.w5henReleased(new ExampleCommand());

    //Joysticks
    private final Joystick operatorPad = new Joystick(RobotMap.PAD_OP);
    private final Joystick driverLeft = new Joystick(RobotMap.DRIVE_LEFT_JOY);
    private final Joystick driverRight = new Joystick(RobotMap.DRIVE_RIGHT_JOY);
    // TODO: Adjust values

    private final int DRIVE_LEFT_AXIS = 2;
    private final int DRIVE_RIGHT_AXIS = 2;

    private Button quickTurn = new JoystickButton(driverLeft, 1);
    private Button deployIntake = new JoystickButton(operatorPad, 8);
    private Button retractIntake = new JoystickButton(operatorPad, 6);
    private Button runRollers = new JoystickButton(operatorPad, 4);
    private Button reverseIntake = new JoystickButton(operatorPad, 10);
    private Button windCatapult = new JoystickButton(operatorPad, 7);
    private Button fireCatapult = new JoystickButton(operatorPad, 5);
    private Button openWings = new JoystickButton(operatorPad, 1);
    private Button clamps = new JoystickButton(operatorPad, 2);
    private Button fireGateLatch = new JoystickButton(operatorPad, 9);
    private Button spitIntake = new JoystickButton(operatorPad, 3);

    // test buttons for auto drive dist
    private Button getDist = new JoystickButton(operatorPad, 20);
    private DriverStationEnhancedIO io = DriverStation.getInstance().getEnhancedIO();


    public OI()
    {
        runRollers.whileHeld(new RollerStartCmd());
        runRollers.whenReleased(new RollerStopCmd());
        deployIntake.whenPressed(new IntakeDeployCmd());
        retractIntake.whenPressed(new RetractIntakesCmd());
        reverseIntake.whileHeld(new RollerReverseCmd());
        reverseIntake.whenReleased(new RollerStopCmd());
        fireCatapult.whileHeld(new ShooterFireCmd());
        windCatapult.whileHeld(new ShooterLoadCmd());
        openWings.whenPressed(new LowerClampsCmd());
        clamps.whenPressed(new RaiseClampsCmd());
        fireGateLatch.whileHeld(new FireGateLatchesCmd());
        fireGateLatch.whenReleased(new RetractGateLatchesCmd());
        spitIntake.whileHeld(new SpitIntakeCmd());
        spitIntake.whenReleased(new StopSpitCmd());
        //autoDrive.whenPressed(new AutoDriveDistanceCmd(100));
        getDist.whenPressed(new GetDistanceCmd());
    }
     private double capAndBand(double value) {
        value = Utils.deadband(value, .15, -1);
        value = Utils.deadband(value, .15, 0);
        value = Utils.deadband(value, .15, 1);
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
        return driverRight.getRawAxis(DRIVE_RIGHT_AXIS);
    }

    public double getDriveLeft() {
        return -driverLeft.getRawAxis(DRIVE_LEFT_AXIS);
    }

    public double getDriveThrottle() {
        return driverLeft.getRawAxis(DRIVE_LEFT_AXIS);
    }

    public double getDriveWheel() {
        return driverRight.getRawAxis(1);
    }

    public boolean getDriveQuickTurn() throws EnhancedIOException {
        return quickTurn.get();
    }
    public double getWinchSpeed()
    {
        return capAndBand(operatorPad.getRawAxis(2));
    }
}