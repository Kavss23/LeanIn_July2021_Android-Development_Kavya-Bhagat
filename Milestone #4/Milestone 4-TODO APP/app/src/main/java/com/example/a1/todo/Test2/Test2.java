package com.example.a1.todo.Test2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.recyclerview.widget.RecyclerView;

import com.example.a1.todo.MainActivity;
import com.example.a1.todo.NewTask;
import com.example.a1.todo.R;
import com.example.a1.todo.Test.Test;
import com.example.a1.todo.Utils.DatabaseHandler;

import java.util.List;

public class Test2 extends RecyclerView.Adapter<Test2.ViewHolder> {


    private List<Test> todoList;
    private MainActivity main;
    private DatabaseHandler db;

    public Test2(DatabaseHandler db, MainActivity main){
        this.db= this.db;
        this.main=main;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int view){
        View item= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_customize,parent,false);
        return new ViewHolder(item);
    }

    public void onBindViewHolder(ViewHolder hold,int pos){
        db.openDatabase();
        Test item=todoList.get(pos);
        hold.check.setText(item.getT());
        hold.check.setChecked(toBoolean(item.getSt()));
        hold.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    db.updateStatus(item.getId(),1);
                }
                else{
                    db.updateStatus(item.getId(),0);
                }
            }


        });
    }

    public int getItemCount(){
        return todoList.size();
    }

    private boolean toBoolean(int n) {
        return n!=0;
    }

    public void setTasks(List<Test> todoList){
        this.todoList=todoList;
        notifyDataSetChanged();
    }

public Context getContext(){
        return main;
}

public void deleteItem(int pos){
        Test item=todoList.get(pos);
        db.deleteTask(item.getId());
        todoList.remove(pos);
        notifyItemRemoved(pos);
}

public void editItem(int pos){
        Test item=todoList.get(pos);
    Bundle bundle=new Bundle();
    bundle.putInt("id",item.getId());
    bundle.putString("task",item.getT());
    NewTask fragment=new NewTask();
    fragment.setArguments(bundle);
    fragment.show(main.getSupportFragmentManager(),NewTask.Tag);
}
    public static class ViewHolder extends RecyclerView.ViewHolder{

    CheckBox check;
        ViewHolder(View view){
            super(view);
            check=view.findViewById(R.id.checkbox);
        }

}


}
