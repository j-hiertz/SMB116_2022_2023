package com.example.tp_4_3_room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {
   private static volatile WordRoomDatabase INSTANCE;

   public abstract WordDao wordDao();

   public static WordRoomDatabase getDatabase(final Context context) {
      if (INSTANCE == null) {
         synchronized (WordRoomDatabase.class) {
            if (INSTANCE == null) {
               INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                       WordRoomDatabase.class, "word_database")
                       .fallbackToDestructiveMigration()
                       .build();
            }
         }
      }
      return INSTANCE;
   }

}

