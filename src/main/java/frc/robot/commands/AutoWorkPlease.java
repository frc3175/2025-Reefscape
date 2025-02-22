// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.path.PathConstraints;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CommandSwerveDrivetrain;



/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */

public class AutoWorkPlease extends Command {
  public Command m_path;
 private boolean m_isFinshed;
 private boolean end = false;
  /** Creates a new AutoWorkPlease. */
  public AutoWorkPlease(Pose2d Pose) {
    Pose2d endPose = Pose;
        PathConstraints constraints = new PathConstraints(4, 1, 2 * Math.PI, 4 * Math.PI); // The constraints for this path.

        // Create the path using the waypoints created above
        final  Command path =  AutoBuilder.pathfindToPose(
                endPose,
                constraints,
                0


                
            
        );
        m_path = path;
    // Use addRequirements() here to declare subsystem dependencies.
  }
  public void changefin(boolean isdone){
    m_isFinshed = isdone;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_path.schedule();
    end = true;
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return end;
  }
}
