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

    public memberadapter(Context context, ArrayList<memberClass> memberItem)
    {
        super(context , 0 , memberItem);
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

        memberClass memberitem = (memberClass)getItem(position);

        TextView name = (TextView)memberlayout.findViewById(R.id.member_name);
        name.setText(memberitem.getName());

        TextView ID = (TextView)memberlayout.findViewById(R.id.member_ID);
        ID.setText(memberitem.getID());

        TextView password = (TextView)memberlayout.findViewById(R.id.member_password);
        password.setText(memberitem.getPassword());

        TextView identity = (TextView)memberlayout.findViewById(R.id.member_identity);
        identity.setText(memberitem.getIdentity());

        return memberlayout;
    }

}
