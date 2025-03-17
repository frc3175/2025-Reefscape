package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Elevator;

public class SetElevator extends Command {

    Elevator m_elevator;
    String m_level;
    double wantedPose;

    public SetElevator(Elevator elevator, String level) {

        m_level = level;
        m_elevator = elevator;
        if(Constants.CORALMODE) {
            switch (level) {
                case "HOME":
                    m_elevator.setpose(Constants.ElevatorConstants.HOME);
                    wantedPose = Constants.ElevatorConstants.HOME;
                    break;

                case "INTAKE":
                    m_elevator.setpose(Constants.ElevatorConstants.INTAKE);
                    wantedPose = Constants.ElevatorConstants.INTAKE;
                    break;

                case "INTERMEDIATE":
                    m_elevator.setpose(Constants.ElevatorConstants.INTERMEDIATE);
                    wantedPose = Constants.ElevatorConstants.INTERMEDIATE;
                    break;

                case "CLIMB":
                    m_elevator.setpose(Constants.ElevatorConstants.CLIMB);
                    wantedPose = Constants.ElevatorConstants.CLIMB;
                    break;

                case "L1":
                    m_elevator.setpose(Constants.ElevatorConstants.L1);
                    wantedPose = Constants.ElevatorConstants.L1;
                    break;
                case "L2":
                    m_elevator.setpose(Constants.ElevatorConstants.L2);
                    wantedPose = Constants.ElevatorConstants.L2;
                    break;

                case "L3":
                    m_elevator.setpose(Constants.ElevatorConstants.L3);
                    wantedPose = Constants.ElevatorConstants.L3;
                    break;

                case "L4":
                    m_elevator.setpose(Constants.ElevatorConstants.L4);
                    wantedPose = Constants.ElevatorConstants.L4;
                    break;
            }
        } else {
            switch (level) {
                case "HOME":
                    m_elevator.setpose(Constants.ElevatorConstants.HOME);
                    wantedPose = Constants.ElevatorConstants.HOME;
                    break;

                case "INTAKE":
                    m_elevator.setpose(Constants.ElevatorConstants.INTAKE);
                    wantedPose = Constants.ElevatorConstants.INTAKE;
                    break;

                case "INTERMEDIATE":
                    m_elevator.setpose(Constants.ElevatorConstants.INTERMEDIATE);
                    wantedPose = Constants.ElevatorConstants.INTERMEDIATE;
                    break;
                
                case "CLIMB":
                    m_elevator.setpose(Constants.ElevatorConstants.CLIMB);
                    wantedPose = Constants.ElevatorConstants.CLIMB;
                    break;

                case "L1":
                    m_elevator.setpose(Constants.ElevatorConstants.PROCESSOR);
                    wantedPose = Constants.ElevatorConstants.PROCESSOR;
                    break;

                case "L2":
                    m_elevator.setpose(Constants.ElevatorConstants.ALGAET2);
                    wantedPose = Constants.ElevatorConstants.ALGAET2;
                    break;

                case "L3":
                    m_elevator.setpose(Constants.ElevatorConstants.ALGAET3);
                    wantedPose = Constants.ElevatorConstants.ALGAET2;
                    break;

                case "L4":
                    m_elevator.setpose(Constants.ElevatorConstants.BARGE);
                    wantedPose = Constants.ElevatorConstants.BARGE;
                    break;
            }

        }   
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

    }

    @Override 
    public void end(boolean isfinished) {

    } 
    
    @Override
    public boolean isFinished() {
        if (Math.abs(wantedPose - m_elevator.getpose()) <= 0.1) {
            return true;
        } else {
            return false;
        }
    }
}
