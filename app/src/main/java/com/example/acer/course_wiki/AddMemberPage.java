package com.example.acer.course_wiki;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddMemberPage extends AppCompatActivity
{
    EditText et_nameInput , et_IDInput , et_passwordInput , et_identityInput;
    SQLiteDatabase memberDatabase;
    ArrayList<memberClass> memberList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member_page);

        memberOpenHelper MopenHelper = new memberOpenHelper(this);
        memberDatabase = MopenHelper.getWritableDatabase();

        Intent intent = getIntent();
        memberList = memberDB.getMemberList(memberDatabase);

        et_nameInput = (EditText)findViewById(R.id.ET_NameInput);
        et_IDInput = (EditText)findViewById(R.id.ET_IDInput);
        et_passwordInput = (EditText)findViewById(R.id.ET_PasswordInput);
        et_identityInput = (EditText)findViewById(R.id.ET_IdentityInput);
    }


    public void onPause()
    {
        super.onPause();
        String name = et_nameInput.getText().toString();
        String ID = et_IDInput.getText().toString();
        String password = et_passwordInput.getText().toString();
        String identity = et_identityInput.getText().toString();

        if(name.equals("") || ID.equals("") || password.equals("") || identity.equals("") )
        {
            Toast.makeText(this , R.string.blank_empty , Toast.LENGTH_LONG).show();
        }
        else if(identity.toUpperCase().equals("S") || identity.toUpperCase().equals("T") )
        {
            boolean flag = memberDB.addMember(memberDatabase , name , ID.toUpperCase() , password , identity.toUpperCase() );
            if(flag == true)
            {
                //addMember會回傳這個學號(ID)是否已存在，已存在就不做事並回傳true，以下顯示學號已存在的警告訊息
                Toast.makeText(this , R.string.ID_exist_already , Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this , "success!!" , Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this , R.string.error , Toast.LENGTH_LONG).show();
        }
    }
}
