package com.example.acer.course_wiki;

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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class comment_page extends AppCompatActivity
{
    int coursePosition;

    public static final String COURSE_ID_KEY = "course_ID_key";
    public static final String COMMENT_KEY = "comment_key";
    public static final String ID_KEY = "ID_key";
    public static final String GIVING_RANK_KEY = "giving_ID_key";
    public static final String COMMENT_CREDIBILITY_KEY = "comment_credibility_key";
    public static final String JUDGED_TIMES_KEY = "judged_times_key";

    SQLiteDatabase courseDatabase , commentDatabase;

    ArrayList<courseClass> courseList;
    ArrayList<commentClass> commentList;

    TextView tv_courseName;
    TextView tv_courseID;
    TextView tv_teacher;

    Button bt_newComment;

    ListView lv_commentList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        coursePosition = intent.getIntExtra(CourseListPage.POSITION_KEY , -1);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        courseOpenHelper CROpenHelper = new courseOpenHelper(this);
        commentOpenHelper CMOpenHelper = new commentOpenHelper(this);

        courseDatabase = CROpenHelper.getWritableDatabase();
        commentDatabase = CMOpenHelper.getWritableDatabase();

        courseList = courseDB.getCourseList(courseDatabase);
        commentList = commentDB.getCommentList(commentDatabase , courseList.get(coursePosition).getCourseID() );

        tv_courseID = (TextView)findViewById(R.id.TV_CourseID);
        tv_courseName = (TextView)findViewById(R.id.TV_CourseName);
        tv_teacher = (TextView)findViewById(R.id.TV_Teacher);

        tv_courseID.setText(courseList.get(coursePosition).getCourseID() );
        tv_courseName.setText(courseList.get(coursePosition).getCourseName() );
        tv_teacher.setText(courseList.get(coursePosition).getTeacher() );

        commentadapter adapter = new commentadapter(this , commentList);
        lv_commentList = (ListView)findViewById(R.id.LV_CommentListpage);
        lv_commentList.setAdapter(adapter);
        lv_commentList.setOnItemClickListener(goToCommentJudge);

        bt_newComment = (Button)findViewById(R.id.BT_NewComment);
        bt_newComment.setOnClickListener(goToNewCommentPage);
    }

    public View.OnClickListener goToNewCommentPage = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if(MainPage.nowUser.getIdentity().equals("T") )
            {
                Toast.makeText(comment_page.this , R.string.have_no_permission , Toast.LENGTH_LONG).show();
            }
            else
            {
                boolean exist = false;

                int i = 0;
                for(i = 0 ; i < commentList.size() && exist == false ; i++)
                {
                    if(MainPage.nowUser.getID().equals(commentList.get(i).getID() ) )
                    {
                        Toast.makeText(comment_page.this , R.string.already_comment , Toast.LENGTH_LONG).show();
                        exist = true;
                    }
                }

                if(exist == false)
                {
                    Intent intent = new Intent();
                    intent.setClass(comment_page.this , NewCommentPage.class);
                    intent.putExtra(COURSE_ID_KEY , tv_courseID.getText().toString() );
                    startActivity(intent);
                }
            }
        }
    };

    public AdapterView.OnItemClickListener goToCommentJudge = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            String nowUserIDTemp = MainPage.nowUser.getID();
            if(commentList.get(position).getID().equals(nowUserIDTemp) )
            {
                Toast.makeText(comment_page.this , R.string.have_no_permission , Toast.LENGTH_LONG).show();
            }
            else if(MainPage.nowUser.getIdentity().equals("T") == true)
            {
                Toast.makeText(comment_page.this , R.string.have_no_permission , Toast.LENGTH_LONG).show();
            }
            else
            {
                Intent intent = new Intent();
                intent.setClass(comment_page.this , CommentJudge.class);
                intent.putExtra(COMMENT_KEY , commentList.get(position).getComment() );
                intent.putExtra(COMMENT_CREDIBILITY_KEY , commentList.get(position).getCommentCredibility() );
                intent.putExtra(ID_KEY , commentList.get(position).getID() );
                intent.putExtra(GIVING_RANK_KEY , commentList.get(position).getGivingRank() );
                intent.putExtra(JUDGED_TIMES_KEY , commentList.get(position).getCommentJudgedTimes() );
                intent.putExtra(COURSE_ID_KEY , commentList.get(position).getCourseID() );
                startActivity(intent);
            }
        }
    };
}
