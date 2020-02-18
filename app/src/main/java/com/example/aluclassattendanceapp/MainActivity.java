package com.example.aluclassattendanceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    EditText nametxt, passwordtxt;
    Button add;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Password = "password";

    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nametxt = findViewById(R.id.nametxt);
        passwordtxt = findViewById(R.id.passwordtxt);

        add = findViewById(R.id.addbtn);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        GetSavedData();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                Toast.makeText(MainActivity.this,"Content Saved",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void saveData(){
        String n  = nametxt.getText().toString();
        String ph  = passwordtxt.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString(Name, n);
        editor.putString(Password, ph);
        editor.apply();
    }
    public void GetSavedData(){
        if(sharedpreferences.contains(Name)){
            String tvName = sharedpreferences.getString(Name,"");
            String tvPassword = sharedpreferences.getString(Password,"");
            nametxt.setText(tvName);
            passwordtxt.setText(tvPassword);
        }
    }
}
