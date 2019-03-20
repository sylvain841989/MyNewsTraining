package conraud.sylvain.mynewstraining.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import conraud.sylvain.mynewstraining.data.Article;
import conraud.sylvain.mynewstraining.ui.fragment.MainFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public MainFragment[] arrayFragment = new MainFragment[3];

    public ViewPagerAdapter(FragmentManager fm ) {
        super(fm);

        for (int i = 0 ; i<arrayFragment.length ; i++)
        {
            arrayFragment[i] = MainFragment.newInstance();
        }
    }

    @Override
    public Fragment getItem(int i) {
        //arrayFragment[i] = MainFragment.newInstance();
        return arrayFragment[i];
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "TOP STORIES";
            case 1:
                return "MOST POPULAR";
            case 2:
                return "SCIENCE";
            default:return null;
        }
    }
}
