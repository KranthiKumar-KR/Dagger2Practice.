package com.example.kranthikumarpolimetla.dagger2practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.number1)
    EditText num1;

    @BindView(R.id.number2)
    EditText num2;

    @BindView(R.id.button)
    Button add;

    @BindView(R.id.result)
    TextView result;

    @Inject
    AddNums addNums;

    public MainActivity() {
        AddNums.getInstance().getAddNumsComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    void addClicked( View view) {
        result.setText(addNums.adding(Integer.valueOf(num1.getText().toString()), Integer.valueOf(num2.getText().toString())));

    }
}
