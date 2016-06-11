package com.example.acer.course_wiki;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cohang on 2016/6/11.
 */
public class memberOpenHelper extends SQLiteOpenHelper {

    public memberOpenHelper (Context context){super(context , "note.db" , null , 1);}

    public static final String TABLE_NAME = "memberTable";

    @Override
    public void onCreate(SQLiteDatabase database){
        database.execSQL("create member" + TABLE_NAME
                +"(memberName,memberID,memberIdentity,memberPassword);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion)
    {
    }
}
