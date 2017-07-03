package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        String[] englishWordsArray = {
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"
        };
        String[] miwokWordsArray = {
                "lutti", "otoiiko", "tolookosu", "oyyisa", "massokka", "temmokka", "kenekaku",
                "kawinta", "wo'e", "na'aacha"
        };
        int[] imageIdArray = {
                R.drawable.number_one,R.drawable.number_two,R.drawable.number_three,
                R.drawable.number_four,R.drawable.number_five,R.drawable.number_six,
                R.drawable.number_seven,R.drawable.number_eight,R.drawable.number_nine,
                R.drawable.number_ten,
        };

        List<Word> words = new ArrayList<>();
        for (int i = 0; i < englishWordsArray.length; i++) {
            words.add(new Word(englishWordsArray[i], miwokWordsArray[i], imageIdArray[i]));
        }

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
