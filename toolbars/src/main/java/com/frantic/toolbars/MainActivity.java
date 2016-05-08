package com.frantic.toolbars;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.badoualy.morphytoolbar.MorphyToolbar;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    CoordinatorLayout cl;
    MorphyToolbar morphyToolbar;
    int primary2;
    int primaryDark2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        primary2 = getResources().getColor(R.color.colorPrimary);
        primaryDark2 = getResources().getColor(R.color.colorPrimaryDark);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

         morphyToolbar = MorphyToolbar.builder(this, toolbar)
                .withToolbarAsSupportActionBar()
                .withTitle("KTM to PKR")
                .withSubtitle("April 30, 2016")
                .withPicture(R.drawable.ic_shop_24dp)
                .withHidePictureWhenCollapsed(false)
                .build();

        morphyToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (morphyToolbar.isCollapsed()) {
                    morphyToolbar.expand(primary2, primaryDark2, new MorphyToolbar.OnMorphyToolbarExpandedListener() {
                        @Override
                        public void onMorphyToolbarExpanded() {
                            morphyToolbar.setTitle("KTM To PKR");
                        }
                    });
                } else {
                    morphyToolbar.collapse();
                }
            }
        });

    }

}
