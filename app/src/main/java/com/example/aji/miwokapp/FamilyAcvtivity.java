package com.example.aji.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyAcvtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList On Android (Stack)

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "epe", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("mother", "eta", R.drawable.family_mother, R.raw.family_father));
        words.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_father));
        words.add(new Word("doughter", "tune", R.drawable.family_daughter, R.raw.family_father));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_father));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_father));
        words.add(new Word("older sister", "tete", R.drawable.family_older_sister, R.raw.family_father));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_father));
        words.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_father));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_father));

        //Array Adapte
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_family);

        //ListView
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
                Word word = words.get(position);
                MediaPlayer mediaPlayer = MediaPlayer.create(FamilyAcvtivity.this, word.getRawResourceId());
                mediaPlayer.start();
            }
        });

    }
}
