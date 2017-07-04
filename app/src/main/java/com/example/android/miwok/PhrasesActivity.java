package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        String[] englishWordsArray = {
                "Where are you going?", "What is your name?", "My name is...",
                "How are you feeling?", "Im feeling good.", "Are you coming?",
                "Yes, Im coming.", "Im coming.", "Lets go.", "Come here."
        };
        String[] miwokWordsArray = {
                "minto wuksus", "tinnә oyaase'nә", "oyaaset...", "michәksәs?", "kuchi achit",
                "әәnәs'aa?", "hәә’ әәnәm", "әәnәm", "yoowutis", "әnni'nem"
        };
        int[] audioIdArray = {
                R.raw.phrase_where_are_you_going,R.raw.phrase_what_is_your_name,R.raw.phrase_my_name_is,
                R.raw.phrase_how_are_you_feeling,R.raw.phrase_im_feeling_good,
                R.raw.phrase_are_you_coming,R.raw.phrase_yes_im_coming,
                R.raw.phrase_im_coming, R.raw.phrase_lets_go,R.raw.phrase_come_here,
        };

        final List<Word> words = new ArrayList<>();
        for (int i = 0; i < englishWordsArray.length; i++) {
            words.add(new Word(englishWordsArray[i], miwokWordsArray[i], audioIdArray[i]));
        }

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int audioId = words.get(position).getAudioResource();
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, audioId);
                mediaPlayer.start();
            }
        });
    }
}
