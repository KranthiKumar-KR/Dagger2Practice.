package com.example.kranthikumarpolimetla.dagger2practice.dagger;

import com.example.kranthikumarpolimetla.dagger2practice.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by KR on 4/6/17.
 * it is a dagger component class where we can see all the module classes that provide dependency and
 * all the target classes where we need this dependency
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
