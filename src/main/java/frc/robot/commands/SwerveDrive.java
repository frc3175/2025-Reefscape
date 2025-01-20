package frc.robot.commands;

import java.util.Arrays;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.SwerveRequest;
import com.ctre.phoenix6.swerve.SwerveDrivetrain.SwerveDriveState;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.units.Unit;
import edu.wpi.first.wpilibj2.command.Command;
import frc.lib.geometry.Translation2dPlus;
import frc.robot.Constants;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.CommandSwerveDrivetrain;


import static edu.wpi.first.units.Units.*;




public class SwerveDrive extends Command {    
    
    private CommandSwerveDrivetrain m_swerveDrivetrain;    
    private DoubleSupplier m_translationSup;
    private DoubleSupplier m_strafeSup;
    private DoubleSupplier m_rotationSup;
    private BooleanSupplier m_robotCentricSup;
    private BooleanSupplier m_isEvading;

    
    private static final Translation2d[] WHEEL_POSITIONS =
        Arrays.copyOf(Constants.moduleTranslations, Constants.moduleTranslations.length);
        

    public SwerveDrive(CommandSwerveDrivetrain swerveDrivetrain, 
                       DoubleSupplier translationSup, 
                       DoubleSupplier strafeSup, 
                       DoubleSupplier rotationSup, 
                       BooleanSupplier robotCentricSup, 
                       BooleanSupplier isEvading) {

        m_swerveDrivetrain = swerveDrivetrain;
        addRequirements(m_swerveDrivetrain);

        m_translationSup = translationSup;
        m_strafeSup = strafeSup;
        m_rotationSup = rotationSup;
        m_robotCentricSup = robotCentricSup;
        m_isEvading = isEvading;
        
       

    }

    private Translation2d getCenterOfRotation(final Rotation2d direction, final double rotation) {

        SwerveDriveState m_swerveState = new SwerveDriveState();
        Rotation2d yaw = m_swerveState.RawHeading;

        final var here = new Translation2dPlus(1.0, direction.minus(yaw));

        var cwCenter = WHEEL_POSITIONS[0];
        var ccwCenter = WHEEL_POSITIONS[WHEEL_POSITIONS.length - 1];

        for (int i = 0; i < WHEEL_POSITIONS.length - 1; i++) {
            final var cw = WHEEL_POSITIONS[i];
            final var ccw = WHEEL_POSITIONS[i + 1];

            if (here.isWithinAngle(cw, ccw)) {
                cwCenter = ccw;
                ccwCenter = cw;
            }
        }

        // if clockwise
        if (Math.signum(rotation) == 1.0) {
            return cwCenter;
        } else if (Math.signum(rotation) == -1.0) {
            return ccwCenter;
        } else {
            return new Translation2d();
        }
    }

    @Override
    public void execute() {
       


          double MaxSpeed = TunerConstants.kSpeedAt12Volts.in(MetersPerSecond);
        double MaxAngularRate = RotationsPerSecond.of(0.75).in(RadiansPerSecond); // 3/4 of a rotation per second max angular velocity

        Translation2d newCenterOfRotation = new Translation2d();
        Translation2d translation = new Translation2d(m_translationSup.getAsDouble(), m_strafeSup.getAsDouble()).times(MaxSpeed);

       

         if(m_isEvading.getAsBoolean() && m_robotCentricSup.getAsBoolean()) {
             newCenterOfRotation = getCenterOfRotation(translation.getAngle(), m_rotationSup.getAsDouble());
         } else {
             newCenterOfRotation = new Translation2d();
         }

        SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
            .withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1) // Add a 10% deadband
            .withDriveRequestType(DriveRequestType.OpenLoopVoltage);
            
            // Use open-loop control for drive motors

        m_swerveDrivetrain.setControl(
                drive.withVelocityX(m_translationSup.getAsDouble()*m_translationSup.getAsDouble()*Math.signum(m_translationSup.getAsDouble()) *- MaxSpeed) // Drive forward with negative Y (forward)
                    .withVelocityY(m_strafeSup.getAsDouble() *m_strafeSup.getAsDouble()*Math.signum(m_strafeSup.getAsDouble())* -MaxSpeed) // Drive left with negative X (left)
                    .withRotationalRate(m_rotationSup.getAsDouble()*m_rotationSup.getAsDouble()*Math.signum(m_rotationSup.getAsDouble()) * -MaxAngularRate)
                    .withCenterOfRotation(newCenterOfRotation) // Drive counterclockwise with negative X (left)
                    

        );
       
    }

}