package com.example.s.cookcook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.s.cookcook.etc.Cate_MainDish;

/**
 * Created by Wonkyung on 2015-06-01.
 */
public class CategoriActivity extends Activity{
    ImageButton imageButton1;
    ImageButton imageButton4;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.s.cookcook.R.layout.activity_categori);

        imageButton1 = (ImageButton) findViewById(com.example.s.cookcook.R.id.imageButton1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriActivity.this, RiceActivity.class);
                startActivity(intent);
            }
        });
        imageButton4 = (ImageButton) findViewById(com.example.s.cookcook.R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriActivity.this, Cate_MainDish.class);
                startActivity(intent);
            }
        });
    }

}