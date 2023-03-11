package com.winshelostlouis.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView questionCardView;
    CardView responseCardView;

    TextView questionTextView;
    TextView responseTextView;
    TextView totalQuestionTextView;
    Button ansA, ansB, ansC;
    Button submitBtn;

    ImageButton eyesOn;
    ImageButton eyesOff;

    LinearLayout layout;

    ImageView AddButton;

    int score = 0;
    int totalQuestion = QuestionsAnswers.question.length;
    int currentQuestionIndex = 0;
    String selectAnswer = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        totalQuestionTextView = findViewById(R.id.totalquestions);

        questionTextView = findViewById(R.id.flascard_question_textview);
        responseTextView = findViewById(R.id.flascard_reponse_textview);

        questionCardView = findViewById(R.id.flascard_question_Cardview);
        responseCardView = findViewById(R.id.flascard_reponse_Cardview);

        ansA = findViewById(R.id.reponse1);
        ansB = findViewById(R.id.reponse2);
        ansC = findViewById(R.id.reponse3);

        eyesOn = findViewById(R.id.eyesonimgb);
        eyesOff = findViewById(R.id.eyesoffimgb);


        submitBtn = findViewById(R.id.submitBtn);

        layout = findViewById(R.id.linearLayout);

        AddButton = findViewById(R.id.addIconButton);




        questionCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                responseTextView.setText(QuestionsAnswers.correctAswers[currentQuestionIndex]);
                responseCardView.setVisibility(View.VISIBLE);
                questionCardView.setVisibility(view.INVISIBLE);
            }
        });

        responseCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                responseCardView.setVisibility(view.INVISIBLE);
                questionTextView.setText(QuestionsAnswers.question[currentQuestionIndex]);
                questionCardView.setVisibility(view.VISIBLE);
            }
        });

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);

        submitBtn.setOnClickListener(this);

        totalQuestionTextView.setText("Total Question : "+ totalQuestion);

        loadNewQuestion();

      eyesOn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              eyesOn.setVisibility(View.INVISIBLE);
              eyesOff.setVisibility(View.VISIBLE);
              layout.setVisibility(View.INVISIBLE);

          }
      });

        eyesOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eyesOn.setVisibility(View.VISIBLE);
                eyesOff.setVisibility(View.INVISIBLE);
                layout.setVisibility(View.VISIBLE);
            }
        });

        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddQuestion.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onClick(View view) {

        Button clickedButton = (Button) view;

        ansA.setBackgroundColor(Color.GRAY);
        ansB.setBackgroundColor(Color.GRAY);
        ansC.setBackgroundColor(Color.GRAY);

        if(clickedButton.getId() == R.id.submitBtn){

            if(selectAnswer.equals(QuestionsAnswers.correctAswers[currentQuestionIndex]))
            {
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();

        }else {

            selectAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.CYAN);
        }

    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }

        ansA.setBackgroundColor(Color.BLUE);
        ansB.setBackgroundColor(Color.BLUE);
        ansC.setBackgroundColor(Color.BLUE);

        questionTextView.setText(QuestionsAnswers.question[currentQuestionIndex]);
        ansA.setText(QuestionsAnswers.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionsAnswers.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionsAnswers.choices[currentQuestionIndex][2]);
    }

    void finishQuiz(){

        String passStatus = " ";

        if(score > totalQuestion+0.60)
        {
            passStatus = "Passed";
        }else {

            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is " + score + " out of " + totalQuestion)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();
    }

    private void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

}