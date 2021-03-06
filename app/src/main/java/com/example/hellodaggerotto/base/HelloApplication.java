/*
 * Copyright (C) 2013 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.hellodaggerotto.base;

import android.app.Application;

import com.example.hellodaggerotto.bus.BusModule;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public class HelloApplication extends Application {
    private ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();
        graph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules() {
        return Arrays.asList(
                new AndroidModule(this),
                new BusModule()
        );
    }

    public void inject(Object object) {
        graph.inject(object);
    }

    public void addModule(Object module) {
        graph.plus(module);
    }

}
