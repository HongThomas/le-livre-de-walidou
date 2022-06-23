package com.project.LivreDeWalidou.view;

import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.LivreDeWalidou.R;
import com.project.LivreDeWalidou.model.Game;
import com.project.LivreDeWalidou.model.IGame;
import com.project.LivreDeWalidou.model.IStory;
import com.project.LivreDeWalidou.model.Story;
import com.project.LivreDeWalidou.model.comp.Choice;
import com.project.LivreDeWalidou.model.comp.Page;
import com.project.LivreDeWalidou.model.comp.StoryImage;
import com.project.LivreDeWalidou.model.comp.StoryText;
import com.project.LivreDeWalidou.model.repository.GameRepository;
import com.project.LivreDeWalidou.model.repository.IGameRepository;
import com.project.LivreDeWalidou.model.repository.IStoryRepository;
import com.project.LivreDeWalidou.model.repository.StoryRepository;

import java.io.File;
import java.util.List;


public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        TextView texte = (TextView) findViewById(R.id.texte_story);
        texte.setText("Test");

    }

    public void test() {
        AssetManager am = this.getAssets();
        Log.d("PATH", String.valueOf(new ContextWrapper(this).getDataDir().getAbsolutePath()));

        Page node = new Page();

        node.addItem(new StoryText("Vous vous réveillez, vous avez les yeux collés et avez un léger" +
                " mal de crâne (rien de grave)."));
        node.addItem(new StoryText("En vous levant vous vous rendez compte que vous ne " +
                "connaissez pas les lieux. (Peut-être avez-vous bu hier, qui sait ?) Vous avez apparemment " +
                "passé la nuit sous un magnifique chêne situé en haut d'une colline, a son pied plusieurs " +
                "cadavres de bouteilles : Tequila, Vodka, Absinthe et compagnie... (Vous avez sûrement bu hier.)." +
                " Dans votre tête, c'est le noir total, vous ne vous souvenez pas du tout comment vous êtes arrivé" +
                " là (bizarre). Vous vous souvenez d'une chose, vous vous appelez Walidou.\n"));
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
        /*
        final ImageView image = findViewById(R.id.game_image);
        image.setImageBitmap(story.getBackground().getContent());


        final Button choix_un = (Button) findViewById(R.id.choix_un);
        choix_un.setText("game.getCurrentPage().getChoices().get(0).toString()");

        final Button choix_deux = (Button) findViewById(R.id.choix_deux);
        choix_deux.setText("game.getCurrentPage().getChoices().get(1).toString()");

        final Button choix_trois = (Button) findViewById(R.id.choix_trois);
        choix_trois.setText("game.getCurrentPage().getChoices().get(2).toString()");

         */
    }

    private static StoryImage createNullImg() {
        return new StoryImage(new File("").toURI());
    }

    public void goBack(View view){
        finish();
    }
}