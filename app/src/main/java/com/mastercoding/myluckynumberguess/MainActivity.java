package com.mastercoding.myluckynumberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Welcome_text1;
    EditText Name_edit;
    Button button_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Welcome_text1=findViewById(R.id.textView);
        Name_edit=findViewById(R.id.editText);
        button_signin=findViewById(R.id.button);
        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user_name=Name_edit.getText().toString();

                // Since We need to navigate in the same app from one activity to other so we will use Explicit Intent
                Intent intent=new Intent(getApplicationContext(),LuckyNumberActivity.class);

                // Passing extra information
                intent.putExtra("name",user_name);
                startActivity(intent);





            }
        });

    }
}