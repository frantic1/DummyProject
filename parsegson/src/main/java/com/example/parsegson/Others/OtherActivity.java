package com.example.parsegson.Others;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.parsegson.R;
import com.example.parsegson.Test;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class OtherActivity extends AppCompatActivity {

    String data ;
    TextView textView;
    RequestQueue requestQueue;
    StringBuffer stringBuffer;
    String Base_Url = "http://192.168.82.2/travel/public/api/v1/category";
    List<Data> dataList;
    ListView listView;
    List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        data = getResources().getString(R.string.json);
        //Log.d("json",data);
        //categoryList = new ArrayList<>();
        names=new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        dataList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.lister);
        volleyReq();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),dataList.get(position).getId(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void volleyReq() {
        StringRequest request =new StringRequest(Request.Method.GET, Base_Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response",response);
                Gson gson = new Gson();
                Category category = gson.fromJson(response,Category.class);
                String status = category.status;
                Log.d("statussss",status);
                System.out.println(category);
                dataList = category.data;
                //Log.d("data",dataList.toString());

                for (int i = 0; i < dataList.size(); i++) {
                    //Log.d("values",dataList.get(i).getName() +"\n"+dataList.get(i).getShort_text()+"\n");
                    names.add(dataList.get(i).getName());
                    //Log.d("name",names.get(i));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(request);
    }
}
