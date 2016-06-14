package com.example.acer.course_wiki;

/**
 * Created by Acer on 2016/6/14.
 */
public class memberClass
{
    private String name = "";
    private String ID = "";
    private String password = "";
    private String identity = "S";

    public memberClass(String name , String ID , String password , String identity)
    {
        this.name = name;
        this.ID = ID;
        this.password = password;
        this.identity = identity;
    }
    public memberClass()
    {
        this.name = "";
        this.ID = "";
        this.password = "";
        this.identity = "S";
    }
}
