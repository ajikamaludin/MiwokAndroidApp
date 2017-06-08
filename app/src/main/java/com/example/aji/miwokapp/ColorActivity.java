package com.example.aji.miwokapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList On Android (Stack)

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red","wetetti"));
        words.add(new Word("green","chokokki"));
        words.add(new Word("brown","takaakki"));
        words.add(new Word("gray","topoppi"));
        words.add(new Word("black","kululli"));
        words.add(new Word("white","kelelli"));
        words.add(new Word("dusty yellow","topiise"));
        words.add(new Word("mustard yellow","chiwiite"));

        //Array Adapte
        WordAdapter itemsAdapter = new WordAdapter(this, words);

        //ListView
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

    }
}
