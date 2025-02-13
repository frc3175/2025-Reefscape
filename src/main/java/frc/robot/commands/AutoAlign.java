// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix6.swerve.SwerveDrivetrain;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.Limelight;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class AutoAlign extends Command {

  private CommandSwerveDrivetrain drivetrain;
  private Limelight camera;
  
  private PIDController xController = new PIDController(0.1, 0, 0);
  private PIDController yController = new PIDController(0.1, 0, 0);
  private PIDController turnController = new PIDController(.05, 0, 0);

  private final double X_SETPOINT = 5;
    private final double Y_SETPOINT = 5;


  public AutoAlign(CommandSwerveDrivetrain drive, Limelight limelight, CommandXboxController controller) {
    drivetrain = drive;
    camera = limelight;

    xController.setSetpoint(X_SETPOINT);
    yController.setSetpoint(Y_SETPOINT);

    xController.setTolerance(0.5);
    yController.setTolerance(0.5);
    turnController.setTolerance(0.5);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    if(!camera.hasTarget())
    {
      end(true);
    }else{
      
    }


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
