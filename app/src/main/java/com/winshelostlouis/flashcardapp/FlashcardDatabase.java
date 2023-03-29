package com.winshelostlouis.flashcardapp;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

public class FlashcardDatabase {

    private final AppDatabase db;

    FlashcardDatabase(Context context){

        db = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "flashcard-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

    }

    public void initFirstCard(){
        if(db.flashcardDao().getAll().isEmpty()){
            insertCard(new Flashcard("Which Company owns the Android", "samsung"));
        }
    }

    public List<Flashcard> getAllCards(){return db.flashcardDao().getAll();}

    private void insertCard(Flashcard flashcard) { db.flashcardDao().insertAll(flashcard);
    }

    public void deleteCard(String flashcardQuestion){
        List<Flashcard> allCards = db.flashcardDao().getAll();

        for(Flashcard f : allCards){
            if (f.getQuestion().equals(flashcardQuestion)){
                db.flashcardDao().delete(f);
            }
        }
    }

    public void updateCard(Flashcard flashcard) {db.flashcardDao().update(flashcard);}
}
