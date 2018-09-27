package com.example.david.animals;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;

public class MainActivity extends AppCompatActivity {
    Server server;

    private ThreadProcessor processor;
    private TextView somethingText;
    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            somethingText.setText((String) msg.obj);
        }
    };

    //MainHandler();

    //public class MainHandler extends Handler {
    //@SuppressLint("HandlerLeak")
  /*      Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Bundle bundle=msg.getData();
                bundle.getString("myKey");
                TextView myTextView =
                        (TextView) findViewById(R.id.somethingText);
                myTextView.setText("Button Pressed");
            }
        };*/
    // }
   /* printPersons(
            roster,
    new CheckPerson() {
        public boolean test(Person p) {
            return p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 25;
        }
    }
);*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        somethingText = (TextView) findViewById(R.id.somethingText);

        //set THREAD_PRIORITY_BACKGROUND
        //Thread.currentThread(); stores runnable objects
        processor = new ThreadProcessor();

        processor.instantiateTask1();
        processor.instantiateTask2();
        processor.instantiateTask3();

        /*public void onDestroy () {
            super.onDestroy();
            processor.quit();
        }*/
    }
}
                //server = new Server(this);


                //add the button after testing
        /*final ImageButton dogButton=findViewById(R.id.dogButton);
        dogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                server=new Server();
                server = new Server(MainActivity.this,handler);

            }
        });*/

//receive message her with handlemessage





