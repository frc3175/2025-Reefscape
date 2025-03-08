// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class StateManger extends SubsystemBase {

  public Elevator m_Elevator;
  public Wrist    m_Wrist;
  public Intake   m_Intake;
  public Limelight m_ll;
  public Climber m_climber;

  
  /** Creates a new RobotState. */
  public StateManger(Wrist wrist, Elevator elevator, Intake intake, Limelight ll,  Climber climber) {
    m_Elevator = elevator;
    m_Wrist = wrist;
    m_Intake = intake;
    m_ll = ll;
    
    m_climber = climber;

    SmartDashboard.putNumber("intake speed", 1);
  }

  


  public void setRobotState(String state) {

    switch (state) {
      
      case "HOME":
        SmartDashboard.putNumber("intake speed", 1);
        SmartDashboard.putBoolean("Max speed", false);
        m_Wrist.setangle(Constants.WristConstants.HOME);
        m_Elevator.setpose(Constants.ElevatorConstants.HOME);
        m_Intake.intakerunvoltage(Constants.IntakeConstants.STOP);
        

      break;

      

      case "HP":
      // while(!m_Intake.HasCoral()){
        SmartDashboard.putNumber("intake speed", 1);
        SmartDashboard.putBoolean("Max speed", false);
        m_Wrist.setangle(Constants.WristConstants.HUMAN);
        m_Elevator.setpose(Constants.ElevatorConstants.HOME);
        m_Intake.intakerunvoltage(Constants.IntakeConstants.INTAKE);
      //}
      // Timer.delay(0.5);
      // m_Wrist.setangle(Constants.WristConstants.UPHUMAN);
      break;

    
    


      case "L4":
      if(Constants.CORALMODE){
        SmartDashboard.putNumber("intake speed", 1);
        SmartDashboard.putBoolean("Max speed", true);
        m_Wrist.setangle(Constants.WristConstants.L4);
        m_Elevator.setpose(Constants.ElevatorConstants.L4);
        m_Intake.intakerunvoltage(Constants.IntakeConstants.STOP);
       
      }
      else{
        SmartDashboard.putNumber("intake speed", 0);
    SmartDashboard.putBoolean("Max speed", true);
    m_Wrist.setangle(Constants.WristConstants.BARGE);
    m_Elevator.setpose(Constants.ElevatorConstants.BARGE);
    m_Intake.intakerunvoltage(Constants.IntakeConstants.OUTTAKEFAST);
      }
      break;

      case "L3":
      if(Constants.CORALMODE){
        SmartDashboard.putNumber("intake speed", 1);
        SmartDashboard.putBoolean("Max speed", true);
        m_Wrist.setangle(Constants.WristConstants.L3);
        m_Elevator.setpose(Constants.ElevatorConstants.L3);
        m_Intake.intakerunvoltage(Constants.IntakeConstants.STOP);
        
        }
        else{
          SmartDashboard.putNumber("intake speed", 0);
          SmartDashboard.putBoolean("Max speed", false);
          m_Wrist.setangle(Constants.WristConstants.ALGAET3);
          m_Elevator.setpose(Constants.ElevatorConstants.ALGAET3);
          m_Intake.intakerunvoltage(Constants.IntakeConstants.OUTTAKEFAST);
         
        }
      break;

      case "L2":
      if (Constants.CORALMODE){
        SmartDashboard.putNumber("intake speed", 1);
        SmartDashboard.putBoolean("Max speed", true);
        m_Wrist.setangle(Constants.WristConstants.L2);
        m_Elevator.setpose(Constants.ElevatorConstants.L2);
        m_Intake.intakerunvoltage(Constants.IntakeConstants.STOP);
       
      }
      else{

        SmartDashboard.putNumber("intake speed", 0);
      SmartDashboard.putBoolean("Max speed", false);
      m_Wrist.setangle(Constants.WristConstants.ALGAET2);
      m_Elevator.setpose(Constants.ElevatorConstants.ALGAET2);
      m_Intake.intakerunvoltage(Constants.IntakeConstants.OUTTAKEFAST);
     

      }
      break;
      case "L1":
        SmartDashboard.putNumber("intake speed", 0);
        SmartDashboard.putBoolean("Max speed", false);
        m_Wrist.setangle(Constants.WristConstants.L1);
        m_Elevator.setpose(Constants.ElevatorConstants.HOME);
        m_Intake.intakerunvoltage(Constants.IntakeConstants.STOP);
       
      break;

      

   
  case "flip":
    SmartDashboard.putNumber("intake speed", 0);
    SmartDashboard.putBoolean("Max speed", false);
    m_Wrist.setangle(-27);
    m_Elevator.setpose(Constants.ElevatorConstants.ALGAET3);
    m_Intake.intakerunvoltage(Constants.IntakeConstants.OUTTAKEFAST);
    
  break;


  
    


      default:

        break;
    }

  

}
}

 
