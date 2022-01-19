package com.kuda.fragment;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.kuda.DetailsProjectCommentFragment;
import com.kuda.DetailsProjectDescriptionFragment;
import com.kuda.DetailsProjectProgressFragment;
import com.kuda.R;

public class DetailsProjectSectionAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_4, R.string.tab_text_5,R.string.tab_text_6};
    private final Context mContext;

    public DetailsProjectSectionAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new DetailsProjectDescriptionFragment();
            case 1:
                return new DetailsProjectProgressFragment();
            case 2:
                return new DetailsProjectCommentFragment();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
