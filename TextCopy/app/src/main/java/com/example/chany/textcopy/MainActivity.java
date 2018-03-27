package com.example.chany.textcopy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public EditText edit_name;
    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;

    // Each part of Buttons and TextView


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //invoke initialize method
    }


    public void init(){

        edit_name=(EditText)findViewById(R.id.EditText);
         btn_clear= (Button)findViewById(R.id.btn_clear);
        btn_print= (Button) findViewById(R.id.btn_print);
        view_print= (TextView)findViewById(R.id.textView);


        // initialize all of the buttons and Text view in init()

    }



    public void clearClicked(View v){
        edit_name.setText("");
        view_print.setText("");


        // clear EditText and Viewprint when clear button is clicked.
    }

    public void printClicked(View v){
        String text="";

        text=edit_name.getText().toString();
        view_print.setText(text);

        // print string in Viewprint from EditText when print button is clicked.
    }
}
