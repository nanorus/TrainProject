package com.example.nanorus.trainproject.bundle_objects;

import android.widget.Button;

import java.io.Serializable;
import java.util.List;

public class SerializableTestPojo implements Serializable {

    int a;
    String b;
    double c;

    Button mImagesDpi;
    List<NotSerializableTestClass> mNotSerializableTestClass;

    public SerializableTestPojo(int a, String b, double c, Button imagesDpi, List<NotSerializableTestClass> notSerializableTestClass) {
        this.a = a;
        this.b = b;
        this.c = c;
        mImagesDpi = imagesDpi;
        mNotSerializableTestClass = notSerializableTestClass;
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

    public Button getImagesDpi() {
        return mImagesDpi;
    }

    public void setImagesDpi(Button imagesDpi) {
        mImagesDpi = imagesDpi;
    }

    public List<NotSerializableTestClass> getNotSerializableTestClass() {
        return mNotSerializableTestClass;
    }

    public void setNotSerializableTestClass(List<NotSerializableTestClass> notSerializableTestClass) {
        mNotSerializableTestClass = notSerializableTestClass;
    }
}
