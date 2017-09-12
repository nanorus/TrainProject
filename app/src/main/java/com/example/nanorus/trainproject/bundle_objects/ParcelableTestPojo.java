package com.example.nanorus.trainproject.bundle_objects;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableTestPojo implements Parcelable {

    int a;
    String b;
    double c;
    NotSerializableTestClass mNotSerializableTestClass;

    protected ParcelableTestPojo(Parcel in) {
    }

    public static final Creator<ParcelableTestPojo> CREATOR = new Creator<ParcelableTestPojo>() {
        @Override
        public ParcelableTestPojo createFromParcel(Parcel in) {
            return new ParcelableTestPojo(in);
        }

        @Override
        public ParcelableTestPojo[] newArray(int size) {
            return new ParcelableTestPojo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(a);
        parcel.writeDouble(c);
        parcel.writeString(b);
    }

    public ParcelableTestPojo(int a, String b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
