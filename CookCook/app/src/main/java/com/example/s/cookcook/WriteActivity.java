package com.example.s.cookcook;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseObject;

/**
 * Created by moon3075 on 2015-06-02.
 */
public class WriteActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.s.cookcook.R.layout.activity_write);

        Button btn_start=(Button)findViewById(com.example.s.cookcook.R.id.btn_start);
        final Button btn_cate1=(Button)findViewById(com.example.s.cookcook.R.id.btn_cate1);
        final Button btn_cate2=(Button)findViewById(com.example.s.cookcook.R.id.btn_cate2);
        final Button btn_cate3=(Button)findViewById(com.example.s.cookcook.R.id.btn_cate3);
        final Button btn_cate4=(Button)findViewById(com.example.s.cookcook.R.id.btn_cate4);
        final Button btn_cate5=(Button)findViewById(com.example.s.cookcook.R.id.btn_cate5);
        final Button btn_cate6=(Button)findViewById(com.example.s.cookcook.R.id.btn_cate6);

        final int REQUEST_CODE_NEXT=3000;
        final EditText edt_dishname=(EditText)findViewById(com.example.s.cookcook.R.id.edt_dishname);
        final EditText edt_dishstuff=(EditText)findViewById(com.example.s.cookcook.R.id.edt_dishstuff);
        final EditText edt_dishperson=(EditText)findViewById(com.example.s.cookcook.R.id.edt_dishperson);



        View.OnClickListener listener= new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case com.example.s.cookcook.R.id.btn_start:

                        ParseObject dish = new ParseObject("Dish");
                        dish.put("dishName", edt_dishname.getText().toString());
                        dish.put("dishStuff", edt_dishstuff.getText().toString());
                        dish.put("dishPerson", edt_dishperson.getText().toString());
                        dish.put("dishCate", 4);
                        dish.saveInBackground();

                        Intent intent = new Intent(getBaseContext(), StepActivity.class);
                        startActivityForResult(intent, REQUEST_CODE_NEXT);
                        break;
                    case com.example.s.cookcook.R.id.btn_cate4:
                        btn_cate4.setFocusable(false);
                        btn_cate2.setFocusable(true);btn_cate3.setFocusable(true);
                        btn_cate4.setFocusable(true);btn_cate5.setFocusable(true);btn_cate6.setFocusable(true);
                        btn_cate4.setBackgroundColor(Color.rgb(100,100,100));
                        //btn_cate2.setBackgroundColor(Color.rgb(200,200,200));
                        //btn_cate3.setBackgroundColor(Color.rgb(200,200,200));
                        //btn_cate4.setBackgroundColor(Color.rgb(200,200,200));
                        //btn_cate5.setBackgroundColor(Color.rgb(200,200,200));
                        //btn_cate6.setBackgroundColor(Color.rgb(200,200,200));
                        break;

                }
            }
        };

        btn_start.setOnClickListener(listener);


    }
}
