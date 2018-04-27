package com.example.chany.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    RadioGroup radioGroup;
    RadioButton maleRadio;
    RadioButton femaleRadio;
    EditText editText;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    CheckBox smsBox;
    CheckBox emailBox;
    Button send;

    //each widget and component assign


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        maleRadio = (RadioButton) findViewById(R.id.maleRadio);
        femaleRadio = (RadioButton) findViewById(R.id.femaleRadio);

        editText= (EditText) findViewById(R.id.editText);
        textView1=(TextView) findViewById(R.id.textView1);
        textView2=(TextView) findViewById(R.id.textView2);
        textView3=(TextView) findViewById(R.id.textView3);

        smsBox=(CheckBox) findViewById(R.id.smsBox);
        emailBox=(CheckBox) findViewById(R.id.emailBox);
        send = (Button) findViewById(R.id.sendButton);

        //find each object by id


        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //when send button clicked

                String name = editText.getText().toString();

                int radioId = radioGroup.getCheckedRadioButtonId();
                String mefe="";
                if (maleRadio.getId()==radioId)
                    mefe = "남자";

                if (femaleRadio.getId()==radioId)
                    mefe = "여자";

                String send = "";
                if (smsBox.isChecked()) {
                    send += "SMS ";
                }
                if (emailBox.isChecked()) {
                    send += "e-mail ";
                }

                //check clicked in each radio/checkbox and string of name







                //reset all of list


                Intent intent = new Intent(getApplicationContext(), NewActivity.class);

                intent.putExtra("name", name);
                intent.putExtra("mefe", mefe);
                intent.putExtra("send", send);
                editText.setText("");
                radioGroup.clearCheck();
                smsBox.setChecked(false);
                emailBox.setChecked(false);
                startActivity(intent);

                //send string to new activity and start activity
            }



        });




    }
}
