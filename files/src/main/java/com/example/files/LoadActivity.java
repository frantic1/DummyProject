package com.example.files;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoadActivity extends AppCompatActivity {
    TextView text1,text2;
    Button load_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        text1 = (TextView) findViewById(R.id.text_load1);
        text2 = (TextView) findViewById(R.id.text_load2);
        load_btn = (Button) findViewById(R.id.loader);
        load_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis = openFileInput("frantic.txt");
                    int read;
                    StringBuffer buffer = new StringBuffer();
                    while ((read=fis.read())!= -1){
                        buffer.append((char) read);
                    }
                    String user = buffer.substring(0,buffer.indexOf(" "));
                    String pass = buffer.substring(buffer.indexOf(" ")+1);
                    text1.setText(user);
                    text2.setText(pass);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
