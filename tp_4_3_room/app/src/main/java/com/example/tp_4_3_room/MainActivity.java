package com.example.tp_4_3_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Word> adapterList = new ArrayList<>();
    private WordRepository wordRepository;
    private WordsAdapter wordsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordRepository = new WordRepository(getApplication());

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        EditText editText = findViewById(R.id.text);

        initializeAdapter();

        recyclerView.setAdapter(wordsAdapter);

        Button validateBtn = findViewById(R.id.validate_btn);
        validateBtn.setOnClickListener(v -> {
            Editable text = editText.getText();
            if (text != null) {
                Word newWord = new Word(text.toString());
                insertWord(newWord);
            }
            editText.setText("");
        });

        Button deleteBtn = findViewById(R.id.delete_all_btn);
        deleteBtn.setOnClickListener(view -> {
            wordRepository.deleteAllWords(() -> {
                this.runOnUiThread(() -> {
                    int size = adapterList.size();
                    adapterList.clear();
                    wordsAdapter.notifyItemRangeRemoved(0, size);
                });
            });
        });

        getAllWords();
    }

    private void initializeAdapter() {
        wordsAdapter = new WordsAdapter(adapterList);
    }

    private void getAllWords() {
        wordRepository.getAllWordsFromDb(() -> {
            this.runOnUiThread(() -> {
                adapterList.addAll(wordRepository.getAllWords());
                wordsAdapter.notifyItemInserted(adapterList.size());
            });
        });
    }

    private void insertWord(Word word) {
        wordRepository.insertWord(word, () -> {
           this.runOnUiThread(() -> {
                adapterList.add(word);
                wordsAdapter.notifyItemInserted(adapterList.size());
           });
        });
    }
}