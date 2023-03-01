package com.winshelostlouis.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView questionCardView;
    CardView responseCardView;

    TextView questionTextView;
    TextView responseTextView;
    TextView totalQuestionTextView;
    Button ansA, ansB, ansC;
    Button submitBtn;


    int score = 0;
    int totalQuestion = QuestionsAnswers.question.length;
    int currentQuestionIndex = 0;
    String selectAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        totalQuestionTextView = findViewById(R.id.totalquestions);

        questionTextView = findViewById(R.id.flascard_question_textview);
        responseTextView = findViewById(R.id.flascard_reponse_textview);

        ansA = findViewById(R.id.reponse1);
        ansB = findViewById(R.id.reponse2);
        ansC = findViewById(R.id.reponse3);

        submitBtn = findViewById(R.id.submitBtn);


        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);

        submitBtn.setOnClickListener(this);

        totalQuestionTextView.setText("Total Question : "+ totalQuestion);

        loadNewQuestion();


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