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
        image resource id
     */
    private int mImageResourceId = NO_IMAGE_PROVIDE;

    /*
        no image provide that minus
     */
    private static final int NO_IMAGE_PROVIDE = -1;

    /*
        sound resorce id
     */
    private int mRawResourceId;

    /*
     * contruktor to set the word
     */
    public Word(String defaultTranslation, String miwokTranslation, int RawResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mRawResourceId = RawResourceId;
    }

    /*
     * second contruktor to set the word with image
     */
    public Word(String defaultTranslation, String miwokTranslation, int ImageResourceId, int RawResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = ImageResourceId;
        mRawResourceId = RawResourceId;
    }

    /*
     * get the default translation
     */
    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    /*
     *   get the miwok translation
     */
    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    /*
     * get the image resource id
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /*
        get the raw id
     */
    public int getRawResourceId() {
        return mRawResourceId;
    }

    /*
        return a boolean to know has image or not
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDE;
    }

}