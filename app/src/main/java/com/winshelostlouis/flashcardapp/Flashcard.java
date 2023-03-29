package com.winshelostlouis.flashcardapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity
public class Flashcard {

    @Ignore
    Flashcard(@NonNull String question, @NonNull String answer){
        this.uuid = UUID.randomUUID().toString();
        this.question = question;
        this.answer= answer;

    }


    Flashcard(@NonNull String question, @NonNull String answer, @NonNull String wrongAnswer1, @NonNull String wrongAnswer2){
        this.uuid = UUID.randomUUID().toString();
        this.question = question;
        this.answer= answer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uuid")
    private String uuid;

    @NonNull
    public String getUuid(){
        return uuid;
    }


    public void setUuid(@NonNull String uuid) { this.uuid = uuid ;}

    @NonNull
    @ColumnInfo(name = "question")
    private String question;


    @NonNull
    @ColumnInfo(name = "answer")
    private String answer;

    @NonNull
    @ColumnInfo(name = "wrong_answer_1")
    private String wrongAnswer1;

    @NonNull
    @ColumnInfo(name = "wrong_answer_2")
    private  String wrongAnswer2;


    @NonNull
    public String getQuestion() {return question;}

    public void setQuestion(@NonNull String question ){this.question = question;}

    @NonNull
    public String getAnswer() {return answer;}

    public void setAnswer(@NonNull String answer){this.answer = answer; }

    @Nullable
    public String getWrongAnswer1() {return wrongAnswer1;}

    public void setWrongAnswer1(){ this.wrongAnswer1 = wrongAnswer1;}

    @Nullable
    public String getWrongAnswer2() {return wrongAnswer1;}

    public void setWrongAnswer2(){ this.wrongAnswer2 = wrongAnswer2;}


}


