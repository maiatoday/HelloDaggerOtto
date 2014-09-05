package com.example.hellodaggerotto.network;

import android.app.Service;

import com.example.hellodaggerotto.base.HelloApplication;

/**
 * Created by maia on 2014/08/28.
 */
public abstract class BaseService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();

        // Perform injection so that when this call returns all dependencies will be available for use.
        ((HelloApplication) getApplication()).inject(this);
    }

}
