package romisfrag.whatshouldiplay.Display;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;

import romisfrag.whatshouldiplay.Enumerations.Race;
import romisfrag.whatshouldiplay.Enumerations.Ranking;
import romisfrag.whatshouldiplay.GamePackage.GameInstance;
import romisfrag.whatshouldiplay.R;
import romisfrag.whatshouldiplay.sortList.Filters;

import static romisfrag.whatshouldiplay.Enumerations.EnumerationTools.ArrayListFromEnum;
import static romisfrag.whatshouldiplay.Enumerations.Race.raceFromString;
import static romisfrag.whatshouldiplay.sortList.RankingSort.rankBy;


public class DisplayCards extends AppCompatActivity {

    GameInstance game_instance;
    SlidingUpPanelLayout slidingUpPanelLayout;
    Filters filters;
    CardElemAdapter elemAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_cards_layout);

        game_instance = (GameInstance) getIntent().getSerializableExtra("gameinstance");
        filters = new Filters(game_instance.get_game_class(),game_instance.get_game_mode());



        //setting up the panel listeners
        slidingUpPanelLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        slidingUpPanelLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                switch(newState) {
                    case EXPANDED:
                        Toast.makeText(getApplicationContext(), "EXPANDED", Toast.LENGTH_SHORT).show();

                        break;
                    case COLLAPSED:
                        Toast.makeText(getApplicationContext(), "COLLAPSED", Toast.LENGTH_SHORT).show();
                        game_instance.performAdvancedSort(filters);
                        displayListe(game_instance.get_listeCard());
                        break;
                    default:
                }
            }
        });

        //Initializing the spinner for sorting list
        Spinner sort_spinner = (Spinner) findViewById(R.id.sort_spinner);
        final ArrayList<String> ranking_liste = ArrayListFromEnum(Ranking.values());
        ArrayAdapter<String> spinner_adapter_ranking = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item, ranking_liste);
        sort_spinner.setAdapter(spinner_adapter_ranking);
        sort_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                rankBy(ranking_liste.get(position),game_instance.get_listeCard());
                elemAdapter.notifyDataSetChanged();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        /*----------------------------Hiden Panel-------------------------------*/
        //Cost Listeners
        Button left = (Button) findViewById(R.id.leftCost);
        Button right = (Button) findViewById(R.id.rightCost);
        final TextView costTexte = (TextView) findViewById(R.id.costTexte);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filters.decrCost();
                costTexte.setText(""+filters.getCost());
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filters.incrCost();
                costTexte.setText(""+filters.getCost());
            }
        });

        //Race spinner
        Spinner spinner = (Spinner) findViewById(R.id.race_spinner);
        final ArrayList<String> liste_spinner = ArrayListFromEnum(Race.values());
        ArrayAdapter<String> spinner_adapter = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item, liste_spinner);
        spinner.setAdapter(spinner_adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Race r = raceFromString(liste_spinner.get(position));
                filters.setRace(r);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //starting the request
        displayListe(game_instance.get_listeCard());

    }





    //affiche la liste fournie en argument
    public void displayListe(ArrayList<CardElementListe> listeOfCard) {
        final ListView lView = (ListView) findViewById(R.id.display_card_liste);
        elemAdapter =
                new CardElemAdapter(this, R.layout.carte_elem_liste,listeOfCard,this);
        lView.setAdapter(elemAdapter);
        elemAdapter.notifyDataSetChanged();

    }

    //this is uses by the element of the list to start a new activity
    public void diplayCard(CardElementListe elem){
        Intent i = new Intent(DisplayCards.this,DisplayCardElem.class);
        i.putExtra("gameinstance", game_instance);
        i.putExtra("card",elem);
        startActivity(i);
    }

}
