package com.frantic.green;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

public class EventActivity extends AppCompatActivity {
    private EventBus bus = EventBus.getDefault();
    private TextView view;
    ChargingEvent event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_event);

        view = new TextView(this);

        view.setTextSize(20f);
        view.setPadding(20, 20, 20, 20);
        view.setText("Waiting for events...");

        //setContentView(view);

        // Register as a subscriber
        bus.register(this);

    }
    @Override
    protected void onDestroy() {
        bus.unregister(this);
        super.onDestroy();
    }

    public void onEvent(ChargingEvent event){
        view.setText(view.getText() + "\n" + event.getData());
    }
}
