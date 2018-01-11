package romisfrag.whatshouldiplay.Display;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import romisfrag.whatshouldiplay.GamePackage.ParameterMenu;
import romisfrag.whatshouldiplay.R;

/**
 * Created by delgado on 16/10/17.
 */

public class CardElemAdapter extends ArrayAdapter<CardElementListe> {

    final List<CardElementListe> liste;
    final int layoutresource;
    DisplayCards displayCards;
    CardElementListe elem;

    public CardElemAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<CardElementListe> objects,
                           DisplayCards display_cards_activity) {
        super(context, resource, objects);
        layoutresource = resource;
        liste = objects;
        displayCards = display_cards_activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layoutresource,null);
        }
        //getting the element of the list
        elem = liste.get(position);
        final CardElementListe tempElem = elem;
        //putting the name of the card
        final TextView cardName = (TextView) convertView.findViewById(R.id.card_liste_name);
        cardName.setText(""+elem.getName());
        //putting the cost of the card
        final TextView cardCost = (TextView) convertView.findViewById(R.id.card_liste_cost);
        cardCost.setText(""+elem.getCost());
        //putting the text of the card
        final TextView cardEffect = (TextView) convertView.findViewById(R.id.card_liste_effect);
        cardEffect.setText(""+elem.getTexte());

        /*
        <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/card_liste_name"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/card_liste_effect"/>

    </LinearLayout>
         */

        //making the listener on the element of the list view
        convertView.setOnClickListener(new View.OnClickListener() {
            //TODO :: solve this problem
            @Override
            public void onClick(View v) {
//                Toast.makeText(displayCards, "onClick " + tempElem.get_imageUrl(), Toast.LENGTH_SHORT).show();
                displayCards.diplayCard(tempElem);
            }
        });




        return convertView;
    }

}
