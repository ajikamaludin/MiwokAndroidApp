package com.example.aji.miwokapp;

/**
 * Created by aji on 07/06/17.
 */

public class Word {

    /*
    default translation
     */
    private String mDefaultTranslation;

    /*
        miwok translation
     */
    private String mMiwokTranslation;

    /*
     * contruktor to set the word
     */
    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /*
     * get the default translation
     */
    public String getmDefaultTranslation(){
        return mDefaultTranslation;
    }

    /*
     *   get the miwok translation
     */
    public String getmMiwokTranslation(){
        return mMiwokTranslation;
    }
}
