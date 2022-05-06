package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrContact= new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerContactAdapter adapter;
    FloatingActionButton btnOpenDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerContact);
        btnOpenDialog=findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog =new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update);
                EditText edtName= dialog.findViewById(R.id.edtName);
                EditText edtAge= dialog.findViewById(R.id.edtAge);

                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "", age = "", address ="";

                        if(!edtName.getText().toString().equals("")){
                            name= edtName.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this,"Pleace Enter Name", Toast.LENGTH_SHORT).show();
                        }

                        if(!edtAge.getText().toString().equals("")){
                            age =edtAge.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this,"Pleace Enter Age", Toast.LENGTH_SHORT).show();
                        }
                        arrContact.add(new ContactModel(name , age, address));

                        adapter.notifyItemInserted(arrContact.size()-1);

                        recyclerView.scrollToPosition(arrContact.size()-1);

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //ContactModel model =new ContactModel(R.drawable.b,"A","25");

        arrContact.add(new ContactModel(R.drawable.b,"A","25","kanpur"));
        arrContact.add(new ContactModel(R.drawable.c,"B","20","India"));
        arrContact.add(new ContactModel(R.drawable.i,"C","22","Delhi"));
        arrContact.add(new ContactModel(R.drawable.f,"D","29","UP"));
        arrContact.add(new ContactModel(R.drawable.g,"E","50","MP"));
        arrContact.add(new ContactModel(R.drawable.h,"F","32","UP"));
        arrContact.add(new ContactModel(R.drawable.i,"G","36","Lucknow"));
        arrContact.add(new ContactModel(R.drawable.g,"H","50","New Delhi"));
        arrContact.add(new ContactModel(R.drawable.h,"I","32","Delhi"));
        arrContact.add(new ContactModel(R.drawable.i,"J","36","New"));


        adapter =new RecyclerContactAdapter(this,arrContact);
        recyclerView.setAdapter(adapter);
    }
}