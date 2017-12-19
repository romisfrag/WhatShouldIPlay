package romisfrag.whatshouldiplay.Display;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import romisfrag.whatshouldiplay.ApplicationCustom;
import romisfrag.whatshouldiplay.GamePackage.GameInstance;
import romisfrag.whatshouldiplay.R;

public class DisplayCardElem extends AppCompatActivity {

    GameInstance game_instance;
    CardElementListe card;
    int nbTry;
    ApplicationCustom app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_card_elem_layout);

        app = (ApplicationCustom)getApplication();
        nbTry = 5;

        game_instance = (GameInstance) getIntent().getSerializableExtra("gameinstance");
        card = (CardElementListe) getIntent().getSerializableExtra("card");

        //getting the ressources
        TextView t = (TextView)findViewById(R.id.cardTitle);
        ImageView img = (ImageView)findViewById(R.id.card_image_view);
        GifImageView img_gold = (GifImageView)findViewById(R.id.card_gif_view);
        //useless
        TextView raceText = (TextView)findViewById(R.id.card_race);
        TextView attackText = (TextView)findViewById(R.id.card_attack);
        TextView healthText = (TextView)findViewById(R.id.card_health);
        TextView flavorText = (TextView)findViewById(R.id.card_flavor);


        t.setText(card.getName());

        raceText.setText(card.getRace().toString());
        attackText.setText(""+card.getAttack());
        healthText.setText(""+card.getHealth());
        flavorText.setText(""+card.getTexte());
        // call to asynchronous task
        callImageLoader();
    }

    public void displayImg(Bitmap bitmap){
        ImageView img = (ImageView)findViewById(R.id.card_image_view);
        img.setImageBitmap(bitmap);
    }


    public void displayGif(GifDrawable is){
        GifImageView img_gold = (GifImageView)findViewById(R.id.card_gif_view);
        img_gold.setImageDrawable(is);
    }

    public void callImageLoader(){
        if(nbTry >= 0) {
            nbTry--;
            if (app.getGoldMode()) {
                Toast.makeText(app, "gold" + card.getGold_url(), Toast.LENGTH_SHORT).show();
                new ImageLoader(this, card.getGold_url(), true).execute();
            } else {
                Toast.makeText(app, "pasglod", Toast.LENGTH_SHORT).show();
                new ImageLoader(this, card.get_imageUrl(), false).execute();
            }
        }
        else{
            Toast.makeText(app, "All try done but can't load image", Toast.LENGTH_SHORT).show();
        }
    }


}
