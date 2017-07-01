package com.example.aji.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mComplateListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp){
            releaseMediaPlayer();
            Toast.makeText(getApplicationContext(),"I'm DONE",Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList On Android (Stack)

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("where are you going ?","minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Word("what is your name ?","tinne oyaasene", R.raw.phrase_what_is_your_name));
        words.add(new Word("my name is . . .","oyaaset . . .", R.raw.phrase_my_name_is));
        words.add(new Word("how are you feeling ?","michekses ?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("im feeling good","kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word("are you coming ?","eenes'aa ?", R.raw.phrase_are_you_coming));
        words.add(new Word("yes im coming ?","hee eenem", R.raw.phrase_yes_im_coming));
        words.add(new Word("im coming","eenem", R.raw.phrase_im_coming));
        words.add(new Word("let's go","yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("come here","enni'nem", R.raw.phrase_come_here));

        //Array Adapte
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_phrases);

        //ListView
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
                Word word = words.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(PhraseActivity.this, word.getRawResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mComplateListener);
            }
        });

    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

        }
    }
}
