package com.example.s.cookcook;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Wonkyung on 2015-06-01.
 */
public class UserActivity extends Activity{

    //private static final int PICK_FROM_CAMERA = 1;

    private static final int PICK_FROM_GALLERY = 2;
    private ImageView imgview;
    final int id=0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        Button folder_add_button=(Button)findViewById(R.id.folder_add_button);
        Button user_setting=(Button)findViewById(R.id.user_setting);
        imgview = (ImageView) findViewById(R.id.user_image);

        folder_add_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                AlertDialog.Builder alert = new AlertDialog.Builder(UserActivity.this);
                alert.setTitle("폴더추가");
                alert.setMessage("추가할 폴더의 이름을 입력하세요");
                final EditText input = new EditText(UserActivity.this);
                alert.setView(input);
                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String value = input.getText().toString();
                        value.toString();
                        // Do something with value!
                        LinearLayout addlayout = (LinearLayout)findViewById(R.id.addlayout1);
                        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        inflater.inflate(R.layout.activity_addfolder, addlayout,true);

                        Button folder = (Button)findViewById(R.id.folder_button);
                        folder.setId(id);
                        folder.setText(value);
                    }
                });

                alert.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // Canceled.
                            }
                        });

                alert.show();
            }
        });

        //setting click -> image select
        user_setting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.putExtra("crop", "true");
                intent.putExtra("aspectX", 0);
                intent.putExtra("aspectY", 0);
                intent.putExtra("outputX", 200);
                intent.putExtra("outputY", 150);
                try {
                    intent.putExtra("return-data", true);
                    startActivityForResult(Intent.createChooser(intent,
                            "Complete action using"), PICK_FROM_GALLERY);
                } catch (ActivityNotFoundException e) {
                    // Do nothing for now
                }
            }
        });
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        if (requestCode == PICK_FROM_GALLERY) {
            Bundle extras2 = data.getExtras();
            if (extras2 != null) {
                Bitmap photo = extras2.getParcelable("data");
                imgview.setImageBitmap(photo);
            }
        }
    }
}