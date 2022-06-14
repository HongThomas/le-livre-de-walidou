package com.android.LivreDeWalidou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.LivreDeWalidou.R;

public class MainActivity extends AppCompatActivity {
    Button load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load = findViewById(R.id.button2);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoadGameActivity.class);
                startActivity(intent);
            }
        });
    }
}