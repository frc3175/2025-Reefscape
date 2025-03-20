package frc.robot;

import frc.robot.subsystems.Elevator.ElevatorState;
import frc.robot.subsystems.Intake.IntakeState;
import frc.robot.subsystems.Wrist.Wriststate;
import frc.robot.subsystems.Climber.ClimberState;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RobotState extends SubsystemBase {

    private BotState robotState;
    private boolean m_isAlgaestate;

    public RobotState(Intake intake, Elevator elevator,  Wrist wrist, Climber climber){
        

    }

    public void setBotState(BotState state) {
        robotState = state;
    }
    public BotState getRobotState() {
        return robotState;
    }
    public void setGamepieceState(boolean isAlgaestate) {
        m_isAlgaestate = isAlgaestate;
    }
    public boolean getGamepieceState() {
        return m_isAlgaestate;
    }

    public enum BotState {

        HP(Wriststate.HP, ElevatorState.HP, IntakeState.INTAKE,  ClimberState.HOME, false),
        HOME(Wriststate.HOME, ElevatorState.HOME, IntakeState.STOP, ClimberState.HOME, false);
    
        public IntakeState intakeState;
        public ElevatorState elevatorState;
        
        public Wriststate wristState;
        public ClimberState climberState;
        public boolean Algaemode;

        private BotState(Wriststate wristState, ElevatorState elevatorState, IntakeState intakeState,  ClimberState climberState, boolean Algaemode) {
            this.intakeState = intakeState;
            this.elevatorState = elevatorState;
            this.wristState = wristState;
            this.climberState = climberState;
            this.Algaemode = Algaemode;
        }
    
    }

    @Override 
    public void periodic() {

        SmartDashboard.putBoolean("Gamepiece State", getGamepieceState());
        SmartDashboard.putString("Robot State", getRobotState().toString());

    }
    

}