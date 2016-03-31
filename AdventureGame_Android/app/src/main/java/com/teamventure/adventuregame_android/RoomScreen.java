package com.teamventure.adventuregame_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import cs314_A4.*;

public class RoomScreen extends AppCompatActivity {

    AdventureGameModelFacade model;
    String description;
    TextView textView;
    String[] items;
    Spinner dropdown;
    String[] hands;
    Spinner dropdown2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        model = new AdventureGameModelFacade();

        description = model.getView() + "\n" + model.getItems();
        textView = new TextView(this);
        textView.setTextSize(15);
        textView.setText(description);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);

        dropdown = (Spinner)findViewById(R.id.AddItem);
        items = model.getContents();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        dropdown2 = (Spinner)findViewById(R.id.DropItem);
        hands = model.getHands();
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, hands);
        dropdown2.setAdapter(adapter2);
    }

    public void refreshText(String desc){
        description = desc;
        textView.setText(description + "\n" + model.getItems());

        items = model.getContents();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        hands = model.getHands();
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, hands);
        dropdown2.setAdapter(adapter2);

    }

    public void clickWest(View view){
        model.goWest();
        refreshText(model.getView());
    }

    public void clickEast(View view){
        model.goEast();
        refreshText(model.getView());
    }

    public void clickUp(View view){
        model.goUp();
        refreshText(model.getView());
    }

    public void clickDown(View view){
        model.goDown();
        refreshText(model.getView());
    }

    public void clickNorth(View view){
        model.goNorth();
        refreshText(model.getView());
    }

    public void clickSouth(View view){
        model.goSouth();
        refreshText(model.getView());
    }

    public void clickGrab(View view){
        int selected = dropdown.getSelectedItemPosition()+1;
        model.pickupItem(selected);
        refreshText(model.getView());
    }

    public void clickDrop(View view){
        int selected = dropdown2.getSelectedItemPosition()+1;
        model.dropItem(selected);
        refreshText(model.getView());
    }
}
