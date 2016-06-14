package com.example.acer.course_wiki;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Acer on 2016/6/14.
 */
public class memberDB
{
    public static String TABLE_NAME = "memberTable";

    public static ArrayList<memberClass> getMemberList(SQLiteDatabase database)
    {
        ArrayList<memberClass> memberList = new ArrayList<memberClass>();
        Cursor databasePtr = database.rawQuery("select * from " + TABLE_NAME, null);
        databasePtr.moveToFirst();

        String name = "";
        String ID = "";
        String password = "";
        String identity = "S";

        int i = 0;
        for (i = 0; i < databasePtr.getCount(); i++)
        {
            name = databasePtr.getString(databasePtr.getColumnIndex("name") );
            ID = databasePtr.getString(databasePtr.getColumnIndex("ID") );
            password = databasePtr.getString(databasePtr.getColumnIndex("password") );
            identity = databasePtr.getString(databasePtr.getColumnIndex("identity") );

            memberList.add(new memberClass(name , ID , password , identity) );
            databasePtr.moveToNext();
        }

        return memberList;
    }
}
