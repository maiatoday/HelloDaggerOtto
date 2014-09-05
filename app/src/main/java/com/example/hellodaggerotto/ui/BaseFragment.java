package com.example.hellodaggerotto.ui;

import android.app.Fragment;
import android.os.Bundle;

import com.example.hellodaggerotto.base.HelloApplication;

/**
 * Created by maia on 2014/09/05.
 */
public class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Perform injection so that when this call returns all dependencies will be available for use.
        ((HelloApplication) getActivity().getApplication()).inject(this);
    }
}
