package com.example.nanorus.trainproject.bundle_objects;


public class NotSerializableTestClass {

    private NotSerializableTestClass mNotSerializableTestClass;

    private Integer i = 5;

    public int getI() {
        return i;
    }

    public void createNotSerializableClass() {
        mNotSerializableTestClass = new NotSerializableTestClass();
    }

    public NotSerializableTestClass getNotSerializableTestClass() {
        return mNotSerializableTestClass;
    }
}

