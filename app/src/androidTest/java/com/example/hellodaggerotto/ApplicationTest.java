package com.example.hellodaggerotto;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.example.hellodaggerotto.base.HelloApplication;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<HelloApplication> {
    public ApplicationTest() {
        super(HelloApplication.class);
    }
}