package com.example.files;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HomeActivity extends AppCompatActivity {

    EditText text1,text2;
    Button save1, next;
    FileOutputStream fos;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        text1 = (EditText) findViewById(R.id.ed1);
        text2 = (EditText) findViewById(R.id.ed2);
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LoadActivity.class);
                startActivity(i);
            }
        });
        save1 = (Button) findViewById(R.id.save);
        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"successfully saved  ",Toast.LENGTH_SHORT).show();

                String file_text =text1.getText().toString()+" "+text2.getText().toString();

                try {
                    file=getFilesDir();
                    fos = openFileOutput("frantic.txt",MODE_PRIVATE);
                    fos.write(file_text.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Toast.makeText(getApplicationContext(),"successfully saved  "+file,Toast.LENGTH_SHORT).show();
            }
        });
    }

}