package frc.robot.util;

import java.util.Arrays;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.Constants;
import frc.robot.FieldConstants;

public class AutoutilsLeft {

    public AutoutilsLeft() {
        // Constructor
        
    }
    
    public static Pose2d getNewLeftPose(Pose2d currentPose) {
        Pose2d closestTag = currentPose.nearest(Arrays.asList(FieldConstants.ReefFaces.TAGS));
        
        Pose2d newPose = new Pose2d();

        if (closestTag == FieldConstants.ReefFaces.TAG6) {
            newPose = Constants.AutoAlignConstants.TAG6L;

        } else if (closestTag == FieldConstants.ReefFaces.TAG7) {
            newPose = Constants.AutoAlignConstants.TAG7L;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG8) {
            newPose = Constants.AutoAlignConstants.TAG8L;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG9) {
            newPose = Constants.AutoAlignConstants.TAG9L;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG10) {
            newPose = Constants.AutoAlignConstants.TAG10L;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG11) {
            newPose = Constants.AutoAlignConstants.TAG11L;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG17) {
            newPose = Constants.AutoAlignConstants.TAG17L;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG18) {
            newPose = Constants.AutoAlignConstants.TAG18L;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG19) {
            newPose = Constants.AutoAlignConstants.TAG19L;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG20) {
            newPose = Constants.AutoAlignConstants.TAG20L;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG21) {
            newPose = Constants.AutoAlignConstants.TAG21L;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG22) {
            newPose = Constants.AutoAlignConstants.TAG22L;
            
        }

        return newPose;
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
                goalpose = new Pose2d(3.216 ,3.060 ,Rotation2d.fromDegrees(60)); //done
                break;

            case 18:
                goalpose = new Pose2d(2.692 ,4.227 ,Rotation2d.fromDegrees(0)); //done
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
            default:
            goalpose = new Pose2d();
        }

        return goalpose;
    }

}

