package com.example.aji.miwokapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList On Android (Stack)

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("where are you going ?","minto wuksus"));
        words.add(new Word("what is your name ?","tinne oyaasene"));
        words.add(new Word("my name is . . .","oyaaset . . ."));
        words.add(new Word("how are you feeling ?","michekses ?"));
        words.add(new Word("im feeling good","kuchi achit"));
        words.add(new Word("are you coming ?","eenes'aa ?"));
        words.add(new Word("yes im coming ?","hee eenem"));
        words.add(new Word("im coming","eenem"));
        words.add(new Word("let's go","yoowutis"));
        words.add(new Word("come here","enni'nem"));

        //Array Adapte
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_phrases);

        //ListView
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

    }
}
