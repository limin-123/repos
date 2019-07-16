package com.limin.app_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "login";
    Button loginBtn = null;
    EditText useridEt = null;
    EditText passEt = null;
    TextView promptText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //去掉标题
        setContentView(R.layout.antivity_login);

        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);
        useridEt = (EditText) findViewById(R.id.userId);
        passEt = (EditText) findViewById(R.id.pass);
        promptText = (TextView) findViewById(R.id.promptText);

     /*   Bundle bundle=new Bundle();
        String flag=bundle.getString("login");
        if(flag=="login"){

        }*/

    }

    @Override
    public void onClick(View v) {
        String userid = useridEt.getText().toString().trim();
        String pass = passEt.getText().toString().trim();
        if (userid.equals("")) {
            promptText.setText(R.string.userIdError);
            return;
        }
        if (pass.equals("")) {
            promptText.setText(R.string.passError);
            return;
        }
        if (userid.equals("admin") && pass.equals("admin")) {
            Toast.makeText(this, R.string.loginSuccess, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            LoginActivity.this.finish();
        } else {
            Toast.makeText(this, R.string.loginError, Toast.LENGTH_LONG).show();
        }

    }
}
