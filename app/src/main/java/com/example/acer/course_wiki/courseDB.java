package com.example.acer.course_wiki;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Acer on 2016/6/19.
 */
public class courseDB
{
    public static final String TABLE_NAME = "courseTable";

    public static ArrayList<courseClass> getCourseList(SQLiteDatabase database)
    {
        ArrayList<courseClass> courseList = new ArrayList<courseClass>();
        Cursor databasePtr = database.rawQuery("select * from " + TABLE_NAME, null);
        databasePtr.moveToFirst();

        String courseName = "";
        String courseID = "";
        double courseScore = 0;
        String teacher = "";
        int score = 0;

        int i = 0;
        for (i = 0; i < databasePtr.getCount(); i++)
        {
            courseName = databasePtr.getString(databasePtr.getColumnIndex("courseName") );
            courseID = databasePtr.getString(databasePtr.getColumnIndex("courseID") );
            courseScore = databasePtr.getDouble(databasePtr.getColumnIndex("courseScore") );
            teacher = databasePtr.getString(databasePtr.getColumnIndex("teacher") );
            score = databasePtr.getInt(databasePtr.getColumnIndex("score") );

            courseList.add(new courseClass(courseName , courseID , courseScore , teacher , score) );
            databasePtr.moveToNext();
        }

        return courseList;
    }

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
