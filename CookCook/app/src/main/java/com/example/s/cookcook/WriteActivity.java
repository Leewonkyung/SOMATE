package com.example.s.cookcook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

/**
 * Created by moon3075 on 2015-06-02.
 */
public class WriteActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        Button btn_start=(Button)findViewById(R.id.btn_start);
        final int REQUEST_CODE_NEXT=3000;


        View.OnClickListener listener= new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.btn_start:
                        Intent intent = new Intent(getBaseContext(), StepActivity.class);
                        startActivityForResult(intent, REQUEST_CODE_NEXT);
                        break;
                }
            }
        };

        btn_start.setOnClickListener(listener);


    }
}
