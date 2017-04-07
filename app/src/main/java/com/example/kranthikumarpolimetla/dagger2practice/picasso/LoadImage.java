package com.example.kranthikumarpolimetla.dagger2practice.picasso;

import android.app.Application;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by cyma on 4/7/2017.
 */

public class LoadImage {
    ArrayList<Image> images;
    ArrayList<String> imageUrls;
    private void setImageUrls() {
        imageUrls.add("https://s3-us-west-1.amazonaws.com/testmunk-public/blog/android-logo.png");
        imageUrls.add("https://s-media-cache-ak0.pinimg.com/736x/71/44/e9/7144e9c2607c90bf6cc21259a30cfd24.jpg");
        imageUrls.add("http://2.bp.blogspot.com/LatdJLz-qiZHGp9J3mm1AxMDQYVgA03tnXyDu529qhWDKlAoh9u0LrpwJPmp_E8T-Q=w300");
        imageUrls.add("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQY1CDYm4Odm-E7nsLcDwjrcs1iV-fNS7WfAp4aJt6zZ9lLNLvZ");
    }
    private void setImages(ArrayList<String> urls) {
        for(int i=0; i<urls.size();i++) {
            images.add(i,new Image(urls.get(i)));
        }
    }
    public ArrayList getImages() {
        return images;
    }
}

/*public class LoadImage extends Application{

    @Inject
    Image image;

   *//* public LoadImage() {
        Image.getInstance().getImageComponent().inject(this);
    }*//*
    @Override
    public void onCreate() {
        Image.getInstance().getImageComponent().inject(this);
        super.onCreate();
        Picasso.with(this)
                .load("YOUR IMAGE URL HERE")
                .into(imageView);
    }

}*/
