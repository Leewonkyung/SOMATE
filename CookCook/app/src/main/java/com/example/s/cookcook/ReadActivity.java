package com.example.s.cookcook;

import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReadActivity extends ActionBarActivity {
    int MAX_PAGE=3;
    Fragment cur_fragment=new Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        ViewPager viewPager=(ViewPager)findViewById((R.id.viewpager));
        viewPager.setAdapter(new adapter(getSupportFragmentManager()));
    }
    private  class adapter extends FragmentPagerAdapter{
        public adapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position<0 || MAX_PAGE<=position)
                return null;
            switch(position) {
                case 0:
                    cur_fragment = new page_1(R.drawable.view1);
                    break;
                case 1:
                    cur_fragment = new page_2();
                    break;
                case 2:
                    cur_fragment = new page_3();
                    break;
            }
            return cur_fragment;
        }

        @Override
        public int getCount() {
            return MAX_PAGE;
        }
        public class page_1 extends android.support.v4.app.Fragment {
            int id;

            public page_1(int id){
                this.id=id;
            }
            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
            }
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.activity_viewpager, container, false);
                LinearLayout background=(LinearLayout)linearLayout.findViewById(R.id.background);
                TextView page_num=(TextView)linearLayout.findViewById(R.id.page_num);
                page_num.setText(String.valueOf(1));
                background.setBackground(new ColorDrawable(0xff6dc6d2));
                return linearLayout;
            }
        }

        public class page_2 extends android.support.v4.app.Fragment {
            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
            }
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.activity_imageview2, container, false);
                LinearLayout background=(LinearLayout)linearLayout.findViewById(R.id.background);
                TextView page_num=(TextView)linearLayout.findViewById(R.id.page_num);
                page_num.setText(String.valueOf(2));
                background.setBackground(new ColorDrawable(0xff26abb5));
                return linearLayout;
            }
        }

        public class page_3 extends android.support.v4.app.Fragment {
            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
            }
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.activity_imageview3, container, false);
                LinearLayout background=(LinearLayout)linearLayout.findViewById(R.id.background);
                TextView page_num=(TextView)linearLayout.findViewById(R.id.page_num);
                page_num.setText(String.valueOf(3));
                background.setBackground(new ColorDrawable(0xff008c9e));
                return linearLayout;
            }
        }
    }

}