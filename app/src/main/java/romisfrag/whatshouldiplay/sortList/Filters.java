package romisfrag.whatshouldiplay.sortList;

import java.util.ArrayList;

import romisfrag.whatshouldiplay.Display.CardElementListe;
import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Mode;

import static romisfrag.whatshouldiplay.Enumerations.Mode.WILD;
import static romisfrag.whatshouldiplay.sortList.AdvancedSort.sortByCost;
import static romisfrag.whatshouldiplay.sortList.GeneralSort.sortByClass;
import static romisfrag.whatshouldiplay.sortList.GeneralSort.sortByMode;
import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Mode;
/**
 * Created by 3364533 on 12/12/17.
 */

public class Filters {

    private HeroClass heroClass;
    private Mode mode;
    private int cost;


    public Filters(HeroClass h,Mode m){
        heroClass = h;
        mode = m;
        //initialize other fields with default value
        cost = -1;
    }

    public ArrayList<CardElementListe> performGeneralSort(ArrayList<CardElementListe> l){
        ArrayList<CardElementListe> ret = l;

        ret = sortByClass (ret, heroClass);
        ret = sortByMode (ret, mode);

        return ret;
    }

    public ArrayList<CardElementListe> performAdvancedSort(ArrayList<CardElementListe> l){
        ArrayList<CardElementListe> ret = l;
        if(cost > -1) {
            ret = sortByCost(ret, cost);
        }

        return ret;
    }

    //Cost functions
    public void incrCost(){
        cost++;
        if(cost >= 7){
            cost = 7;
        }
    }
    public void decrCost(){
        cost--;
        if(cost <= 0){
            cost = 0;
        }
    }
    public int getCost(){
        return cost;
    }



}
