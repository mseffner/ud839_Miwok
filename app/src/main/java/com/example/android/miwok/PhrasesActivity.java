package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        String[] englishWordsArray = {
                "Where are you going?", "What is your name?", "My name is...",
                "How are you feeling?", "I’m feeling good.", "Are you coming?",
                "Yes, I’m coming.", "I’m coming.", "Let’s go.", "Come here."
        };
        String[] miwokWordsArray = {
                "minto wuksus", "tinnә oyaase'nә", "oyaaset...", "michәksәs?", "kuchi achit",
                "әәnәs'aa?", "hәә’ әәnәm", "әәnәm", "yoowutis", "әnni'nem"
        };

        List<Word> words = new ArrayList<>();
        for (int i = 0; i < englishWordsArray.length; i++) {
            words.add(new Word(englishWordsArray[i], miwokWordsArray[i]));
        }

        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
