package frc.robot.util;

import javax.swing.text.StyledEditorKit.BoldAction;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;

public class Autoutils {

    public Autoutils() {
        // Constructor
        
    }

    public static double getAngle(double input) {
        if (input == 1) return 10;
        else if (input == 2) return 20;
        else if (input == 3) return 30;
        else if (input == 4) return 40;
        else if (input == 5) return 50;
        else if (input == 6) return 0;
        else if (input == 7) return 70;
        else if (input == 8) return 80;
        else if (input == 9) return 90;
        else if (input == 10) return 100;
        else if (input == 11) return 110;
        else if (input == 12) return 120;
        else if (input == 13) return 130;
        else if (input == 14) return 140;
        else if (input == 15) return 150;
        else if (input == 16) return 160;
        else if (input == 17) return 170;
        else if (input == 18) return 180;
        else if (input == 19) return 190;
        else if (input == 20) return 200;
        else if (input == 21) return 210;
        else if (input == 22) return 220;
        else return -1; // Default case if input is not in the range
    }
    
    public static Pose2d getnewpose(double input, Boolean isLeft) {
        Pose2d goalpose = new Pose2d();
        
        if      (input == 1){
            if (isLeft){
                goalpose = new Pose2d(15.987 ,0.652 ,Rotation2d.fromDegrees(65)); 
            }
            else{
                return new Pose2d(15.987 ,0.652 ,Rotation2d.fromDegrees(65));
            }
        }

        if      (input == 2){
            if (isLeft){
                
                return new Pose2d(16.017 ,7.353,Rotation2d.fromDegrees(95));
            }
            else{
                return new Pose2d(16.017 ,7.353,Rotation2d.fromDegrees(95));
            }
        }

        if      (input == 3){
            if (isLeft){
                
                return new Pose2d(11.510 ,7.533 ,Rotation2d.fromDegrees(90));
            }
            else{
                return new Pose2d(11.510 ,7.533 ,Rotation2d.fromDegrees(90));
            }
        }

        if      (input == 4){
            if (isLeft){
                
                return new Pose2d(999,999, Rotation2d.fromDegrees(999));
            }
            else{
                return new Pose2d(999,999, Rotation2d.fromDegrees(999));
            }
        }

        if      (input == 5){
            if (isLeft){
                
                return new Pose2d(999,999, Rotation2d.fromDegrees(999));
            }
            else{
                return new Pose2d(999,999, Rotation2d.fromDegrees(999));
            }
        }

        if      (input == 6){
            if (isLeft){
                
                return new Pose2d(12.87 ,3.2,Rotation2d.fromDegrees(120)); //done
            }
            else{
                return new Pose2d(13.2 ,3.4,Rotation2d.fromDegrees(120));//done
            }
        }

        if      (input == 7){
            if(isLeft){
                
                goalpose = new Pose2d(13.5 ,3.953 ,Rotation2d.fromDegrees(180)); //done
            }
            else{
                goalpose = new Pose2d(13.5 ,4.3,Rotation2d.fromDegrees(180)); //done
            }
        }

        if      (input == 8){
            if (isLeft){
                
                return new Pose2d(13.195,4.87 ,Rotation2d.fromDegrees(-120)); //done
            }
            else{
                return new Pose2d(12.9,5. ,Rotation2d.fromDegrees(-120)); //done
            }
        }

        if      (input == 9){
            if (isLeft){
                
                return new Pose2d(12.3 ,5 ,Rotation2d.fromDegrees(-60)); //done
            }
            else{
                return new Pose2d(11.95 ,4.88,Rotation2d.fromDegrees(-60)); //done
            }
        }

        if      (input == 10){
            if (isLeft){
                
                return new Pose2d(11.821 ,4.165 ,Rotation2d.fromDegrees(0));
            }
            else{
                return new Pose2d(11.821 ,3.908,Rotation2d.fromDegrees(0));
            }
        }

        if      (input == 11){
            if (isLeft){
                
                return new Pose2d(11.1 ,3.56 ,Rotation2d.fromDegrees(60));
            }
            else{
                return new Pose2d(12.29 ,3.15,Rotation2d.fromDegrees(60));
            }
        }

        if      (input == 12){
            if (isLeft){
                
                return new Pose2d(0 ,0 ,Rotation2d.fromDegrees(0));
            }
            else{
                return new Pose2d(1 ,1,Rotation2d.fromDegrees(0));
            }
        }

        if      (input == 13){
            if (isLeft){
                
                return new Pose2d(0 ,0 ,Rotation2d.fromDegrees(0));
            }
            else{
                return new Pose2d(1 ,1,Rotation2d.fromDegrees(0));
            }
        }

        if      (input == 14){
            if (isLeft){
                
                return new Pose2d(999,999, Rotation2d.fromDegrees(999));
            }
            else{
                return new Pose2d(999,999, Rotation2d.fromDegrees(999));
            }
        }

        if      (input == 15){
            if (isLeft){
                
                return new Pose2d(999,999, Rotation2d.fromDegrees(999));
            }
            else{
                return new Pose2d(999,999, Rotation2d.fromDegrees(999));
            }
        }

        if      (input == 16){
            if (isLeft){
                
                return new Pose2d(0 ,0 ,Rotation2d.fromDegrees(0));
            }
            else{
                return new Pose2d(1 ,1,Rotation2d.fromDegrees(0));
            }
        }

        if      (input == 17){
            if (isLeft){
                
                return new Pose2d(0 ,0 ,Rotation2d.fromDegrees(0));
            }
            else{
                return new Pose2d(1 ,1,Rotation2d.fromDegrees(0));
            }
        }

        if      (input == 18){
            if (isLeft){
                
                return new Pose2d(0 ,0 ,Rotation2d.fromDegrees(0));
            }
            else{
                return new Pose2d(1 ,1,Rotation2d.fromDegrees(0));
            }
        }

        if      (input == 19){
            if (isLeft){
                
                return new Pose2d(0 ,0 ,Rotation2d.fromDegrees(0));
            }
            else{
                return new Pose2d(1 ,1,Rotation2d.fromDegrees(0));
            }
        }

        if      (input == 20){
            if (isLeft){
                
                return new Pose2d(0 ,0 ,Rotation2d.fromDegrees(0));
            }
            else{
                return new Pose2d(1 ,1,Rotation2d.fromDegrees(0));
            }
        }

        if      (input == 21){
            if (isLeft){
                
                return new Pose2d(0 ,0 ,Rotation2d.fromDegrees(0));
            }
            else{
                return new Pose2d(1 ,1,Rotation2d.fromDegrees(0));
            }
        }

        if      (input == 22){
            if (isLeft){
                
                return new Pose2d(0 ,0 ,Rotation2d.fromDegrees(0));
            }
            else{
                return new Pose2d(1 ,1,Rotation2d.fromDegrees(0));
            }
        }

        if(input == -1) return new Pose2d(999,999, Rotation2d.fromDegrees(999)); // Default case if input is not in the range
        return goalpose;
    }
   
    
}