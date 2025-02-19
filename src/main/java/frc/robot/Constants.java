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

        //set points
        public static final double HOME = 0.4;  //0.4
        public static final double HUMAN = 1.0;
        public static final double L1 = 0;
        public static final double L2 = 4.6; //4
        public static final double L3 = 10.2; //10
        public static final double L4 = 18.0;
        public static final double BARGE = 17.6;
        public static final double ALGAET2 = 1.37;
        public static final double ALGAET3 = 7.15;
        
        
        //configs
        public static final double kp = 1; //1
        public static final double ki = 0; //0
        public static final double kD = 0.05; //0.05
        public static final double kV = 0.05; //0.05
        public static final double kS = 0.08; //0.08
        public static final double kG = 0.16; //0.16

        public static final double  MotionMagicCruiseVelocity = 90;
        public static final double  MotionMagicAcceleration = 180;
        public static final double  MotionMagicJerk = 600;
        public static final boolean EnableFOC = true;

        public static final boolean CurrentLimitEnable = true;
        public static final double  CurrentLimit       = 80;

}


public class WristConstants {

    public static final int MOTORID = 2;

    public static final double HOME = 0; //working
    public static final double HUMAN = 19.7;
    public static final double L1 = -12;
    public static final double L2 = -10;
    public static final double L3 = -10; //-8.8^
    public static final double L4 = -11;
    public static final double BARGE = -20;
    public static final double ALGAET2 = -11.27;
    public static final double ALGAET3 = -11.27;
    public static final double ALGAEIN = 7.7;


    public static final double climb = -15; //-15 //-32 is up


   
    
}

    public class AlgaeIntakeConstants {

        public static final int PIVOTID = 30;
        public static final int ROLLERID = 22;

        public static final double HOME = 0;  
        public static final double OFFSET = 4.8; //working
        public static final double INTAKEANGLE = 13.2; //working
        public static final double climb = 19.583984375;

        public static final double INTAKE = 0.5;
        public static final double STOP = 0;

         
    }
    public class IntakeConstants{

        public static final int MOTORID = 1;

        public static final double INTAKE = 13;
        public static final double OUTTAKE = -10;
        public static final double OUTTAKEFAST = -13; //-0.5
        public static final double STOP = 0;
        public static final double L1 = -5;
    
    }
    public class ClimberConstants{

        public static final int MOTORID = 37;
        
        public static final double HOME = 0;
    }

    public class CANdleConstants{
        public static final int CANdleID = 43;
    }

    public static double stickDeadband = 0.1;
    

     
    
}
