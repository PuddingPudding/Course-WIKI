package com.example.acer.course_wiki;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Acer on 2016/6/19.
 */
public class courseDB
{
    public static final String TABLE_NAME = "courseTable";

//    public static ArrayList<courseClass>

    public static boolean addCourse(SQLiteDatabase database , String courseName , String courseID , double courseScore , String teacher , int score)
    {
        boolean exist = false; //exist代表是否已存在，先假設他不存在

        if(exist == false)
        {
            ContentValues input = new ContentValues();
            input.put("courseName" , courseName);
            input.put("courseID" , courseID.toUpperCase() );
            input.put("courseScore" , courseScore);
            input.put("teacher" , teacher);
            input.put("score" , score);

            database.insert(TABLE_NAME , null , input);
        }

        return exist;
    }
}
