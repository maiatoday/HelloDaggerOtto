package com.example.hellodaggerotto.network;


import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.hellodaggerotto.bus.PingRequest;
import com.example.hellodaggerotto.bus.PongRequest;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.Random;

import javax.inject.Inject;

/**
 * Created by maia on 2014/08/24.
 */
public class MyService extends BaseService {
    // Binder given to clients
    private final IBinder mBinder = new MyBinder();
    // Random number generator
    private final Random mGenerator = new Random();

    @Inject
    public Bus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        bus.register(this);
    }

    @Override
    public void onDestroy() {
        bus.unregister(this);
    }

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class MyBinder extends Binder {
        public MyService getService() {
            // Return this instance of LocalService so clients can call public methods
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    public String ping_old() {

        return "pong!" + mGenerator.nextInt(100);
    }

    @Subscribe
    public void ping(final PingRequest ping) {
        bus.post(new PongRequest("hello pong"+ mGenerator.nextInt(100)));
    }
}
