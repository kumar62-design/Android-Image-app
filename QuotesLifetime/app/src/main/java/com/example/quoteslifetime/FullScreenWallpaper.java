package com.example.quoteslifetime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.io.IOException;

public class FullScreenWallpaper extends AppCompatActivity {

    String originalUrl;
    PhotoView photoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_wallpaper);

        getSupportActionBar().hide();

        Intent intent = getIntent();
        originalUrl = intent.getStringExtra("originalUrl");


        photoView = findViewById(R.id.photoView);
        Glide.with(this).load(originalUrl).into(photoView);

    }

    public void SetWallpaperEvent(View view) {

        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);

        Bitmap bitmap = ((BitmapDrawable)photoView.getDrawable()).getBitmap();

        try {
            wallpaperManager.setBitmap(bitmap);
            Toast.makeText(this, "wallpaper set", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}