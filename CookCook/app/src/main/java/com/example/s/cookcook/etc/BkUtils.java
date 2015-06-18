package com.example.s.cookcook.etc;

import com.example.s.cookcook.R;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class BkUtils {
    /** 뷰페이저 아이템 종류 */
    public static final int TYPE_TEXTVIEW = 0, TYPE_SCROLLVIEW=1, TYPE_LISTVIEW=2;

    /**
     * 뷰 페이저에 추가할 뷰를 생성하여 반환한다
     * @param type - 추가할 뷰 타입
     * @param con - 뷰 생성에 사용할 Context
     * @return 뷰 객체
     */
    public static View getView(int type, Context con) {

        return getScrollView(con);
    }

    /**
     * 텍스트 뷰를 생성하여 반환한다
     * @param con - 뷰 생성에 사용할 Context
     * @return 텍스트 뷰
     */

    private static EditText getTextView(Context con) {
        int color = (int)(Math.random()*256);

        TextView tv = new TextView(con);
        tv.setBackgroundColor(Color.rgb(color, color, color));	//배경색 지정
        tv.setText("TextView Item");									//글자지정
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);		//글자 크기 24sp

        EditText b=new EditText(con);
        b.setHint("재료를 손질할꺼에요!\n" +
                "양파와 대파는 흐르는 물에 씻어주시고, " +
                "양파는 길게 썰어주시고, " +
                "대파는 1cm길이로 어슷썰기 해주세요. " +
                "그리고 김치는 5cm로 썰어주세요.");
        b.setHintTextColor(Color.rgb(100, 100, 100));
        b.setTextColor(Color.rgb(0, 0, 0));
        //edittext에 자동으로 focus되는 것을 막기 위해 해당 xml에서 linear layout (아마 아무거나 상관없을듯?)
        //에 포커스를 주었다.
        return b;
    }



    /**
     * 여러개의 뷰가 있는 스크롤 뷰를 반환한다
     * @param con - 뷰 생성에 사용할 Context
     * @return 스크롤 뷰
     */


    private static ScrollView getScrollView(Context con) {
        ScrollView sv = new ScrollView(con);

        LinearLayout ll = new LinearLayout(con);
        ll.setOrientation(LinearLayout.VERTICAL);

        ll.addView(getImageView(con));
        ll.addView(getTextView(con));
        sv.addView(ll);
        return sv;
    }

    private static ImageView getImageView(Context con) {
        ImageView iv = new ImageView(con);
        iv.setImageResource(R.drawable.image);
        iv.setPadding(0,100,0,100);
        return iv;
    }

}
