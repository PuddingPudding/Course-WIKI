package com.example.acer.course_wiki;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class NewCoursePage extends AppCompatActivity
{
    EditText et_courseName;
    EditText et_courseID;
    EditText et_score;

    SQLiteDatabase courseDatabase;
    ArrayList<courseClass> courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_course_page);

        Intent intent = getIntent();

        courseOpenHelper openHelper = new courseOpenHelper(this);
        courseDatabase = openHelper.getWritableDatabase();

        courseList = courseDB.getCourseList(courseDatabase);

        et_courseName = (EditText)findViewById(R.id.ET_CourseName);
        et_courseID = (EditText)findViewById(R.id.ET_CourseID);
        et_score = (EditText)findViewById(R.id.ET_Score);
    }

    protected void onPause()
    {
        super.onPause();
        String courseName = et_courseName.getText().toString();
        String courseID = et_courseID.getText().toString();
        String scoreStr = et_score.getText().toString();

        if(courseName.equals("") || courseID.equals("") || scoreStr.equals(""))
        {
            Toast.makeText(NewCoursePage.this , R.string.error , Toast.LENGTH_LONG).show();
        }
        else
        {
            int score = Integer.parseInt(scoreStr);
            if(score < 0)
            {
                Toast.makeText(NewCoursePage.this , R.string.error , Toast.LENGTH_LONG).show();
            }
            else
            {
                boolean flag = courseDB.addCourse(courseDatabase , courseName , courseID , 0 , MainPage.nowUser.getName() , score);
                if(flag == true)
                {
                    //anddCourse這個函數會回傳該選課代碼是否已存在，已存在則不做事並回傳true
                    Toast.makeText(this , R.string.ID_exist_already , Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(this , "success!!" , Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}
