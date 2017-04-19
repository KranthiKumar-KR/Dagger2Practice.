package com.example.kranthikumarpolimetla.dagger2practice.picasso;

/**
 * Created by cyma on 4/7/2017.
 */

public class Image {
    private String url;
    public Image(String url) {
        this.url = url;
    }
    public String getUrl(){
        return url;
    }
}

/*public class Image extends Application {
    private static Image instance = new Image();
    private static ImageComponent imageComponent;
    private ArrayList<String> imageUrls;

    private void setImageUrls() {
        imageUrls.add("https://s3-us-west-1.amazonaws.com/testmunk-public/blog/android-logo.png");
        imageUrls.add("https://s-media-cache-ak0.pinimg.com/736x/71/44/e9/7144e9c2607c90bf6cc21259a30cfd24.jpg");
        imageUrls.add("http://2.bp.blogspot.com/LatdJLz-qiZHGp9J3mm1AxMDQYVgA03tnXyDu529qhWDKlAoh9u0LrpwJPmp_E8T-Q=w300");
        imageUrls.add("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQY1CDYm4Odm-E7nsLcDwjrcs1iV-fNS7WfAp4aJt6zZ9lLNLvZ");
    }
    public ArrayList getImageUrls() {
        return imageUrls;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        imageUrls = new ArrayList<String>();
        setImageUrls();
        getImageComponent();
    }
    public ImageComponent getImageComponent(){
        if(imageComponent == null) {
            imageComponent = DaggerImageComponent.builder().imageModule(new ImageModule(this)).build();
            return imageComponent;
        }
        return imageComponent;
    }

    public static Image getInstance() {
        return instance;
    }
}*/
