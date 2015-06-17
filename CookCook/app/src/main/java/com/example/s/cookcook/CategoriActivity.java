package com.example.s.cookcook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Wonkyung on 2015-06-01.
 */
public class CategoriActivity extends Activity{
    ImageButton imageButton1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categori);

        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriActivity.this, RiceActivity.class);
                startActivity(intent);
            }
        });
    }

}