package com.example.aluclassattendanceapp;


import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CaptureInfo extends Fragment {

    Button add, viewBtn;
    Database db;
    EditText id, sName, email, password;

    private Button btn, savebtn;


    public CaptureInfo(MainActivity mainActivity) {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_capture_info, container, false);



        db = new Database(this.getActivity());

        id = view.findViewById(R.id.idtxt);
        sName = view.findViewById(R.id.nametxt);
        password = view.findViewById(R.id.passwordtxt);
        email = view.findViewById(R.id.emailtxt);




        add = view.findViewById(R.id.addbtn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = db.insertData(sName.getText().toString(), password.getText().toString(), email.getText().toString());
                System.out.println(sName.getText().toString());

                if (check){
                    Toast.makeText(getActivity(), "data has been inserted", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getActivity(), "data has not been inserted", Toast.LENGTH_LONG).show();

                }

//                if (validateInput(id, sName, password, email)){
//
////                    MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer, new Success(), null).addToBackStack(null).commit();
//                }
            }
        });

        viewBtn = view.findViewById(R.id.viewbtn);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor results = db.readData();

                if (results.getCount() == 0){
                    showMessage("Error", "Nothing in the database");
                    return;

                }

                StringBuilder sb = new StringBuilder();

//                while (results.moveToNext()){
//                    sb.append("RedNo : ").append(results.getString(0)).append("\n");
//                    sb.append("Name : ").append(results.getString(1)).append("\n");
//                    sb.append("Password : ").append(results.getString(2)).append("\n");
//                    sb.append("Email : ").append(results.getString(3)).append("\n");
//                }

                showMessage("Students Record", "mess");
            }
        });


        return view;
    }

    public boolean validateInput(EditText id, EditText sName, EditText password, EditText email){
        if (id.getText().toString().isEmpty()){
            id.setError("Enter ID");
            return false;
        }

        if (sName.getText().toString().isEmpty()){
            sName.setError("Enter student name");
            return false;
        }

        if (password.getText().toString().isEmpty()){
            password.setError("Enter password");
            return false;
        }

        if (email.getText().toString().isEmpty()){
            email.setError("Enter student name");
            return false;
        }

        return true;
    }


    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
