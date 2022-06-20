package com.android.LivreDeWalidou.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.LivreDeWalidou.R;
import com.android.LivreDeWalidou.model.Game;
import com.android.LivreDeWalidou.model.comp.StoryImage;
import com.android.LivreDeWalidou.viewmodel.LoadGameViewModel;

import java.util.ArrayList;
import java.util.List;

public class LoadGameActivity extends AppCompatActivity {
    private LoadGameViewModel loadGameController;
    private Game currentGame;
    private List<ImageButton> gameLoadedButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_game);
        /*
        gameLoadedButtons = this.buildGameButtons(loadGameController.getRepositoryGames());
        gameLoadedButtons
                .stream()
                .map(bitmap -> bitmap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        currentGame = loadGameController.loadGame(gameSelected);
                        Intent intent = new Intent(LoadGameActivity.this, GameActivity.class);
                        intent.putExtra("game", currentGame);
                        startActivity(intent);
                    }
                }));
         */
    }
    /*
    public List<ImageButton> buildGameButtons(List<Game> games) {
        List<ImageButton> gameButtons = new ArrayList<>();
        games.stream().map(game ->
            gameButtons.add(new ImageButton(this))
        );

        gameButtons.stream().map(gameButton -> gameButton.setImageBitmap());

        return gameButtons;
    }
     */

    public void setCurrentGame(Game game) {
        this.currentGame = game;
    }

    public void goBack(View view){
        finish();
    }
}