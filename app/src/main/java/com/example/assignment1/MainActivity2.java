package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView textView,textView1;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView=findViewById(R.id.desc_img);

        textView=findViewById(R.id.textview);
        textView1=findViewById(R.id.textview1);

        imageView.setImageResource(getIntent().getIntExtra("img",0));

        textView.setText(getIntent().getStringExtra("Name"));
        textView1.setText(getIntent().getStringExtra("Age"));
    }
}