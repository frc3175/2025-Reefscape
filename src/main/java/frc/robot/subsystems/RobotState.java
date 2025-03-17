package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RobotState extends SubsystemBase {
 
    private boolean CoralMode = true;

    public void changeMode() {
        CoralMode =  !CoralMode;

    }

    public boolean isCoralMode() {
        return CoralMode;
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Coral Mode", CoralMode);
                            }//pain ow
}
