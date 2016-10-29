package com.example.gio.fragmentsviewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startViewpagerActivity(View view) {
        startActivity(new Intent(this,ViewPagerActivity.class));
    }

    public void startFragmentsReplaceActivity(View view) {
        startActivity(new Intent(this,FragmentReplaceActivity.class));
    }

    public void startScrollviewActivity(View view) {
        startActivity(new Intent(this,ScrollviewActivity.class));
    }
}
