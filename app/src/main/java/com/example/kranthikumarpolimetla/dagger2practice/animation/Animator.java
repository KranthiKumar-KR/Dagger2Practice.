package com.example.kranthikumarpolimetla.dagger2practice.animation;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.viewanimator.AnimationListener;
import com.github.florent37.viewanimator.ViewAnimator;

import java.util.Locale;

/**
 * Created by cyma on 4/12/2017.
 */

public class Animator {
    static void simpleAnimation(View dog, View headset, View sleepify) {
        ViewAnimator.animate(dog)
                .translationY(-1000, 0)
                .alpha(0, 1)
                .andAnimate(sleepify)
                .translationX(-200, 0)
                .interpolator(new DecelerateInterpolator())
                .duration(2000)

                .thenAnimate(dog)
                .scale(1f, 0.5f, 1f)
                .interpolator(new AccelerateInterpolator())
                .duration(1000)

                .start();
    }

    static void animateParallel(View dog, View headset, View sleepify) {
        final ViewAnimator viewAnimator = ViewAnimator.animate(dog, headset)
                .dp().translationY(-1000, 0)
                .alpha(0, 1)
                .singleInterpolator(new OvershootInterpolator())

                .andAnimate(sleepify)
                .textColor(Color.BLACK, Color.WHITE)
                .backgroundColor(Color.WHITE, Color.BLACK)

                .waitForHeight()
                .singleInterpolator(new AccelerateDecelerateInterpolator())
                .duration(2000)

                .thenAnimate(percent)
                .custom(new AnimationListener.Update<TextView>() {
                    @Override
                    public void update(TextView view, float value) {
                        view.setText(String.format(Locale.US, "%.02f%%", value));
                    }
                }, 0, 1)



                .start();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                viewAnimator.cancel();
            }
        }, 3000);
    }

    static void animateSequentially(View dog, View headset, View sleepify) {
        ViewAnimator.animate(headset)
                .dp().width(100f, 150f)
                .alpha(1, 0.1f)
                .interpolator(new DecelerateInterpolator())
                .duration(800)
                .thenAnimate(headset)
                .dp().width(150f, 100f)
                .alpha(0.1f, 1f)
                .interpolator(new AccelerateInterpolator())
                .duration(1200)
                .start();

        ViewAnimator
                .animate(headset).scaleX(0, 1).scaleY(0, 1).alpha(0, 1).decelerate().duration(500)
                .thenAnimate(headset).scaleX(1, 0).scaleY(1, 0).alpha(1, 0).accelerate().duration(500);
    }
}
