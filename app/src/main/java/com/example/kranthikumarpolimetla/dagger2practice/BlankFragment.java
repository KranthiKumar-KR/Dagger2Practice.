package com.example.kranthikumarpolimetla.dagger2practice;


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

import com.squareup.picasso.Picasso;

import pl.droidsonroids.gif.GifImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    ImageView imageView;
    View snackbarView;
    Button previous, next;
    GifImageView gifImageView;
    LinearLayout linearLayout;
    int currentIndex = 0;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_blank, container, false);
        imageView = (ImageView) relativeLayout.findViewById(R.id.imageView);
        snackbarView = relativeLayout.findViewById(R.id.snackbar);
        previous = (Button) relativeLayout.findViewById(R.id.previousImage);
        next = (Button) relativeLayout.findViewById(R.id.nextImage);
        gifImageView = (GifImageView) relativeLayout.findViewById(R.id.endOfSlideGifs);
        linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.fragGifLayout);
        gifImageView.setVisibility(View.INVISIBLE);
        setImageUrls();
        loadImage(imageUrls.get(currentIndex));
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousImage();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextImage();
            }
        });
        return relativeLayout;
    }

    private void loadImage(final String url) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Picasso.with(getActivity())
                        .load(url)
                        .into(imageView);
            }
        });
        next.setVisibility(View.VISIBLE);
        previous.setVisibility(View.VISIBLE);
    }

    void nextImage() {
        if (currentIndex < imageUrls.size() - 1) {
            currentIndex = currentIndex + 1;
            loadImage(imageUrls.get(currentIndex));
        } else {
            next.setVisibility(View.INVISIBLE);
            previous.setVisibility(View.INVISIBLE);
            gifImageView.setImageResource(R.drawable.lastimage);
            gifImageView.setVisibility(View.VISIBLE);
            Snackbar snackbar = Snackbar.make(snackbarView, "this is the last image", Snackbar.LENGTH_LONG);
            View view2 = snackbar.getView();
            TextView tv = (TextView) view2.findViewById(android.support.design.R.id.snackbar_text);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    gifImageView.setVisibility(View.INVISIBLE);
                    previous.setVisibility(View.VISIBLE);
                }
            }, 4500);
        }


    }

    void previousImage() {
        if (currentIndex > 0) {
            currentIndex = currentIndex - 1;
            loadImage(imageUrls.get(currentIndex));
        } else {
            next.setVisibility(View.INVISIBLE);
            previous.setVisibility(View.INVISIBLE);
            gifImageView.setImageResource(R.drawable.startingimage);
            gifImageView.setVisibility(View.VISIBLE);
            Snackbar snackbar = Snackbar.make(snackbarView, "this is the starting image", Snackbar.LENGTH_LONG);
            View view2 = snackbar.getView();
            TextView tv = (TextView) view2.findViewById(android.support.design.R.id.snackbar_text);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    gifImageView.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.VISIBLE);
                }
            }, 4500);
        }


    }

}
