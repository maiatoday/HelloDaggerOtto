package com.example.hellodaggerotto;

import android.content.Context;
import android.content.Intent;
import android.test.ServiceTestCase;
import android.widget.EditText;

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

    public void tearDown() throws Exception {

    }

    public void testStart() throws Exception {
       this.startService(new Intent(getContext(), MyService.class));
    }

}