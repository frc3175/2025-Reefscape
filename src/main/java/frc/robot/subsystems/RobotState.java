// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RobotState extends SubsystemBase {

  private BotState m_botState; 
  /** Creates a new RobotState. */
  public RobotState() {

  }

  public void setRobotState(BotState state) {

    m_botState = state;

}

public BotState getRobotState() {

    return m_botState;

} 
public enum BotState {
  
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
