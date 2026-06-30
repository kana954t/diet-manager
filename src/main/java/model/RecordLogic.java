package model;

public class RecordLogic {
    public double calculateBmi(double height, double weight) {
        if (height <= 0 || weight <= 0) {
            return 0;
        }

        double heightMeter = height / 100;
        double bmi = weight / (heightMeter * heightMeter);

        return Math.round(bmi * 10.0) / 10.0;
    }
}