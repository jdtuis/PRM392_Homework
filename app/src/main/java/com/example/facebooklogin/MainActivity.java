package com.example.facebooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText txtUsername;
    EditText txtPassword;
    Intent toHomepage;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.login_button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtUsername = findViewById(R.id.txtUsername);
                txtPassword = findViewById(R.id.txtPassword);
                if(txtUsername.getText().toString().equals("admin") && txtPassword.getText().toString().equals("admin")){
                    toHomepage = new Intent(MainActivity.this, HomePageActivity.class);
                    toHomepage.putExtra("FullName", "Tran Hoang Nguyen");
                    startActivity(toHomepage);
                    finish();
                }

            }
        });
    }


}