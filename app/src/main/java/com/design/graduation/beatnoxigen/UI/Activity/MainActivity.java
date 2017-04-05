package com.design.graduation.beatnoxigen.UI.Activity;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.design.graduation.beatnoxigen.R;
import com.design.graduation.beatnoxigen.UI.Fragment.Monitor.HeartbeatFragment;
import com.design.graduation.beatnoxigen.UI.Fragment.Monitor.OxigenFragment;
import com.design.graduation.beatnoxigen.UI.Fragment.PersonalFragment;
import com.design.graduation.beatnoxigen.UI.Framework.ClickTabsLayout.ClickTabsFramework;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ClickTabsFramework mClickTabsFramework;
    private ContentPage[] mContentPages;

    private void prepareContentPages() {
        Resources res = getResources();
        mContentPages = new ContentPage[]{
                new ContentPage(
                        HeartbeatFragment.newInstance(),
                        res.getString(R.string.title_heartbeat),
                        R.drawable.ic_heartbeat_default,
                        R.drawable.ic_heartbeat_selected,
                        res.getColor(R.color.colorHeartbeat)
                ),
                new ContentPage(
                        OxigenFragment.newInstance(),
                        res.getString(R.string.title_oxigen),
                        R.drawable.ic_oxigen_default,
                        R.drawable.ic_oxigen_selected,
                        res.getColor(R.color.colorOxigen)
                ),
                new ContentPage(
                        PersonalFragment.newInstance(),
                        res.getString(R.string.title_personal),
                        R.drawable.ic_personal_default,
                        R.drawable.ic_personal_selected,
                        res.getColor(R.color.colorPersonal))
        };
    }

    private List<Fragment> getContentFragments() {
        List<Fragment> fragments = new ArrayList<>();
        for (ContentPage contentPage : mContentPages) {
            fragments.add(contentPage.mFragment);
        }
        return fragments;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareContentPages();
        mClickTabsFramework = new ClickTabsFramework();
        mClickTabsFramework.setContentItems(getContentFragments());
        mClickTabsFramework.setDistributeEvenly(true);
        mClickTabsFramework.setCustomTabDraw(new TabsDraw());
        mClickTabsFramework.setTabLayout(R.layout.click_tabs_item);
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.TabsLayoutHost, mClickTabsFramework);
        trans.commit();
    }

    private static class ContentPage {
        public Fragment mFragment;
        public String mTitle;
        public int mIcon;
        public int mIcon2;
        public int mColor;

        public ContentPage(Fragment fragment, String title, int icon, int icon2, int color) {
            mFragment = fragment;
            mTitle = title;
            mIcon = icon;
            mIcon2 = icon2;
            mColor = color;
        }
    }

    private class TabsDraw implements ClickTabsFramework.TabDraw {
        @Override
        public void initDraw(View v, int pos) {
            ((TextView) v.findViewById(R.id.tabTitle)).setText(mContentPages[pos].mTitle);
            ImageView icon = (ImageView) v.findViewById(R.id.tabIcon);
            icon.setImageResource(mContentPages[pos].mIcon);

        }

        @Override
        public void onClickedDraw(View last, int lastpos, View now, int pos) {
            if (last != null && lastpos != -1) {
                last.setBackgroundColor(getResources().getColor(R.color.colorTabBackground));
                ((ImageView) last.findViewById(R.id.tabIcon)).setImageResource(mContentPages[lastpos].mIcon);
            }
            now.setBackgroundColor(mContentPages[pos].mColor);
            ((ImageView) now.findViewById(R.id.tabIcon)).setImageResource(mContentPages[pos].mIcon2);
        }
    }
}
