package com.example.android.miwok;

/**
 * Created by MatthewG on 2017/07/04.
 */

public class PhrasesFragment extends BaseListFragment {

    @Override
    protected void initializeData() {
        englishWords = new String[]{
                "Where are you going?", "What is your name?", "My name is...",
                "How are you feeling?", "Im feeling good.", "Are you coming?",
                "Yes, Im coming.", "Im coming.", "Lets go.", "Come here."
        };
        miwokWords = new String[]{
                "minto wuksus", "tinnә oyaase'nә", "oyaaset...", "michәksәs?", "kuchi achit",
                "әәnәs'aa?", "hәә’ әәnәm", "әәnәm", "yoowutis", "әnni'nem"
        };
        audioIds = new int[]{
                R.raw.phrase_where_are_you_going,R.raw.phrase_what_is_your_name,R.raw.phrase_my_name_is,
                R.raw.phrase_how_are_you_feeling,R.raw.phrase_im_feeling_good,
                R.raw.phrase_are_you_coming,R.raw.phrase_yes_im_coming,
                R.raw.phrase_im_coming, R.raw.phrase_lets_go,R.raw.phrase_come_here,
        };

        backgroundColor = R.color.category_phrases;
    }
}
