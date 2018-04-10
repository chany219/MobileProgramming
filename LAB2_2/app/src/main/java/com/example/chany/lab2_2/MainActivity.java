package com.example.chany.lab2_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    EditText Url;
    Button nextBtn;
    //각 버튼과 에딧텍스트에 대한 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Url=(EditText) findViewById(R.id.Url);
        nextBtn=(Button) findViewById(R.id.button1);
        //각 에딧텍스트와 버튼을 xml 파일에 대해 설정해줌

        nextBtn.setOnClickListener(new View.OnClickListener(){ //넥스트 버튼이 눌렸을 때의 행동

            @Override
            public void onClick(View view){
                String myUrl=Url.getText().toString();
                //해당 텍스트에 입력된 스트링을 myUrl에 지정해줌
                Intent intent = new Intent (getApplicationContext(), newActivity.class);
                //뉴액티비티에 대한 인텐트를 설정함
                intent.putExtra("Url", myUrl); //myUrl의 값을 인텐트로 새로운 액티비티에 보내줌
                startActivity(intent);
                //해당 액티비티를 실행함

            }







        });
    }
}
