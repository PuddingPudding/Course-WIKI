package com.example.acer.course_wiki;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class HomePage extends AppCompatActivity {

    Button logInBtn;
    Button bt_addMember;
    Button bt_memberList;

    public static final String ID_INPUT_KEY = "IDinput";
    public static final String PASSWORD_INPUT_KEY = "passwordInput";

    EditText et_IDinput;
    EditText et_pwdInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageSetHomePage();

    }

    private void pageSetHomePage()
    {
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et_IDinput = (EditText)findViewById(R.id.ET_IDinput);
        et_pwdInput = (EditText)findViewById(R.id.ET_PWDinput);

        logInBtn = (Button)findViewById(R.id.BT_LogIn);
        logInBtn.setOnClickListener(goToMainPage);

        bt_addMember = (Button)findViewById(R.id.BT_AddMember);
        bt_addMember.setOnClickListener(goToAddMemberPage);

        bt_memberList = (Button)findViewById(R.id.BT_MemberList);
        bt_memberList.setOnClickListener(goToMemberListPage);
    }

    public View.OnClickListener goToMainPage = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            String ID = et_IDinput.getText().toString();
            String password = et_pwdInput.getText().toString();

            Intent intent = new Intent();
            intent.setClass(HomePage.this , MainPage.class);
            intent.putExtra(ID_INPUT_KEY , ID);
            intent.putExtra(PASSWORD_INPUT_KEY , password);
        }
    };

    public View.OnClickListener goToAddMemberPage = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(HomePage.this , AddMemberPage.class);
            startActivity(intent);
        }
    };

    public View.OnClickListener goToMemberListPage = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(HomePage.this , MemberListPage.class);
            startActivity(intent);
        }
    };

    public void pageSetMainPage()
    {
        setContentView(R.layout.activity_main_page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
