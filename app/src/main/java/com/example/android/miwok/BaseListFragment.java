package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MatthewG on 2017/07/04.
 */

public abstract class BaseListFragment extends Fragment {

    private List<Word> words;
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private MediaPlayer.OnCompletionListener onCompletionListener;
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
    protected String[] englishWords;
    protected String[] miwokWords;
    protected int[] imageIds;
    protected int[] audioIds;
    protected int backgroundColor;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        initializeData();

        // Get the AudioManager for managing audio focus
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        // Create the AudioFocusChangeListener to respond to changes in focus
        audioFocusChangeListener = getAudioFocusChangeListener();

        // Create the OnCompletionListener to release media resources after playback completes
        onCompletionListener = getOnCompletionListener();

        // Build the Word list
        buildWordList();

        // Create the WordAdapter from the Word list and appropriate background color
        // Get the ListView and attach the new WordAdapter
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, backgroundColor);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        // Give the ListView an OnItemClickListener to play audio when a list item is clicked
        listView.setOnItemClickListener(getOnItemClickListener());

        return rootView;
    }

    @NonNull
    private MediaPlayer.OnCompletionListener getOnCompletionListener() {
        return new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                releaseMediaPlayer();
            }
        };
    }

    /**
     * This method will be called at the start of the onCreate method. It must provide the data
     * for the protected variables (imageIds is optional).
     */
    protected abstract void initializeData();

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;

            audioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }

    private void buildWordList() {
        words = new ArrayList<>();
        for (int i = 0; i < englishWords.length; i++) {
            if (imageIds != null) {
                words.add(new Word(englishWords[i], miwokWords[i], imageIds[i], audioIds[i]));
            } else {
                words.add(new Word(englishWords[i], miwokWords[i], audioIds[i]));
            }
        }
    }

    private AdapterView.OnItemClickListener getOnItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int audioId = words.get(position).getAudioResource();
                releaseMediaPlayer();

                // Request transient audio focus
                int result = audioManager.requestAudioFocus(audioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                // If we get focus, play the audio
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(getActivity(), audioId);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(onCompletionListener);
                }
            }
        };
    }

    private AudioManager.OnAudioFocusChangeListener getAudioFocusChangeListener() {
        return new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int focusChange) {
                switch (focusChange) {
                    case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                        break;
                    case AudioManager.AUDIOFOCUS_GAIN:
                        mediaPlayer.start();
                        break;
                    case AudioManager.AUDIOFOCUS_LOSS:
                        releaseMediaPlayer();
                }
            }
        };
    }

}
