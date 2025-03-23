package frc.robot.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.Constants;
import frc.robot.FieldConstants;

@SuppressWarnings("all")

public class Autoutils {

    public Autoutils() {
        // Constructor
        
    }

    public enum AutoUtilsLeft {

        TAG6L(FieldConstants.ReefFaces.TAG6, Constants.AutoAlignConstants.TAG6L),
        TAG7L(FieldConstants.ReefFaces.TAG7, Constants.AutoAlignConstants.TAG7L),
        TAG8L(FieldConstants.ReefFaces.TAG8, Constants.AutoAlignConstants.TAG8L),
        TAG9L(FieldConstants.ReefFaces.TAG9, Constants.AutoAlignConstants.TAG9L),
        TAG10L(FieldConstants.ReefFaces.TAG10, Constants.AutoAlignConstants.TAG10L),
        TAG11L(FieldConstants.ReefFaces.TAG11, Constants.AutoAlignConstants.TAG11L),
        TAG17L(FieldConstants.ReefFaces.TAG17, Constants.AutoAlignConstants.TAG17L),
        TAG18L(FieldConstants.ReefFaces.TAG18, Constants.AutoAlignConstants.TAG18L),
        TAG19L(FieldConstants.ReefFaces.TAG19, Constants.AutoAlignConstants.TAG19L),
        TAG20L(FieldConstants.ReefFaces.TAG20, Constants.AutoAlignConstants.TAG20L),
        TAG21L(FieldConstants.ReefFaces.TAG21, Constants.AutoAlignConstants.TAG21L),
        TAG22L(FieldConstants.ReefFaces.TAG22, Constants.AutoAlignConstants.TAG22L);

        public final Pose2d reefFace;
        public final Pose2d endPose;
        private AutoUtilsLeft (Pose2d reefFace, Pose2d endPose) {
            this.reefFace = reefFace;
            this.endPose = endPose;
        }

        public Pose2d getReefFace() {
            return reefFace;
        }

        public static AutoUtilsLeft fromReefFace(Pose2d reefFace) {
            for (AutoUtilsLeft entry : AutoUtilsLeft.values()) {
                if (entry.getReefFace().equals(reefFace)) {
                    return entry;
                }
            }
            return null;
        }
    }

    public enum AutoUtilsRight {

        TAG6R(FieldConstants.ReefFaces.TAG6, Constants.AutoAlignConstants.TAG6R),
        TAG7R(FieldConstants.ReefFaces.TAG7, Constants.AutoAlignConstants.TAG7R),
        TAG8R(FieldConstants.ReefFaces.TAG8, Constants.AutoAlignConstants.TAG8R),
        TAG9R(FieldConstants.ReefFaces.TAG9, Constants.AutoAlignConstants.TAG9R),
        TAG10R(FieldConstants.ReefFaces.TAG10, Constants.AutoAlignConstants.TAG10R),
        TAG11R(FieldConstants.ReefFaces.TAG11, Constants.AutoAlignConstants.TAG11R),
        TAG17R(FieldConstants.ReefFaces.TAG17, Constants.AutoAlignConstants.TAG17R),
        TAG18R(FieldConstants.ReefFaces.TAG18, Constants.AutoAlignConstants.TAG18R),
        TAG19R(FieldConstants.ReefFaces.TAG19, Constants.AutoAlignConstants.TAG19R),
        TAG20R(FieldConstants.ReefFaces.TAG20, Constants.AutoAlignConstants.TAG20R),
        TAG21R(FieldConstants.ReefFaces.TAG21, Constants.AutoAlignConstants.TAG21R),
        TAG22R(FieldConstants.ReefFaces.TAG22, Constants.AutoAlignConstants.TAG22R);

        public final Pose2d reefFace;
        public final Pose2d endPose;
        private AutoUtilsRight (Pose2d reefFace, Pose2d endPose) {
            this.reefFace = reefFace;
            this.endPose = endPose;
        }

        public Pose2d getReefFace() {
            return reefFace;
        }

        public static AutoUtilsRight fromReefFace(Pose2d reefFace) {
            for (AutoUtilsRight entry : AutoUtilsRight.values()) {
                if (entry.getReefFace().equals(reefFace)) {
                    return entry;
                }
            }
            return null;
        }
    }
    
    // public static Pose2d getnewpose(double input) {
    //     Double doubleInput = new Double(input);
    //     int intInput = doubleInput.intValue();
    //     Pose2d goalpose = new Pose2d();
       
    //     switch(intInput) {
    //         case 6:
    //             goalpose = new Pose2d(13.048 ,2.913,Rotation2d.fromDegrees(120)); //done
    //             break;

    //         case 7:
    //             goalpose = new Pose2d(13.846 ,3.973 ,Rotation2d.fromDegrees(180)); //done
    //             break; 

    //         case 8:
    //             goalpose = new Pose2d(13.374,5.123 ,Rotation2d.fromDegrees(-120)); //done
    //             break; 

    //         case 9:
    //             goalpose = new Pose2d(12.050 ,5.294 ,Rotation2d.fromDegrees(-60)); //done
    //             break;

    //         case 10:
    //             goalpose = new Pose2d(11.262 ,4.236 ,Rotation2d.fromDegrees(0)); //done
    //             break;

    //         case 11:
    //             goalpose = new Pose2d(11.769 ,3.077 ,Rotation2d.fromDegrees(60)); //done 
    //             break;

    //         case 17:
    //             goalpose = new Pose2d(3.216 ,3.060 ,Rotation2d.fromDegrees(60)); //done
    //             break;

    //         case 18:
    //             goalpose = new Pose2d(2.692 ,4.227 ,Rotation2d.fromDegrees(0)); //done
    //             break;

    //         case 19:
    //             goalpose = new Pose2d(3.484 ,5.289 ,Rotation2d.fromDegrees(-60)); //done
    //             break;

    //         case 20:
    //             goalpose = new Pose2d(4.770 ,5.128 ,Rotation2d.fromDegrees(-120)); //done
    //             break;

    //         case 21:
    //             goalpose = new Pose2d(5.267 ,3.949 ,Rotation2d.fromDegrees(180)); //done
    //             break;

    //         case 22:
    //             goalpose = new Pose2d(4.485 ,2.927 ,Rotation2d.fromDegrees(120)); //done
    //             break;

    //         case -1:
    //             goalpose = new Pose2d(999,999, Rotation2d.fromDegrees(999)); // Default case if input is not in the range
    //             break;
    //         default:
    //         goalpose = new Pose2d();
    //     }

    //     return goalpose;
    // }

}

