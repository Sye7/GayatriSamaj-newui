package com.example.dell.jaapactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class startActivity extends AppCompatActivity {
    Button singup, login;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        singup =findViewById(R.id.signUp);
        login = findViewById(R.id.login);

        //check if user is null
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser!= null){
            Intent in = new Intent(startActivity.this,ScrollingActivity.class);
            startActivity(in);
            finish();
        }
        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  i = new Intent(startActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(startActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }
}
