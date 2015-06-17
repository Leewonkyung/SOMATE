package com.example.s.cookcook;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by moon3075 on 2015-06-16.
 */


//++


import java.util.ArrayList;

import com.example.s.cookcook.etc.BkUtils;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.Toast;

public class StepActivity extends Activity implements OnClickListener {
    private final int MAX = 10;
    private int mPrevPosition;						//이전에 선택되었던 포지션 값

    private Button mAddView;					//뷰 페이저에 아이템 추가하는 버튼
    //private Spinner mViewTypeSpinner;			//뷰 페이저에 추가할 아이템의 타입을 고르는 스피너
    private ViewPager mPager;					//뷰 페이저
    private LinearLayout mPageMark;			//현재 몇 페이지 인지 나타내는 뷰
    private BkPagerAdapter mAdapter;			//아답터 객체. 아이템을 추가 하기 위해 변수 선언

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);

        mAddView = (Button)findViewById(R.id.btn_add);		//추가 버튼
        mAddView.setOnClickListener(this);						//클릭 리스너 등록

       // mViewTypeSpinner = (Spinner)findViewById(R.id.spinner_view_type);	//아이템 타입 선택하는 스피너

        //mPageMark = (LinearLayout)findViewById(R.id.page_mark);			//상단의 현재 페이지 나타내는 뷰

        mPager = (ViewPager)findViewById(R.id.pager);						//뷰 페이저
        mAdapter = new BkPagerAdapter(getApplicationContext());

        mPager.setAdapter(mAdapter);											//PagerAdapter로 설정
        mPager.setOnPageChangeListener(new OnPageChangeListener() {	//아이템이 변경되면, gallery나 listview의 onItemSelectedListener와 비슷
            //아이템이 선택이 되었으면
            @Override public void onPageSelected(int position) {
                //mPageMark.getChildAt(mPrevPosition).setBackgroundResource(R.drawable.page_not);	//이전 페이지에 해당하는 페이지 표시 이미지 변경
                //mPageMark.getChildAt(position).setBackgroundResource(R.drawable.page_select);		//현재 페이지에 해당하는 페이지 표시 이미지 변경
                mPrevPosition = position;				//이전 포지션 값을 현재로 변경
            }
            @Override public void onPageScrolled(int position, float positionOffest, int positionOffsetPixels) {}
            @Override public void onPageScrollStateChanged(int state) {}
        });

        mPrevPosition = 0;	//이전 포지션 값 초기화
        //addPageMark();		//현재 페이지 표시하는 뷰 추가
        //mPageMark.getChildAt(mPrevPosition).setBackgroundResource(R.drawable.page_select);	//이전 페이지에 해당하는 페이지 표시 이미지 변경
    }

    //상단의 현재 페이지 표시하는 뷰 추가.
    //뷰 페이저에 아이템이 추가 될 때마다 한개 씩 추가한다
    private void addPageMark(){
        ImageView iv = new ImageView(getApplicationContext());	//페이지 표시 이미지 뷰 생성
        iv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        //iv.setBackgroundResource(R.drawable.page_not);
        mPageMark.addView(iv);//LinearLayout에 추가
    }

    //Pager 아답터 구현
    private class BkPagerAdapter extends PagerAdapter{
        private Context mContext;
        private ArrayList<Integer> mItems;			//아이템 뷰의 타입. 아이템 갯수 만큼
        public BkPagerAdapter( Context con) {
            super(); mContext = con;
            mItems = new ArrayList<Integer>();		//아답터 생성시 리스트 생성
            mItems.add(BkUtils.TYPE_TEXTVIEW);		//최초 1개의 아이템은 기본으로 생성한다
        }

        //뷰 페이저의 아이템 갯수는 리스트의 갯수
        //나중에 뷰 페이저에 아이템을 추가하면 리스트에 아이템의 타입을 추가 후 새로 고침하게 되면
        //자동으로 뷰 페이저의 갯수도 늘어난다.
        @Override public int getCount() { return mItems == null ? 0:mItems.size(); }

        //뷰페이저에서 사용할 뷰객체 생성/등록
        @Override public Object instantiateItem(View pager, int position)
        {
            View v = BkUtils.getView(mItems.get(position), mContext);	//해당 포지션의 아이템 뷰를 생성한다
            ((ViewPager)pager).addView(v);
            return v;
        }

        //뷰 객체 삭제.
        @Override public void destroyItem(View pager, int position, Object view) {
            ((ViewPager)pager).removeView((View)view);
        }

        // instantiateItem메소드에서 생성한 객체를 이용할 것인지
        @Override public boolean isViewFromObject(View view, Object obj) { return view == obj; }

        @Override public void finishUpdate(View arg0) {}
        @Override public void restoreState(Parcelable arg0, ClassLoader arg1) {}
        @Override public Parcelable saveState() { return null; }
        @Override public void startUpdate(View arg0) {}

        /**
         * 동적으로 아이템을 추가하는 메소드
         * @param type - 아이템 타입
         */
        public void addItem(int type){
            mItems.add(type);				//아이템 목록에 추가
            mAdapter.notifyDataSetChanged();		//아답터에 데이터 변경되었다고 알림. 알아서 새로고침
        }
    }

    @Override
    public void onClick(View v) {
        //뷰 페이저에 아이템 추가
        if(v == mAddView) {
            if(mAdapter.getCount() <= MAX) {			//최대 갯수 이하이면
                //int type = mViewTypeSpinner.getSelectedItemPosition();	//아이템 타입을 가져와

                mAdapter.addItem(0);					//해당 타입의 아이템을 추가한다. 뷰 페이져 새로고침
                //addPageMark();								//페이지 표시 뷰도 추가
            }
            else
                Toast.makeText(getApplicationContext(), "최대 10개의 아이템만 등록 가능합니다. 소스를 수정하세요.", Toast.LENGTH_SHORT).show();
        }
    }
}

