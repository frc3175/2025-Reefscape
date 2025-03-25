package frc.robot.util;

import java.util.Arrays;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.Constants;
import frc.robot.FieldConstants;

@SuppressWarnings("all")

public class AutoutilsRight {

    public AutoutilsRight() {
        // Constructor
        
    }

    public static Pose2d getNewRightPose(Pose2d currentPose) {
        Pose2d closestTag = currentPose.nearest(Arrays.asList(FieldConstants.ReefFaces.TAGS));
        
        Pose2d newPose = new Pose2d();

        if (closestTag == FieldConstants.ReefFaces.TAG6) {
            newPose = Constants.AutoAlignConstants.TAG6R;

        } else if (closestTag == FieldConstants.ReefFaces.TAG7) {
            newPose = Constants.AutoAlignConstants.TAG7R;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG8) {
            newPose = Constants.AutoAlignConstants.TAG8R;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG9) {
            newPose = Constants.AutoAlignConstants.TAG9R;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG10) {
            newPose = Constants.AutoAlignConstants.TAG10R;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG11) {
            newPose = Constants.AutoAlignConstants.TAG11R;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG17) {
            newPose = Constants.AutoAlignConstants.TAG17R;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG18) {
            newPose = Constants.AutoAlignConstants.TAG18R;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG19) {
            newPose = Constants.AutoAlignConstants.TAG19R;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG20) {
            newPose = Constants.AutoAlignConstants.TAG20R;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG21) {
            newPose = Constants.AutoAlignConstants.TAG21R;
            
        } else if (closestTag == FieldConstants.ReefFaces.TAG22) {
            newPose = Constants.AutoAlignConstants.TAG22R;
            
        }

        return newPose;
    }
    
    
    public static Pose2d getnewpose(double input) {
        Double doubleInput = new Double(input);
        int intInput = doubleInput.intValue();
        Pose2d goalpose = new Pose2d();
       
        switch(intInput) {
            case 6:
                goalpose = new Pose2d(13.353 ,3.079,Rotation2d.fromDegrees(120)); //done
                break;

            case 7:
                goalpose = new Pose2d(13.856 ,4.303,Rotation2d.fromDegrees(180)); //done
                break;

            case 8:
                goalpose = new Pose2d(13.009,5.317 ,Rotation2d.fromDegrees(-120)); //done
                break;

            case 9:
                goalpose = new Pose2d(11.752 ,5.126,Rotation2d.fromDegrees(-60)); //done
                break;

            case 10:
                goalpose = new Pose2d(11.259 ,3.946,Rotation2d.fromDegrees(0)); //done
                break;

            case 11:
                goalpose = new Pose2d(12.050 ,2.908,Rotation2d.fromDegrees(60)); //done
                break;

            case 17:
                goalpose = new Pose2d(3.507 ,2.877,Rotation2d.fromDegrees(60)); //done
                break;

            case 18:
                goalpose = new Pose2d(2.696 ,3.906,Rotation2d.fromDegrees(0)); //done
                break;

            case 19:
                goalpose = new Pose2d(3.191 ,5.129,Rotation2d.fromDegrees(-60)); //done
                break;

            case 20:
                goalpose = new Pose2d(4.479 ,5.314,Rotation2d.fromDegrees(-120)); //done
                break;

            case 21:
                goalpose = new Pose2d(5.281 ,4.257,Rotation2d.fromDegrees(180)); //done
                break;

            case 22:
                goalpose = new Pose2d(4.786 ,3.080,Rotation2d.fromDegrees(120)); //done
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



    

