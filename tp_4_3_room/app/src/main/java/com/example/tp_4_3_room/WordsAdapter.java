package com.example.tp_4_3_room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WordViewHolder> {

   List<Word> wordsList;

   public WordsAdapter(List<Word> words) {
      this.wordsList = words;
   }

   @NonNull
   @Override
   public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(parent.getContext())
              .inflate(R.layout.words_item, parent, false);
      return new WordViewHolder(itemView);
   }

   @Override
   public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
      // Retrieve the correct data for that position
      Word data = wordsList.get(position);
      // Add the data to the view
      holder.bind(data);
   }

   @Override
   public int getItemCount() {
      // Return the number of data items to display
      return wordsList.size();
   }

   class WordViewHolder extends RecyclerView.ViewHolder {

      TextView wordTextView;

      public WordViewHolder(@NonNull View itemView) {
         super(itemView);
         wordTextView = itemView.findViewById(R.id.word_textview);
      }

      public void bind(Word data) {
         wordTextView.setText(data.getWord());
      }
   }
}
