package com.example.android.miwok;

/**
 * Created by MatthewG on 2017/07/04.
 */

public class FamilyFragment extends BaseListFragment {

    @Override
    protected void initializeData() {
        englishWords = new String[]{
                "father", "mother", "son", "daughter", "older brother", "younger brother",
                "older sister", "younger sister", "grandmother", "grandfather"
        };
        miwokWords = new String[]{
                "әpә", "әṭa", "angsi", "tune", "taachi", "chalitti", "teṭe", "kolliti", "ama",
                "paapa"
        };
        imageIds = new int[]{
                R.drawable.family_father,R.drawable.family_mother,R.drawable.family_son,
                R.drawable.family_daughter,R.drawable.family_older_brother,
                R.drawable.family_younger_brother,R.drawable.family_older_sister,
                R.drawable.family_younger_sister,R.drawable.family_grandmother,
                R.drawable.family_grandfather
        };
        audioIds = new int[]{
                R.raw.family_father,R.raw.family_mother,R.raw.family_son,
                R.raw.family_daughter,R.raw.family_older_brother,
                R.raw.family_younger_brother,R.raw.family_older_sister,
                R.raw.family_younger_sister,R.raw.family_grandmother,
                R.raw.family_grandfather
        };

        backgroundColor = R.color.category_family;
    }
}
