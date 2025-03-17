// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants;

// public class StateManger extends SubsystemBase {

//   public Elevator m_Elevator;
//   public Wrist    m_Wrist;
//   public Intake   m_Intake;
//   public Limelight m_ll;
//   public Climber m_climber;

  
//   /** Creates a new RobotState. */
//   public StateManger(Wrist wrist, Elevator elevator, Intake intake, Limelight ll,  Climber climber) {
//     m_Elevator = elevator;
//     m_Wrist = wrist;
//     m_Intake = intake;
//     m_ll = ll;
    
//     m_climber = climber;

//     SmartDashboard.putNumber("intake speed", 1);
//   }

  


//   public void setRobotState(String state) {

//     switch (state) {
      
//       case "HOME":
//         SmartDashboard.putNumber("intake speed", 1);
//         SmartDashboard.putBoolean("Max speed", false);
//         if (m_Intake.HasCoral()) {
//           m_Wrist.setangle(Constants.WristConstants.INTERMEDIATE);
//           m_Elevator.setpose(Constants.ElevatorConstants.INTERMEDIATE);
//           m_Intake.coralintakerunvoltage(Constants.CoralIntakeConstants.HOLD);
//         } else {
//         m_Wrist.setangle(Constants.WristConstants.HOME);
//         m_Elevator.setpose(Constants.ElevatorConstants.HOME);
//         m_Intake.coralintakerunvoltage(Constants.CoralIntakeConstants.STOP);
//         }
//         if (m_Intake.HasAlgae()) {
//           m_Intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.HOLD);
//         } else {
//           m_Intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.STOP);
//         }

//       break;

      

//       case "HP":
//       if (m_Intake.HasCoral()) {
//         m_Wrist.setangle(Constants.WristConstants.INTERMEDIATE);
//         m_Elevator.setpose(Constants.ElevatorConstants.INTERMEDIATE);
//         m_Intake.coralintakerunvoltage(Constants.CoralIntakeConstants.HOLD);
//       } else {
//       m_Wrist.setangle(Constants.WristConstants.HUMAN);
//       m_Elevator.setpose(Constants.ElevatorConstants.HUMAN);
//       m_Intake.coralintakerunvoltage(Constants.CoralIntakeConstants.INTAKE);
//       }
//       if (m_Intake.HasAlgae()) {
//         m_Intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.HOLD);
//       } else {
//         m_Intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.STOP);
//       }
        
//       //}
//       // Timer.delay(0.5);
//       // m_Wrist.setangle(Constants.WristConstants.UPHUMAN);
//       break;

    
    


//       case "L4":

//       if(Constants.CORALMODE){
//         SmartDashboard.putNumber("intake speed", 1);
//         SmartDashboard.putBoolean("Max speed", true);
//         m_Wrist.setangle(Constants.WristConstants.L4);
//         m_Elevator.setpose(Constants.ElevatorConstants.L4);
//         m_Intake.coralintakerunvoltage(Constants.CoralIntakeConstants.HOLD);

//       } else {
//         SmartDashboard.putNumber("intake speed", 0);
//         SmartDashboard.putBoolean("Max speed", true);
//         m_Wrist.setangle(Constants.WristConstants.BARGE);
//         m_Elevator.setpose(Constants.ElevatorConstants.BARGE);
//         m_Intake.algaeintakerunvoltage(Constants.CoralIntakeConstants.OUTTAKE);
//       }
//       break;

//       case "L3":
//       if(Constants.CORALMODE){
//         SmartDashboard.putNumber("intake speed", 1);
//         SmartDashboard.putBoolean("Max speed", true);
//         m_Wrist.setangle(Constants.WristConstants.L3);
//         m_Elevator.setpose(Constants.ElevatorConstants.L3);
//         m_Intake.coralintakerunvoltage(Constants.CoralIntakeConstants.STOP);
        
//         }else{
//           SmartDashboard.putNumber("intake speed", 0);
//           SmartDashboard.putBoolean("Max speed", false);
//           m_Wrist.setangle(Constants.WristConstants.ALGAET3);
//           m_Elevator.setpose(Constants.ElevatorConstants.ALGAET3);
//           m_Intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.INTAKE);
         
//         }
//       break;

//       case "L2":
//       if (Constants.CORALMODE){
//         SmartDashboard.putNumber("intake speed", 1);
//         SmartDashboard.putBoolean("Max speed", true);
//         m_Wrist.setangle(Constants.WristConstants.L2);
//         m_Elevator.setpose(Constants.ElevatorConstants.L2);
//         m_Intake.coralintakerunvoltage(Constants.CoralIntakeConstants.STOP);
       
//       }else{
//         SmartDashboard.putNumber("intake speed", 0);
//         SmartDashboard.putBoolean("Max speed", false);
//         m_Wrist.setangle(Constants.WristConstants.ALGAET2);
//         m_Elevator.setpose(Constants.ElevatorConstants.ALGAET2);
//         m_Intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.INTAKE);
     

//       }
//       break;
//       case "L1":
//         SmartDashboard.putNumber("intake speed", 0);
//         SmartDashboard.putBoolean("Max speed", false);
//         m_Wrist.setangle(Constants.WristConstants.L1);
//         m_Elevator.setpose(Constants.ElevatorConstants.HOME);
//         m_Intake.coralintakerunvoltage(Constants.CoralIntakeConstants.STOP);
       
//       break;

      

   
//   case "flip":
//     SmartDashboard.putNumber("intake speed", 0);
//     SmartDashboard.putBoolean("Max speed", false);
//     m_Wrist.setangle(-27);
//     m_Elevator.setpose(Constants.ElevatorConstants.ALGAET3);
//     m_Intake.coralintakerunvoltage(Constants.CoralIntakeConstants.OUTTAKEFAST);
    
//   break;


//   case "INTERMEDIATE":
//         SmartDashboard.putNumber("intake speed", 1);
//         SmartDashboard.putBoolean("Max speed", false);
//         m_Wrist.setangle(Constants.WristConstants.INTERMEDIATE);
//         m_Elevator.setpose(Constants.ElevatorConstants.INTERMEDIATE);
//         m_Intake.coralintakerunvoltage(Constants.CoralIntakeConstants.INTERMEDIATE);
//         m_Intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.INTERMEDIATE);
        

//       break;

//     case "FORCE_INTAKE":
//         SmartDashboard.putNumber("intake speed", 1);
//         SmartDashboard.putBoolean("Max speed", false);
//         m_Wrist.setangle(Constants.WristConstants.HUMAN);
//         m_Elevator.setpose(Constants.ElevatorConstants.HUMAN);
//         m_Intake.coralintakerunvoltage(Constants.CoralIntakeConstants.INTAKE);
//         if (m_Intake.HasAlgae()) {
//           m_Intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.HOLD);
//         } else {
//           m_Intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.STOP);
//         }
        

//       break;


  
    


//       default:

//         break;
//     }

  

// }
// }

 
