package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        String[] englishWordsArray = {
                "red", "green", "brown", "gray", "black", "white", "dusty yellow", "mustard yellow"
        };
        String[] miwokWordsArray = {
                "weṭeṭṭi", "chokokki", "ṭakaakki", "ṭopoppi", "kululli", "kelelli", "ṭopiisә",
                "chiwiiṭә"
        };
        int[] imageIdArray = {
                R.drawable.color_red,R.drawable.color_green,R.drawable.color_brown,
                R.drawable.color_gray,R.drawable.color_black,R.drawable.color_white,
                R.drawable.color_dusty_yellow,R.drawable.color_mustard_yellow
        };

        List<Word> words = new ArrayList<>();
        for (int i = 0; i < englishWordsArray.length; i++) {
            words.add(new Word(englishWordsArray[i], miwokWordsArray[i], imageIdArray[i]));
        }

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
