package com.example.acer.course_wiki;

public class commentClass
{
    private String ID = "";
    private String comment = "";
    private double givingRank = 0;
    private double commentCredibility = 0;

    public commentClass(String ID, String comment, double givingRank, double commentCredibility)
    {
        this.ID = ID;
        this.comment = comment;
        this.givingRank = givingRank;
        this.commentCredibility = commentCredibility;
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

    public double getGivingRank()
    {
        return this.givingRank;
    }

    public double getCommentCredibility()
    {
        return this.commentCredibility;
    }
}