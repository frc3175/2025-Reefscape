package frc.robot.subsystems;

import java.util.Timer;

import edu.wpi.first.math.Matrix;
import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.math.numbers.N3;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;
import frc.robot.LimelightHelpers.PoseEstimate;

public class poseEsta  extends SubsystemBase  {
    Limelight m_Limelight;
    CommandSwerveDrivetrain drivetrain;

    public poseEsta(CommandSwerveDrivetrain drive, Limelight ll){
        drivetrain = drive;
        m_Limelight = ll;
    }

    private SwerveDrivePoseEstimator poseEstimator;
    private Matrix<N3, N1> robotPoseStdDevs = VecBuilder.fill(0,0,0);

    public void initializePoseEstimator(
        SwerveDriveKinematics kinematics,
        Rotation2d gyroAngle,
        SwerveModulePosition[] modulePositions,
        Pose2d initialPoseMeters
    ) {
        poseEstimator = new SwerveDrivePoseEstimator(kinematics, gyroAngle, modulePositions, initialPoseMeters);
    }
    

    public void addDriveMeasurement(Rotation2d rotation, SwerveModulePosition[] modulePositions) {
        poseEstimator.update(rotation, modulePositions);

    }

    public void addVisionMeasurement(Pose2d pose, Matrix<N3, N1> stdDevs, double timestamp) {
        poseEstimator.addVisionMeasurement(pose, timestamp, stdDevs);
    }

    public Pose2d getpose2d() {
        Pose2d pose = poseEstimator.getEstimatedPosition();
        return pose;
    }

    @Override
    public void periodic() {
        PoseEstimate llMeasurement = LimelightHelpers.getBotPoseEstimate_wpiRed_MegaTag2("limelight");
        addVisionMeasurement(m_Limelight.getpose3d(), robotPoseStdDevs, llMeasurement.timestampSeconds);

        SmartDashboard.putNumber("555 pose esta get X", poseEstimator.getEstimatedPosition().getX());
        SmartDashboard.putNumber("555 pose esta get y", poseEstimator.getEstimatedPosition().getY());
        SmartDashboard.putNumber("555 pose esta get R", poseEstimator.getEstimatedPosition().getRotation().getDegrees());

    }

    
}
