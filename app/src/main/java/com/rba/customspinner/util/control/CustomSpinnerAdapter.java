package com.rba.customspinner.util.control;

import android.content.Context;

import java.util.List;

/**
 * Created by Ricardo Bravo on 9/06/16.
 */

public class CustomSpinnerAdapter<T> extends CustomSpinnerBaseAdapter {

    private final List<T> mItems;

    public CustomSpinnerAdapter(Context context, List<T> items, int textColor, int backgroundSelector) {
        super(context, textColor, backgroundSelector);
        mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.size() - 1;
    }

    @Override
    public T getItem(int position) {

        if(position == mItems.size()){
            return mItems.get(position);
        }else{
            if (position >= mSelectedIndex) {
                return mItems.get(position + 1);
            } else {
                return mItems.get(position);
            }
        }

    }

    @Override
    public T getItemInDataset(int position) {
        return mItems.get(position);
    }
}
