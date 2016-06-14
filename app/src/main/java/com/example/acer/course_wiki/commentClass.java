package com.example.acer.course_wiki;

public class commentClass
{
    private String ID = "";
    private String comment = "";
    private double givingRank = 0;
    private double commentCredibility = 0;

    commentClass(String ID, String comment, double givingRank, double commentCredibility)
    {
        this.ID = ID;
        this.comment = comment;
        this.givingRank = givingRank;
        this.commentCredibility = commentCredibility;
    }

    commentClass()
    {
        this.ID = "";
        this.comment = "";
        this.givingRank = 0;
        this.commentCredibility = 0;
    }
}