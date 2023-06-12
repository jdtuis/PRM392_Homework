package com.example.facebooklogin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {

    TextView txtName, txtEmail;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_page);
        txtName = findViewById(R.id.item_name);
        txtEmail = findViewById(R.id.item_email);
        image = findViewById(R.id.item_image);
        if(getIntent() != null){
            txtName.setText(getIntent().getStringExtra("item_name"));
            txtEmail.setText(getIntent().getStringExtra("item_email"));
            byte[] byteArray = getIntent().getByteArrayExtra("item_image");
            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            image.setImageBitmap(bmp);
        }
    }
}
