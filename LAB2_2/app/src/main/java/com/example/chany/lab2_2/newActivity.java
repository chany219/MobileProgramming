package com.example.chany.lab2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;


public class newActivity extends AppCompatActivity {


    TextView textView;
    Button goBtn;
    Button backBtn;
    //각 버튼과 텍스트뷰에 대한 선언


    @Override
    protected void onCreate(Bundle savedInstanceState) { // 액티비티가 생성된 상황
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView = (TextView) findViewById(R.id.textView);
        goBtn = (Button) findViewById(R.id.button1);
        backBtn = (Button) findViewById(R.id.button2);
        //각 버튼에 대해 xml과 매칭해줌

        Intent passedIntent= getIntent(); //메인 액티비티의 인텐트를 받아오는 부분
        final String passedUrl = passedIntent.getStringExtra("Url"); //Url에서의 주소인 스트링을 passedUrl에 받아옴
        textView.setText(passedUrl); //받아온 주소를 텍스트뷰에 표시해줌


        goBtn.setOnClickListener(new View.OnClickListener(){ //고 버튼이 눌렸을 때의 행동
            @Override
            public void onClick(View view) {
                if (!passedUrl.equals("")) { //만약 받아온 주소가 공백이 아니라면
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+passedUrl));
                    startActivity(intent);
                    //해당하는 주소로 웹뷰어를 띄우도록 함
                } else {
                    Toast.makeText(getApplicationContext(), "주소를 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                    //해당 주소가 비어있으므로 토스트 메세지를 통해 다시 주소를 입력하도록 안내함
                }

            }

            });



        backBtn.setOnClickListener(new View.OnClickListener(){ //백 버튼이 눌렸을 때의 행동
            @Override
            public void onClick(View view) {
               Toast.makeText(getApplicationContext(), "뒤로가기 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
               //토스트 메세지로 뒤로가기 버튼을 눌렀다는 것을 알려줌
                finish();
                //현재 액티비티를 종료함
            }

        });




    }



}


