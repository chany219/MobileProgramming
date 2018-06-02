package com.example.chany.lab6_1;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import static java.lang.System.in;




public class MainActivity extends AppCompatActivity {

    private static final String FILEPATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyFile";
    private static final String FILENAME = "mysdfile.txt";
    private File file;
    public EditText editText = null;
    public Button writeBtn, readBtn, clearBtn, finishBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.txtData);
        writeBtn = findViewById(R.id.write);
        readBtn = findViewById(R.id.read);
        clearBtn = findViewById(R.id.clear);
        finishBtn = findViewById(R.id.finish);

        File directory = new File(FILEPATH);
        directory.mkdir();

        file = new File(directory, FILENAME);

        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fOut = new FileOutputStream(file);
                    OutputStreamWriter osw = new OutputStreamWriter(fOut);

                    String str = editText.getText().toString();

                    /* Write String to File */
                    osw.write(str);
                    osw.flush();

                    /* Close File Output Stream */
                    osw.close();
                    fOut.close();

                    Toast.makeText(getApplicationContext(), "Done writing SD '"+ FILENAME+"'", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(null);
            }
        });

        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    /* Open File Input Stream */
                    FileInputStream fIn = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fIn);
                    StringBuffer buf = new StringBuffer();

                    /* Read each character and put into StringBuffer */
                    while (isr.ready()) {
                        buf.append((char) isr.read());
                    }
                    editText.setText(buf.toString());

                    /* Close File Input Stream */
                    isr.close();
                    fIn.close();

                    Toast.makeText(getApplicationContext(), "Done reading SD '"+FILENAME+"'", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



}









