package frc.robot.commands;

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
        if (m_intake.HasCoral()) {
            m_intake.coralintakerunvoltage(Constants.CoralIntakeConstants.HOLD);
        } 
        if (m_intake.HasAlgae()) {
            m_intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.HOLD);
        }

        if(m_robotState.isCoralMode() && !m_intake.HasCoral()) {
            switch (m_level) {
                case "HOME":
                    m_intake.coralintakerunvoltage(Constants.CoralIntakeConstants.STOP);
                    break;

                case "INTAKE":
                    m_intake.coralintakerunvoltage(Constants.CoralIntakeConstants.INTAKE);
                    break;

                case "INTERMEDIATE":
                    m_intake.coralintakerunvoltage(Constants.CoralIntakeConstants.HOLD);
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
                    m_intake.coralIntakePercentOutput(-.2);//(Constants.CoralIntakeConstants.OUTTAKE);
                    break;
            }
        } else if (!m_robotState.isCoralMode() && !m_intake.HasAlgae()) {
            switch (m_level) {
                case "HOME":
                    m_intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.STOP);
                    break;

                case "INTAKE":
                    m_intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.INTAKE);
                    break;

                case "INTERMEDIATE":
                    m_intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.HOLD);
                    break;

                case "CLIMB":
                    m_intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.STOP);
                    break;

                case "L1":
                    m_intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.HOLD);
                    break;

                case "L2":
                    m_intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.INTAKE);
                    break;

                case "L3":
                    m_intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.INTAKE);
                    break;

                case "L4":
                    m_intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.HOLD);
                    break;

                case "OUTTAKE":
                    m_intake.algaeintakerunvoltage(Constants.AlgaeIntakeConstants.OUTTAKE);
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
        return true;
        
    }
    
}
