package com.example.s.cookcook;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by moon3075 on 2015-06-01.
 */
public class MainActivity extends TabActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;

        intent = new Intent().setClass(this, WriteActivity.class);
        spec = tabHost.newTabSpec("main").setIndicator("MAIN",
                res.getDrawable(R.drawable.cash)).setContent(intent);
        tabHost.addTab(spec);


        intent = new Intent().setClass(this, CategoriActivity.class);
        spec = tabHost.newTabSpec("categori").setIndicator("CATE",
                res.getDrawable(R.drawable.cash)).setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, WriteActivity.class);
        spec = tabHost.newTabSpec("reci").setIndicator("RECI",
                res.getDrawable(R.drawable.cash)).setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, UserActivity.class);
        spec = tabHost.newTabSpec("user").setIndicator("USER",
                res.getDrawable(R.drawable.cash)).setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
    }
}