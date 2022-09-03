package com.duan.pojo;

public class Student {
    private int id;
    private String name;
    private String no;
    private String homeTown;
    private int cnScore;
    private int enScore;
    private int mathScore;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }


    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public int getCnScore() {
        return cnScore;
    }

    public void setCnScore(int cnScore) {
        this.cnScore = cnScore;
    }

    public int getEnScore() {
        return enScore;
    }

    public void setEnScore(int enScore) {
        this.enScore = enScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }
}
