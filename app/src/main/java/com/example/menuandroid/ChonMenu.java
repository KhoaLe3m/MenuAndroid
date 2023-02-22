package com.example.menuandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ChonMenu extends AppCompatActivity {
    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_menu);
        textView = findViewById(R.id.choose);
        Intent intent = getIntent();
        if(intent.hasExtra("anh")){
            String s = intent.getStringExtra("anh");
            textView.setText("Bạn đã chọn ContextMenu  độ khó : " + s);
        }else if(intent.hasExtra("luachon")){
            String k = intent.getStringExtra("luachon");
            textView.setText("Bạn đã chọn Option menu item số  : " + k);
        }else if(intent.hasExtra("popup")){
            String k = intent.getStringExtra("popup");
            textView.setText("Bạn đã chọn popup item số " + k);
        }

    }
}