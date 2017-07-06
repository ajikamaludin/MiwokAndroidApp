package com.example.aji.miwokapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 * Created by aji on 06/07/17.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            Log.v("ini:","1");
            return new NumbersFragment();
        } else if (position == 1) {
            Log.v("ini:","2");
            return new FamilyFragment();
        } else if (position == 2) {
            Log.v("ini:","3");
            return new ColorFragment();
        } else {
            Log.v("ini:","4");
            return new PhraseFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
