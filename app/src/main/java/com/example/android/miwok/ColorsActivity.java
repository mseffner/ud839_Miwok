package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

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
        int[] audioIdArray = {
                R.raw.color_red,R.raw.color_green,R.raw.color_brown,
                R.raw.color_gray,R.raw.color_black,R.raw.color_white,
                R.raw.color_dusty_yellow,R.raw.color_mustard_yellow
        };

        final List<Word> words = new ArrayList<>();
        for (int i = 0; i < englishWordsArray.length; i++) {
            words.add(new Word(englishWordsArray[i], miwokWordsArray[i], imageIdArray[i], audioIdArray[i]));
        }

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int audioId = words.get(position).getAudioResource();
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, audioId);
                mediaPlayer.start();
            }
        });
    }
}
