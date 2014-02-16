/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.nutrons.aerialassist;


import com.nutrons.aerialassist.commands.CommandBase;
import com.nutrons.aerialassist.commands.auto.AutoOneBall;
import com.nutrons.aerialassist.commands.auto.AutoTwoBall;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.nutrons.aerialassist.commands.CommandBase;
import com.nutrons.aerialassist.commands.drivetrain.DTManualTankCmd;
import edu.wpi.first.wpilibj.Preferences;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Nutrons2014 extends IterativeRobot {

    Command autonomousCommand;
    SendableChooser autoChooser = new SendableChooser();
    private Compressor comp = new Compressor(RobotMap.AIR_PRESSURE, RobotMap.COMPRESSOR_PORT);

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    Preferences prefs;
    public void robotInit() {
        //autonomousCommand = new DTManualTankCmd();

        // Initialize all subsystems

        CommandBase.init();
        autoChooser.addDefault("One Ball Auto", (Command) new AutoOneBall());
        autoChooser.addObject("Two Ball Auto", (Command) new AutoTwoBall());
        SmartDashboard.putData("Autonomous Mode", autoChooser);
    }

    public void autonomousInit() {
        comp.start();
        // schedule the autonomous command (example)
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //autonomousCommand.cancel();
        comp.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        RobotMap.DRIVE_KP = prefs.getDouble("DRIVE_KP", 1.0);
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    public void disabledInit() {
        comp.stop();
    }

    public void disabledPeriodic() {
        autonomousCommand = (Command) autoChooser.getSelected();
    }

}
