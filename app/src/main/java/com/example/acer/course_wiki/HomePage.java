package com.example.acer.course_wiki;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    Button logInBtn;
    Button bt_addMember;
    Button bt_memberList;

    public static final String ID_INPUT_KEY = "IDinput";
    public static final String PASSWORD_INPUT_KEY = "passwordInput";
//    ID_INPUT_KEY代表intent噴出資料時用來標記ID(學號)的KEY
//    PASSWORD_INPUT_KEY則代表intent噴出資料時用來標記password(密碼)的KEY

    EditText et_IDinput;
    EditText et_pwdInput;

    SQLiteDatabase memberDatabase;

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

        memberOpenHelper MopenHelper = new memberOpenHelper(this);
        memberDatabase = MopenHelper.getWritableDatabase();
    }

    public View.OnClickListener goToMainPage = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            String ID = et_IDinput.getText().toString();
            String password = et_pwdInput.getText().toString();

            if(memberDB.getMember(memberDatabase , ID , password) == null)
            {
                Toast.makeText(HomePage.this , R.string.error , Toast.LENGTH_LONG).show();
            }
            else
            {
                Intent intent = new Intent();
                intent.setClass(HomePage.this , MainPage.class);
                intent.putExtra(ID_INPUT_KEY , ID);
                intent.putExtra(PASSWORD_INPUT_KEY , password);
                startActivity(intent);
            }

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
