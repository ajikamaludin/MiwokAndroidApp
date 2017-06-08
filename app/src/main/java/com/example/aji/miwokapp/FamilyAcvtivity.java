package com.example.aji.miwokapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyAcvtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList On Android (Stack)

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father","epe"));
        words.add(new Word("mother","eta"));
        words.add(new Word("son","angsi"));
        words.add(new Word("doughter","tune"));
        words.add(new Word("older brother","taachi"));
        words.add(new Word("younger brother","chalitti"));
        words.add(new Word("older sister","tete"));
        words.add(new Word("younger sister","kolliti"));
        words.add(new Word("grandmother","ama"));
        words.add(new Word("grandfather","paapa"));

        //Array Adapte
        WordAdapter itemsAdapter = new WordAdapter(this, words);

        //ListView
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

    }
}
