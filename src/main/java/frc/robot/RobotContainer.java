// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.*;

import java.net.FileNameMap;
import java.sql.Driver;

import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.SwerveRequest;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.epilogue.logging.FileBackend;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine.Direction;
import frc.robot.commands.Auto;
import frc.robot.commands.Auto2d;
import frc.robot.commands.AutoWorkPlease;
import frc.robot.commands.SwerveDrive;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.AlgaeIntake;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.StateManger;
import frc.robot.subsystems.Wrist;
import frc.robot.util.Autoutils;

public class RobotContainer {
    private double MaxSpeed = TunerConstants.kSpeedAt12Volts.in(MetersPerSecond); // kSpeedAt12Volts desired top speed

    /* Setting up bindings for necessary control of the swerve drive platform */
    private final SwerveRequest.SwerveDriveBrake brake = new SwerveRequest.SwerveDriveBrake();
    private final SwerveRequest.PointWheelsAt point = new SwerveRequest.PointWheelsAt();
    private final SwerveRequest.RobotCentric forwardStraight = new SwerveRequest.RobotCentric()
            .withDriveRequestType(DriveRequestType.OpenLoopVoltage);

    private final SwerveRequest.FieldCentric evade = new SwerveRequest.FieldCentric();

     private final Telemetry logger = new Telemetry(MaxSpeed);

    private final CommandXboxController driverController = new CommandXboxController(Constants.DRIVER_CONTROLER);
    private final CommandXboxController opController  = new CommandXboxController(Constants.OPERATOR_CONTROLER);
    private final CommandXboxController testController  = new CommandXboxController(4);
   
    
    public final Limelight m_ll = new Limelight();
    public final CommandSwerveDrivetrain drivetrain = TunerConstants.createDrivetrain();



    public final Elevator m_elevator = new Elevator();
    public final Wrist m_wrist = new Wrist();
    public final Intake m_intake = new Intake();
    public final AlgaeIntake m_algaeIntake = new AlgaeIntake();
    
    public final Climber m_climber = new Climber();
    public final Auto2d m_auto = new Auto2d(drivetrain, m_ll);

    // public LED m_Led = new LED();
   
    public final StateManger m_StateManger = new StateManger(m_wrist, m_elevator, m_intake, m_ll, m_algaeIntake, m_climber  );

    private final int translationAxis = XboxController.Axis.kLeftY.value;
    private final int strafeAxis = XboxController.Axis.kLeftX.value;
    private final int rotationAxis = XboxController.Axis.kRightX.value;


    /* Path follower */
    private final SendableChooser<Command> autoChooser;



    
    

    public RobotContainer() {
        // drivetrain.setlimelight(m_ll);
        NamedCommands.registerCommand("Intake",  new InstantCommand(() -> m_StateManger.setRobotState("HP")));
        NamedCommands.registerCommand("Outtake", new InstantCommand(() -> m_intake.OUTTAKE(Constants.IntakeConstants.OUTTAKE)));
        NamedCommands.registerCommand("L4", new InstantCommand(() -> m_StateManger.setRobotState("L4")));
        NamedCommands.registerCommand("HOME", new InstantCommand(() -> m_StateManger.setRobotState("HOME")));
        NamedCommands.registerCommand("auto1piece", new Auto2d(drivetrain, m_ll).newPath(m_ll, false));
        
        autoChooser = AutoBuilder.buildAutoChooser("Tests");

      
        

       
    
 
       
        SmartDashboard.putData("Auto Mode", autoChooser);
        SmartDashboard.putNumber("set elevator", 0);

        configureBindings();
        
    }

    private void configureBindings() {
        // Note that X is defined as forward according to WPILib convention,
        // and Y is defined as to the left according to WPILib convention.
        drivetrain.setDefaultCommand(
            // Drivetrain will execute this command periodically
            new SwerveDrive(
                drivetrain, 
                () -> -driverController.getRawAxis(translationAxis), 
                () -> -driverController.getRawAxis(strafeAxis), 
                () -> -driverController.getRawAxis(rotationAxis), 
                () -> true, 
                () -> driverController.rightBumper().getAsBoolean(),
                () -> SmartDashboard.getBoolean("Max speed", false))
        );
         drivetrain.registerTelemetry(logger::telemeterize);

         driverController.x().onTrue(drivetrain.runOnce(() -> drivetrain.seedFieldCentric()));
         driverController.leftBumper().onTrue(new InstantCommand(()-> m_intake.OUTTAKE(Constants.IntakeConstants.OUTTAKE)));
         driverController.a().onTrue(new InstantCommand(() -> m_wrist.setangle(-27)));
         driverController.pov(0).onTrue(new InstantCommand(()-> m_wrist.setnudge(-.1)));
         driverController.pov(180).onTrue(new InstantCommand(()-> m_wrist.setnudge(.1)));
         driverController.button(7).onTrue(new InstantCommand(() -> m_intake.intakerunvoltage(12)));
         driverController.pov(180).onTrue(new InstantCommand(()-> m_wrist.setangle(m_wrist.getpose())));
         driverController.pov(0).onTrue(new InstantCommand(()-> m_wrist.setangle(m_wrist.getpose())));
        // driverController.a().onTrue(new InstantCommand(() -> m_wrist.setangle(Constants.WristConstants.climb)));
        //  driverController.a().onTrue(new InstantCommand(() -> m_algaeIntake.setangle(Constants.AlgaeIntakeConstants.climb)));
         
    
        opController.y().onTrue(new InstantCommand(() -> m_StateManger.setRobotState("L4")));
        opController.b().onTrue(new InstantCommand(() -> m_StateManger.setRobotState("L3")));
        opController.x().onTrue(new InstantCommand(() -> m_StateManger.setRobotState("L2")));
        opController.a().onTrue(new InstantCommand(() -> m_StateManger.setRobotState("HOME")));

        opController.button(10).onTrue(new InstantCommand(() -> m_StateManger.setRobotState("L1")));
        

        opController.rightBumper().whileTrue(new InstantCommand(() -> m_StateManger.setRobotState("HP")));
        opController.leftBumper().whileTrue(new InstantCommand(() -> m_StateManger.setRobotState("ALGAE INTAKE")));

        opController.rightBumper().onFalse(new InstantCommand(() -> m_StateManger.setRobotState("HOME")));
        opController.leftBumper().onFalse(new InstantCommand(() -> m_StateManger.setRobotState("HOME")));

        opController.pov(180).whileTrue(new InstantCommand(() -> m_algaeIntake.intakePercentOutput(-.5)));
        opController.pov(180).onFalse(new InstantCommand(() -> m_algaeIntake.intakePercentOutput(0)));

        opController.pov(270).onTrue(new InstantCommand(() -> m_StateManger.setRobotState("AlgaeT2")));
        opController.pov(90).onTrue(new InstantCommand(() -> m_StateManger.setRobotState("AlgaeT3")));
        opController.pov(0).onTrue(new InstantCommand(() -> m_StateManger.setRobotState("Barge")));
        
        // testController.y().onTrue(m_auto.newPath(0,0,0));
        //driverController.y().onTrue(new Auto2d(drivetrain, m_ll).newPath(m_ll, false));
        //driverController.b().onTrue(new Auto2d(drivetrain, m_ll).newPath(m_ll, true));

        driverController.pov(90).onTrue(new AutoWorkPlease(m_ll, false));
        driverController.pov(270).onTrue(new AutoWorkPlease(m_ll, true));
    
    
        }

    public Command getAutonomousCommand() {
        /* Run the path selected from the auto chooser */
        // return autoChooser.getSelected();
        return null;
    }
}
