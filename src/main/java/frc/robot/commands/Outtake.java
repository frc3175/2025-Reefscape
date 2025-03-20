// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Wrist;
import frc.robot.Constants;
import frc.robot.subsystems.BotState;
import frc.robot.subsystems.BotState.BobotState;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Outtake extends Command {
  public Intake m_intake;
  public BotState m_botState;

  /** Creates a new IntakeAndReset. */
  public Outtake(Intake intake, BotState botState) {

    m_intake = intake;
    m_botState = botState;

    addRequirements(m_intake, m_botState);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    if (m_botState.getCurrentBotState().intakeState.isCoralOuttake) {
      m_intake.coralintakerunvoltage(Constants.CoralIntakeConstants.OUTTAKE);

    } else {
      m_intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.OUTTAKE);
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
      return true;

  }
}
