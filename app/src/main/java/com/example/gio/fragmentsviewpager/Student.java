package com.example.gio.fragmentsviewpager;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gio on 29.10.2016.
 */

public class Student implements Parcelable {
    private int age;
    private double point;
    private String name, surname;
    private String school;
    private boolean highSchool;
    private StudentDetailedInfo studentDetailedInfo;

    public StudentDetailedInfo getStudentDetailedInfo() {
        return studentDetailedInfo;
    }

    public void setStudentDetailedInfo(StudentDetailedInfo studentDetailedInfo) {
        this.studentDetailedInfo = studentDetailedInfo;
    }

    public Student() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setHighSchool(boolean highSchool) {
        this.highSchool = highSchool;
    }

    public boolean isHighSchool() {
        return highSchool;
    }

    protected Student(Parcel in) {
        age = in.readInt();
        point = in.readDouble();
        name = in.readString();
        surname = in.readString();
        school = in.readString();
        highSchool = in.readByte() != 0;
        studentDetailedInfo = in.readParcelable(StudentDetailedInfo.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeDouble(point);
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeString(school);
        dest.writeByte((byte) (highSchool ? 1 : 0));
        dest.writeParcelable(studentDetailedInfo, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
