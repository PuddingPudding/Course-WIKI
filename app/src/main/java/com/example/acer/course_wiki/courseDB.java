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
        ArrayList<courseClass> courseList = getCourseList(database);
        String courseIDtemp = "";

        int i = 0;
        for(i = 0 ; i < courseList.size() && exist == false ; i++)
        {
            courseIDtemp = courseList.get(i).getCourseID();
            if(courseID.equals(courseIDtemp) == true)
            {
                exist = true;
            }
        }

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

    public static void courseUpdate(SQLiteDatabase database , ArrayList<commentClass> commentList)
    {
        if(commentList.size() > 0)
        {
            int i = 0 , counter = 0;
            double sum = 0;
            for(i = 0 ; i < commentList.size() ; i++)
            {
                if(commentList.get(i).getCommentCredibility() > 4)
                {
//                只取可信度>4的評分
                    counter++;
                    sum += commentList.get(i).getGivingRank();
                }
            }
            sum = sum / counter;

            ArrayList<courseClass> courseList = getCourseList(database);
            Cursor databasePtr = database.rawQuery("select * from " + TABLE_NAME , null);
            databasePtr.moveToFirst();
            boolean exist = false;
            String strTemp , commentCourseID;

            for(i = 0 ; i < courseList.size() && exist ==false ; i++)
            {
                strTemp = databasePtr.getString(databasePtr.getColumnIndex("courseID"));
                commentCourseID = commentList.get(0).getCourseID();
                if(strTemp.equals(commentCourseID) == true)
                {
                    exist = true;
                    ContentValues input = new ContentValues();
                    input.put("courseName" , databasePtr.getString(databasePtr.getColumnIndex("courseName") ) );
                    input.put("courseID" , databasePtr.getString(databasePtr.getColumnIndex("courseID") ) );
                    input.put("courseScore" , sum);
                    input.put("teacher" , databasePtr.getString(databasePtr.getColumnIndex("teacher") ) );
                    input.put("score" , databasePtr.getInt(databasePtr.getColumnIndex("score") ) );

                    database.update(TABLE_NAME , input , "courseID='" + commentCourseID + "'" , null);
                }
                else
                {
                    databasePtr.moveToNext();
                }
            }
        }
    }

    public static void courseUpdate(SQLiteDatabase courseDatabase , SQLiteDatabase commentDatabase)
    {
        ArrayList<courseClass> courseList = getCourseList(courseDatabase);
        ArrayList<commentClass> commentList;
        Cursor databasePtr = courseDatabase.rawQuery("select * from " + TABLE_NAME , null);
        databasePtr.moveToFirst();
        String strTemp;

        int i = 0;
        for(i = 0 ; i < courseList.size() ; i++)
        {
            strTemp = courseList.get(i).getCourseID();
            commentList = commentDB.getCommentList(commentDatabase , strTemp);
            courseUpdate(courseDatabase , commentList);
        }
    }
}
