package com.example.kranthikumarpolimetla.dagger2practice.dagger;

import com.example.kranthikumarpolimetla.dagger2practice.animation.Animator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cyma on 4/13/2017.
 */

@Module
public class MyAnimatorModule {
    private final Animator animator;

    public MyAnimatorModule(Animator animator) {
        this.animator = animator;
    }

    @Singleton
    @Provides
    public Animator providesAnimator() {
        return animator;
    }
}
