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
import android.widget.TextView;
import android.widget.Toast;

public class CommentJudge extends AppCompatActivity
{
    private String ID = "";
    private String comment = "";
    private String courseID = "";
    private double givingRank = 0;
    private double commentCredibility = 0;
    private int commentJudgedTimes = 0;

    TextView tv_comment;

    EditText et_judge;

    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_judge);

        commentOpenHelper openHelper = new commentOpenHelper(this);
        database = openHelper.getWritableDatabase();

        Intent intent = getIntent();
        comment = intent.getStringExtra(comment_page.COMMENT_KEY);
        ID = intent.getStringExtra(comment_page.ID_KEY);
        courseID = intent.getStringExtra(comment_page.COURSE_ID_KEY);
        givingRank = intent.getDoubleExtra(comment_page.GIVING_RANK_KEY , 0);
        commentCredibility = intent.getDoubleExtra(comment_page.COMMENT_CREDIBILITY_KEY , 0);
        commentJudgedTimes = intent.getIntExtra(comment_page.JUDGED_TIMES_KEY , 0);

        tv_comment = (TextView)findViewById(R.id.TV_Comment);
        tv_comment.setText(comment);

        et_judge = (EditText)findViewById(R.id.ET_Judge);
    }


    @Override
    protected void onPause()
    {
        super.onPause();

        String judgeStr = et_judge.getText().toString();

        if(judgeStr.equals("") )
        {
            Toast.makeText(CommentJudge.this , R.string.error , Toast.LENGTH_LONG).show();
        }
        else
        {
            double credibility = Double.parseDouble(judgeStr);
            if(credibility < 0 || credibility > 10)
            {
                Toast.makeText(CommentJudge.this , R.string.error , Toast.LENGTH_LONG).show();
            }
            else
            {
                commentJudgedTimes++;
                commentCredibility = (commentCredibility*(commentJudgedTimes-1) + credibility) / commentJudgedTimes;
                commentDB.update(database , ID , courseID , givingRank , commentCredibility , comment , commentJudgedTimes);
            }
        }
    }
}
