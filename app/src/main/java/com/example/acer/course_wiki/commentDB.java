package com.example.acer.course_wiki;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Acer on 2016/6/12.
 */
public class commentDB
{
    public static final String TABLE_NAME = "commentTable";


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
                commentList.add(new commentClass(ID , comment , givingRank , commentCredibility) );
            }
            databasePtr.moveToNext();
        }

        return commentList;

    }
}
