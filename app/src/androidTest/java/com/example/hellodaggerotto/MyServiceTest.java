package com.example.hellodaggerotto;

import android.content.Intent;
import android.os.IBinder;
import android.test.ServiceTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import com.example.hellodaggerotto.network.MyService;

public class MyServiceTest extends ServiceTestCase<MyService> {


    /**
     * Constructor
     *
     */
    public MyServiceTest() {
        super(MyService.class);
    }

    public void setUp() throws Exception {
        super.setUp();

    }

    /**
     * Test basic startup/shutdown of Service
     */
    @SmallTest
    public void testStartable() {
        Intent startIntent = new Intent();
        startIntent.setClass(getContext(), MyService.class);
        startService(startIntent);
    }

    /**
     * Test binding to service
     */
    @MediumTest
    public void testBindable() {
        Intent startIntent = new Intent();
        startIntent.setClass(getContext(), MyService.class);
        IBinder service = bindService(startIntent);
    }

    public void tearDown() throws Exception {

    }

    public void testStart() throws Exception {
       this.startService(new Intent(getContext(), MyService.class));
    }

}