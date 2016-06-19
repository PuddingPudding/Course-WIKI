package com.example.acer.course_wiki;

public class commentClass
{
    private String ID = "";
    private String comment = "";
    private String courseID = "";
    private double givingRank = 0;
    private double commentCredibility = 0;
    private int commentJudgedTimes = 0;

    public commentClass(String ID, String comment, double givingRank, double commentCredibility , String courseID , int commentJudgedTimes)
    {
        this.ID = ID;
        this.comment = comment;
        this.givingRank = givingRank;
        this.commentCredibility = commentCredibility;
        this.courseID = courseID;
        this.commentJudgedTimes = commentJudgedTimes;
    }

    public commentClass()
    {
        this.ID = "";
        this.comment = "";
        this.givingRank = 0;
        this.commentCredibility = 0;
    }

    public String getID()
    {
        return this.ID;
    }

    public String getComment()
    {
        return this.comment;
    }

    public String getCourseID()
    {
        return this.courseID;
    }

    public double getGivingRank()
    {
        return this.givingRank;
    }

    public double getCommentCredibility()
    {
        return this.commentCredibility;
    }

    public int getCommentJudgedTimes()
    {
        return this.commentJudgedTimes;
    }
}