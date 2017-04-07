package com.example.kranthikumarpolimetla.dagger2practice;

import android.app.Application;

import com.example.kranthikumarpolimetla.dagger2practice.dagger.AddNumsComponent;
import com.example.kranthikumarpolimetla.dagger2practice.dagger.AddNumsModule;
import com.example.kranthikumarpolimetla.dagger2practice.dagger.DaggerAddNumsComponent;

/**
 * Created by kranthikumarpolimetla on 4/6/17.
 */

public class AddNums extends Application{
    private int num1;
    private int num2;

    private  static AddNums instance = new AddNums();
    private static AddNumsComponent addNumsComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        //setInstance();
        //getInstance();
       // instance = this;
        getAddNumsComponent();
    }


    public  AddNumsComponent getAddNumsComponent() {
        if (addNumsComponent == null) {
            addNumsComponent = DaggerAddNumsComponent.builder()
                    .addNumsModule(new AddNumsModule(this))
                    .build();
            return addNumsComponent;
        }
        return addNumsComponent;
    }

    public  void setInstance() {
        instance = this;
    }

    /**
     *
     * @return returns AddNums instance for dependency injection
     */

    public static AddNums getInstance(){
        return instance;
    }

    /**
     * this method is  to add two numbers that are passed as arguments
     * @param numA number1 to add
     * @param numB number2 to add
     */

    public int adding(int numA, int numB) {
        this.num1 = numA;
        this.num2 = numB;
        return num1 + num2;
    }
}
