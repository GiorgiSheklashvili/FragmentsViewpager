package com.example.gio.fragmentsviewpager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FragmentReplaceActivity extends AppCompatActivity {
    FragmentManager fm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.activity_open_translate, R.anim.activity_close_scale);
        setContentView(R.layout.activity_fragment_replace);
        fm = getSupportFragmentManager();
        addFragment(new RandomColorFragment(), false, false);
    }

    private void addFragment(Fragment fragment, boolean addToStack, boolean animate) {
        FragmentTransaction ft = fm.beginTransaction();
        if (animate)
            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        ft.replace(R.id.fragment_container, fragment);
        if (addToStack)
            ft.addToBackStack("");
        ft.commit();
    }
        int count=0;
    public void addNewFragment(View view) {
        RandomColorFragment randomColorFragment=new RandomColorFragment();
        Bundle bundle=new Bundle();
        Student student=new Student();
        student.setAge(22);
        student.setHighSchool(true);
        student.setName("gela");
        student.setPoint(2.5);
        student.setSchool("57");
        student.setSurname("mgeladze");
        bundle.putInt("count",++count);
        bundle.putParcelable("student",student);
        randomColorFragment.setArguments(bundle);
        addFragment(randomColorFragment,true,true);
    }
}
