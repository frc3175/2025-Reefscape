package frc.robot.util;

public class Autoangles {

    public Autoangles() {
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
}