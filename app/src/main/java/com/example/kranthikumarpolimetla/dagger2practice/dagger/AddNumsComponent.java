package com.example.kranthikumarpolimetla.dagger2practice.dagger;

import com.example.kranthikumarpolimetla.dagger2practice.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kranthikumarpolimetla on 4/6/17.
 */


@Singleton
@Component(
        modules = {
                AddNumsModule.class
        }
)
public interface AddNumsComponent {
    void inject(MainActivity mainActivity);
}
