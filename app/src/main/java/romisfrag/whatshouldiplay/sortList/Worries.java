package romisfrag.whatshouldiplay.sortList;

import java.util.ArrayList;
import java.util.regex.Pattern;

import romisfrag.whatshouldiplay.Display.CardElementListe;
import romisfrag.whatshouldiplay.Enumerations.EWorries;

/**
 * Created by delgado on 09/01/18.
 */

public class Worries {

    public static boolean matchString(String s, EWorries w){
        //s = "losdf sdfsd fs damage to all afs dfs dfsdf g";
        switch(w){
            case AOE:
                return Pattern.matches(".*(?i)damage( to)? all.*",s);
            default:
                return false;
        }
    }

    public static ArrayList<CardElementListe> performWorriesSort(ArrayList<CardElementListe> l,
                                                                 boolean[] lw){
        ArrayList<CardElementListe> res = new ArrayList<>();
        ArrayList<EWorries> worriesToFind = new ArrayList<>();
        EWorries[] listeWorries = EWorries.values();
        for(int i = 0; i < lw.length; i++){
            if(lw[i]){
                worriesToFind.add(listeWorries[i]);
            }
        }
        for(CardElementListe card : l){
            for(EWorries w : worriesToFind){
                if(matchString(card.getTexte(),w)){
                    res.add(card);
                    break;
                }
            }
        }
        return res;
    }

}
