package com.example.hellodaggerotto;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;


public class MyActivityTest extends ActivityInstrumentationTestCase2<MyActivity> {

    private MyActivity mActivity;
    private Button mButton;

    public MyActivityTest() {
        super(MyActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
        mButton = (Button) mActivity.findViewById(R.id.button);
        assertTrue(mActivity != null);
        assertTrue(mButton != null);
    }

    public void tearDown() throws Exception {

    }

    public void testButtonClick() throws Exception {
        assertTrue(true);
    }

}