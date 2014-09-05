package com.example.hellodaggerotto.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hellodaggerotto.R;
import com.example.hellodaggerotto.bus.PingRequest;
import com.example.hellodaggerotto.bus.PongRequest;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

/**
 * Created by maia on 2014/09/05.
 */
/**
 * A placeholder fragment containing a simple view.
 */
public class MyFragment extends BaseFragment {

    @Inject
    public Bus bus;
    private TextView mTv;

    public MyFragment() {
    }

    @Override
    public void onPause() {
        super.onPause();
        bus.unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Subscribe
    public void pong(final PongRequest pong) {
        mTv.setText(pong.getMessage());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my, container, false);

        mTv = (TextView) rootView.findViewById(R.id.textView);
        Button btn = (Button) rootView.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bus.post(new PingRequest());
            }
        });
        return rootView;
    }
}

