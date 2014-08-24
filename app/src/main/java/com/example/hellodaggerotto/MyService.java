package com.example.hellodaggerotto;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by maia on 2014/08/24.
 */
public class MyService extends Service implements MyServiceInterface {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void ping() {

    }
}
