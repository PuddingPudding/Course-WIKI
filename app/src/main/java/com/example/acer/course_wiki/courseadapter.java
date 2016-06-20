package com.example.acer.course_wiki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Acer on 2016/6/20.
 */
public class courseadapter extends ArrayAdapter<courseClass>
{
    Context context;

    public courseadapter(Context context, ArrayList<courseClass> courseItem)
    {
        super(context , 0 , courseItem);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        LinearLayout courselayout = null;

        if (convertView == null)
        {
            courselayout = (LinearLayout) inflater.inflate(R.layout.course_item, null);
        }
        else
        {
            courselayout = (LinearLayout) convertView;
        }

        courseClass courseitem = (courseClass) getItem(position);

        TextView name = (TextView) courselayout.findViewById(R.id.courseName);
        name.setText(courseitem.getCourseName());

        TextView ID = (TextView) courselayout.findViewById(R.id.courseID);
        ID.setText(courseitem.getCourseID());

        TextView courseScore = (TextView) courselayout.findViewById(R.id.courseScore);
        courseScore.setText("" + courseitem.getCourseScore());

        TextView teacher = (TextView) courselayout.findViewById(R.id.courseTeacher);
        teacher.setText(courseitem.getTeacher());

        TextView score = (TextView) courselayout.findViewById(R.id.Score);
        score.setText("" + courseitem.getScore() );

        return courselayout;
    }
}
