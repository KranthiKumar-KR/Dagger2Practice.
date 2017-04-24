package com.example.kranthikumarpolimetla.dagger2practice.dagger;


import com.example.kranthikumarpolimetla.dagger2practice.AddNums;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/***
 * it is module class to provide AddNums dependency
 */

@Module
public class AddNumsModule {
    private final AddNums addNums;

    public AddNumsModule(AddNums addNums) {
        this.addNums = addNums;
    }

    @Provides
    @Singleton
     AddNums provideContext() {
        return addNums;
    }

}
