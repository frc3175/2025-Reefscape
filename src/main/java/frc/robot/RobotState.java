package main.java.frc.robot;

import frc.robot.subsystems.Elevator.ElevatorState;
import frc.robot.subsystems.Intake.IntakeState;
import frc.robot.subsystems.AlgaeIntake.AlgaeIntakeState;
import frc.robot.subsystems.Wrist.Wriststate;
import frc.robot.subsystems.Climber.ClimberState;
import frc.robot.subsystems.AlgaeIntake;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Wrist;


import frc.robot.subsystems.Slide;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.AlgaeIntakeConstants;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;

public class RobotState extends SubsystemBase {

    private BotState robotState;
    private boolean m_isAlgaestate;

    public RobotState(Intake intake, Elevator elevator, AlgaeIntake algaeIntake, Wrist wrist, Climber climber){
        setBotState(BotState.reset);

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
        return m_isConem_isAlgaestateState;
    }

    public enum BotState {

        HP(Wriststate.HP, ElevatorState.HP, IntakeState.INTAKE, AlgaeIntakeState.INTAKE, ClimberState.HOME, false),
        HOME(Wriststate.HOME, ElevatorState.HOME, Constants.IntakeConstants.STOP, Constants.AlgaeIntakeConstants.OFFSET, ClimberState.HOME, false);
    
        public IntakeState intakeState;
        public ElevatorState elevatorState;
        public AlgaeIntakeState algaeIntakeState;
        public Wriststate wristState;
        public ClimberState climberState;
        public boolean Algaemode;

        private BotState(Wriststate wristState, ElevatorState elevatorState, IntakeState intakeState, AlgaeIntakeState algaeIntakeState, ClimberState climberState, boolean Algaemode) {
            this.intakeState = intakeState;
            this.elevatorState = elevatorState;
            this.algaeIntakeState = algaeIntakeState;
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