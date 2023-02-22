package com.example.menuandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
    ImageView imgView;
    Button btnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView = findViewById(R.id.imageView);
        btnPopup = findViewById(R.id.showPopup);
        registerForContextMenu(imgView);
        btnPopup.setOnClickListener(click);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    };

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        if(v.getId()==R.id.imageView){
            inflater.inflate(R.menu.context_menu_img,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(MainActivity.this,ChonMenu.class);
        String x = item.getTitle().toString();
        intent.putExtra("anh",x);
        startActivity(intent);
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(MainActivity.this,ChonMenu.class);
        String x = item.getTitle().toString();
        intent.putExtra("luachon",x);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.showPopup:
                    PopupMenu newPopUpMenu = new PopupMenu(MainActivity.this,view);
                    newPopUpMenu.inflate(R.menu.popup_menu);
                    newPopUpMenu.show();
                    newPopUpMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            Intent intent =new Intent(MainActivity.this,ChonMenu.class);
                            String s = menuItem.getTitle().toString();
                            intent.putExtra("popup",s);
                            startActivity(intent);
                            return false;
                        }
                    });
                    break;
            }
        }
    };
}