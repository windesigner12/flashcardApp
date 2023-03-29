package com.winshelostlouis.flashcardapp;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FlashcardDao {
    @Query("SELECT * FROM Flashcard")
    List<Flashcard> getAll();

    @Insert
    void insertAll(Flashcard... flashCards);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Flashcard flashCard);

    @Delete
    void delete(Flashcard flashCard);

}
