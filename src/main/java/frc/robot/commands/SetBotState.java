package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.BotState;
import frc.robot.subsystems.BotState.BobotState;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Wrist;

public class SetBotState extends Command {

    BotState m_botState;
    BobotState m_state;
    Elevator m_elevator;
    Wrist m_wrist;
    Intake m_intake;


    public SetBotState(BotState botState, Elevator elevator, Wrist wrist, Intake intake, BobotState desiredState) {

        m_state = desiredState;
        m_botState = botState;
        m_elevator = elevator;
        m_wrist = wrist;
        m_intake = intake;

    }

    @Override
    public void initialize() {

        m_botState.setBotState(m_state);
        m_elevator.setpose(m_botState.getCurrentBotState().elevatorState.elevatorSetpoint);
        m_wrist.setangle(m_botState.getCurrentBotState().wristState.wristSetpoint, m_state.wristState.wristVelocity, m_state.wristState.wristAcceleration, m_state.wristState.wristJerk);
        m_intake.coralintakerunvoltage(m_botState.getCurrentBotState().intakeState.coralIntakeSpeed);
        m_intake.algaeintakerunvoltage(m_botState.getCurrentBotState().intakeState.algaeIntakeSpeed);

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
