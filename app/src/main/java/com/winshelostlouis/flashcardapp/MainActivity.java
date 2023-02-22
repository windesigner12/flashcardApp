package com.winshelostlouis.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardView question;
    CardView response;
    Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        question = findViewById(R.id.flascard_question_textview);
        response = findViewById(R.id.flascard_reponse_textview);
        button1 = findViewById(R.id.reponse1);
        button2 = findViewById(R.id.reponse2);
        button3 = findViewById(R.id.reponse3);
        button4 = findViewById(R.id.reponse4);


              button1.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                     button1.setVisibility(View.INVISIBLE);
                     Toast.makeText(MainActivity.this,"Mauvaise reponse", Toast.LENGTH_LONG).show();
                   }
              });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    response.setVisibility(View.VISIBLE);
                    question.setVisibility(View.INVISIBLE);
                    button2.setVisibility(View.INVISIBLE);
                    button4.setVisibility(View.VISIBLE);

                }
            });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button3.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this,"Mauvaise reponse", Toast.LENGTH_LONG).show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button4.setVisibility(View.INVISIBLE);
                response.setVisibility(View.INVISIBLE);
                question.setVisibility(View.VISIBLE);
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button3.setVisibility(View.VISIBLE);
            }
        });

    }
}