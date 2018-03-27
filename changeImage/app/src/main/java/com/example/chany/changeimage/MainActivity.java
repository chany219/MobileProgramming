package com.example.chany.changeimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;

    int imageIndex=0;
    //set Index for check which image is now showing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = (ImageView)findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView2) ;
        //set imageView in java with thier id
    }


    public void onButtonClicked(View v){
        changeImage();
    } //when change button is clicked, changeImage method is provoked


    public void changeImage(){
        if(imageIndex==0){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageIndex=1;
        }
        else if(imageIndex==1){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageIndex=0;
        }
//set visible and invisible for each  images
    }


}
