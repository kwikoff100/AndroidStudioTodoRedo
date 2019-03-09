package com.example.todoredo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btnButton);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String URL1 = "https://mern-boilerplate-app2.herokuapp.com/putData";
                final String URL2 = "https://largeproject-mern-app.herokuapp.com/todos/add";

                JSONObject obj =  new JSONObject();
                try {
                    obj.put("todo_description", "Yeet");
                    obj.put("todo_responsible", "Yote");
                    obj.put("todo_priority", "low");
                    obj.put("todo_completed", false);
                }
                catch(Exception e){

                }
                final String message = obj.toString();

                final JSONObject ret = com.example.todoredo.JsonIo.doJsonIo(URL2, message);

                TextView tv = (TextView) findViewById(R.id.tvText);
                tv.setText(message);

            }
        });
    }
}