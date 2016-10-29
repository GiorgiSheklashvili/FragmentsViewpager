package com.example.gio.fragmentsviewpager;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gio on 29.10.2016.
 */

public class StudentDetailedInfo implements Parcelable{
    private String descripeStudent;

    protected StudentDetailedInfo(Parcel in) {
        descripeStudent = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(descripeStudent);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StudentDetailedInfo> CREATOR = new Creator<StudentDetailedInfo>() {
        @Override
        public StudentDetailedInfo createFromParcel(Parcel in) {
            return new StudentDetailedInfo(in);
        }

        @Override
        public StudentDetailedInfo[] newArray(int size) {
            return new StudentDetailedInfo[size];
        }
    };
}
