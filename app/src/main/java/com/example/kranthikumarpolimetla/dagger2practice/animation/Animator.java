package com.example.kranthikumarpolimetla.dagger2practice.animation;

import android.app.Application;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.example.kranthikumarpolimetla.dagger2practice.dagger.AnimatorComponent;
import com.example.kranthikumarpolimetla.dagger2practice.dagger.MyAnimatorModule;
import com.example.kranthikumarpolimetla.dagger2practice.dagger.DaggerAnimatorComponent;
import com.github.florent37.viewanimator.ViewAnimator;


/**
 * Created by cyma on 4/12/2017.
 */

public class Animator extends Application{

    private static Animator instance = new Animator();
    private static AnimatorComponent animatorComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        getAnimatorComponent();
    }
    public AnimatorComponent getAnimatorComponent() {
        if (animatorComponent == null){
            animatorComponent = DaggerAnimatorComponent.builder()
                    .myAnimatorModule(new MyAnimatorModule(this))
                    .build();
            return animatorComponent;
        }
        return animatorComponent;
    }


    public  static Animator getInstance() {
        return instance;
    }

    public  void simpleAnimation(View dog, View headset, View sleepify) {
        ViewAnimator.animate(dog)
                .translationY(-1000, 0)
                .alpha(0, 1)
                .andAnimate(sleepify)
                .translationX(-1000, 0)
                .interpolator(new DecelerateInterpolator())
                .duration(2000)

                .thenAnimate(dog)
                .scale(1f, 0.5f, 1f)
                .interpolator(new AccelerateInterpolator())
                .duration(1000)

                .start();
    }

    public void rotationAnimation(View view) {
        ViewAnimator
                .animate(view)
                .bounceIn().interpolator(new BounceInterpolator()) //to bounce
                .rotation(360)
                //to apply height transformation
                /*.waitForHeight() //wait until a ViewTreeObserver notification
                .dp().width(100,200)
                .dp().height(50,100)*/
                .start();
    }
    public void animateText(View view) {
        ViewAnimator
                .animate(view)
                .flash().repeatCount(1)
                /*.custom(new AnimationListener.Update<TextView>() {
                    @Override public void update(TextView view, float value) {
                        view.setText(String.format("%.02f",value));
                    }
                }, 0, 1)*/
                .start();
    }

}
