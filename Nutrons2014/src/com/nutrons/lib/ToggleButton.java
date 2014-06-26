/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.lib;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author NUTRONs
 */
public class ToggleButton extends Button {

    boolean state = false;
    JoystickButton button;

    public ToggleButton(Joystick joystick, int port) {
        button = new JoystickButton(joystick, port);
    }

    public boolean get() {
        state = !state;
        return state;
    }

    public void whenPressed(Command command) {
        button.whenPressed(command);
    }

}
