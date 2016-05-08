package com.example.dependency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.ed1) EditText editText;
    @BindView(R.id.save) Button saver;
    @BindView(R.id.view_text) TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.save)
    public void save_clicked(){
        Toast.makeText(getApplicationContext(),"wasssabeef",Toast.LENGTH_SHORT).show();

    }
}
