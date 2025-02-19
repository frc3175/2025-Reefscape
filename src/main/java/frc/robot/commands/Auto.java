package frc.robot.commands;

import java.util.List;

import com.pathplanner.lib.path.GoalEndState;
import com.pathplanner.lib.path.IdealStartingState;
import com.pathplanner.lib.path.PathConstraints;
import com.pathplanner.lib.path.PathPlannerPath;
import com.pathplanner.lib.path.Waypoint;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.RobotState;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.util.Autoangles;

 

public class Auto {
    public CommandSwerveDrivetrain m_drivetrain;
    public Limelight m_limelight;
    public Rotation2d negativeHeading;
    public PathPlannerPath m_toapriltag;
    public Auto(CommandSwerveDrivetrain drivetrain, Limelight limelight) {

    Pose2d startPose = drivetrain.getState().Pose;
    Pose2d endPose = new Pose2d(4.0, 4.0, Rotation2d.fromDegrees(0));
   
        // Create a list of waypoints from poses. Each pose represents one waypoint.
// The rotation component of the pose should be the direction of travel. Do not use holonomic rotation.
// List<Waypoint> waypoints = PathPlannerPath.waypointsFromPoses(
//         Pose2d = drivetrain.getState().Pose,
//         new Pose2d(4, 4, Rotation2d.fromDegrees(0))
// );

PathConstraints constraints = new PathConstraints(0.5, .5, 2 * Math.PI, 4 * Math.PI); // The constraints for this path.
// PathConstraints constraints = PathConstraints.unlimitedConstraints(12.0); // You can also use unlimited constraints, only limited by motor torque and nominal battery voltage

// Create the path using the waypoints created above
final PathPlannerPath toapriltag = new PathPlannerPath(
        PathPlannerPath.waypointsFromPoses(startPose, endPose),
        constraints,
        null, // The ideal starting state, this is only relevant for pre-planned paths, so can be null for on-the-fly paths.
        new GoalEndState(0.0, Rotation2d.fromDegrees(0)) 
        // Goal end state. You can set a holonomic rotation here. If using a differential drivetrain, the rotation will have no effect.
);
m_toapriltag = toapriltag;

// Prevent the path from being flipped if the coordinates are already correct
toapriltag.preventFlipping = true
;
toapriltag.name = "toapriltag"; // The name of the path. This is used for debugging and logging purposes.

        // Constructor
    }
    public PathPlannerPath getPath() {
        return m_toapriltag;
    }
    
}
