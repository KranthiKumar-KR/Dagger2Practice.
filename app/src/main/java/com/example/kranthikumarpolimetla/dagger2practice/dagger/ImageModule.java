package com.example.kranthikumarpolimetla.dagger2practice.dagger;

import com.example.kranthikumarpolimetla.dagger2practice.picasso.Image;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cyma on 4/7/2017.
 */


@Module
public class ImageModule {
    private Image image;

    public ImageModule(Image image) {
        this.image = image;
    }


    @Provides
    @Singleton
    Image provideImage(){
        return image;
    }
}
