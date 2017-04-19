package com.example.kranthikumarpolimetla.dagger2practice;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.kranthikumarpolimetla.dagger2practice.picasso.LoadImage.*;

import com.example.kranthikumarpolimetla.dagger2practice.animation.Animator;
import com.example.kranthikumarpolimetla.dagger2practice.util.NavigatorSupport;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import pl.droidsonroids.gif.GifImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    @Inject
    Animator animator;

    //fragment elements
    ImageView imageView;
    View snackbarView;
    Button previousButton, nextButton;
    GifImageView gifImageView;
    LinearLayout linearLayout;
    int currentIndex = 0;
    RelativeLayout relativeLayout;
    Button startAnimationButton;

    //animator layout elements
    Button stopAnimationButton;
    Button inflatorAnimateButton;
    ImageView dog, headphones, sleepify;
    TextView headsetWarning;
    View animationView;

    NavigatorSupport navigatorSupport;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        Animator.getInstance().getAnimatorComponent().inject(this);

        relativeLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_blank, container, false);

        //inflating layout
        animationView = inflater.inflate(R.layout.animator_layout, container, false);

        //bindings manually

        //fragment elements binding
        imageView = (ImageView) relativeLayout.findViewById(R.id.imageView);
        snackbarView = relativeLayout.findViewById(R.id.snackbar);
        previousButton = (Button) relativeLayout.findViewById(R.id.previousImage);
        nextButton = (Button) relativeLayout.findViewById(R.id.nextImage);
        startAnimationButton = (Button) relativeLayout.findViewById(R.id.animator);
        gifImageView = (GifImageView) relativeLayout.findViewById(R.id.endOfSlideGifs);
        linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.fragGifLayout);

        //animator elements binding
        stopAnimationButton = (Button) animationView.findViewById(R.id.stopButton);
        inflatorAnimateButton = (Button) animationView.findViewById(R.id.animateButton);
        dog = (ImageView) animationView.findViewById(R.id.sleepingDog);
        headphones = (ImageView) animationView.findViewById(R.id.headset);
        sleepify = (ImageView) animationView.findViewById(R.id.sleepifyText);
        headsetWarning = (TextView) animationView.findViewById(R.id.headsetWarning);
        gifImageView.setVisibility(View.INVISIBLE);
        removeUrls();
        setImageUrls();
        loadImage(imageUrls.get(currentIndex));
        previousButton.setOnClickListener(e -> previousImage());
        nextButton.setOnClickListener( e -> nextImage());
        startAnimationButton.setOnClickListener(e -> inflateLayout());
        stopAnimationButton.setOnClickListener(e -> stopAnimation());
        inflatorAnimateButton.setOnClickListener(e -> startAnimation(dog, headphones, sleepify, headsetWarning));
        return relativeLayout;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NavigatorSupport) {
            navigatorSupport = (NavigatorSupport) context;
        } else
            throw new RuntimeException("Activity must implement NavigatorSupport");
    }

    @Override
    public void onDetach() {
        navigatorSupport = null;
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
        navigatorSupport.setAddButtonVisibility(false);
        navigatorSupport.setLoadImageButtonVisibility(false);
    }

    @Override
    public void onPause() {
        navigatorSupport.setAddButtonVisibility(true);
        navigatorSupport.setLoadImageButtonVisibility(true);
        super.onPause();

    }

    @Override
    public void onStop() {
        navigatorSupport.setLoadImageButtonVisibility(true);
        navigatorSupport.setAddButtonVisibility(true);
        super.onStop();

    }

    private void loadImage(final String url) {
        new Handler(Looper.getMainLooper()).post(() -> Picasso.with(getActivity())
                .load(url)
                .into(imageView));
        nextButton.setVisibility(View.VISIBLE);
        previousButton.setVisibility(View.VISIBLE);
    }
    void nextImage() {
        if (currentIndex < imageUrls.size() - 1) {
            currentIndex = currentIndex + 1;
            loadImage(imageUrls.get(currentIndex));
        } else {
            nextButton.setVisibility(View.INVISIBLE);
            previousButton.setVisibility(View.INVISIBLE);
            startAnimationButton.setVisibility(View.INVISIBLE);
            gifImageView.setImageResource(R.drawable.lastimage);
            gifImageView.setVisibility(View.VISIBLE);
            Snackbar snackbar = Snackbar.make(snackbarView, "this is the last image", Snackbar.LENGTH_LONG);
            View view2 = snackbar.getView();
            TextView tv = (TextView) view2.findViewById(android.support.design.R.id.snackbar_text);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                gifImageView.setVisibility(View.INVISIBLE);
                previousButton.setVisibility(View.VISIBLE);
                startAnimationButton.setVisibility(View.VISIBLE);
            }, 4500);
        }


    }

    void previousImage() {
        if (currentIndex > 0) {
            currentIndex = currentIndex - 1;
            loadImage(imageUrls.get(currentIndex));
        } else {
            nextButton.setVisibility(View.INVISIBLE);
            previousButton.setVisibility(View.INVISIBLE);
            startAnimationButton.setVisibility(View.INVISIBLE);
            gifImageView.setImageResource(R.drawable.startingimage);
            gifImageView.setVisibility(View.VISIBLE);
            Snackbar snackbar = Snackbar.make(snackbarView, "this is the starting image", Snackbar.LENGTH_LONG);
            View view2 = snackbar.getView();
            TextView tv = (TextView) view2.findViewById(android.support.design.R.id.snackbar_text);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
            new Handler(Looper.getMainLooper()).postDelayed( () -> {
                    gifImageView.setVisibility(View.INVISIBLE);
                    nextButton.setVisibility(View.VISIBLE);
                    startAnimationButton.setVisibility(View.VISIBLE);
            }, 4500);
        }


    }

    void inflateLayout() {
        relativeLayout.removeAllViews();
        startAnimationButton.setVisibility(View.INVISIBLE);
        nextButton.setVisibility(View.INVISIBLE);
        previousButton.setVisibility(View.INVISIBLE);
        relativeLayout.addView(animationView);
    }

    void stopAnimation() {
        if (animationView != null) {
            if (animationView.isShown()) {
                navigatorSupport.setLoadImageButtonVisibility(true);
                navigatorSupport.setAddButtonVisibility(true);
                relativeLayout.setVisibility(View.VISIBLE);
                animationView.setVisibility(View.INVISIBLE);
                relativeLayout.bringToFront();
                startAnimationButton.setVisibility(View.VISIBLE);
                nextButton.setVisibility(View.VISIBLE);
                previousButton.setVisibility(View.VISIBLE);
            }
        }
    }

    void startAnimation(View dog, View headset, View sleepify, View headsetWarningIn) {
        animator.simpleAnimation(dog, headset, sleepify);
        animator.rotationAnimation(headset);
        this.headsetWarning.setText(this.getString(R.string.headset_Warning));
        animator.animateText(headsetWarningIn);

    }

}
