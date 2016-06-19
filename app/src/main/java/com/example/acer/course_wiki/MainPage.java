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
import android.widget.Button;
import android.widget.TextView;

public class MainPage extends AppCompatActivity
{
    String ID , password;

    public static memberClass nowUser;

    SQLiteDatabase memberDatabase;

    TextView tv_nameAndID;

    Button bt_goToCourseList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        memberOpenHelper MopenHelper = new memberOpenHelper(this);
        memberDatabase = MopenHelper.getWritableDatabase();

        Intent intent = getIntent();
        ID = intent.getStringExtra(HomePage.ID_INPUT_KEY);
        password = intent.getStringExtra(HomePage.PASSWORD_INPUT_KEY);

        nowUser = memberDB.getMember(memberDatabase , ID , password);

        tv_nameAndID = (TextView)findViewById(R.id.TV_NameAndID);
        tv_nameAndID.setText(nowUser.getID() + " " + nowUser.getName() );

        bt_goToCourseList = (Button)findViewById(R.id.BT_GoToCourseList);
        bt_goToCourseList.setOnClickListener(goToCourseList);
    }

    public View.OnClickListener goToCourseList = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(MainPage.this , CourseListPage.class);
            startActivity(intent);
        }
    };

}
