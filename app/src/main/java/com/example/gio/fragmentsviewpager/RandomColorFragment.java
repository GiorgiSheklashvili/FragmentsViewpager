package com.example.gio.fragmentsviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.zip.Inflater;


public class RandomColorFragment extends Fragment {
    TextView studentInfoTextView;
    int[] colorids = {R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5,
            R.color.color6, R.color.color7, R.color.color8, R.color.color8, R.color.color9,
            R.color.color10, R.color.color11, R.color.color12, R.color.color13, R.color.color14,
            R.color.color15, R.color.color16, R.color.color17, R.color.color18, R.color.color19,
            R.color.color20, R.color.color21, R.color.color22, R.color.color23, R.color.color24,
            R.color.color25, R.color.color26, R.color.color27, R.color.color28, R.color.color29,
            R.color.color30, R.color.color31, R.color.color33};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rancom_color_fragment, container, false);
        int color = ContextCompat.getColor(getContext(), colorids[new Random().nextInt(33)]);
        view.findViewById(R.id.background_color).setBackgroundColor(color);
        studentInfoTextView = (TextView) view.findViewById(R.id.student);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            int count=getArguments().getInt("count");
            Toast.makeText(getContext(),"I'm the number = "+count,Toast.LENGTH_SHORT).show();
            Student student=getArguments().getParcelable("student");
            String studInfo = student.getAge() + "\n" + student.getPoint() + "\n" + student.getName();
            studentInfoTextView.setText(studInfo);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
