package com.example.hellodaggerotto.base;

import android.app.Activity;
import android.os.Bundle;

import com.example.hellodaggerotto.HelloApplication;

/**
 * Created by maia on 2014/08/28.
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Perform injection so that when this call returns all dependencies will be available for use.
        ((HelloApplication) getApplication()).inject(this);
    }
}
