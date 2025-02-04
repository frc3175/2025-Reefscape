// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class StateManger extends SubsystemBase {

  public Elevator m_Elevator;
  public Wrist    m_Wrist;
  public Intake   m_Intake;
  public Limelight m_ll;
  public AlgaeIntake m_algaeIntake;
  public Climber m_climber;

  
  /** Creates a new RobotState. */
  public StateManger(Wrist wrist, Elevator elevator, Intake intake, Limelight ll, AlgaeIntake algaeIntake, Climber climber) {
    m_Elevator = elevator;
    m_Wrist = wrist;
    m_Intake = intake;
    m_ll = ll;
    m_algaeIntake = algaeIntake;
    m_climber = climber;

    SmartDashboard.putNumber("intake speed", 1);
  }

  


  public void setRobotState(String state) {

    switch (state) {
      
      case "HOME":
        SmartDashboard.putNumber("intake speed", 1);
        m_Wrist.setangle(Constants.WristConstants.HOME);
        m_Elevator.setpose(Constants.ElevatorConstants.HOME);
        m_Intake.intakerun(Constants.IntakeConstants.STOP);
        m_algaeIntake.intakerun(Constants.AlgaeIntakeConstants.STOP);
        m_algaeIntake.setangle(Constants.AlgaeIntakeConstants.OFFSET);

      break;

      case "ALGAE INTAKE":
        SmartDashboard.putNumber("intake speed", 1);
        m_Wrist.setangle(13);
        m_Elevator.setpose(Constants.ElevatorConstants.HOME);
        m_Intake.OUTTAKE(-.5);
        m_algaeIntake.intakePercentOutput(.5);
        m_algaeIntake.setangle(Constants.AlgaeIntakeConstants.INTAKEANGLE);
      break;

      case "HP":
        SmartDashboard.putNumber("intake speed", 1);
        m_Wrist.setangle(Constants.WristConstants.HUMAN);
        m_Elevator.setpose(Constants.ElevatorConstants.HOME);
        m_Intake.intakerun(Constants.IntakeConstants.INTAKE);
        m_algaeIntake.intakePercentOutput(0);
        m_algaeIntake.setangle(Constants.AlgaeIntakeConstants.OFFSET);
      break;

      case "L4":
        SmartDashboard.putNumber("intake speed", 1);
        m_Wrist.setangle(Constants.WristConstants.L4);
        m_Elevator.setpose(Constants.ElevatorConstants.L4);
        m_Intake.intakerun(Constants.IntakeConstants.STOP);
        m_algaeIntake.intakePercentOutput(0);
        m_algaeIntake.setangle(Constants.AlgaeIntakeConstants.OFFSET);
      break;

      case "L3":
        SmartDashboard.putNumber("intake speed", 1);
        m_Wrist.setangle(Constants.WristConstants.L3);
        m_Elevator.setpose(Constants.ElevatorConstants.L3);
        m_Intake.intakerun(Constants.IntakeConstants.STOP);
        m_algaeIntake.intakePercentOutput(0);
        m_algaeIntake.setangle(Constants.AlgaeIntakeConstants.OFFSET);
      break;

      case "L2":
        SmartDashboard.putNumber("intake speed", 1);
        m_Wrist.setangle(Constants.WristConstants.L2);
        m_Elevator.setpose(Constants.ElevatorConstants.L2);
        m_Intake.intakerun(Constants.IntakeConstants.STOP);
        m_algaeIntake.intakePercentOutput(0);
        m_algaeIntake.setangle(Constants.AlgaeIntakeConstants.OFFSET);
      break;
      case "L1":
        SmartDashboard.putNumber("intake speed", 0);
        m_Wrist.setangle(Constants.WristConstants.L1);
        m_Elevator.setpose(Constants.ElevatorConstants.HOME);
        m_Intake.intakerun(Constants.IntakeConstants.STOP);
        m_algaeIntake.intakePercentOutput(0);
        m_algaeIntake.setangle(Constants.AlgaeIntakeConstants.OFFSET);
      break;

      default:

        break;
    }

  

}
}

 
