package com.jav1001.vinaysingh.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList dataModels;
    ListView listView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        TextInputEditText editText = (TextInputEditText) findViewById(R.id.textInputEditText);
        dataModels = new ArrayList();

        dataModels.add(new DataModel("Hello World", true));
        dataModels.add(new DataModel("Get Apples", false));


        adapter = new CustomAdapter(dataModels, getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                DataModel dataModel= (DataModel) dataModels.get(position);
                dataModels.remove(position);
                adapter = new CustomAdapter(dataModels, getApplicationContext());

                listView.setAdapter(adapter);



            }
        });

        Button addButton = (Button) findViewById(R.id.button);
        addButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        System.out.println("CLICK");
                        dataModels.add(new DataModel(editText.getText().toString(), false));
                        adapter = new CustomAdapter(dataModels, getApplicationContext());

                        listView.setAdapter(adapter);

                    }
                });
            }
}