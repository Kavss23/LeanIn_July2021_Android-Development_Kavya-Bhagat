package com.example.a1.todo;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.content.ContextCompat;

import com.example.a1.todo.Test.Test;
import com.example.a1.todo.Utils.DatabaseHandler;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class NewTask extends BottomSheetDialogFragment {

    public static final String Tag ="ActionBottomDialog";
    private EditText newTaskText;
    private Button newSave;
    private DatabaseHandler db;

    public static NewTask newInstance(){
     return new NewTask();
    }
  @Override
    public  void onCreate(Bundle SavedInstance){
        super.onCreate(SavedInstance);
        setStyle(STYLE_NORMAL,R.style.DialogStyle);
  }

  @Override
    public void onViewCreated(View view,Bundle SavedInstance) {
      super.onViewCreated(view, SavedInstance);
      newTaskText = getView().findViewById(R.id.newText);
      newSave = getView().findViewById(R.id.newTask);

      db = new DatabaseHandler(getActivity());
      db.openDatabase();
      boolean isUpdate = false;
      final Bundle bundle = getArguments();
      if (bundle != null) {
          isUpdate = true;
          String task = bundle.getString("task");
          newTaskText.setText(task);
          if (task.length() > 0)
              newSave.setTextColor(ContextCompat.getColor(getContext(), R.color.pink));
      }
      newTaskText.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {

          }

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
              if (s.toString().equals("")) {
                  newSave.setEnabled(false);
                  newSave.setTextColor(Color.GRAY);
              } else {
                  newSave.setEnabled(true);
                  newSave.setTextColor(ContextCompat.getColor(getContext(), R.color.pink));
              }

          }

          @Override
          public void afterTextChanged(Editable s) {

          }
      });

      boolean finalIsUpdate = isUpdate;
      newSave.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String text = newTaskText.getText().toString();
              if (finalIsUpdate) {
                  db.updateTask(bundle.getInt("id"), text);
              } else {
                  Test task = new Test();
                  task.setT(text);
                  task.setSt(0);
              }
              dismiss();
          }
      });
  }
  @Override
          public void onDismiss(DialogInterface dialog){
          Activity activity=getActivity();
          if(activity instanceof  DialogCloseListener){
              ((DialogCloseListener)activity).handleDialogClose(dialog);
          }

    }
}
