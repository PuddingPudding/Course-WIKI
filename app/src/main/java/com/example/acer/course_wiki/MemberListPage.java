package com.example.acer.course_wiki;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MemberListPage extends AppCompatActivity {

    SQLiteDatabase memberDatabase;
    ArrayList<memberClass> memberList;
    ListView lv_memberList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list_page);

        Intent intent = getIntent();

        lv_memberList = (ListView)findViewById(R.id.LV_MemberList);

        memberOpenHelper MopenHelper = new memberOpenHelper(this);
        memberDatabase = MopenHelper.getWritableDatabase();

        memberList = memberDB.getMemberList(memberDatabase);
        memberadapter adapter = new memberadapter(this , memberList);
        lv_memberList.setAdapter(adapter);
    }
}
