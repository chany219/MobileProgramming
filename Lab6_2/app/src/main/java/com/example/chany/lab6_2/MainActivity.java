package com.example.chany.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String sn, name;
    EditText snText, nameText;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button save = findViewById(R.id.save);
        Button load = findViewById(R.id.load);
        Button clear = findViewById(R.id.clear);
         snText = findViewById(R.id.sn);
       nameText = findViewById(R.id.nameText);



        save.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                sn = snText.getText().toString();
                name = nameText.getText().toString();
                sharedPrefernces();
                Toast.makeText(getApplicationContext(), "Details are saved", Toast.LENGTH_LONG).show();
            }
        });


        load.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                applySharedPreference();
            }
        });



        clear.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                snText.setText("");
                nameText.setText("");
            }
        });



    }



    public void sharedPrefernces() {
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("Serial Number", sn);
        toEdit.putString("Name", name);
        toEdit.commit();
    }

    public void applySharedPreference(){
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        if (sh_Pref!=null && sh_Pref.contains("Serial Number")){
            String serial = sh_Pref.getString("Serial Number", "nosn");
            snText.setText(serial);
        }
        if (sh_Pref!=null && sh_Pref.contains("Name")){
            String name = sh_Pref.getString("Name", "noname");
            nameText.setText(name);
        }

    }



}
