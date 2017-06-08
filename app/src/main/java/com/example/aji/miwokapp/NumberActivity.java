package com.example.aji.miwokapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
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

        //ArrayList On Android (Stack)

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one","lutti"));
        words.add(new Word("two","otiiko"));
        words.add(new Word("three","tolookosu"));
        words.add(new Word("four","oyyisa"));
        words.add(new Word("five","massokka"));
        words.add(new Word("six","temmokka"));
        words.add(new Word("saven","kenekaku"));
        words.add(new Word("eight","kawinta"));
        words.add(new Word("nine","wo'e"));
        words.add(new Word("ten","na'aacha"));
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
        WordAdapter itemsAdapter = new WordAdapter(this, words);

        //ListView
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        //GridView
        /*
        GridView gridview = (GridView)findViewById(R.id.gridview);
        gridview.setAdapter(itemsAdapter);
        */

    }
}
