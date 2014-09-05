package com.example.hellodaggerotto.bus;

import com.example.hellodaggerotto.network.MyService;
import com.example.hellodaggerotto.ui.MyActivity;
import com.example.hellodaggerotto.ui.MyFragment;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by maia on 2014/09/05.
 */
@Module(
        injects = {MyService.class, MyActivity.class, MyFragment.class},
        overrides = true
)
public class MockBusModule {
    @Provides
    @Singleton
    Bus provideBus() {
        return new Bus(ThreadEnforcer.ANY);
    } //TODO make one that isn't on the main thread
}