package com.example.tp_4_3_room;

import android.app.Application;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WordRepository {

   private final WordDao wordDao;
   private final ExecutorService executorService = Executors.newSingleThreadExecutor();
   private List<Word> allWords;

   WordRepository(Application application) {
      WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
      wordDao = db.wordDao();
   }

   public List<Word> getAllWordsFromDb() {
      return allWords;
   }

   public void getAllWordsFromDb(OnQueryCompletedListener listener) {
      executorService.submit(() -> {
         allWords = wordDao.getAllWords();
         listener.onQueryComplete();
      });

   }

   public void insertWord(Word word, OnQueryCompletedListener listener) {
      executorService.submit(() -> {
         wordDao.insert(word);
         listener.onQueryComplete();
      });
   }

   public void deleteAllWords(OnQueryCompletedListener listener) {
      executorService.submit(() -> {
         wordDao.deleteAll();
         allWords.clear();
         listener.onQueryComplete();
      });
   }

   public List<Word> getAllWords() {
      return allWords;
   }

   interface OnQueryCompletedListener {
      void onQueryComplete();
   }
}
