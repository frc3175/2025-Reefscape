package frc.robot.commands;

import frc.robot.subsystems.RobotState;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Wrist;

public class SetWrist extends Command {

    Wrist m_wrist;
    String m_level;
    double wantedPose;
    RobotState m_robotState;

    public SetWrist(Wrist wrist, RobotState robotState, String level) {

        m_level = level;
        m_wrist = wrist;
        m_robotState = robotState;
    }

    @Override
    public void initialize() {
        if(m_robotState.isCoralMode()) {
            switch (m_level) {
                case "HOME":
                        m_wrist.setangle(Constants.WristConstants.INTERMEDIATE);
                        wantedPose = Constants.WristConstants.INTERMEDIATE;
                    break;

                case "INTAKE":
                    m_wrist.setangle(Constants.WristConstants.INTAKE);
                    wantedPose = Constants.WristConstants.INTAKE;
                    break;

                case "CLIMB":
                    m_wrist.setangle(Constants.WristConstants.CLIMB);
                    wantedPose = Constants.WristConstants.CLIMB;
                    break;

                case "L1":
                    m_wrist.setangle(Constants.WristConstants.L1);
                    wantedPose = Constants.WristConstants.L1;
                    break;
                case "L2":
                    m_wrist.setangle(Constants.WristConstants.L2);
                    wantedPose = Constants.WristConstants.L2;
                    break;

                case "L3":
                    m_wrist.setangle(Constants.WristConstants.L3);
                    wantedPose = Constants.WristConstants.L3;
                    break;

                case "L4":
                    m_wrist.setangle(Constants.WristConstants.L4);
                    wantedPose = Constants.WristConstants.L4;
                    break;
            }
        } else {
            switch (m_level) {
                case "HOME":
                    m_wrist.setangle(Constants.WristConstants.ALGAEHOME);
                    wantedPose = Constants.WristConstants.ALGAEHOME;
                    break;

                case "INTAKE":
                    m_wrist.setangle(Constants.WristConstants.INTAKE);
                    wantedPose = Constants.WristConstants.INTAKE;
                    break;

                case "CLIMB":
                    m_wrist.setangle(Constants.WristConstants.CLIMB);
                    wantedPose = Constants.WristConstants.CLIMB;
                    break;

                case "L1":
                    m_wrist.setangle(Constants.WristConstants.PROCESSOR);
                    wantedPose = Constants.WristConstants.PROCESSOR;
                    break;

                case "L2":
                    m_wrist.setangle(Constants.WristConstants.ALGAET2);
                    wantedPose = Constants.WristConstants.ALGAET2;
                    break;

                case "L3":
                    m_wrist.setangle(Constants.WristConstants.ALGAET3);
                    wantedPose = Constants.WristConstants.ALGAET2;
                    break;

                case "L4":
                    m_wrist.setangle(Constants.WristConstants.BARGE);
                    wantedPose = Constants.WristConstants.BARGE;
                    break;
            }

        }  
    }

    @Override
    public void execute() {

    }

    @Override 
    public void end(boolean isfinished) {

    } 
    
    @Override
    public boolean isFinished() {
        if (Math.abs(wantedPose - m_wrist.getpose()) <= 1) {
            return true;
        } else {
            return false;
        }
    }
}
