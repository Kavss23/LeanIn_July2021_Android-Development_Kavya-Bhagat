package com.example.a1.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.example.a1.todo.Test.Test;
import com.example.a1.todo.Test2.Test2;
import com.example.a1.todo.Utils.DatabaseHandler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static androidx.recyclerview.widget.ItemTouchHelper.*;

public class MainActivity extends AppCompatActivity implements DialogCloseListener{


    private RecyclerView R1;
    private Test2 adapter;
    private FloatingActionButton f;
    private List<Test> List;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        db=new DatabaseHandler(this);
        db.openDatabase();



        R1=findViewById(R.id.recyclerview);
        R1.setLayoutManager(new LinearLayoutManager(this));
        adapter=new Test2(db,this);
        R1.setAdapter(adapter);

        f=findViewById(R.id.floating);
        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new RecyclerTouchHelper(adapter));
        itemTouchHelper.attachToRecyclerView(R1);


       List=db.getTasks();
       Collections.reverse(List);
       adapter.setTasks(List);

       f.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               NewTask.newInstance().show(getSupportFragmentManager(),NewTask.Tag);
           }
       });

    }
    @Override
    public void handleDialogClose(DialogInterface dialog){
        List=db.getTasks();
        Collections.reverse(List);
        adapter.setTasks(List);
        adapter.notifyDataSetChanged();
    }
}