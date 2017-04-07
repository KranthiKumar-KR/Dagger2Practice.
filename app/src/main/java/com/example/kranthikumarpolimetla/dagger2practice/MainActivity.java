package com.example.kranthikumarpolimetla.dagger2practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AddNums.getInstance().getAddNumsComponent().inject(this);
/*num1 = (EditText) findViewById(R.id.number1);
        num2 = (EditText) findViewById(R.id.number2);
        add = (Button) findViewById(R.id.button);
        output = (TextView) findViewById(R.id.result);*/
    }

    public void addClicked(View view) {
        numb1 = Integer.parseInt(num1.getText().toString());
        numb2 = Integer.parseInt(num2.getText().toString());
        output.setText(addNums.adding(numb1, numb2)+"");


    }
}
