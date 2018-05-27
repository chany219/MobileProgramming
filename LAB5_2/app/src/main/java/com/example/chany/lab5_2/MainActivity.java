package com.example.chany.lab5_2;

        import android.os.AsyncTask;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    TextView textView1,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.editText);
        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String str=editText.getText().toString();
                Integer num=Integer.parseInt(str);
                new calculateTask().execute(num);
                //factorial calculation in input number
            }
        });
    }

    class calculateTask extends AsyncTask<Integer,Integer,Void> {
        //class to calculate result
        String progress="";
        Integer result=1;
        String resultStr="= ";
        protected  void onPreExecute() {
        }

        protected Void doInBackground(Integer... params) {
            for(Integer i=params[0];i>0;i-- ) {
                try {Thread.sleep(500) ;
                    result*=i;

                    publishProgress(i);
                }catch (Exception e) {}
            }
            return null;

        }
        protected void onProgressUpdate(Integer...values) {
            progress=progress+" "+values[0];
            textView1.setText(progress);
        }

        protected  void onPostExecute(Void aVoid) {
            // update to textView result
            resultStr+=result;
            textView2.setText(resultStr);
        }
    }

}