// package frc.robot.commands;

// import edu.wpi.first.wpilibj.DriverStation;
// import edu.wpi.first.wpilibj2.command.Command;
// import frc.robot.Constants;
// import frc.robot.subsystems.Elevator;
// import frc.robot.subsystems.RobotState;

// public class SetElevator extends Command {

//     Elevator m_elevator;
//     String m_level;
//     double wantedPose;
//     RobotState m_robotState;

//     public SetElevator(Elevator elevator, RobotState robotState, String level) {

//         m_level = level;
//         m_elevator = elevator;
//         m_robotState = robotState;
        
//     }

//     @Override
//     public void initialize() {
//             switch (m_level) {
//                 case "HOME":
//                     m_elevator.setpose(Constants.ElevatorConstants.INTERMEDIATE);
//                     wantedPose = Constants.ElevatorConstants.INTERMEDIATE;
//                     break;

//                 case "INTAKE":
//                     m_elevator.setpose(Constants.ElevatorConstants.INTAKE);
//                     wantedPose = Constants.ElevatorConstants.INTAKE;
//                     break;

//                 case "CLIMB":
//                     m_elevator.setpose(Constants.ElevatorConstants.CLIMB);
//                     wantedPose = Constants.ElevatorConstants.CLIMB;
//                     break;

//                 case "L1":
//                     m_elevator.setpose(Constants.ElevatorConstants.L1);
//                     wantedPose = Constants.ElevatorConstants.L1;
//                     break;
//                 case "L2":
//                     m_elevator.setpose(Constants.ElevatorConstants.L2);
//                     wantedPose = Constants.ElevatorConstants.L2;
//                     break;

//                 case "L3":
//                     m_elevator.setpose(Constants.ElevatorConstants.L3);
//                     wantedPose = Constants.ElevatorConstants.L3;
//                     break;

//                 case "L4":
//                     m_elevator.setpose(Constants.ElevatorConstants.L4);
//                     wantedPose = Constants.ElevatorConstants.L4;
//                     break;
//                 case "PROCESSOR":
//                     m_elevator.setpose(Constants.ElevatorConstants.PROCESSOR);
//                     wantedPose = Constants.ElevatorConstants.PROCESSOR;
//                     break;
//                 case "ALGAET2":
//                     m_elevator.setpose(Constants.ElevatorConstants.ALGAET2);
//                     wantedPose = Constants.ElevatorConstants.ALGAET2;
//                     break;
//                 case "ALGAET3":
//                     m_elevator.setpose(Constants.ElevatorConstants.ALGAET3);
//                     wantedPose = Constants.ElevatorConstants.ALGAET2;
//                     break;
//                 case "NET":
//                     m_elevator.setpose(Constants.ElevatorConstants.BARGE);
//                     wantedPose = Constants.ElevatorConstants.BARGE;
//                     break;
//                 default:
//                 DriverStation.reportError("State: " + m_level + " does not exist for Subsystem Elevator", false);
//             }

                
                

            
         
            
                

              
                
                

                

             
                    

                

                
//             }

          
    

//     @Override
//     public void execute() {

//     }

//     @Override 
//     public void end(boolean isfinished) {

//     } 
    
//     @Override
//     public boolean isFinished() {
//         if (Math.abs(wantedPose - m_elevator.getpose()) <= 0.5) {
//             return true;
//         } else {
//             return false;
//         }
//     }
// }
