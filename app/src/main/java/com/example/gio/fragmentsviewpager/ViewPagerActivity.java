package com.example.gio.fragmentsviewpager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TextView tab1, tab2, tab3;
    private View active_slide;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.activity_open_translate, R.anim.activity_close_scale);
        setContentView(R.layout.activity_view_pager);
        viewPager=(ViewPager)findViewById(R.id.viewpager1);
        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tab1=(TextView) findViewById(R.id.tab1);
        tab2=(TextView)findViewById(R.id.tab2);
        tab3=(TextView)findViewById(R.id.tab3);
        active_slide=findViewById(R.id.active_slide);
        tab1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ViewGroup.LayoutParams params=active_slide.getLayoutParams();
                params.width=tab1.getWidth();
                params.height=tab1.getHeight();
                active_slide.setLayoutParams(params);
                tab1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            active_slide.animate().x(active_slide.getWidth()*position);
            }

            @Override
            public void onPageSelected(int position) {
//                active_slide.animate().x(active_slide.getWidth()*position);
            }
//d
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.activity_open_scale,R.anim.activity_close_translate);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new RandomColorFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
