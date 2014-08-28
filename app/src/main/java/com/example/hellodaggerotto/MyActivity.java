package com.example.hellodaggerotto;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hellodaggerotto.base.BaseActivity;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;


public class MyActivity extends BaseActivity {


    @Inject
    public static Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public  static class PlaceholderFragment extends Fragment {


        MyService mService;
        boolean mBound = false;
        private TextView mTv;

        public PlaceholderFragment() {
        }
        @Override
        public void onStart() {
            super.onStart();
            // Bind to LocalService
            Intent intent = new Intent(getActivity(), MyService.class);
           getActivity().bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        }

        @Override
        public void onStop() {
            super.onStop();
            // Unbind from the service
            if (mBound) {
                getActivity().unbindService(mConnection);
                mBound = false;
            }
        }

        @Subscribe
        public void pong(final PongRequest ping) {
            bus.post(new PongRequest("hello pong"));
            mTv.setText(ping.getMessage());
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);

            final TextView tv = (TextView) rootView.findViewById(R.id.textView);
            mTv = (TextView) rootView.findViewById(R.id.textView2);
            Button btn = (Button) rootView.findViewById(R.id.button);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mBound) {
                        tv.setText(mService.ping());
                    }
                    tv.setText("pong");
                }
            });
            Button btn2 = (Button) rootView.findViewById(R.id.button2);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mBound) {
                        bus.post(new PingRequest());
                    }
                }
            });
            return rootView;
        }

        /** Defines callbacks for service binding, passed to bindService() */
        private ServiceConnection mConnection = new ServiceConnection() {

            @Override
            public void onServiceConnected(ComponentName className,
                                           IBinder service) {
                // We've bound to LocalService, cast the IBinder and get LocalService instance
                MyService.MyBinder binder = (MyService.MyBinder) service;
                mService = binder.getService();
                mBound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName arg0) {
                mBound = false;
            }
        };
    }

}
