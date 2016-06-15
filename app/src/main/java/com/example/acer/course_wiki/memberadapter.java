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
 * Created by arial on 2016/6/15.
 */
public class memberadapter extends ArrayAdapter<memberClass>
{
    Context context;

    public memberadapter(Context context, ArrayList<memberClass> matchItem)
    {
        super(context , 0 , matchItem);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(context);

        LinearLayout memberlayout = null;

        if(convertView == null)
        {
            memberlayout = (LinearLayout)inflater.inflate(R.layout.member_item,null);
        }
        else
        {
            memberlayout = (LinearLayout)convertView;
        }

        memberClass matchitem = (memberClass)getItem(position);

        TextView name = (TextView)memberlayout.findViewById(R.id.member_name);
        name.setText(matchitem.getname());

        TextView ID = (TextView)memberlayout.findViewById(R.id.member_ID);
        name.setText(matchitem.getID());

        TextView password = (TextView)memberlayout.findViewById(R.id.member_password);
        name.setText(matchitem.getpassword());

        TextView identity = (TextView)memberlayout.findViewById(R.id.member_identity);
        name.setText(matchitem.getidentity());

        return memberlayout;
    }

}
