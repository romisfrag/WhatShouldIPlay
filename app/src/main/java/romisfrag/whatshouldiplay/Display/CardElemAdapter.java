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
        //putting the text of the element
        final TextView textElem = (TextView) convertView.findViewById(R.id.texte_carte_elem_liste);
        textElem.setText(elem.getName());
        //making the listener on the element of the list view
        convertView.setOnClickListener(new View.OnClickListener() {
            //TODO :: solve this problem
            @Override
            public void onClick(View v) {
                Toast.makeText(displayCards, "onClick " + tempElem.get_imageUrl(), Toast.LENGTH_SHORT).show();
                displayCards.diplayCard(tempElem);
            }
        });




        return convertView;
    }

}
