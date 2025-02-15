// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.ResourceBundle.Control;

import com.ctre.phoenix6.mechanisms.swerve.LegacySwerveRequest.FieldCentric;
import com.ctre.phoenix6.swerve.SwerveDrivetrain;
import com.ctre.phoenix6.swerve.SwerveRequest;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.util.Autoangles;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Autoturn extends Command {

  private CommandSwerveDrivetrain drivetrain;
  private Limelight camera;
  private CommandXboxController m_controller;
  
  private PIDController xController = new PIDController(.02, .1, .01);
  private PIDController yController = new PIDController(0.1, 0, 0);
  private PIDController turnController = new PIDController(.2, 0, .01 ); //.2  .01good enough
  boolean ready = false;


  private final double X_SETPOINT = -30;
    private final double Y_SETPOINT = 7;

    SwerveRequest.FieldCentric motion = new SwerveRequest.FieldCentric();


  public Autoturn(CommandSwerveDrivetrain drive, Limelight limelight, CommandXboxController controller, Boolean Rightside) {
    drivetrain = drive;
    camera = limelight;
    m_controller = controller;

    xController.setSetpoint(X_SETPOINT);
    yController.setSetpoint(Y_SETPOINT);

    turnController.setTolerance(1);
    xController.setTolerance(5);
    yController.setTolerance(3);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if(!camera.hasTarget())
    {
      end(true);
    }else{
      double tag = camera.getTargetid();

       if(Autoangles.getAngle(1) == -1){
        end(true);
       }else{
          
        Rotation2d yaw = drivetrain.get2dgyro();
        double angle = Autoangles.getAngle(camera.getTargetid());
        turnController.setSetpoint(angle);
        // xController.setSetpoint(2);
        // yController.setSetpoint(7);


        xController.setSetpoint(X_SETPOINT);
    yController.setSetpoint(Y_SETPOINT);

        
        drivetrain.setControl(
          motion.withVelocityX(yController.calculate(camera.getYOffset())) // TOFIX DONT RUN TILL FIXED PLEASE 
          .withVelocityY(xController.calculate(camera.getXOffset())) // Drive left with negative X (left)
          .withRotationalRate(turnController.calculate(yaw.getDegrees())));

            if(turnController.atSetpoint() || xController.atSetpoint()){
              end(true);
            }
            

          



          // double x = dis.getX();
          // double y = dis.getY();
          // double xSpeed = xController.calculate(x);
          // double ySpeed = yController.calculate(y);
          // rotationSpeed = -turnController.calculate(yaw, 0);
          // drivetrain.drive(new Translation2d(xSpeed, ySpeed),-rotationSpeed , false, false);


       }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // drivetrain.setControl(
    //   motion/*.withVelocityX(0)*/ // Drive forward with negative Y (forward)
    //   // .withVelocityY(0) // Drive left with negative X (left)
    //   .withRotationalRate(0));
    //   // new Autotranslate(drivetrain, camera, m_controller, true);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
