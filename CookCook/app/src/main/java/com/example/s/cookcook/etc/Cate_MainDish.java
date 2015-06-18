package com.example.s.cookcook.etc;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.s.cookcook.R;
import com.parse.GetCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;

/**
 * Created by moon3075 on 2015-06-19.
 */
public class Cate_MainDish extends ActionBarActivity {
    ListView listView;
    myAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(com.example.s.cookcook.R.layout.activity_maindish);

        listView= (ListView) findViewById(com.example.s.cookcook.R.id.listview);
        adapter= new myAdapter();
        listView.setAdapter(adapter);
/*
        ParseQuery<ParseObject> gameScore = ParseQuery.getQuery("GameScore");
        gameScore.getInBackground("xWMyZ4YEGZ", new GetCallback<ParseObject>() {
            public void done(ParseObject gamescore, ParseException e) {
                if (e == null) {
                    // object will be your game score
                } else {
                    // something went wrong
                }
            }
        });

        int score = gameScore.getInt("score");
        String playerName = gameScore.getString("playerName");*/
    }

    class myAdapter extends BaseAdapter{

        String[] items= {"item1", "item2", "item3", "item4"};

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return items[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView view=new TextView(getApplicationContext());
            view.setText(items[position]);
            view.setTextSize(40.0f);

            return view;
        }
    }
}
