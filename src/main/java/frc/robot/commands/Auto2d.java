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
import com.pathplanner.lib.pathfinding.Pathfinding;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.util.AutoutilsRight;

 

public class Auto2d {
    public CommandSwerveDrivetrain m_drivetrain;
    public Limelight m_limelight;
    public Rotation2d negativeHeading;
    public Command m_path;
    public Auto2d(CommandSwerveDrivetrain drivetrain, Limelight limelight) {


        m_drivetrain = drivetrain;
        m_limelight = limelight;
    }
   

    public Command newPath(Limelight ll, boolean isLeft) {

        // if(pose.getX() == 999){
        //     return new Command() {};
        // }else{
            m_limelight = ll;

        Pose2d endPose = AutoutilsRight.getnewpose(m_limelight.getTargetid(), isLeft);
        PathConstraints constraints = new PathConstraints(4, 1, 2 * Math.PI, 4 * Math.PI); // The constraints for this path.

        // Create the path using the waypoints created above
        final  Command path =  AutoBuilder.pathfindToPose(
                endPose,
                constraints,
                0
            
        );
        
        return path;
    // }
        
       
    }
    
}
