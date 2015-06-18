package com.example.s.cookcook;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TabHost;

import com.parse.Parse;
import com.parse.ParseObject;


/**
 * Created by moon3075 on 2015-06-17
 */
public class MainActivity extends TabActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Enable Local Datastore.
        //Parse.enableLocalDatastore(this);
        //위에껀 안써도 되나 봅니다....ㄷㄷㄷ
        Parse.initialize(this, "Ef36aNYkL3qk9kqGAaYYgLmCuMrxPrhKpg2NgHHI", "jJv5HSwfDBi5LF0ckX9squCnqg1yFlIGHCL62P5M");

/*
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
*/
        startActivity(new Intent(this, LoadingActivity.class));

        String[] optionLavala = getResources().getStringArray(R.array.dataArray1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,optionLavala);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.edit);
        textView.setAdapter(adapter);

        Resources res = getResources();
        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;

        intent = new Intent().setClass(this, MainActivity2.class);
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