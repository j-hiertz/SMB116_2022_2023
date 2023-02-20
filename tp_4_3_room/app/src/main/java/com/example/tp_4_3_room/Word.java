package com.example.tp_4_3_room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {

   @PrimaryKey(autoGenerate = true)
   private int id;

   @NonNull
   @ColumnInfo(name = "word")
   private String word;

   public Word(@NonNull String word) {
      this.word = word;
   }

   public String getWord() {
      return word;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public void setWord(@NonNull String word) {
      this.word = word;
   }
}
