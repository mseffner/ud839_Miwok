package com.example.android.miwok;


public class NumbersActivity extends BaseListActivity {

    @Override
    protected void initializeData() {
        englishWords = new String[]{
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"
        };
        miwokWords = new String[]{
                "lutti", "otoiiko", "tolookosu", "oyyisa", "massokka", "temmokka", "kenekaku",
                "kawinta", "wo'e", "na'aacha"
        };
        imageIds = new int[]{
                R.drawable.number_one, R.drawable.number_two, R.drawable.number_three,
                R.drawable.number_four, R.drawable.number_five, R.drawable.number_six,
                R.drawable.number_seven, R.drawable.number_eight, R.drawable.number_nine,
                R.drawable.number_ten,
        };
        audioIds = new int[]{
                R.raw.number_one, R.raw.number_two, R.raw.number_three,
                R.raw.number_four, R.raw.number_five, R.raw.number_six,
                R.raw.number_seven, R.raw.number_eight, R.raw.number_nine,
                R.raw.number_ten,
        };

        backgroundColor = R.color.category_numbers;
    }
}
