package com.example.kranthikumarpolimetla.dagger2practice.dagger;

import com.example.kranthikumarpolimetla.dagger2practice.BlankFragment;
import com.example.kranthikumarpolimetla.dagger2practice.animation.Animator;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cyma on 4/13/2017.
 */
@Singleton
@Component ( modules = {
        MyAnimatorModule.class
})
public interface AnimatorComponent {

    public void inject(BlankFragment fragment);
}
