package com.example.kranthikumarpolimetla.dagger2practice.dagger;

import android.content.Context;

import com.example.kranthikumarpolimetla.dagger2practice.AddNums;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kranthikumarpolimetla on 4/6/17.
 */

@Module
public class AddNumsModule {
    private final AddNums addNums;

    public AddNumsModule(AddNums addNums) {
        this.addNums = addNums;
    }

    @Provides
    @Singleton
    public AddNums provideContext() {
        return addNums;
    }

}
