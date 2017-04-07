package com.example.kranthikumarpolimetla.dagger2practice.dagger;

import com.example.kranthikumarpolimetla.dagger2practice.picasso.Image;
import com.example.kranthikumarpolimetla.dagger2practice.picasso.LoadImage;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cyma on 4/7/2017.
 */

@Singleton
@Component (
        modules = {
                ImageModule.class
        }
)
public interface ImageComponent {
    void inject(LoadImage loadImage);
}
