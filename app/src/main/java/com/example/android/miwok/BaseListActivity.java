package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MatthewG on 2017/07/04.
 */

public abstract class BaseListActivity extends AppCompatActivity {
    
    protected MediaPlayer mediaPlayer;
    protected String[] englishWords;
    protected String[] miwokWords;
    protected int[] imageIds;
    protected int[] audioIds;
    protected int backgroundColor;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        initializeData();

        final List<Word> words = new ArrayList<>();
        for (int i = 0; i < englishWords.length; i++) {
            if (imageIds != null) {
                words.add(new Word(englishWords[i], miwokWords[i], imageIds[i], audioIds[i]));
            } else {
                words.add(new Word(englishWords[i], miwokWords[i], audioIds[i]));
            }
        }
        
        WordAdapter itemsAdapter = new WordAdapter(this, words, backgroundColor);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int audioId = words.get(position).getAudioResource();
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(getBaseContext(), audioId);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
    }

    protected abstract void initializeData();

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
