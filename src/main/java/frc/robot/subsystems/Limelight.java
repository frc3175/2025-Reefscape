package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {

    private final NetworkTable limelightalgae = NetworkTableInstance.getDefault().getTable("limelight-algae");
    private final NetworkTable limelightTable = NetworkTableInstance.getDefault().getTable("limelight");

    public Limelight() {
        // Limelight setup, if any
    }

    public double getXOffset() {
        return limelightTable.getEntry("tx").getDouble(0.0); // Horizontal offset (degrees)
    }

    public double getYOffset() {
        return limelightTable.getEntry("ty").getDouble(0.0); // Horizontal offset (degrees)
    }

    

    public double algaegetHorizontalOffset() {
        return limelightalgae.getEntry("tx").getDouble(0.0); // Horizontal offset (degrees)
    }

    public boolean hasTarget() {
        return limelightTable.getEntry("ta").getDouble(0.0) > 0.0; // If target area is > 0

    }

    public boolean algaehasTarget() {
        return limelightalgae.getEntry("ta").getDouble(0.0) > 0.0; // If target area is > 0

    }

    public double getTargetid() {
        return limelightTable.getEntry("tid").getDouble(0.0); // If target area is > 0

    }

    public double algaegetTargetid() {
        return limelightalgae.getEntry("tid").getDouble(0.0); // If target area is > 0

    }


     @Override
  public void periodic() {
    SmartDashboard.putNumber("x offset",getXOffset());
    SmartDashboard.putNumber("Y offset",getYOffset());
    SmartDashboard.putBoolean("has tag",hasTarget());
    SmartDashboard.putNumber("algae horizontal offset",algaegetHorizontalOffset());
    SmartDashboard.putBoolean("algae has tag",algaehasTarget());
    SmartDashboard.putNumber("targetid", getTargetid());
    SmartDashboard.putNumber("alagaetargetid", algaegetTargetid());
  }
}