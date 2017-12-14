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
        ArrayList<CardElementListe> withoutSpell = sortByType(l,true);
        ArrayList<CardElementListe> res = new ArrayList<>();
        for(CardElementListe card : withoutSpell){
            if(card.getRace().compareTo(r) == 0){
                res.add(card);
            }
        }
        return res;
    }


}
