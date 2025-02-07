package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {

    private final NetworkTable limelightTable = NetworkTableInstance.getDefault().getTable("limelight-algae");
    private final NetworkTable limelightTable2 = NetworkTableInstance.getDefault().getTable("limelight");

    public Limelight() {
        // Limelight setup, if any
    }

    public double getHorizontalOffset() {
        return limelightTable2.getEntry("tx").getDouble(0.0); // Horizontal offset (degrees)
    }

    public boolean hasTarget() {
        return limelightTable2.getEntry("ta").getDouble(0.0) > 0.0; // If target area is > 0

    }
     @Override
  public void periodic() {
    SmartDashboard.putNumber("horizontal offset",getHorizontalOffset());
    SmartDashboard.putBoolean("has tag",hasTarget());
  }
}