package com.example.facebooklogin;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener{

    Button btnClose;
    EditText txtFullName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
//        txtFullName = findViewById(R.id.FullName);

//        if(getIntent() != null){
//            txtFullName.setText(getIntent().getStringExtra("FullName"));
//        }

//        btnClose = findViewById(R.id.CloseButton);
//        btnClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getIntent().removeExtra("FullName");
//                finish();
//            }
//        });
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("John wick","john.wick@email.com",R.drawable.a));
        items.add(new Item("Robert j","robert.j@email.com",R.drawable.b));
        items.add(new Item("James Gunn","james.gunn@email.com",R.drawable.c));
        items.add(new Item("Ricky tales","rickey.tales@email.com",R.drawable.d));
        items.add(new Item("Micky mose","mickey.mouse@email.com",R.drawable.e));
        items.add(new Item("Pick War","pick.war@email.com",R.drawable.f));
        items.add(new Item("Leg piece","leg.piece@email.com",R.drawable.g));
        items.add(new Item("Apple Mac","apple.mac@email.com",R.drawable.g));
        items.add(new Item("John wick","john.wick@email.com",R.drawable.a));
        items.add(new Item("Robert j","robert.j@email.com",R.drawable.b));
        items.add(new Item("James Gunn","james.gunn@email.com",R.drawable.c));
        items.add(new Item("Ricky tales","rickey.tales@email.com",R.drawable.d));
        items.add(new Item("Micky mose","mickey.mouse@email.com",R.drawable.e));
        items.add(new Item("Pick War","pick.war@email.com",R.drawable.f));
        items.add(new Item("Leg piece","leg.piece@email.com",R.drawable.g));
        items.add(new Item("Apple Mac","apple.mac@email.com",R.drawable.g));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(getApplicationContext(),items);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Item item) {
        Intent intent = new Intent(HomePageActivity.this, ItemDetailActivity.class);
        intent.putExtra("item_name", item.getName());
        intent.putExtra("item_email", item.getEmail());
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), item.getImage());
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        intent.putExtra("item_image", byteArray);
        startActivity(intent);
    }
}
