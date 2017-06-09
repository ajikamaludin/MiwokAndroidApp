package com.example.aji.miwokapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.test.suitebuilder.TestMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aji on 07/06/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    private int mColor;
    /*
    Constructor
     */
    public WordAdapter(Activity context, ArrayList<Word> word, int Color){
        super(context, 0, word);
        mColor = Color;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }

        Word nameWord = getItem(position);

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.defaultTranslation);

        defaultTextView.setText(nameWord.getmDefaultTranslation());

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwokTranslation);

        miwokTextView.setText(nameWord.getmMiwokTranslation());

        ImageView iconText = (ImageView) listItemView.findViewById(R.id.image_item);

        if(nameWord.hasImage()){
            iconText.setImageResource(nameWord.getImageResourceId());
            iconText.setVisibility(View.VISIBLE);
        }else{
            iconText.setVisibility(View.GONE);
        }

        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.llayout);

        int color = ContextCompat.getColor(getContext(), mColor);

        linearLayout.setBackgroundColor(color);

        return listItemView;
    }
}
