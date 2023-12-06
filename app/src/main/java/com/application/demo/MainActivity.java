package com.application.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ComponentAdapter adapter = new ComponentAdapter(BasicComponentsListManager.getComponentList());
        RecyclerView rv = findViewById(R.id.rv);
        adapter.setListener(basicComponentsInfo -> startActivity(new Intent(MainActivity.this, basicComponentsInfo.targetCls)));
        rv.setAdapter(adapter);
    }

}