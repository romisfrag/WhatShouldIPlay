package romisfrag.whatshouldiplay.Display;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import static android.view.View.VISIBLE;

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

        // call to asynchronous task
        new ImageLoader(card.get_imageUrl(), img).execute();

    }

}
