package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import frc.robot.subsystems.RobotState.BotState;

public class Constants {
    public static final double TRACK_WIDTH = Units.inchesToMeters(18.875);
    public static final double WHEEL_BASE = Units.inchesToMeters(18.875);

     public static final Translation2d[] moduleTranslations = new Translation2d[]{
            new Translation2d(WHEEL_BASE / 2.0, TRACK_WIDTH / 2.0),
            new Translation2d(WHEEL_BASE / 2.0, -TRACK_WIDTH / 2.0),
            new Translation2d(-WHEEL_BASE / 2.0, TRACK_WIDTH / 2.0),
            new Translation2d(-WHEEL_BASE / 2.0, -TRACK_WIDTH / 2.0)};




    public static final String CANIVORE = "";
    public static final String RIO = "";

    public static final int DRIVER_CONTROLER = 0;
    public static final int OPERATOR_CONTROLER = 1;




    public class ElevatorConstants {

        public static final int RIGHTID = 0;
        public static final int LEFTID = 1;

        public static final int HOME = 0;
        public static final int HUMAN = 0;
        public static final int L1 = 0;
        public static final int L2 = 0;
        public static final int L3 = 0;
        public static final int L4 = 0;
        public static final int BARGE = 0;
        public static final int ALGAET2 = 0;
        public static final int ALGAET3 = 0;


        public enum ElevatorState {

           

           
        }



    
}


public class WristConstants {

    public static final int MOTORID = 2;
   

    public static final int HOME = 0;
    public static final int HUMAN = 0;
    public static final int L1 = 0;
    public static final int L2 = 0;
    public static final int L3 = 0;
    public static final int L4 = 0;
    public static final int BARGE = 0;
    public static final int ALGAET2 = 0;
    public static final int ALGAET3 = 0;



    public enum WristState{

    }
}

    public class AlgaeIntakeConstants {
        public enum AlgaeIntakeState {


        } 
    }

     
    
}
