package com.example.berna.seccion3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.berna.seccion3.Adapters.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_main;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_main = (RecyclerView) findViewById(R.id.rv_main);

        names = this.getAllNames();
        //Tipos de diseño
        layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager = new GridLayoutManager(getApplicationContext(),3);
        layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        MyAdapter myAdapter = new MyAdapter(names, R.layout.recicler_item, new MyAdapter.onItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                message(name+" - "+position);
            }
        });
        rv_main.setHasFixedSize(true);
        rv_main.setItemAnimator(new DefaultItemAnimator());
        rv_main.setLayoutManager(layoutManager);
        rv_main.setAdapter(myAdapter);
    }

    private List<String> getAllNames(){
        return new ArrayList<String>(){{
            add("Bernardo");
            add("Carla");
            add("Daniela");
        }};
    }
    private void message(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
