package com.example.acer.course_wiki;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class NewCoursePage extends AppCompatActivity
{
    EditText et_courseName;
    EditText et_courseID;
    EditText et_score;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_course_page);

        et_courseName = (EditText)findViewById(R.id.ET_CourseName);
        et_courseID = (EditText)findViewById(R.id.ET_CourseID);
        et_score = (EditText)findViewById(R.id.ET_Score);
    }

    protected void onPause()
    {
        super.onPause();
        String courseName = et_courseName.getText().toString();
        String courseID = et_courseID.getText().toString();
        int score = Integer.parseInt(et_score.getText().toString() );
    }

}
