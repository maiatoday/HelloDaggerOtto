package com.example.hellodaggerotto;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.hellodaggerotto.base.HelloApplication;
import com.example.hellodaggerotto.bus.MockBusModule;
import com.example.hellodaggerotto.ui.MyActivity;


public class MyActivityTest extends ActivityInstrumentationTestCase2<MyActivity> {

    private MyActivity mActivity;
    private Button mButton;
    private Instrumentation mInstrumentation;
    private TextView mText;

    public MyActivityTest() {
        super(MyActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
        HelloApplication app = (HelloApplication) mActivity.getApplication();
        app.addModule(new MockBusModule());
        mInstrumentation = getInstrumentation();
    }

    public void testPreconditions() {
        assertNotNull(mInstrumentation);
        assertNotNull(mActivity);
    }

    public void testButtonClick() {
        mActivity = getActivity();
        mButton = (Button) mActivity.findViewById(R.id.button);
        mText = (TextView) mActivity.findViewById(R.id.textView);
        assertNotNull(mButton);
        assertNotNull(mText);
        TouchUtils.clickView(this, mButton);
        String expectedTextStart = "pong";
        assertTrue(mText.getText().toString().startsWith(expectedTextStart));
    }

//    public void testStartServiceOnInit () {
//        final AtomicBoolean serviceStarted = new AtomicBoolean(false);
//        setActivityContext(new ContextWrapper(getInstrumentation().getTargetContext()) {
//            @Override
//            public ComponentName startService(Intent service) {
//                Log.v("mockcontext", "Start service: " + service.toUri(0));
//                if (service.getComponent().getClassName().equals ("com.example.hellodaggerotto.network.MyService"))
//                    serviceStarted.set(true);
//                return service.getComponent();
//            }
//        });
//        startActivity(new Intent(), null, null);
//        assertTrue ("Service should have been started", serviceStarted.get());
//    }


    public void tearDown() throws Exception {

    }

}