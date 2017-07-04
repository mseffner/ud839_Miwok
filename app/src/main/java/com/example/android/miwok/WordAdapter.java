package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MatthewG on 2017/07/02.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;
    private MediaPlayer mediaPlayer;

    public WordAdapter(@NonNull Context context, @NonNull List<Word> objects, int colorResourceId) {
        super(context, 0, objects);
        this.mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }


        final Word currentWord = getItem(position);

        listItemView.setTag(currentWord.getAudioResource());

        LinearLayout wordListLayout = (LinearLayout) listItemView.findViewById(R.id.word_list_layout);
        wordListLayout.setBackgroundResource(mColorResourceId);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        miwokTextView.setText(currentWord.getMiwokTranslation());
        defaultTextView.setText(currentWord.getDefaultTranslation());

        if (currentWord.getImageResourceId() == -1)
            imageView.setVisibility(View.GONE);
        else
            imageView.setImageResource(currentWord.getImageResourceId());

        return listItemView;

    }
}
