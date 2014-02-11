[1mdiff --git a/Nutrons2014/build/preverify/META-INF/MANIFEST.MF b/Nutrons2014/build/preverify/META-INF/MANIFEST.MF[m
[1mdiff --git a/Nutrons2014/build/preverify/META-INF/maven/edu.wpi.first.wpilib.networktables.java/NetworkTablesAzalea/pom.properties b/Nutrons2014/build/preverify/META-INF/maven/edu.wpi.first.wpilib.networktables.java/NetworkTablesAzalea/pom.properties[m
[1mdiff --git a/Nutrons2014/build/preverify/META-INF/maven/edu.wpi.first.wpilib.networktables.java/NetworkTablesAzalea/pom.xml b/Nutrons2014/build/preverify/META-INF/maven/edu.wpi.first.wpilib.networktables.java/NetworkTablesAzalea/pom.xml[m
[1mdiff --git a/Nutrons2014/nbproject/private/private.xml b/Nutrons2014/nbproject/private/private.xml[m
[1mdiff --git a/Nutrons2014/src/com/nutrons/aerialassist/subsystems/Catapult.java b/Nutrons2014/src/com/nutrons/aerialassist/subsystems/Catapult.java[m
[1mindex 9ac9715..abb6715 100644[m
[1m--- a/Nutrons2014/src/com/nutrons/aerialassist/subsystems/Catapult.java[m
[1m+++ b/Nutrons2014/src/com/nutrons/aerialassist/subsystems/Catapult.java[m
[36m@@ -6,6 +6,7 @@[m [mpackage com.nutrons.aerialassist.subsystems;[m
 [m
 import com.nutrons.aerialassist.RobotMap;[m
 import com.nutrons.aerialassist.commands.WinchTestCmd;[m
[32m+[m[32mimport com.nutrons.aerialassist.commands.shooter.LimitSwitchTestCmd;[m
 import com.nutrons.lib.DebouncedBoolean;[m
 import edu.wpi.first.wpilibj.DigitalInput;[m
 import edu.wpi.first.wpilibj.SpeedController;[m
[36m@@ -23,17 +24,14 @@[m [mpublic class Catapult extends Subsystem {[m
     private SpeedController motor2 = new Talon(RobotMap.WINCH2);[m
     private DigitalInput sensor = new DigitalInput(RobotMap.WINCH_SENSOR);[m
     public final double FORWARDS = -0.7;[m
[31m-[m
[31m-[m
     private DebouncedBoolean ready = new DebouncedBoolean(1);[m
 [m
     public void initDefaultCommand() {[m
[31m-        // Set the default command for a subsystem here.[m
[31m-        //setDefaultCommantd(new MySpecialCommand());[m
[32m+[m[32m        setD