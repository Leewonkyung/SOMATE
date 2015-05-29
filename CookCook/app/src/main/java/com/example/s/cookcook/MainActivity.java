package com.example.s.cookcook;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity {

    private int NUM_PAGES = 3; //�ִ� �������� ��
    /*Fragment numbering*/
    public final static int FRAGMENT_PAGE1 = 0;
    public final static int FRAGMENT_PAGE2 = 1;
    public final static int FRAGMENT_PAGE3 = 2;

    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //viewpager�� �˻��ϰ� Adapter�� �޾��ְ�, ù �������� �������ش�
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mViewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        mViewPager.setCurrentItem(FRAGMENT_PAGE1);
    }

    //FragmentPageAdpter : Fragment�ν� ������ �������� ��� �������� �����Ѵ�
    private  class pagerAdapter extends FragmentPagerAdapter {
        public pagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position){
            switch (position){
                case FRAGMENT_PAGE1:
                    return new Page1Activity();
                case FRAGMENT_PAGE2:
                    return new Page2Activity();
                case FRAGMENT_PAGE3:
                    return new Page3Activity();
                default:
                    return null;
            }
        }

        //�ļ� ������ ������ ������ ��ȯ���ش�.
        public int getCount() {
            return NUM_PAGES;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
