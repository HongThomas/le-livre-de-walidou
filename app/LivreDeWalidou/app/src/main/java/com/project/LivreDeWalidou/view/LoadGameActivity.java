package com.project.LivreDeWalidou.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.project.LivreDeWalidou.R;
import com.project.LivreDeWalidou.model.Game;
import com.project.LivreDeWalidou.viewmodel.LoadGameViewModel;

import java.util.List;

public class LoadGameActivity extends AppCompatActivity {
    private LoadGameViewModel loadGameController;
    private Game currentGame;
    private List<ImageView> gameLoadedButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_game);
        /*gameLoadedButtons = this.buildGameButtons(loadGameController.getGames());
        gameLoadedButtons
                .stream()
                .map(button -> button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        currentGame = loadGameController.loadGame(gameSelected);
                        Intent intent = new Intent(LoadGameActivity.this, GameActivity.class);
                        intent.putExtra("game", currentGame);
                        startActivity(intent);
                    }
                }));*/
    }

    /*public List<ImageView> buildGameButtons(List<Game> games) {
        List<ImageView> gameButtons;
        games.forEach(game -> {
            gameButtons.add(new ImageView(game.getImage()));
        });

        return gameButtons;
    }*/

    public void setCurrentGame(Game game) {
        this.currentGame = game;
    }

    public void goBack(View view){
        finish();
    }
}