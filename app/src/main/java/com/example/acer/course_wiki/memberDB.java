package com.example.acer.course_wiki;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Acer on 2016/6/14.
 */
public class memberDB
{
    public static String TABLE_NAME = "memberTable";

//    靜態函數 getMemberList:會回傳所有人的資料，該資料用於檢查用
//    靜態函數 addMember:新增member用，會回傳這個人是否已經存在，已存在則不新增並回傳true，不存則相反

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

    public static boolean addMember(SQLiteDatabase database , String name , String ID , String password , String identity)
    {
        ArrayList<memberClass> memberList = getMemberList(database);
        boolean exist = false; //exist代表是否已存在，先假設他不存在
        String IDTemp = "";

        int i = 0;
        for(i = 0 ; i < memberList.size() && exist == false ; i++)
        {
            IDTemp = memberList.get(i).getID();
            if(ID.equals(IDTemp) == true)
            {
                exist = true;
            }
        }

        if(exist == false)
        {
            ContentValues input = new ContentValues();
            input.put("name" , name);
            input.put("ID" , ID);
            input.put("password" , password);
            input.put("identity" , identity);

            database.insert(TABLE_NAME , null , input);
        }

        return exist;
    }

}
