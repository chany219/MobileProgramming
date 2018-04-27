package com.example.chany.lab3_2;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NewActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);


        TextView name= (TextView) findViewById(R.id.name);
        TextView mefe= (TextView) findViewById(R.id.mefe);
        TextView send= (TextView) findViewById(R.id.send);


        Intent passedIntent=getIntent();
        if(passedIntent!=null) {
            String nameText = passedIntent.getStringExtra("name");
            String mefeText= passedIntent.getStringExtra("mefe");
            String sendText= passedIntent.getStringExtra("send");

            //get string from the main activity

            name.setText(nameText);
            mefe.setText(mefeText);
            send.setText(sendText);

            //set text in textView
        }





        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                finish();
                //back button go back to the main activity
            }

        });

    }
}
