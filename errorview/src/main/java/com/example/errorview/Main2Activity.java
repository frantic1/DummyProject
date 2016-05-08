package com.example.errorview;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {
    ViewSwitcher viewSwitcher;
    Button login;
    TextView textView;
    ImageView img;
    String a = "<html><h1>Frantic</h1><p>These are my interests:<br>" +
            "<ul>" +
            "<li>A</li>" +
            "<li>B</li>" +
            "<li>C</li>" +
            "<li>D</li>" +
            "</ul>" +
            "<ul><li>cats</li><li>dogs</li></ul></p></html>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        viewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcherId);
         login = (Button) findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.texter);

        img = (ImageView) findViewById(R.id.img);
        req();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = getIntent();
                finish();
                startActivity(intent);*/
                if (isOnline()){
                    req();
                    viewSwitcher.showPrevious();
                    Log.d("name","online");
                    Toast.makeText(getApplicationContext(),"online",Toast.LENGTH_SHORT).show();
                }else {
                    Log.d("name","offline");
                    Toast.makeText(getApplicationContext(),"offline",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void req() {
        if (isOnline()){
            textView.setText(Html.fromHtml(a));
            Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(img);
        }else {
            viewSwitcher.showNext();
        }
    }

    protected boolean isOnline(){
        ConnectivityManager con = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = con.getActiveNetworkInfo();
        if (info != null && info.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

}
