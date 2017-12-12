package romisfrag.whatshouldiplay.sortList;

import java.util.ArrayList;

import romisfrag.whatshouldiplay.Display.CardElementListe;
import romisfrag.whatshouldiplay.Enumerations.HeroClass;

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


}
