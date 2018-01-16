package romisfrag.whatshouldiplay.Display;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
    Resources resources;
    String getPackageName;

    public CardElemAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<CardElementListe> objects,
                           DisplayCards display_cards_activity, Resources resources, String packageName) {
        super(context, resource, objects);
        layoutresource = resource;
        liste = objects;
        this.resources = resources;
        displayCards = display_cards_activity;
        this.getPackageName = packageName;
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
        cardName.setPaintFlags(cardName.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        //putting the cost of the card
        final ImageView cardCost = (ImageView) convertView.findViewById(R.id.card_liste_cost);
        if(elem.getCost() >= 7){
            cardCost.setImageResource(R.drawable.cristal7);
        }
        else{
            int id =  resources.getIdentifier(("cristal"+elem.getCost()),"drawable",getPackageName);
            cardCost.setImageResource(id);
        }
        //putting the text of the card
        final TextView cardEffect = (TextView) convertView.findViewById(R.id.card_liste_effect);

        cardEffect.setText(Html.fromHtml(""+elem.getTexte()));



        //putting the icon of a card
        if(elem.minion){
            TextView attack_view = (TextView) convertView.findViewById(R.id.attack_adapteur);
            TextView defense_view = (TextView) convertView.findViewById(R.id.defense_adapteur);
            attack_view.setBackgroundResource(R.drawable.attack);
            defense_view.setBackgroundResource(R.drawable.health);
            attack_view.setText(""+elem.getAttack());
            defense_view.setText(""+elem.getHealth());
        }
        else{
            TextView attack_view = (TextView) convertView.findViewById(R.id.attack_adapteur);
            TextView defense_view = (TextView) convertView.findViewById(R.id.defense_adapteur);
            attack_view.setBackgroundResource(R.color.transparent);
            defense_view.setBackgroundResource(R.color.transparent);
            attack_view.setText("");
            defense_view.setText("");
        }

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
