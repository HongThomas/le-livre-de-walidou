package com.project.LivreDeWalidou.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.project.LivreDeWalidou.R;
import com.project.LivreDeWalidou.R;
import com.project.LivreDeWalidou.model.AppFolder;
import com.project.LivreDeWalidou.model.Game;
import com.project.LivreDeWalidou.model.IGame;
import com.project.LivreDeWalidou.model.IStory;
import com.project.LivreDeWalidou.model.Story;
import com.project.LivreDeWalidou.model.comp.Choice;
import com.project.LivreDeWalidou.model.comp.Page;
import com.project.LivreDeWalidou.model.comp.StoryImage;
import com.project.LivreDeWalidou.model.comp.StoryText;
import com.project.LivreDeWalidou.model.manager.GameManager;
import com.project.LivreDeWalidou.model.manager.GameManagerJson;
import com.project.LivreDeWalidou.model.manager.StoryManagerJson;
import com.project.LivreDeWalidou.model.repository.GameRepository;
import com.project.LivreDeWalidou.model.repository.IGameRepository;
import com.project.LivreDeWalidou.model.repository.IStoryRepository;
import com.project.LivreDeWalidou.model.repository.StoryRepository;

import java.io.File;
import java.net.URI;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    Button load;
    Button newg;
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
        newg = findViewById(R.id.button);
        newg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewGameActivity.class);
                startActivity(intent);
            }
        });
        AppFolder appFolder = new AppFolder(this.getApplication());

        //this.test();
    }

    public void test() {
        AssetManager am = this.getAssets();
        Log.d("PATH", String.valueOf(new ContextWrapper(this).getDataDir().getAbsolutePath()));

        Page node = new Page();

        node.addItem(new StoryText("Vous vous réveillez, vous avez les yeux collés et avez un léger mal de crâne (rien de grave)."));
        node.addItem(new StoryText("En vous levant vous vous rendez compte que vous ne connaissez pas les lieux. (Peut-être avez-vous bu hier, qui sait ?) Vous avez apparemment passé la nuit sous un magnifique chêne situé en haut d'une colline, a son pied plusieurs cadavres de bouteilles : Tequila, Vodka, Absinthe et compagnie... (Vous avez sûrement bu hier.). Dans votre tête, c'est le noir total, vous ne vous souvenez pas du tout comment vous êtes arrivé là (bizarre). Vous vous souvenez d'une chose, vous vous appelez Walidou.\n"));
        node.addItem(createNullImg());

        IStory story = new Story(node, new StoryText("Le livre de walidou"), new StoryImage(new File("").toURI()));

        Page partir = new Page();
        node.addChoice(new Choice(partir, new StoryText("Rester")));
        node.addChoice(new Choice(new Page(), new StoryText("Partir")));
        partir.addItem(new StoryText("Vous êtes définitivement complétement fou.. Vous auriez dû rester où vous êtes et attendre les secours. Vous avez clairement oublié qui vous êtes, on ne peut pas vous en vouloir."));
        partir.addItem(new StoryText("Trop tard maintenant (pas de chance).\n" +
                "\n" +
                "Un panneau indiquant deux directions se trouve en bas de la colline pas loin du chêne.")
        );
        partir.addChoice(new Choice(new Page(), new StoryText("Trop bien, allons voir !")));
        partir.addChoice(new Choice(new Page(), new StoryText("Partir dans la direction opposé au panneau dans les hautes herbes.")));

        File appFolder = new ContextWrapper(this.getApplication()).getFilesDir();
        Log.d("appFolder", appFolder.getAbsolutePath());
        IStoryRepository sr = new StoryRepository(new File(appFolder, "stories"));
        sr.addStory(story);

        IGame game = new Game(story, partir);
        IGameRepository gr = new GameRepository(new File(appFolder, "games"));
        gr.addGame(game);
    }

    private static StoryImage createNullImg() {
        return new StoryImage(new File("").toURI());
    }


}