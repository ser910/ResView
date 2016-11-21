package com.degtyar.sergey.resview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    private List<String> dataset = new ArrayList<String>();

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        if(recyclerView == null) return;
        //Если нет динамических элементов меняющих размер
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

        fillDataset();
        adapter = new MyAdapter(dataset, callback);
        recyclerView.setAdapter(adapter);
    }

    private void fillDataset() {
        dataset.add("asdf");
        dataset.add("ijhbg");
        dataset.add("mnjytrfb");
        dataset.add("dgoijs");
        dataset.add("grhsgrlf");
        dataset.add("mnjytrfb");
        dataset.add("dgoijs");
        dataset.add("grhsgrlf");
    }
    private RecyclerViewCallback callback = new RecyclerViewCallback() {
        @Override
        public void onClick(int position) {
            Toast.makeText(MainActivity.this, "click item "+dataset.get(position),Toast.LENGTH_SHORT).show();
        }
    };
}
