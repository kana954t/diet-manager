package model;

import java.io.Serializable;
import java.time.LocalDate;

public class DietRecord implements Serializable {
    private int id;
    private int userId;
    private LocalDate recordDate;
    private double weight;
    private double bmi;
    private String breakfast;
    private String lunch;
    private String dinner;
    private String exercise;
    private String memo;

    public DietRecord() {
    }

    public DietRecord(int userId, LocalDate recordDate, double weight, double bmi,
                      String breakfast, String lunch, String dinner,
                      String exercise, String memo) {
        this.userId = userId;
        this.recordDate = recordDate;
        this.weight = weight;
        this.bmi = bmi;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.exercise = exercise;
        this.memo = memo;
    }

    public DietRecord(int id, int userId, LocalDate recordDate, double weight, double bmi,
                      String breakfast, String lunch, String dinner,
                      String exercise, String memo) {
        this.id = id;
        this.userId = userId;
        this.recordDate = recordDate;
        this.weight = weight;
        this.bmi = bmi;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.exercise = exercise;
        this.memo = memo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }
    
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
    
    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }
    
    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }
    
    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }
    
    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }
    
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}