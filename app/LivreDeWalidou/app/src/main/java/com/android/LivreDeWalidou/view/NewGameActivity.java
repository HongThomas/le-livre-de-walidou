package com.android.LivreDeWalidou.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.android.LivreDeWalidou.R;

public class NewGameActivity extends AppCompatActivity {
    private Button drunkStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        this.drunkStory = findViewById(R.id.story_drunk);
        this.drunkStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewGameActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
    }

    public void goBack(View view){
        finish();
    }
}