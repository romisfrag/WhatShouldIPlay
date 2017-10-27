package romisfrag.whatshouldiplay;

import java.util.ArrayList;

import romisfrag.whatshouldiplay.Display.CardElementListe;

/**
 * Created by delgado on 16/10/17.
 */

//All the methode of this don't destruct the initial list they create a new one
public class DataSorting {



    public ArrayList<CardElementListe> OnlyCost(ArrayList<CardElementListe> liste, int cost){

        ArrayList<CardElementListe> res = new ArrayList<CardElementListe>();

        for(CardElementListe elem : liste){
            if(elem.getCost() == cost){
                res.add(elem);
            }
        }

        return res;
    }




}
