package frc.robot;

import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;

public class FieldConstants {

    public static class ReefFaces {

        public static final Pose2d[] TAGS = new Pose2d[12]; 
        
            static {

                TAGS[0] = new Pose2d(13.474446, 3.3012379999999997, Rotation2d.fromDegrees(120)); //6
                TAGS[1] = new Pose2d(13.890498, 4.0208200000000005, Rotation2d.fromDegrees(180)); //7
                TAGS[2] = new Pose2d(13.474446, 4.740402, Rotation2d.fromDegrees(-120)); //8
                TAGS[3] = new Pose2d(12.643358, 4.740402, Rotation2d.fromDegrees(-60)); //9
                TAGS[4] = new Pose2d(12.227305999999999, 4.0208200000000005, Rotation2d.fromDegrees(0)); //10
                TAGS[5] = new Pose2d(12.643358, 3.3012379999999997, Rotation2d.fromDegrees(60)); //11

                TAGS[6] = new Pose2d(4.073905999999999, 3.3012379999999997, Rotation2d.fromDegrees(60)); //17
                TAGS[7] = new Pose2d(3.6576, 4.0208200000000005, Rotation2d.fromDegrees(0)); //18
                TAGS[8] = new Pose2d(4.073905999999999, 4.740402, Rotation2d.fromDegrees(-60)); //19
                TAGS[9] = new Pose2d(4.904739999999999, 4.740402, Rotation2d.fromDegrees(-120)); //20
                TAGS[10] = new Pose2d(5.321046, 4.0208200000000005, Rotation2d.fromDegrees(180)); //21
                TAGS[11] = new Pose2d(4.904739999999999, 3.3012379999999997, Rotation2d.fromDegrees(120)); //22

        };
    }

    public static class ReefSetPoints {

        public static final Pose2d[] RIGHTSETPOINTS = new Pose2d[12];

            static {

                RIGHTSETPOINTS[0] = new Pose2d(13.353 ,3.079,Rotation2d.fromDegrees(120));
                RIGHTSETPOINTS[1] = new Pose2d(13.856 ,4.303,Rotation2d.fromDegrees(180));
                RIGHTSETPOINTS[2] = new Pose2d(13.009,5.317 ,Rotation2d.fromDegrees(-120));
                RIGHTSETPOINTS[3] = new Pose2d(11.752 ,5.126,Rotation2d.fromDegrees(-60));
                RIGHTSETPOINTS[4] = new Pose2d(11.259 ,3.946,Rotation2d.fromDegrees(0));
                RIGHTSETPOINTS[5] = new Pose2d(12.050 ,2.908,Rotation2d.fromDegrees(60));

                RIGHTSETPOINTS[6] = new Pose2d(3.448 ,2.926,Rotation2d.fromDegrees(60));
                RIGHTSETPOINTS[7] = new Pose2d(2.692 ,3.949,Rotation2d.fromDegrees(0));
                RIGHTSETPOINTS[8] = new Pose2d(3.191 ,5.129,Rotation2d.fromDegrees(-60));
                RIGHTSETPOINTS[9] = new Pose2d(4.479 ,5.314,Rotation2d.fromDegrees(-120));
                RIGHTSETPOINTS[10] = new Pose2d(5.281 ,4.257,Rotation2d.fromDegrees(180));
                RIGHTSETPOINTS[11] = new Pose2d(4.786 ,3.080,Rotation2d.fromDegrees(120));
                
            };

        public static final Pose2d[] LEFTSETPOINTS = new Pose2d[12];

            static {
                LEFTSETPOINTS[0] = new Pose2d(13.048 ,2.913,Rotation2d.fromDegrees(120));
                LEFTSETPOINTS[1] = new Pose2d(13.846 ,3.973 ,Rotation2d.fromDegrees(180));
                LEFTSETPOINTS[2] = new Pose2d(13.374,5.123 ,Rotation2d.fromDegrees(-120));
                LEFTSETPOINTS[3] = new Pose2d(12.050 ,5.294 ,Rotation2d.fromDegrees(-60));
                LEFTSETPOINTS[4] = new Pose2d(11.262 ,4.236 ,Rotation2d.fromDegrees(0));
                LEFTSETPOINTS[5] = new Pose2d(11.769 ,3.077 ,Rotation2d.fromDegrees(60));

                LEFTSETPOINTS[6] = new Pose2d(3.182 ,3.085 ,Rotation2d.fromDegrees(60));
                LEFTSETPOINTS[7] = new Pose2d(2.691 ,4.289 ,Rotation2d.fromDegrees(0));
                LEFTSETPOINTS[8] = new Pose2d(3.484 ,5.289 ,Rotation2d.fromDegrees(-60));
                LEFTSETPOINTS[9] = new Pose2d(4.770 ,5.128 ,Rotation2d.fromDegrees(-120));
                LEFTSETPOINTS[10] = new Pose2d(5.267 ,3.949 ,Rotation2d.fromDegrees(180));
                LEFTSETPOINTS[11] = new Pose2d(4.485 ,2.927 ,Rotation2d.fromDegrees(120));
            };

    }
    
    public static Pose2d getNearestReefFace(Pose2d currentPose) {
        return currentPose.nearest(List.of(FieldConstants.ReefFaces.TAGS));

    } 

    public static Pose2d getNearestRightPose(Pose2d currentPose) {
        return getNearestReefFace(currentPose).nearest(List.of(FieldConstants.ReefSetPoints.RIGHTSETPOINTS));
    }

    public static Pose2d getNearestLeftPose(Pose2d currentPose) {
        return getNearestReefFace(currentPose).nearest(List.of(FieldConstants.ReefSetPoints.LEFTSETPOINTS));
    }

}
