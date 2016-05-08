package com.frantic.green;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {

    TextView textView;
    Context context = getActivity();
    List<Person> personList;
    StringBuffer stringBuffer;

    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_two, container, false);
        textView= (TextView) v.findViewById(R.id.texter);
        personList = new ArrayList<>();
        if (getArguments()!= null){

            String a = getArguments().getString("name");
            String b = getArguments().getString("abc");
            personList=getArguments().getParcelableArrayList("person");
            stringBuffer = new StringBuffer();
            for (int i = 0; i < personList.size(); i++) {
                Person person = personList.get(i);
                stringBuffer.append("name: "+person.getFirstname()+" "+person.getLastname()+"\n\n"+"occupation: "+
                        person.getOccupation()+"\n\n\n");
            }
            textView.setText(a+"  "+b+"\n\n"+stringBuffer+"\n\n"+personList.size());
        }else {
            Toast.makeText(getActivity(),"Null Data",Toast.LENGTH_SHORT).show();
        }
        //EventBus.getDefault().register(this);
        return v;
    }


    public void setData(String event){
        textView.setText(event);
    }


}
