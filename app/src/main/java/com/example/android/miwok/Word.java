package com.example.android.miwok;

/**
 * Created by MatthewG on 2017/07/02.
 */

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId;
    private int mAudioResource;

    public Word(String defaultTranslation, String miwokTranslation, int audioResource) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mImageResourceId = -1;
        this.mAudioResource = audioResource;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResource, int audioResource) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mImageResourceId = imageResource;
        this.mAudioResource = audioResource;
    }

    public String getDefaultTranslation() {
        return this.mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return this.mMiwokTranslation;
    }

    public int getImageResourceId() {
        return this.mImageResourceId;
    }

    public int getAudioResource() {
        return this.mAudioResource;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResource=" + mAudioResource +
                '}';
    }
}
