package com.example.acer.course_wiki;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fred309200444 on 2016/6/9.
 */
public class courseOpenHelper extends SQLiteOpenHelper {

    public courseOpenHelper(Context context){
        super(context,"note.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " +
                courseDB.COURSETABLE + "(courseName,courseID,courseScore,teacher,score);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldV,int newV){}
}