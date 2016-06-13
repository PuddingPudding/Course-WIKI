package com.example.acer.course_wiki;

public class commentClass
{
    String ID = "";
    String comment = "";
    double givingRank = 0;
    double commentCredibility = 0;

    commentClass(String ID, String comment, double givingRank, double commentCredibility)
    {
        this.ID = ID;
        this.comment = comment;
        this.givingRank = givingRank;
        this.commentCredibility = commentCredibility;
    }
}