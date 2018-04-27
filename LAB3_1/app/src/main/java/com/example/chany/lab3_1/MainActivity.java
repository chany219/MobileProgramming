package com.example.chany.lab3_1;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    Button mBtn; //button assign

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = (Button)findViewById(R.id.button);
        registerForContextMenu(mBtn);
        //find view by id of button
        //register button for Context menu
    }



    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        Log.d("test", "onCreateContextMenu");
        menu.setHeaderTitle("Button Menu");
        menu.add(0,1,0,"Red");
        menu.add(0,2,0,"Green");
        menu.add(0,3,0,"Blue");

        //set color in button text
    }

    public boolean onContextItemSelected (MenuItem item) {

        switch (item.getItemId()) {
            case 1:mBtn.setTextColor(Color.RED);
            return true;
            case 2:mBtn.setTextColor(Color.GREEN);
            return true;
            case 3:mBtn.setTextColor(Color.BLUE);
            return true;

            //button click in menu item
        }


            return true;
    }
}



