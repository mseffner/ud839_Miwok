package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

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
        int[] audioIdArray = {
                R.raw.number_one,R.raw.number_two,R.raw.number_three,
                R.raw.number_four,R.raw.number_five,R.raw.number_six,
                R.raw.number_seven,R.raw.number_eight,R.raw.number_nine,
                R.raw.number_ten,
        };

        final List<Word> words = new ArrayList<>();
        for (int i = 0; i < englishWordsArray.length; i++) {
            words.add(new Word(englishWordsArray[i], miwokWordsArray[i], imageIdArray[i], audioIdArray[i]));
        }

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int audioId = words.get(position).getAudioResource();
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, audioId);
                mediaPlayer.start();
            }
        });
    }
}
