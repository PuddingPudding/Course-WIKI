package com.example.acer.course_wiki;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class CourseListPage extends AppCompatActivity
{

    Button bt_newCourse;

    ListView lv_courseList;

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
            else if(MainPage.nowUser.getIdentity().equals("T") == true)
            {
                Intent intent = new Intent();
                intent.setClass(CourseListPage.this , NewCoursePage.class);
                startActivity(intent);
            }
        }
    };
}
