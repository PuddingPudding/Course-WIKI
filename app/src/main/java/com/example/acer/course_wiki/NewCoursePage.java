package com.example.acer.course_wiki;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        Intent intent = getIntent();

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

            }
        }
    }

}
