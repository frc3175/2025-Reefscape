// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;




import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.RobotState;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class IntakeAndReset extends Command {
  public Intake m_intake;
  public Wrist m_wrist;
  public Elevator m_elevator;
  public RobotState m_robotState;

  /** Creates a new IntakeAndReset. */
  public IntakeAndReset(Intake intake, Wrist wrist, Elevator elevator, RobotState robotState) {

    m_intake = intake;
    m_wrist = wrist;
    m_elevator = elevator;
    m_robotState = robotState;

    addRequirements(m_intake, m_wrist, m_elevator, m_robotState);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    new SetIntake(m_intake, m_robotState, "INTAKE")
            .alongWith(new SetElevator(m_elevator, m_robotState, "INTAKE")
            .andThen(new SetWrist(m_wrist, m_robotState, "INTAKE"))).schedule();


  }





  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    
      new SetIntake(m_intake, m_robotState, "HOME")
                  .alongWith(new SetWrist(m_wrist, m_robotState, "HOME"))
                  .andThen(new SetElevator(m_elevator, m_robotState, "HOME")).schedule();
                
      
        
      
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(SmartDashboard.getBoolean("Has Coral", false)){
    return true;
    }
    else{
    return false;
    }
  }
}
