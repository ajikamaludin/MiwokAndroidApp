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
public class PhraseFragment extends Fragment {

    MediaPlayer mediaPlayer;

    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mComplateListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp){
            releaseMediaPlayer();
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

        }
    }

    public PhraseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        getActivity().setContentView(R.layout.word_list);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_phrases);

        //Audio Manager


        //ListView
        ListView listView = (ListView) getActivity().findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
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


        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
