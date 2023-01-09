package com.example.tp_3_5_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final List<String> adjective = Arrays.asList("important", "black", "alluring", "reasonable", "fluffy", "smiling", "half", "stereotyped", "smoggy", "suitable");
    private final List<String> name = Arrays.asList("engineering", "beer", "revolution", "highway", "insect", "mode", "meal", "complaint", "conversation", "cigarette");
    private final List<String> adapterList = new ArrayList<>();
    private WordsAdapter wordsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 100; i++) {
            adapterList.add(generateRandomWord());
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeAdapter();

        recyclerView.setAdapter(wordsAdapter);

        FloatingActionButton fab = findViewById(R.id.add_btn);
        fab.setOnClickListener(v -> {
            adapterList.add(5, generateRandomWord());
            wordsAdapter.notifyItemInserted(5);
        });
    }

    private String generateRandomWord() {
        // 2 - Générer deux nombres aléatoire et concatener deux éléments de liste
        Random rn = new Random();
        return adjective.get(rn.nextInt(adjective.size())) + " " + name.get(rn.nextInt(name.size()));
    }

    private void initializeAdapter() {
        wordsAdapter = new WordsAdapter(adapterList, word -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            intent.putExtra("word", word);
            startActivity(intent);
        });
    }
}