package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.StateManger;

public class SetIntakeAndReset extends Command {

    Intake m_intake;
    StateManger m_stateManager;

    public SetIntakeAndReset(Intake intake, StateManger m_StateManager) {

        m_intake = intake;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

        m_intake.coralintakerunvoltage(Constants.CoralIntakeConstants.INTAKE);

    }

    @Override 
    public void end(boolean isfinished) {

        m_stateManager.setRobotState("INTERMEDIATE");
        m_intake.coralintakerunvoltage(Constants.CoralIntakeConstants.HOLD);

    } 
    
    @Override
    public boolean isFinished() {
        return m_intake.HasCoral();
    }
}
