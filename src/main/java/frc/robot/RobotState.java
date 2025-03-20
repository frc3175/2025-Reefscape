package frc.robot;

import frc.robot.subsystems.Elevator.ElevatorState;
import frc.robot.subsystems.Intake.IntakeState;
import frc.robot.subsystems.Wrist.Wriststate;

import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;



import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RobotState extends SubsystemBase {

    private BotState robotState;
    

    public RobotState(Intake intake, Elevator elevator,  Wrist wrist, Climber climber){
        setBotState(BotState.HOME);
    }

    public void setBotState(BotState state) {
        robotState = state;
    }

    public BotState getRobotState() {
        return robotState;
    }
    
    

    public enum BotState {

        INTAKE(Wriststate.INTAKE, ElevatorState.INTAKE, IntakeState.INTAKE),
        HOME(Wriststate.HOME, ElevatorState.HOME, IntakeState.HOME),
        CLIMB(Wriststate.CLIMB, ElevatorState.CLIMB, IntakeState.CLIMB),
        L1(Wriststate.L1, ElevatorState.L1, IntakeState.L1),
        L2(Wriststate.L2, ElevatorState.L2, IntakeState.L2),
        L3(Wriststate.L3, ElevatorState.L3, IntakeState.L3),
        L4(Wriststate.L4, ElevatorState.L4, IntakeState.L4),
        PROCESSOR(Wriststate.PROCESSOR, ElevatorState.PROCESSOR, IntakeState.L1),
        ALGAET2(Wriststate.ALGAET2, ElevatorState.ALGAET2, IntakeState.ALGAET2),
        ALGAET3(Wriststate.ALGAET3, ElevatorState.ALGAET3, IntakeState.ALGAET3),
        NET(Wriststate.NET, ElevatorState.NET, IntakeState.NET);
    
        public IntakeState intakeState;
        public ElevatorState elevatorState;
        public Wriststate wristState;
        
        private BotState(Wriststate wristState, ElevatorState elevatorState, IntakeState intakeState) {
            this.intakeState = intakeState;
            this.elevatorState = elevatorState;
            this.wristState = wristState;
            
           
        }
    
    }

    @Override 
    public void periodic() {
        SmartDashboard.putString("Robot State", getRobotState().toString());

    }
    

}