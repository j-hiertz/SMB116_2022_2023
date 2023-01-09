package com.example.tp_3_5_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WordViewHolder> {

    List<String> wordsList;
    WordsListener wordsListener;

    public WordsAdapter(List<String> words, WordsListener listener) {
        this.wordsList = words;
        this.wordsListener = listener;
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
        String data = wordsList.get(position);
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

        public void bind(String data) {
            wordTextView.setText(data);
            wordTextView.setOnClickListener((view) -> wordsListener.onWordSelected(data));
        }
    }
}
