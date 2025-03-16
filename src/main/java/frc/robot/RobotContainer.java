// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.MetersPerSecond;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.SetIntakeAndReset;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.StateManger;
import frc.robot.subsystems.Wrist;


public class RobotContainer {
    private double MaxSpeed = TunerConstants.kSpeedAt12Volts.in(MetersPerSecond); // kSpeedAt12Volts desired top speed

    /* Setting up bindings for necessary control of the swerve drive platform */
    

     private final Telemetry logger = new Telemetry(MaxSpeed);

    private final CommandXboxController driverController = new CommandXboxController(Constants.DRIVER_CONTROLER);
    private final CommandXboxController opController  = new CommandXboxController(Constants.OPERATOR_CONTROLER);
    private final CommandXboxController testController  = new CommandXboxController(4);
   
    
    public final Limelight m_ll = new Limelight();
    public final CommandSwerveDrivetrain drivetrain = TunerConstants.createDrivetrain();



    public final Elevator m_elevator = new Elevator();
    public final Wrist m_wrist = new Wrist();
    public final Intake m_intake = new Intake();
    
    
    public final Climber m_climber = new Climber();
   

    
   
    public final StateManger m_StateManger = new StateManger(m_wrist, m_elevator, m_intake, m_ll,  m_climber  );

    private final int translationAxis = XboxController.Axis.kLeftY.value;
    private final int strafeAxis = XboxController.Axis.kLeftX.value;
    private final int rotationAxis = XboxController.Axis.kRightX.value;

    /* Path follower */
    private final SendableChooser<Command> autoChooser;



    
    

    public RobotContainer() {
        NamedCommands.registerCommand("Intake",  new InstantCommand(() -> m_StateManger.setRobotState("HP")));
        NamedCommands.registerCommand("Outtake", new InstantCommand(() -> m_intake.OUTTAKE(Constants.IntakeConstants.OUTTAKE)));
        NamedCommands.registerCommand("L4", new InstantCommand(() -> m_StateManger.setRobotState("L4")));
        NamedCommands.registerCommand("HOME", new InstantCommand(() -> m_StateManger.setRobotState("HOME")));
        NamedCommands.registerCommand("L2", new InstantCommand(() -> m_StateManger.setRobotState("L2")));
        
        
        autoChooser = AutoBuilder.buildAutoChooser("Red 2 Piece Left");

      
        

       
    
 
       
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
         driverController.leftBumper().onTrue(new InstantCommand(()-> m_intake.CORALOUTTAKE(Constants.CoralIntakeConstants.OUTTAKE)));
         driverController.pov(0).onTrue(new InstantCommand(()-> m_wrist.setnudge(-.1)));
         driverController.pov(180).onTrue(new InstantCommand(()-> m_wrist.setnudge(.1)));
         driverController.button(7).onTrue(new InstantCommand(() -> m_intake.algaeintakerunvoltage(12)));
         driverController.pov(180).onTrue(new InstantCommand(()-> m_wrist.setangle(m_wrist.getpose())));
         driverController.pov(0).onTrue(new InstantCommand(()-> m_wrist.setangle(m_wrist.getpose())));
         driverController.start().onTrue(new InstantCommand(() -> m_StateManger.setRobotState("FORCE_INTAKE")));
         driverController.back().onTrue(new InstantCommand(() -> m_StateManger.setRobotState("INTERMEDIATE")));

        driverController.rightTrigger().onTrue(new AutoRight(m_ll));
        driverController.leftTrigger().onTrue(new AutoLeft(m_ll));

        
         
    
        opController.y().onTrue(new InstantCommand(() -> m_elevator.setpose(Constants.ElevatorConstants.L4))
            .andThen(new InstantCommand(() -> m_wrist.setangle(Constants.WristConstants.L4)))
            );
        opController.b().onTrue(new InstantCommand(() -> m_elevator.setpose(Constants.ElevatorConstants.L3))
        .andThen(new InstantCommand(() -> m_wrist.setangle(Constants.WristConstants.L3)))
        );
        opController.x().onTrue(new InstantCommand(() -> m_elevator.setpose(Constants.ElevatorConstants.L2))
        .andThen(new InstantCommand(() -> m_wrist.setangle(Constants.WristConstants.L2)))
        );
        opController.a().onTrue(new InstantCommand(() -> m_wrist.setangle(Constants.WristConstants.INTERMEDIATE))
        .andThen(new InstantCommand(() -> m_elevator.setpose(Constants.ElevatorConstants.INTERMEDIATE)))
        .andThen(new InstantCommand(() -> m_StateManger.setRobotState("HOME")))
        );

        opController.button(10).onTrue(new InstantCommand(() -> m_StateManger.setRobotState("L1")));
        

        opController.rightBumper().onTrue(new InstantCommand(() -> m_StateManger.setRobotState("HP")));
        opController.rightBumper().whileTrue(new SetIntakeAndReset(m_intake, m_StateManger));
        
        
        opController.rightBumper().onFalse(new InstantCommand(() -> m_StateManger.setRobotState("HOME")));
        //opController.leftBumper().onFalse(new InstantCommand(() -> m_StateManger.setRobotState("HOME")));

        

        opController.button(7).onTrue(new InstantCommand(() -> Constants.changemode()));
        opController.button(8).onTrue(new InstantCommand(() -> Constants.changemode()));
        
        }

    public Command getAutonomousCommand() {
        /* Run the path selected from the auto chooser */
        return autoChooser.getSelected();
       // return null;
    }
}
