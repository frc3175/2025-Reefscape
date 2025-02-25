package frc.robot.commands;

import java.nio.file.Path;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.path.GoalEndState;
import com.pathplanner.lib.path.IdealStartingState;
import com.pathplanner.lib.path.PathConstraints;
import com.pathplanner.lib.path.PathPlannerPath;
import com.pathplanner.lib.path.Waypoint;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.util.AutoutilsRight;

 

public class Auto {
    public CommandSwerveDrivetrain m_drivetrain;
    public Limelight m_limelight;
    public Rotation2d negativeHeading;
    public Command m_path;
    public Auto(CommandSwerveDrivetrain drivetrain, Limelight limelight) {


        m_drivetrain = drivetrain;
        m_limelight = limelight;
    }
   

    public Command newPath(double x, double y, double rotation) {

        Pose2d endPose = new Pose2d(x, y, Rotation2d.fromDegrees(rotation));
        PathConstraints constraints = new PathConstraints(2, .5, 2 * Math.PI, 4 * Math.PI); // The constraints for this path.

        // Create the path using the waypoints created above
        final  Command path =  AutoBuilder.pathfindToPose(
                endPose,
                constraints,
                0
        );

        
        return path;
    }
    
}
