package romisfrag.whatshouldiplay.Display;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import romisfrag.whatshouldiplay.GamePackage.GameInstance;
import romisfrag.whatshouldiplay.R;
import romisfrag.whatshouldiplay.Requester;

public class DisplayCardElem extends AppCompatActivity {

    GameInstance game_instance;
    CardElementListe card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_card_elem_layout);

        game_instance = (GameInstance) getIntent().getSerializableExtra("gameinstance");
        card = (CardElementListe) getIntent().getSerializableExtra("card");

        //getting the ressources
        TextView t = (TextView)findViewById(R.id.cardTitle);
        ImageView img = (ImageView)findViewById(R.id.card_image_view);

        t.setText(card.getName());

        Drawable png = LoadImageFromWebOperations(card.get_imageUrl());
        img.setImageDrawable(png);


    }

    public Drawable LoadImageFromWebOperations(String url) {
        String newurl = "http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_116.png";
        //we first try to get the image from the url
        try {
            URL o_url = new URL(newurl);
            //InputStream is = (InputStream) new URL(newurl).getContent();
            InputStream is = null;
            URLConnection c = o_url.openConnection();
            c.getContent();


            //and then convert it to a drawable object
            try{
                Drawable d = Drawable.createFromStream(is,"lol");
                return d;
            } catch (Exception e){
                Toast.makeText(this, "Can't Drawable", Toast.LENGTH_SHORT).show();
                return null;
            }
        } catch (MalformedURLException e) {
            Toast.makeText(this, "Bad URL", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Error" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        } catch (Exception e){
            Toast.makeText(this, "Can't load stream", Toast.LENGTH_SHORT).show();
            return null;
        }

    }


}
