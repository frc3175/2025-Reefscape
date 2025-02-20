package frc.robot.util;

import edu.wpi.first.math.geometry.Rotation2d;

public class invert {
    public static double invertnum(Rotation2d rotation){
       return  -Math.toDegrees(rotation.getRadians());
        
        

    }
    
}
