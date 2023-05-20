package com.example.videosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.videosapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<model> arrayList = new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        getSupportActionBar().hide();
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getTheme().applyStyle(R.style.FullScreen, false);
        arrayList.add(new model("android.resource://"+getPackageName()+"/" + R.raw.a,R.drawable.woman, "Riya"));
        arrayList.add(new model("android.resource://"+getPackageName()+"/" + R.raw.b,R.drawable.woman, "Riya"));
        arrayList.add(new model("android.resource://"+getPackageName()+"/" + R.raw.c,R.drawable.woman, "Riya"));
        arrayList.add(new model("android.resource://"+getPackageName()+"/" + R.raw.d,R.drawable.woman, "Riya"));
        arrayList.add(new model("android.resource://"+getPackageName()+"/" + R.raw.e,R.drawable.woman, "Riya"));
        adapter= new Adapter(MainActivity.this, arrayList);
        binding.ViewPager2.setAdapter(adapter);
    }
}