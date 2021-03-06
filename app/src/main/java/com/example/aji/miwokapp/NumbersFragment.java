package com.example.aji.miwokapp;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {

    MediaPlayer mediaPlayer;

    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mComplateListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp){
            releaseMediaPlayer();
            //Toast.makeText(getApplicationContext(),"I'm DONE",Toast.LENGTH_SHORT).show();
        }
    };

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChane){
                    if(focusChane == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChane == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                    } else if(focusChane == AudioManager.AUDIOFOCUS_GAIN){
                        mediaPlayer.start();
                    } else if(focusChane == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                }
            };

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

            //release audio
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //getActivity().setContentView(R.layout.word_list);
        /* // Array On Android Studio
        String[] words = new String[10];
        words[0] = "one";
        words[1] = "two";
        words[2] = "three";
        words[3] = "four";
        words[4] = "five";
        words[5] = "six";
        words[6] = "saven";
        words[7] = "eight";
        words[8] = "nine";
        words[9] = "ten";

        Log.v("NumbersActivity","Word at index -0 :" + words[0]);
        Log.v("NumbersActivity","Word at index -1 :" + words[1]);
        Log.v("NumbersActivity","Word at index -2 :" + words[2]);
        Log.v("NumbersActivity","Word at index -3 :" + words[3]);
        Log.v("NumbersActivity","Word at index -4 :" + words[4]);
        Log.v("NumbersActivity","Word at index -5 :" + words[5]);
        Log.v("NumbersActivity","Word at index -6 :" + words[6]);
        Log.v("NumbersActivity","Word at index -7 :" + words[7]);
        Log.v("NumbersActivity","Word at index -8 :" + words[8]);
        Log.v("NumbersActivity","Word at index -9 :" + words[9]);
        */

        //Inisialisasi Audio Manager
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        //ArrayList On Android (Stack)

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("saven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo'e" , R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));
        /*
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("saven");
        words.add("eight");
        words.add("nine");
        words.add("ten");
        */
        //LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

        /*
        //MyLoop
        for (int i = 0 ;i < words.size(); i++){
            TextView wordview = new TextView(this);
            wordview.setText(words.get(i));
            rootView.addView(wordview);
        }
        */

        //Udacity Example Loop
        /*
        int index = 0;
        while(index < words.size()){
            TextView wordview = new TextView(this);
            wordview.setText(words.get(index));
            rootView.addView(wordview);
            Log.v("Sy:","index - "+index+" : " + words.get(index));
            index++;
        }
        */

        //Array Adapte
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_numbers);

        //ListView
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int position,long l){

                //call the class
                Word word = words.get(position);

                //Request Audio Focus
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN
                );

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Logging From Class Word Have Function To String
                    // Log.v("NumbersActivity", "Current word: " + word.toString());
                    releaseMediaPlayer();
                    mediaPlayer = MediaPlayer.create(getActivity(), word.getRawResourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mComplateListener);
                }
            }
        });
        //GridView
        /*
        GridView gridview = (GridView)findViewById(R.id.gridview);
        gridview.setAdapter(itemsAdapter);
        */



        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

}
