/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.nutrons.aerialassist;


import com.nutrons.aerialassist.commands.CommandBase;
import com.nutrons.aerialassist.commands.auto.AutoDriveDistanceOnly;
import com.nutrons.aerialassist.commands.auto.AutoOneBall;
import com.nutrons.aerialassist.commands.auto.AutoThreeBall;
import com.nutrons.aerialassist.commands.auto.AutoTwoBall;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


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
        autoChooser.addObject("Three Ball Auto", (Command) new AutoThreeBall());
        autoChooser.addObject("Drive Forward Only",(Command) new AutoDriveDistanceOnly());
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
        SmartDashboard.putData("Left Encoder", CommandBase.dt.getLeftEncoder());
        SmartDashboard.putData("Right Encoder", CommandBase.dt.getRightEncoder());
        SmartDashboard.putData("R Vel PID", CommandBase.dt.getRightVPID());
        SmartDashboard.putData("L Vel PID", CommandBase.dt.getLeftVPID());
        SmartDashboard.putNumber("L Joystick", CommandBase.oi.getDriveLeft());
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("Hot Goal", CommandBase.catapult.isHot());
        SmartDashboard.putNumber("Right Distance",CommandBase.dt.getRightDistance());
        SmartDashboard.putNumber("Left Distance",CommandBase.dt.getLeftDistance());
        SmartDashboard.putNumber("Left rate", CommandBase.dt.getLeftRate());
        SmartDashboard.putNumber("Right rate", CommandBase.dt.getRightRate());
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
//        System.out.println("Banner is: " + CommandBase.catapult.isHot());
    }

}
