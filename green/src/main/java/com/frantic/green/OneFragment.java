package com.frantic.green;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {
    EditText editText;
    Button submit;
    Communicator cm;
    List<Person> personList;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_one, container, false);
        editText = (EditText) v.findViewById(R.id.editer);
        submit = (Button) v.findViewById(R.id.submit_btn);
        personList = new ArrayList<>();
        personList.add(new Person("A","B","C"));
        personList.add(new Person("23","gf","hh"));

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();
                Log.d("value",a);
                //EventBus.getDefault().post(new IntentServiceResult(Activity.RESULT_OK, a));
                cm.sendData(a);
                cm.people(personList);
            }
        });
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        cm = (Communicator) activity;
    }

    /*  @Subscribe(threadMode = ThreadMode.MAIN)
    public void doThis(IntentServiceResult intentServiceResult) {
        Toast.makeText(getActivity(), intentServiceResult.getValue(), Toast.LENGTH_SHORT).show();
    }*/


}
