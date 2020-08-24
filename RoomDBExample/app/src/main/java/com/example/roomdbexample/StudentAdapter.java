package com.example.roomdbexample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    Context c;
    List<Student_entity> list;
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.every_row_design,parent,false);
        return new StudentViewHolder(v);
    }

    public StudentAdapter(Context c, List<Student_entity> list) {
        this.c = c;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
          holder.name.setText(list.get(position).getName());
          holder.rollnumber.setText(list.get(position).getRollno());
          holder.s_delete.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                 // MainActivity.dataBase.studentDAO().delete(list.get(position));
                MainActivity.viewModel.delete(list.get(position));
              }
          });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
         TextView name,rollnumber,edit,s_delete;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tv_name);
            rollnumber=itemView.findViewById(R.id.tv_rollnumber);
            edit=itemView.findViewById(R.id.edit);
            s_delete=itemView.findViewById(R.id.delete);
            edit.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    String n=name.getText().toString();
                    String r=rollnumber.getText().toString();
                    Intent i=new Intent(c,UpdateActivity.class);
                    i.putExtra("name",n);
                    i.putExtra("rollno",r);
                    c.startActivity(i);
                }
            });
        }
    }
}
