package romisfrag.whatshouldiplay.sortList;

import android.util.Log;

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
        ArrayList<String> authorizedSets = new ArrayList<>();
        switch(m){
            case WILD:
                authorizedSets = Mode.getWildExtension();
                break;
            case STANDARD:
                authorizedSets = Mode.getStandardExtension();
                break;
            case ARENA:
                authorizedSets = Mode.getArenaExtension();
                break;
        }

        for (CardElementListe card : l) {
           for(String s : authorizedSets){
               if(s.equals(card.getSet())){
                   newList.add(card);
                   break;
               }
           }
        }

        Log.d("SORT", ""+newList.size());

        return newList;

    }
}
