package com.project.LivreDeWalidou.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.project.LivreDeWalidou.R;
import com.project.LivreDeWalidou.model.IStory;
import com.project.LivreDeWalidou.viewmodel.NewGameViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NewGameActivity extends AppCompatActivity implements PropertyChangeListener {

    private LinearLayout storiesList;
    private NewGameViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        this.storiesList = this.findViewById(R.id.stories_list);
        this.vm = new NewGameViewModel(this.getApplication());
        this.setStories();
    }

    public void goBack(View view){
        finish();
    }

    private void setStories() {
        this.storiesList.removeAllViews();
        for (IStory story : this.vm.getStories()) {
            ImageView ib;
            ib = this.getImageButtonFromStory(story);
            this.storiesList.addView(ib);
        }
    }

    public ImageView getImageButtonFromStory(IStory story) {
        ImageView ib = new ImageButton(this.getApplicationContext());
        ib.setImageBitmap(story.getBackground().getContent());

        int dps = 500;
        final float scale = this.getResources().getDisplayMetrics().density;
        int pixels = (int) (dps * scale + 0.5f);
        ib.setMaxHeight(200);

        ib.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dps,
                1f));
        ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) ib.getLayoutParams();
        margin.setMargins(-30,0,-30,0);
        ib.setLayoutParams(margin);
        ib.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ib.setVisibility(View.VISIBLE);
        ib.setBackgroundResource(0);

        return ib;
    }
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }
}