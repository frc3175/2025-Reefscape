package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.RobotState;

public class SetIntake extends Command {

    Intake m_intake;
    String m_level;
    RobotState m_robotState;

    public SetIntake(Intake intake, RobotState robotState, String level) {

        m_level = level;
        m_intake = intake;
        m_robotState = robotState;

    }

    @Override
    public void initialize() {
            switch (m_level) {
                case "HOME":
                    m_intake.coralintakerunvoltage(Constants.CoralIntakeConstants.HOLD);
                    break;

                case "INTAKE":
                    m_intake.coralintakerunvoltage(Constants.CoralIntakeConstants.INTAKE);
                    break;

                case "CLIMB":
                    m_intake.coralintakerunvoltage(Constants.CoralIntakeConstants.STOP);
                    break;

                case "L1":
                    m_intake.coralintakerunvoltage(Constants.CoralIntakeConstants.HOLD);
                    break;

                case "L2":
                    m_intake.coralintakerunvoltage(Constants.CoralIntakeConstants.HOLD);
                    break;

                case "L3":
                    m_intake.coralintakerunvoltage(Constants.CoralIntakeConstants.HOLD);
                    break;

                case "L4":
                    m_intake.coralintakerunvoltage(Constants.CoralIntakeConstants.HOLD);
                    break;
                case "OUTTAKE":
                    m_intake.coralintakerunvoltage(Constants.CoralIntakeConstants.OUTTAKE);;//(Constants.CoralIntakeConstants.OUTTAKE);
                    break;
                case "ALGAET2":
                m_intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.INTAKE);
                    break;
                case "AlGAET3":
                m_intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.INTAKE);
                    break;
                case "NET":
                m_intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.HOLD);
                    break;
                default:
                DriverStation.reportError("State: " + m_level + " does not exist for Subsystem Intake", false);
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
        return true;
        
    }
    
}
