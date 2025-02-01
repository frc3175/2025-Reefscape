package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;

public class Constants {
    public static final double TRACK_WIDTH = Units.inchesToMeters(22.875);
    public static final double WHEEL_BASE = Units.inchesToMeters(22.875);

     public static final Translation2d[] moduleTranslations = new Translation2d[]{
            new Translation2d(WHEEL_BASE / 2.0, TRACK_WIDTH / 2.0),
            new Translation2d(WHEEL_BASE / 2.0, -TRACK_WIDTH / 2.0),
            new Translation2d(-WHEEL_BASE / 2.0, TRACK_WIDTH / 2.0),
            new Translation2d(-WHEEL_BASE / 2.0, -TRACK_WIDTH / 2.0)};




    public static final String CANIVORE = "elevatoryiboi";
    public static final String RIO = "rio";

    public static final int DRIVER_CONTROLER = 0;
    public static final int OPERATOR_CONTROLER = 1;




    public class ElevatorConstants {

        public static final int BACKID = 19;
        public static final int FRONTID = 3;

        public static final double HOME = 0.0;
        public static final double HUMAN = 1.0;
        public static final double L1 = 2.0;
        public static final double L2 = 3.0;
        public static final double L3 = 4.0;
        public static final double L4 = 5.0;
        public static final double BARGE = 6.0;
        public static final double ALGAET2 = 7.0;
        public static final double ALGAET3 = 8.0;

}


public class WristConstants {

    public static final int MOTORID = 2;

    public static final double HOME = 0.0;
    public static final double HUMAN = 1.0;
    public static final double L1 = 2.0;
    public static final double L2 = 3.0;
    public static final double L3 = 4.0;
    public static final double L4 = 5.0;
    public static final double BARGE = 6.0;
    public static final double ALGAET2 = 7.0;
    public static final double ALGAET3 = 8.0;
   
    
}

    public class AlgaeIntakeConstants {

        public static final int PIVOTID = 30;
        public static final int ROLLERID = 22;

        public static final double HOME = 0;
        public static final double OFFSET = 3;
        public static final double INTAKEANGLE = 0;

        public static final double INTAKE = 0.5;
        public static final double STOP = 0;

         
    }
    public class IntakeConstants{

        public static final int MOTORID = 1;

        public static final double INTAKE = 0.5;
        public static final double OUTTAKE = -0.5;
        public static final double STOP = 0.5;
        public static final double L1 = 0.5;
    
    }
    public class ClimberConstants{

        public static final int MOTORID = 37;
        
        public static final double NONE = 0;
    }

     
    
}