//++




/*
public class StepActivity extends ActionBarActivity {
    int MAX_PAGE = 3;
    Fragment cur_fragment = new Fragment();

    //++
    private final int COUNT = 10;
    private int[] mColorArray = {Color.YELLOW, Color.BLUE, Color.CYAN, Color.DKGRAY, Color.GRAY,
            Color.GREEN, Color.LTGRAY, Color.MAGENTA, Color.RED, Color.WHITE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        ViewPager viewPager = (ViewPager) findViewById((R.id.viewpager));
        viewPager.setAdapter(new adapter(getSupportFragmentManager()));
    }

    private class adapter extends FragmentPagerAdapter {
        public adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position < 0 || MAX_PAGE <= position)
                return null;
            switch (position) {
                case 0:
                    cur_fragment = new page_1();
                    break;
                case 1:
                    //cur_fragment = new page_2();
                    break;
                case 2:
                    //cur_fragment = new page_3();
                    break;
            }
            return cur_fragment;
        }

        @Override
        public int getCount() {
            return MAX_PAGE;
        }

        public class page_1 extends android.support.v4.app.Fragment {
            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
            }

            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.activity_step, container, false);
               /* LinearLayout background=(LinearLayout)linearLayout.findViewById(R.id.background);
                TextView page_num=(TextView)linearLayout.findViewById(R.id.page_num);
                page_num.setText(String.valueOf(1));
                background.setBackground(new ColorDrawable(0xff6dc6d2));*/
/*
                return linearLayout;
            }
        }
    }

    //++

    //Pager 아답터 구현
    private class BkPagerAdapter extends PagerAdapter {
        private Context mContext;

        public BkPagerAdapter(Context con) {
            super();
            mContext = con;
        }

        @Override
        public int getCount() {
            return COUNT;
        }    //여기서는 2개만 할 것이다.

        //뷰페이저에서 사용할 뷰객체 생성/등록
        @Override
        public Object instantiateItem(View pager, int position) {
            TextView tv = new TextView(mContext);                    //텍스트뷰
            tv.setBackgroundColor(mColorArray[position]);            //배경색 지정
            tv.setText("ViewPager Item" + (position + 1));                //글자지정
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);        //글자 크기 24sp
            tv.setTextColor(mColorArray[mColorArray.length - (position + 1)]);    //글자 색상은 배경과 다른 색으로
            ((ViewPager) pager).addView(tv, 0);        //뷰 페이저에 추가

            return tv;
        }

        //뷰 객체 삭제.
        @Override
        public void destroyItem(View pager, int position, Object view) {
            ((ViewPager) pager).removeView((View) view);
        }
        //++

    }
}

        public class page_2 extends android.support.v4.app.Fragment {
            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
            }
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.activity_viewpager,container,false);
                LinearLayout background=(LinearLayout)linearLayout.findViewById(R.id.background);
                TextView page_num=(TextView)linearLayout.findViewById(R.id.page_num);
                page_num.setText(String.valueOf(2));
                background.setBackground(new ColorDrawable(0xff26abb5));
                return linearLayout;
            }
        }

        public class page_3 extends android.support.v4.app.Fragment {
            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
            }
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.activity_viewpager,container,false);
                LinearLayout background=(LinearLayout)linearLayout.findViewById(R.id.background);
                TextView page_num=(TextView)linearLayout.findViewById(R.id.page_num);
                page_num.setText(String.valueOf(3));
                background.setBackground(new ColorDrawable(0xff008c9e));
                return linearLayout;
            }
        }*/

/*
public class StepActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);
    }

}
*/