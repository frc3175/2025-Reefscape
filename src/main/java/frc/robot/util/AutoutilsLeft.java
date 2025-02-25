package frc.robot.util;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;

public class AutoutilsLeft {

    public AutoutilsLeft() {
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
    
    public static Pose2d getnewpose(double input) {
        Double doubleInput = new Double(input);
        int intInput = doubleInput.intValue();
        Pose2d goalpose = new Pose2d();
       
        switch(intInput) {
            case 6:
                goalpose = new Pose2d(13.048 ,2.896,Rotation2d.fromDegrees(120)); //done
                break;

            case 7:
                goalpose = new Pose2d(13.85 ,3.93 ,Rotation2d.fromDegrees(180)); //done
                break; 

            case 8:
                goalpose = new Pose2d(13.350,5.132 ,Rotation2d.fromDegrees(-120)); //done
                break; 

            case 9:
                goalpose = new Pose2d(12.073 ,5.317 ,Rotation2d.fromDegrees(-60)); //done
                break;

            case 10:
                goalpose = new Pose2d(11.261 ,4.299 ,Rotation2d.fromDegrees(0)); //done
                break;

            case 11:
                goalpose = new Pose2d(11.739 ,3.075 ,Rotation2d.fromDegrees(60)); //done 
                break;

            case 17:
                goalpose = new Pose2d(3.182 ,3.085 ,Rotation2d.fromDegrees(60)); //done
                break;

            case 18:
                goalpose = new Pose2d(2.691 ,4.289 ,Rotation2d.fromDegrees(0)); //done
                break;

            case 19:
                goalpose = new Pose2d(3.524 ,5.337 ,Rotation2d.fromDegrees(-60)); //done
                break;

            case 20:
                goalpose = new Pose2d(4.789 ,5.140 ,Rotation2d.fromDegrees(-120)); //done
                break;

            case 21:
                goalpose = new Pose2d(5.282 ,3.911 ,Rotation2d.fromDegrees(180)); //done
                break;

            case 22:
                goalpose = new Pose2d(4.472 ,2.893 ,Rotation2d.fromDegrees(120)); //done
                break;

            case -1:
                goalpose = new Pose2d(999,999, Rotation2d.fromDegrees(999)); // Default case if input is not in the range
                break;
        }

        return goalpose;
    }

}



    


    //     else if      (input == 6){
    //         if (isLeft){
                
    //             return new Pose2d(13.048 ,2.896,Rotation2d.fromDegrees(120)); //done
    //         }
    //         else{
    //             return new Pose2d(13.324 ,3.033,Rotation2d.fromDegrees(120)); //done
    //         }
    //     }

    //     else if      (input == 7){
    //         if(isLeft){
                
    //             return new Pose2d(13.85 ,3.93 ,Rotation2d.fromDegrees(180)); //done
    //         }
    //         else{
    //             return new Pose2d(13.859 ,4.247,Rotation2d.fromDegrees(180)); //done
    //         }
    //     }

    //     else if      (input == 8){
    //         if (isLeft){
                
    //             return new Pose2d(13.350,5.132 ,Rotation2d.fromDegrees(-120)); //done
    //         }
    //         else{
    //             return new Pose2d(13.076,5.304 ,Rotation2d.fromDegrees(-120)); //done
    //         }
    //     }

    //     else if      (input == 9){
    //         if (isLeft){
                
    //             return new Pose2d(12.073 ,5.317 ,Rotation2d.fromDegrees(-60)); //done
    //         }
    //         else{
    //             return new Pose2d(11.771 ,5.179,Rotation2d.fromDegrees(-60)); //done
    //         }
    //     }

    //     else if      (input == 10){
    //         if (isLeft){
                
    //             return new Pose2d(11.261 ,4.299 ,Rotation2d.fromDegrees(0)); //done
    //         }
    //         else{
    //             return new Pose2d(11.259 ,3.954,Rotation2d.fromDegrees(0)); //done
    //         }
    //     }

    //     else if      (input == 11){
    //         if (isLeft){
                
    //             return new Pose2d(11.739 ,3.075 ,Rotation2d.fromDegrees(60)); //done
    //         }
    //         else{
    //             return new Pose2d(12.023 ,2.913,Rotation2d.fromDegrees(60)); //done
            

    //     else if      (input == 17){
    //         if (isLeft){
                
    //             return new Pose2d(3.182 ,3.085 ,Rotation2d.fromDegrees(60)); //done
    //         }
    //         else{
    //             return new Pose2d(3.448 ,2.926,Rotation2d.fromDegrees(60)); //done
    //         }
    //     }

    //     else if      (input == 18){
    //         if (isLeft){
                
    //             return new Pose2d(2.691 ,4.289 ,Rotation2d.fromDegrees(0)); //done
    //         }
    //         else{
    //             return new Pose2d(2.692 ,3.949,Rotation2d.fromDegrees(0)); //done
    //         }
    //     }

    //     else if      (input == 19){
    //         if (isLeft){
                
    //             return new Pose2d(3.524 ,5.337 ,Rotation2d.fromDegrees(-60)); //done
    //         }
    //         else{
    //             return new Pose2d(3.216 ,5.161,Rotation2d.fromDegrees(-60)); //done
    //         }
    //     }

    //     else  if      (input == 20){
    //         if (isLeft){
                
    //             return new Pose2d(4.789 ,5.140 ,Rotation2d.fromDegrees(-120)); //done
    //         }
    //         else{
    //             return new Pose2d(4.505 ,5.305,Rotation2d.fromDegrees(-120)); //done
    //         }
    //     }

    //     else if      (input == 21){
    //         if (isLeft){
                
    //             return new Pose2d(5.282 ,3.911 ,Rotation2d.fromDegrees(180)); //done
    //         }
    //         else{
    //             return new Pose2d(5.282 ,4.248,Rotation2d.fromDegrees(180)); //done
    //         }
    //     }

    //     else if      (input == 22){
    //         if (isLeft){
                
    //             return new Pose2d(4.472 ,2.893 ,Rotation2d.fromDegrees(120)); //done
    //         }
    //         else{
    //             return new Pose2d(4.754 ,3.055,Rotation2d.fromDegrees(120)); //done
    //         }
    //     }

    //     if(input == -1) return new Pose2d(999,999, Rotation2d.fromDegrees(999)); // Default case if input is not in the range
    //     return goalpose;
    // }
   