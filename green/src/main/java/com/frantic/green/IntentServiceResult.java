package com.frantic.green;

/**
 * Created by Frantic on 5/1/2016.
 */
public class IntentServiceResult {
    int mResult;
    String value;

    public IntentServiceResult() {
    }

    public IntentServiceResult(int mResult, String value) {
        this.mResult = mResult;
        this.value = value;
    }

    public int getmResult() {
        return mResult;
    }

    public void setmResult(int mResult) {
        this.mResult = mResult;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
