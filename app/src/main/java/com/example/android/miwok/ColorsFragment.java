package com.example.android.miwok;

/**
 * Created by MatthewG on 2017/07/04.
 */

public class ColorsFragment extends BaseListFragment {

    @Override
    protected void initializeData() {
        englishWords = new String[]{
                "red", "green", "brown", "gray", "black", "white", "dusty yellow", "mustard yellow"
        };
        miwokWords = new String[]{
                "weṭeṭṭi", "chokokki", "ṭakaakki", "ṭopoppi", "kululli", "kelelli", "ṭopiisә",
                "chiwiiṭә"
        };
        imageIds = new int[]{
                R.drawable.color_red,R.drawable.color_green,R.drawable.color_brown,
                R.drawable.color_gray,R.drawable.color_black,R.drawable.color_white,
                R.drawable.color_dusty_yellow,R.drawable.color_mustard_yellow
        };
        audioIds = new int[]{
                R.raw.color_red,R.raw.color_green,R.raw.color_brown,
                R.raw.color_gray,R.raw.color_black,R.raw.color_white,
                R.raw.color_dusty_yellow,R.raw.color_mustard_yellow
        };

        backgroundColor = R.color.category_colors;
    }
}
