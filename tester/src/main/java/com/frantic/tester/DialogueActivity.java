package com.frantic.tester;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DialogueActivity extends AppCompatActivity {
    TextView adult;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue);
        context = DialogueActivity.this;
        adult = (TextView) findViewById(R.id.namer);
        adult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder loginDialog = new AlertDialog.Builder(context,4);
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View dialogView = inflater.inflate(R.layout.dialog_customview, null);
                loginDialog.setView(dialogView);
                loginDialog.setTitle("Adult");
                loginDialog.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"Yeppie",Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog dialog = loginDialog.create();
                dialog.show();

            }
        });
    }
}
