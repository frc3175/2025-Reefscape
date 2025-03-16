package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.StateManger;

public class SetWrist extends Command {

    Wrist m_wrist;
    int m_level;
    double wantedPose;

    public SetWrist(Wrist wrist, int level) {

        m_level = level;
        m_wrist = wrist;
        if(Constants.CORALMODE) {
            switch (level) {
                case 1:
                    m_wrist.setangle(Constants.WristConstants.L1);
                    wantedPose = Constants.WristConstants.L1;
                    break;
                case 2:
                    m_wrist.setangle(Constants.WristConstants.L2);
                    wantedPose = Constants.WristConstants.L2;
                    break;

                case 3:
                    m_wrist.setangle(Constants.WristConstants.L3);
                    wantedPose = Constants.WristConstants.L3;
                    break;

                case 4:
                    m_wrist.setangle(Constants.WristConstants.L4);
                    wantedPose = Constants.WristConstants.L4;
                    break;
            }
        } else {
            switch (level) {
                case 1:
                    m_wrist.setangle(Constants.WristConstants.PROCESSOR);
                    wantedPose = Constants.WristConstants.PROCESSOR;
                    break;

                case 2:
                    m_wrist.setangle(Constants.WristConstants.ALGAET2);
                    wantedPose = Constants.WristConstants.ALGAET2;
                    break;

                case 3:
                    m_wrist.setangle(Constants.WristConstants.ALGAET3);
                    wantedPose = Constants.WristConstants.ALGAET2;
                    break;

                case 4:
                    m_wrist.setangle(Constants.WristConstants.BARGE);
                    wantedPose = Constants.WristConstants.BARGE;
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
        if (Math.abs(wantedPose - m_wrist.getpose()) <= 0.1) {
            return true;
        } else {
            return false;
        }
    }
}
