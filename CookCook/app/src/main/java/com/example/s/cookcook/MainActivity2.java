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
public class MainActivity2 extends Activity{
    ImageButton mainButton1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mainButton1 = (ImageButton) findViewById(R.id.mainButton1);
        mainButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, ReadActivity.class);
                startActivity(intent);
            }
        });
    }

}
