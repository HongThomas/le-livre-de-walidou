package com.project.LivreDeWalidou.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.project.LivreDeWalidou.R;

public class NewGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void goBack(View view){
        finish();
    }
}