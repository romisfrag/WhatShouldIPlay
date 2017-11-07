package romisfrag.whatshouldiplay.Display;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import romisfrag.whatshouldiplay.GamePackage.GameInstance;
import romisfrag.whatshouldiplay.Interfaces.UseRequester;
import romisfrag.whatshouldiplay.JsonTransformer;
import romisfrag.whatshouldiplay.R;
import romisfrag.whatshouldiplay.input_output.Requester;


public class DisplayCards extends AppCompatActivity {

    GameInstance game_instance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_card_layout);

        game_instance = (GameInstance) getIntent().getSerializableExtra("gameinstance");

        /*final ArrayList<CardElementListe> listeOfCard = new ArrayList<CardElementListe>();
        listeOfCard.add(new CardElementListe("lol", 1));
        for (int i = 0; i < 50; i++) {
            listeOfCard.add(new CardElementListe("lol", 1));
        }*/


        final TextView t = (TextView) findViewById(R.id.test);



        //starting the request
        // TODO :: use the good informations from gameInstance to load the card
        displayListe(game_instance.get_listeCard());
        t.setText("Loaded");

    }





    //affiche la liste fournie en argument
    public void displayListe(ArrayList<CardElementListe> listeOfCard) {
        final ListView lView = (ListView) findViewById(R.id.display_card_liste);
        final CardElemAdapter elemAdapter =
                new CardElemAdapter(this, R.layout.carte_elem_liste,listeOfCard,this);
        lView.setAdapter(elemAdapter);

    }

    //this is uses by the element of the list to start a new activity
    public void diplayCard(CardElementListe elem){
        Intent i = new Intent(DisplayCards.this,DisplayCardElem.class);
        i.putExtra("gameinstance", game_instance);
        i.putExtra("card",elem);
        startActivity(i);
    }

}
