package com.example.acer.course_wiki;

/**
 * Created by arial on 2016/6/19.
 */
public class courseClass
{
    private String courseName = "";
    private String courseID = "";
    private double courseScore = 0;
    private String teacher = "";
    private int score = 0;

    public courseClass(String courseName, String courseID, double courseScore, String teacher, int score)
    {
        this.courseName = courseName;
        this.courseID = courseID;
        this.courseScore = courseScore;
        this.teacher = teacher;
        this.score = score;
    }

    public courseClass()
    {
        this.courseName = "";
        this.courseID = "";
        this.courseScore = 0;
        this.teacher = "";
        this.score = 0;
    }

    public String getCourseName()
    {
        return this.courseName;
    }

    public String getCourseID()
    {
        return this.courseID;
    }

    public double getCourseScore()
    {
        return this.courseScore;
    }

    public String getTeacher()
    {
        return this.teacher;
    }

    public int getScore()
    {
        return this.score;
    }
}
