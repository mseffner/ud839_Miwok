package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FamilyActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        String[] englishWordsArray = {
                "father", "mother", "son", "daughter", "older brother", "younger brother",
                "older sister", "younger sister", "grandmother", "grandfather"
        };
        String[] miwokWordsArray = {
                "әpә", "әṭa", "angsi", "tune", "taachi", "chalitti", "teṭe", "kolliti", "ama",
                "paapa"
        };
        int[] imageIdArray = {
                R.drawable.family_father,R.drawable.family_mother,R.drawable.family_son,
                R.drawable.family_daughter,R.drawable.family_older_brother,
                R.drawable.family_younger_brother,R.drawable.family_older_sister,
                R.drawable.family_younger_sister,R.drawable.family_grandmother,
                R.drawable.family_grandfather
        };
        int[] audioIdArray = {
                R.raw.family_father,R.raw.family_mother,R.raw.family_son,
                R.raw.family_daughter,R.raw.family_older_brother,
                R.raw.family_younger_brother,R.raw.family_older_sister,
                R.raw.family_younger_sister,R.raw.family_grandmother,
                R.raw.family_grandfather
        };

        final List<Word> words = new ArrayList<>();
        for (int i = 0; i < englishWordsArray.length; i++) {
            words.add(new Word(englishWordsArray[i], miwokWordsArray[i], imageIdArray[i], audioIdArray[i]));
        }

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int audioId = words.get(position).getAudioResource();
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, audioId);
                mediaPlayer.start();
            }
        });

    }
}
