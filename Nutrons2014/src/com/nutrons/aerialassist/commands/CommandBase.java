package com.nutrons.aerialassist.commands;

import com.nutrons.aerialassist.OI;
import com.nutrons.aerialassist.subsystems.Catapult;
import com.nutrons.aerialassist.subsystems.DriveTrain;
import com.nutrons.aerialassist.subsystems.Intake;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static DriveTrain dt = new DriveTrain();
    public static Intake intake = new Intake();
    public static Catapult catapult = new Catapult();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
//        dt = new DriveTrain();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(dt);
        SmartDashboard.putData(catapult);
        SmartDashboard.putData(intake);
        SmartDashboard.putBoolean("Intake Down", intake.isDeployed());
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
