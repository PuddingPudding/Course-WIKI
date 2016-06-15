package com.example.acer.course_wiki;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Acer on 2016/6/10.
 */
public class commentOpenHelper extends SQLiteOpenHelper
{

    public commentOpenHelper(Context context)
    {
        super(context,"comment.db",null,1);
    }
    public static final String TABLE_NAME = "commentTable";

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL("create table " +
                TABLE_NAME + "(ID,courseID,givingRank,commentCredibility,comment,commentJudgedTimes);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion)
    {
    }
}
