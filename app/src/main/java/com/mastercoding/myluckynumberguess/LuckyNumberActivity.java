package com.mastercoding.myluckynumberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    Button Share_button2;
    TextView Wel_text2;
    TextView Lucky_no_text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        Share_button2=findViewById(R.id.button2);
        Wel_text2=findViewById(R.id.textView2);
        Lucky_no_text3=findViewById(R.id.textView3);

        Intent intent=getIntent();
        String userName=intent.getStringExtra("name");

        int Random_Number=randomNumberGenerator();
        Lucky_no_text3.setText("Hello\n"+userName+"\nYour Lucky No. is:\n"+Random_Number);

        Share_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                share_data(userName,Random_Number);

            }
        });

    }

    public int randomNumberGenerator(){

        int upper_limit=1000;
        Random random= new Random();
        int random_number=random.nextInt(upper_limit);
        return random_number;
    }

    public void share_data(String name,int val){
        Intent intent3=new Intent(Intent.ACTION_SEND);
        intent3.setType("text/plain");

        String number=String.valueOf(val);

        intent3.putExtra(Intent.EXTRA_SUBJECT,name+" got Lucky Today!");
        intent3.putExtra(Intent.EXTRA_TEXT,"Your Lucky Number is: "+number+"\nThis Number is Generated and Send by Aaryan Sahlot Lucky Number Application\n\n\nThanking You");


        startActivity(Intent.createChooser(intent3,"Choose a Platform"));


    }
}