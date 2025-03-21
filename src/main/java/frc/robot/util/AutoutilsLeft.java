package frc.robot.util;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;

@SuppressWarnings("all")

public class AutoutilsLeft {

    public AutoutilsLeft() {
        // Constructor
        
    }
    
    public static Pose2d getnewpose(double input) {
        Double doubleInput = new Double(input);
        int intInput = doubleInput.intValue();
        Pose2d goalpose = new Pose2d();
       
        switch(intInput) {
            case 6:
                goalpose = new Pose2d(13.048 ,2.913,Rotation2d.fromDegrees(120)); //done
                break;

            case 7:
                goalpose = new Pose2d(13.846 ,3.973 ,Rotation2d.fromDegrees(180)); //done
                break; 

            case 8:
                goalpose = new Pose2d(13.374,5.123 ,Rotation2d.fromDegrees(-120)); //done
                break; 

            case 9:
                goalpose = new Pose2d(12.050 ,5.294 ,Rotation2d.fromDegrees(-60)); //done
                break;

            case 10:
                goalpose = new Pose2d(11.262 ,4.236 ,Rotation2d.fromDegrees(0)); //done
                break;

            case 11:
                goalpose = new Pose2d(11.769 ,3.077 ,Rotation2d.fromDegrees(60)); //done 
                break;

            case 17:
                goalpose = new Pose2d(3.182 ,3.085 ,Rotation2d.fromDegrees(60)); //done
                break;

            case 18:
                goalpose = new Pose2d(2.691 ,4.289 ,Rotation2d.fromDegrees(0)); //done
                break;

            case 19:
                goalpose = new Pose2d(3.484 ,5.289 ,Rotation2d.fromDegrees(-60)); //done
                break;

            case 20:
                goalpose = new Pose2d(4.770 ,5.128 ,Rotation2d.fromDegrees(-120)); //done
                break;

            case 21:
                goalpose = new Pose2d(5.267 ,3.949 ,Rotation2d.fromDegrees(180)); //done
                break;

            case 22:
                goalpose = new Pose2d(4.485 ,2.927 ,Rotation2d.fromDegrees(120)); //done
                break;

            case -1:
                goalpose = new Pose2d(999,999, Rotation2d.fromDegrees(999)); // Default case if input is not in the range
                break;
        }

        return goalpose;
    }

}

