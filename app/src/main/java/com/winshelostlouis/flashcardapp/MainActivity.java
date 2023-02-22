package com.winshelostlouis.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView question;
    TextView reponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        question = findViewById(R.id.flascard_question_textview);
        reponse = findViewById(R.id.flascard_reponse_textview);


        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                question.setVisibility(View.INVISIBLE);
                reponse.setVisibility(View.VISIBLE);

            }
        });

        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                question.setVisibility(View.VISIBLE);
                reponse.setVisibility(View.INVISIBLE);

            }
        });
    }
}