package lincyu.homework4r;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class GreetingActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView)findViewById(R.id.say_hello);
        Intent intent = getIntent();
        String hello = "Hello ";
        if(intent != null) {
            String name = intent.getStringExtra("KEY_NAME");
            hello = hello + name;
            tv.setText(hello);
        }
    }
}
