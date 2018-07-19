package com.bigdata.student.bean;

public class student_Score {
    private String id;
    private String name;
    private String clazz;
    private String courcename;
    private int score;

    @Override
    public String toString() {
        return "student_Score{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", clazz='" + clazz + '\'' +
                ", courcename='" + courcename + '\'' +
                ", score=" + score +
                '}';
    }

    public student_Score() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getCourcename() {
        return courcename;
    }

    public void setCourcename(String courcename) {
        this.courcename = courcename;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public student_Score(String id, String name, String clazz, String courcename, int score) {

        this.id = id;
        this.name = name;
        this.clazz = clazz;
        this.courcename = courcename;
        this.score = score;
    }
}
