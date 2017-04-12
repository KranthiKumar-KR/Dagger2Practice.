package com.example.kranthikumarpolimetla.dagger2practice;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.droidsonroids.gif.GifImageView;

import static android.support.design.widget.Snackbar.make;

public class MainActivity extends AppCompatActivity {

    @Inject
    AddNums addNums;
    int numb1;
    int numb2;

    @BindView(R.id.number1)
    EditText num1;

    @BindView(R.id.number2)
    EditText num2;

    @BindView(R.id.button)
    Button add;

    @BindView(R.id.result)
    TextView output;

    @BindView(R.id.snackbarPosition)
    View snackbarView;

    @BindView(R.id.gifLayout)
    LinearLayout gifLayout;

    @BindView(R.id.gifImageView)
    GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        gifLayout.setVisibility(View.VISIBLE);
        hideGIF();
        AddNums.getInstance().getAddNumsComponent().inject(this);
    }

    public void addClicked(View view) {
        numb1 = Integer.parseInt(num1.getText().toString());
        numb2 = Integer.parseInt(num2.getText().toString());
        output.setText(addNums.adding(numb1, numb2)+"");
       Snackbar snackbar= Snackbar.make(snackbarView, "your result is" +addNums.adding(numb1, numb2), Snackbar.LENGTH_LONG);
        View view2 = snackbar.getView();
        TextView tv = (TextView) view2.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        snackbar.show();
    }
    @OnClick (R.id.Imgbutton)
    public void loadImage(View view) {
        BlankFragment fragment= new BlankFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.mainLayout, fragment); // fragment container id in first parameter is the  container(Main layout id) of Activity
        transaction.addToBackStack(null);  // this will manage backstack
        transaction.commit();
    }
    public void hideGIF() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                gifLayout.setVisibility(View.GONE);
            }
        }, 3000);
    }

}
