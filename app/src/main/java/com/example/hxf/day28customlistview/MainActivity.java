package com.example.hxf.day28customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> datas;
    String[] strings={
            "A","B","C","D","E","F","G","H","I","J","K","L","M",
            "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
    };
    MyList myList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList= (MyList) findViewById(R.id.listviewId);
//        initView();
        initData();
        adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.item_listview);

    }

    private void initView() {

    }

    private void initData() {
        datas=new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            datas.add(strings[(int) (Math.random()*strings.length)]+"天道");
        }
    }


}
