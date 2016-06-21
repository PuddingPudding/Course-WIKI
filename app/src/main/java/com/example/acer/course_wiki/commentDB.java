package com.example.acer.course_wiki;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Acer on 2016/6/12.
 */
public class commentDB
{
    public static final String TABLE_NAME = "commentTable";

//    靜態函數 getCommentList:獲得一串資料，這一串資料用於顯示評論時使用

    public static void addComment(SQLiteDatabase database , String courseID , String comment , double givingRank)
    {
        ContentValues input = new ContentValues();
        input.put("ID", MainPage.nowUser.getID());
        input.put("courseID", courseID.toUpperCase());
        input.put("givingRank", givingRank);
        input.put("commentCredibility", 0);
        input.put("comment", comment);
        input.put("commentJudgedTimes" , 0);

        database.insert(TABLE_NAME , null , input);
    }

    public static void update(SQLiteDatabase database , String ID , String courseID , double givingRank , double commentCredibility , String comment , int commentJudgedTimes)
    {
        ContentValues input = new ContentValues();
        input.put("ID", ID );
        input.put("courseID", courseID.toUpperCase() );
        input.put("givingRank", givingRank);
        input.put("commentCredibility", commentCredibility);
        input.put("comment", comment);
        input.put("commentJudgedTimes" , commentJudgedTimes);

        database.update(TABLE_NAME , input , "ID='" + ID + "'AND courseID='" + courseID + "'" , null);
    }

    public static ArrayList<commentClass> getCommentList(SQLiteDatabase database , String courseID)
    {
        ArrayList<commentClass> commentList = new ArrayList<commentClass>();
        Cursor databasePtr = database.rawQuery("select * from " + TABLE_NAME , null);
        databasePtr.moveToFirst();
        String strTemp = "";

        String ID = "";
        String comment = "";
        double givingRank = 0;
        double commentCredibility = 0;
        int commentJudgedTimes = 0;

        int i = 0;
        for(i = 0 ; i < databasePtr.getCount() ; i++)
        {
            strTemp = databasePtr.getString(databasePtr.getColumnIndex("courseID"));
            if(courseID.equals(strTemp) == true)
            {
                ID = databasePtr.getString(databasePtr.getColumnIndex("ID") );
                comment = databasePtr.getString(databasePtr.getColumnIndex("comment") );
                givingRank = databasePtr.getDouble(databasePtr.getColumnIndex("givingRank") );
                commentCredibility = databasePtr.getDouble(databasePtr.getColumnIndex("commentCredibility") );
                commentJudgedTimes = databasePtr.getInt(databasePtr.getColumnIndex("commentJudgedTimes") );

                commentList.add(new commentClass(ID , comment , givingRank , commentCredibility , courseID , commentJudgedTimes) );
            }
            databasePtr.moveToNext();
        }

        return commentList;
    }

}
