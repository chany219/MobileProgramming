package com.example.chany.lab6_3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    SQLiteDatabase db;
    MySQLiteOpenHelper helper;
    ListView listView;
    Button addBtn;
    Button deleteBtn;
    EditText nameText,snText;
    String[] studentInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        helper = new MySQLiteOpenHelper(MainActivity.this, "student.db", null, 1);


        addBtn = findViewById(R.id.add);
        deleteBtn = findViewById(R.id.delete);
        nameText = findViewById(R.id.nameText);
        snText = findViewById(R.id.snText);

        invalidate();


        addBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                String name= nameText.getText().toString();
                String sn =snText.getText().toString();

                if(name.equals("")||sn.equals("")){
                    Toast.makeText(MainActivity.this, "모든 항목을 입력해주세요", Toast.LENGTH_LONG).show();
                }else {
                    insert(name, sn);
                    invalidate();
                }
            }

        });


        deleteBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                String name= nameText.getText().toString();
                if(name.equals("")){
                    Toast.makeText(MainActivity.this, "이름을 입력해주세요", Toast.LENGTH_LONG).show();
                }
                
                else {
                    delete(name);
                    invalidate();
                }
            }

        });



    }


    public void insert(String name, String sn) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("studentNo", sn);
        db.insert("student", null, values);


    }


    public void delete (String name) {
        db = helper.getWritableDatabase();
        db.delete("student", "name=?", new String[]{name});
        Log.i("db1", name + "정상적으로 삭제 되었습니다.");


    }


    public void select() {
        db = helper.getReadableDatabase();
        Cursor c;
        c = db.query("student", null, null, null, null, null, null);

        studentInfo = new String[c.getCount()];
        int count=0;
        while (c.moveToNext()) {
            studentInfo[count] = c.getString(c.getColumnIndex("name"))
                    +" "+c.getString(c.getColumnIndex("studentNo"));
            count++;
        }
        c.close();
    }


    private void invalidate(){
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,studentInfo);
        listView.setAdapter(adapter);


    }
}
