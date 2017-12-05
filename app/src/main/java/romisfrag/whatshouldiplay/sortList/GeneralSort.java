package romisfrag.whatshouldiplay.sortList;

import java.util.ArrayList;

import romisfrag.whatshouldiplay.Display.CardElementListe;
import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Mode;

/**
 * Created by 3364533 on 05/12/17.
 */

public class GeneralSort {

    static public ArrayList<CardElementListe> sortByClass (ArrayList<CardElementListe> l, HeroClass c) {
        ArrayList<CardElementListe> newList = new ArrayList<>();

        for (CardElementListe card : l) {
            if (card.getHeroClass().equals(HeroClass.NEUTRAL)
                    || card.getHeroClass().equals(c)
                    ) {
                newList.add(card);
            }
        }

        return newList;
    }

    static  public  ArrayList<CardElementListe> sortByMode (ArrayList<CardElementListe> l, Mode m) {
        ArrayList<CardElementListe> newList = new ArrayList<>();

        for (CardElementListe card : l) {
           /* if (card.toUpperCase().equals("NEUTRAL")
                    || card.getHeroClass().toUpperCase().equals(c.toString().toUpperCase())
                    ) {
                newList.add(card);
            }*/
        }

        return l;

    }
}
