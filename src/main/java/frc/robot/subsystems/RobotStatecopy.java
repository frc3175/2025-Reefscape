// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RobotStatecopy extends SubsystemBase {

  public Elevator m_Elevator;
  public Wrist    m_Wrist;
  public Intake   m_Intake;
  public Limelight m_ll;
  public AlgaeIntake m_algaeIntake;
  public Climber m_climber;

  /** Creates a new RobotState. */
  public RobotStatecopy(Wrist wrist, Elevator elevator, Intake intake, Limelight ll, AlgaeIntake algaeIntake, Climber climber) {
    m_Elevator = elevator;
    m_Wrist    = wrist;
    m_Intake = intake;
    m_ll = ll;
    m_algaeIntake = algaeIntake;
    m_climber = climber;
  }

  public void setRobotState(String state) {

    switch (state) {
      
      case "HOME":
        m_Wrist.setangle(Constants.WristConstants.HOME);
        m_Elevator.setpose(Constants.ElevatorConstants.HOME);
        m_Intake.intakerun(Constants.IntakeConstants.STOP);
        m_algaeIntake.intakerun(Constants.AlgaeIntakeConstants.STOP);
        m_algaeIntake.setangle(Constants.AlgaeIntakeConstants.HOME);
      break;

      default:

        break;
    }

  

}
}

 
