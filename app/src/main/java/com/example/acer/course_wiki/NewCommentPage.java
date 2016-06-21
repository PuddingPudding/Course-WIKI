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

public class NewCommentPage extends AppCompatActivity
{
    EditText et_comment;
    EditText et_givingRank;

    String courseID;

    SQLiteDatabase commentDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_comment_page);

        Intent intent = getIntent();
        courseID = intent.getStringExtra(comment_page.COURSE_ID_KEY);

        et_comment = (EditText)findViewById(R.id.ET_Comment);
        et_givingRank = (EditText)findViewById(R.id.ET_GivingRank);

        commentOpenHelper openHelper = new commentOpenHelper(this);
        commentDatabase = openHelper.getWritableDatabase();
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        String comment = et_comment.getText().toString();
        String givingRankStr = et_givingRank.getText().toString();

        if(givingRankStr.equals("") || comment.equals("") )
        {
            Toast.makeText(NewCommentPage.this , R.string.error , Toast.LENGTH_LONG).show();
        }
        else
        {
            double givingRank = Double.parseDouble(givingRankStr);
            if(givingRank > 10 || givingRank < 0)
            {
                Toast.makeText(NewCommentPage.this , R.string.error , Toast.LENGTH_LONG).show();
            }
            else
            {
                commentDB.addComment(commentDatabase , courseID , comment , givingRank);
            }
        }
    }

}
