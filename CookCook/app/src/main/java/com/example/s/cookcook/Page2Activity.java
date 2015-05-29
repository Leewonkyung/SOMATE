package com.example.s.cookcook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Wonkyung on 2015-05-29.
 */
public class Page2Activity extends Fragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        RelativeLayout layout=(RelativeLayout)inflater.inflate(R.layout.activity_page2,container,false);

        Button testBtn = (Button)layout.findViewById(R.id.page1btn);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"두번째 페이지입니다.",Toast.LENGTH_SHORT).show();
            }
        });
        return layout;
    }
}
