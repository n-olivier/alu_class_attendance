package com.example.aluclassattendanceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Database db;
    EditText sName, email, password;

    private Button btn, savebtn;
    Context ctxt;



    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        if(findViewById(R.id.FragmentContainer) != null){

            if(savedInstanceState != null){
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            CaptureInfo captureInfo = new CaptureInfo(this);
            fragmentTransaction.add(R.id.FragmentContainer, captureInfo, null);
            fragmentTransaction.commit();
        }
    }
}
