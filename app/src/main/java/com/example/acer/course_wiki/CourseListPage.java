package com.example.acer.course_wiki;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CourseListPage extends AppCompatActivity
{

    Button bt_newCourse;

    ListView lv_courseList;

    ArrayList<courseClass> courseList;

    SQLiteDatabase courseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list_page);

        bt_newCourse = (Button)findViewById(R.id.BT_NewCourse);
        bt_newCourse.setOnClickListener(newCourse);

        lv_courseList = (ListView)findViewById(R.id.LV_CourseList);
//        lv_courseList.setOnItemClickListener();
    }

    public View.OnClickListener newCourse = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if(MainPage.nowUser.getIdentity().equals("S") == true)
            {
                Toast.makeText(CourseListPage.this , R.string.have_no_permission , Toast.LENGTH_LONG).show();
            }
        }
    };
}
