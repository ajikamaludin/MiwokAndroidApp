package com.example.aji.miwokapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    /*//This is a Listener Example
        NumbersClickListener clickListener = new NumbersClickListener();

        TextView numbers = (TextView)findViewById(R.id.numbers);

        numbers.setOnClickListener(clickListener);
    */

    }

    public void openNumberActivity(View view){
        Intent N = new Intent(this, NumberActivity.class);
        startActivity(N);
    }


    public void openFamiliActivity(View view){
        Intent F = new Intent(this, FamilyAcvtivity.class);
        startActivity(F);
    }

    public void openColorActivity(View view){
        Intent C = new Intent(this, ColorActivity.class);
        startActivity(C);
    }

    public void openPhraseActivity(View view){
        Intent P = new Intent(this, PhraseActivity.class);
        startActivity(P);
    }

}
