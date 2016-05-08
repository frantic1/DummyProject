package com.frantic.tester;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AdultActivity extends AppCompatActivity {

    int N=3;
    LinearLayout linearLayout;
    Context context;
    EditText first,last;
    Button submit;
    EditText[] editTexts,editTexts2;
    List<Person> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adult);
        linearLayout = (LinearLayout) findViewById(R.id.linear);
        context = getApplicationContext();
        personList = new ArrayList<>();
        editTexts = new EditText[N];
        editTexts2 = new EditText[N];
        submit = (Button) findViewById(R.id.submit);

        for (int i = 0; i < N; i++) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.name,null);

            editTexts[i] = (EditText) v.findViewById(R.id.firstname);
            editTexts2[i] = (EditText) v.findViewById(R.id.lastname);
            //first.setHint("Adult " + i);
            //editTexts[i] = first;
            editTexts2[i] = last;
            linearLayout.addView(v);
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < N; i++) {
                    //String a =editTexts[i].getText().toString().trim();
                    //String b = editTexts2[i].getText().toString().trim();
                    if (editTexts[i].length()<N){
                        editTexts[i].setError("empty");
                        Log.d("empty", editTexts[i]+ "");
                    }else if(editTexts[i].length()<3) {
                        i++;
                        Toast.makeText(getApplicationContext(),"vvvvv",Toast.LENGTH_LONG).show();
                    }else{
                        Log.d("editer", editTexts[i].getText().length()+"");
                            Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                            Person person = new Person();
                        /*person.setFirstname(a);
                        person.setLastname(b);*/
                            personList.add(person);

                           // Log.d("s", personList.get(i).getFirstname() + " " + personList.get(i).getLastname());

                            //Log.d("size",personList.size()+"");

                            /*String si = personList.size()+"";
                            Intent intent = new Intent();
                            intent.putExtra("a", si);
                            setResult(RESULT_OK, intent);*/
                            //finish();
                        }
                    }


               /* for (int i = 0; i < N; i++) {

                    Log.d("s",personList.get(i).getFirstname()+" "+personList.get(i).getLastname());
                }

                Log.d("size",personList.size()+"");
                String si = personList.size()+"";
                Intent intent = new Intent();
                intent.putExtra("a",si);
                setResult(RESULT_OK,intent);
                finish();*/

            }
        });
    }


}
