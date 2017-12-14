package romisfrag.whatshouldiplay.sortList;

import java.util.ArrayList;

import romisfrag.whatshouldiplay.Display.CardElementListe;
import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Race;

/**
 * Created by 3364533 on 12/12/17.
 */

public class AdvancedSort {

    static public ArrayList<CardElementListe> sortByCost  (ArrayList<CardElementListe> l, int c) {
        ArrayList<CardElementListe> newList = new ArrayList<>();
        if(c == 7){
            for (CardElementListe card : l) {
                if (card.getCost() >= c) {
                    newList.add(card);
                }
            }
        }
        else{
            for (CardElementListe card : l) {
                if (card.getCost() == c) {
                    newList.add(card);
                }
            }
        }
        return newList;
    }

    static public ArrayList<CardElementListe> sortByType(ArrayList<CardElementListe> l, boolean minion) {
        ArrayList<CardElementListe> res = new ArrayList<>();
        for(CardElementListe card : l){
            if(minion == card.getMinion()){
                res.add(card);
            }
        }
        return res;
    }

    static public ArrayList<CardElementListe> sortByRace(ArrayList<CardElementListe> l, Race r){
        ArrayList<CardElementListe> res = sortByType(l,true);
        //TODO : need to consider only minions (make a sort apart) because everyOne has a Race
        for(CardElementListe card : l){
            if(card.getRace().equals(r)){
                res.add(card);
            }
        }
        return res;
    }


}
