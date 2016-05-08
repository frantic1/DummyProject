package com.frantic.tester;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;

import java.util.ArrayList;
import java.util.List;

public class PoperActivity extends AppCompatActivity {

    TextView t1,rows;
    LinearLayout linearLayout;
    EditText first,last;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button btn1;
    ArrayList<List<Person>> arrayList = new ArrayList<>();
    FragmentManager fm = getSupportFragmentManager();
    List<Person> personList;
    List<String> names;
    MaterialDialog md;
    Context context;
    int N=4;
    TextView[] textViews ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poper);
        context = getApplicationContext();
        btn1 = (Button) findViewById(R.id.btn);
        names = new ArrayList<>();
        personList = new ArrayList<>();
        textViews = new TextView[N];
        linearLayout = (LinearLayout) findViewById(R.id.cont);
        for (int i = 0; i < N; i++) {
            rows = new TextView(this);
            rows.setHint("adult"+i);
            linearLayout.addView(rows);
            textViews[i] = rows;
        }
        for (int i = 0; i < N; i++) {
            final int finalI = i;
            final int finalI1 = i;
            textViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // getName();
                    md = new MaterialDialog.Builder(PoperActivity.this)
                            .customView(R.layout.dialog_customview, true)
                            .cancelable(false)
                            .theme(Theme.DARK)
                            .positiveText(R.string.app_name)
                            .negativeText(android.R.string.cancel)
                            .positiveText("OK")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(MaterialDialog dialog, DialogAction which) {
                                    first = (EditText) md.getCustomView().findViewById(R.id.firstname);
                                    last = (EditText) md.getCustomView().findViewById(R.id.lastname);
                                    radioGroup = (RadioGroup) md.getCustomView().findViewById(R.id.radiogroup);
                                    int selectedId = radioGroup.getCheckedRadioButtonId();
                                    radioButton = (RadioButton) md.getCustomView().findViewById(selectedId);

                                    String salutation = radioButton.getText().toString();
                                    String firstname = first.getText().toString();
                                    String lastname = last.getText().toString();
                                    Person person = new Person();
                                    person.setSalutation(salutation);
                                    person.setFirstname(firstname);
                                    person.setLastname(lastname);
                                    personList.add(person);
                                        textViews[finalI].setText(salutation + " " + firstname + " " + lastname);
                                        names.add(firstname);

                                }
                            })
                            .show();

                    Toast.makeText(getApplicationContext(), "no:" + finalI, Toast.LENGTH_LONG).show();
                }
            });
        }
       t1 = (TextView) findViewById(R.id.text1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopFragment pop = new PopFragment();

                for (int i = 0; i < N; i++) {
                   Person person = personList.get(i);
                    arrayList.add(personList);
                    t1.setText(person.getSalutation() + person.getFirstname() + person.getLastname() + "\n");
                }

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {

                        Log.d("sa",arrayList.get(i).get(j).getSalutation());
                        Log.d("name",arrayList.get(i).get(j).getFirstname());
                        Log.d("last",arrayList.get(i).get(j).getLastname());
                    }
                }


                /*if (textViews[1].getText().toString().isEmpty()){
                    textViews[1].setError("Enter name");
                }else {
                    textViews[1].setError(null);
                    String a = "";
                    for (int i = 0; i < names.size(); i++) {
                        a =a+ names.get(i).toString();
                        t1.setText(a);
                    }
                }*/

            }
        });

    }

    private void getName() {
        md = new MaterialDialog.Builder(PoperActivity.this)
                .title(R.string.app_name)
                .customView(R.layout.dialog_customview, true)
                .positiveText(R.string.app_name)
                .negativeText(android.R.string.cancel)
                .positiveText("OK")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which) {
                        first = (EditText) md.getCustomView().findViewById(R.id.firstname);
                        String a = first.getText().toString();
                        rows.setText(a);
                    }
                })
               .show();
    }

}
