package com.example.chany.lab3_3;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final int FRAGMENT1 = 1;
    private final int FRAGMENT2 = 2;

    private Button bt_tab1, bt_tab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //find each btn for Id
        bt_tab1 = (Button)findViewById(R.id.bt_tab1);
        bt_tab2 = (Button)findViewById(R.id.bt_tab2);

        // link listener to each tab btn
        bt_tab1.setOnClickListener(this);
        bt_tab2.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_tab1 :
                // call fragment1 for btn 1
                callFragment(FRAGMENT1);
                break;

            case R.id.bt_tab2 :
                // call fragment2 for btn 2
                callFragment(FRAGMENT2);
                break;
        }
    }

    private void callFragment(int frament_no){


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (frament_no){
            case 1:
                // 'call fragment 1
                Fragment1 fragment1 = new Fragment1();
                transaction.replace(R.id.fragment_container, fragment1);
                transaction.commit();
                break;

            case 2:
                // call fragment 2
                Fragment2 fragment2 = new Fragment2();
                transaction.replace(R.id.fragment_container, fragment2);
                transaction.commit();
                break;
        }

    }


}
