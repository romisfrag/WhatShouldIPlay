package romisfrag.whatshouldiplay.sortList;

import java.util.ArrayList;
import java.util.Arrays;

import romisfrag.whatshouldiplay.Display.CardElementListe;
import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Mechanics;
import romisfrag.whatshouldiplay.Enumerations.Mode;

import static romisfrag.whatshouldiplay.sortList.AdvancedSort.sortByCost;
import static romisfrag.whatshouldiplay.sortList.AdvancedSort.sortByMechanics;
import static romisfrag.whatshouldiplay.sortList.AdvancedSort.sortByRace;
import static romisfrag.whatshouldiplay.sortList.AdvancedSort.sortByType;
import static romisfrag.whatshouldiplay.sortList.GeneralSort.sortByClass;
import static romisfrag.whatshouldiplay.sortList.GeneralSort.sortByMode;
import static romisfrag.whatshouldiplay.sortList.Worries.performWorriesSort;

import romisfrag.whatshouldiplay.Enumerations.Race;
import romisfrag.whatshouldiplay.Enumerations.EWorries;

/**
 * Created by 3364533 on 12/12/17.
 */

public class Filters {

    private HeroClass heroClass;
    private Mode mode;
    private int cost;
    private Race race;
    private boolean[] listeMecha;
    private boolean[] listeWorries;
    boolean onlyMinions;


    public Filters(HeroClass h,Mode m){
        heroClass = h;
        mode = m;
        //initialize other fields with default value
        cost = -1;
        listeMecha = new boolean[Mechanics.values().length];
        for(int i = 0; i < listeMecha.length;i++){
            listeMecha[i] = false;
        }

        listeWorries = new boolean[EWorries.values().length];
        for(int i = 0; i < listeWorries.length;i++){
            listeWorries[i] = false;
        }

        onlyMinions = false;

    }


    //sorting methods
    public ArrayList<CardElementListe> performGeneralSort(ArrayList<CardElementListe> l){
        ArrayList<CardElementListe> ret = l;

        ret = sortByClass (ret, heroClass);
        ret = sortByMode (ret, mode);

        return ret;
    }

    public ArrayList<CardElementListe> performAdvancedSort(ArrayList<CardElementListe> l){
        ArrayList<CardElementListe> ret = l;
        //performing the cost
        if(cost > -1) {
            ret = sortByCost(ret, cost);
        }
        //performing the race
        if(race.compareTo(Race.NORACE) != 0) {
            ret = sortByRace(ret, race);
        }
        //performing by mechanics
        for(int i = 0; i < listeMecha.length;i++){
            if(listeMecha[i]){
                ret = sortByMechanics(ret,listeMecha);
                break;
            }
        }
        //performing worries
        for(int i = 0; i < listeWorries.length;i++){
            if(listeWorries[i]){
                ret = performWorriesSort(ret,listeWorries);
                break;
            }
        }

        //getting out all the nonMinions
        if(onlyMinions){
            ret = sortByType(ret,true);
        }

        return ret;
    }


    public boolean[] initArrayBoolFalse(int lenght){
        boolean[] res = new boolean[lenght];
        Arrays.fill(res, false);
        return res;
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

    public void deleteCost(){
        cost = -1;
    }


    //getter setters
    public int getCost(){
        return cost;
    }

    public void setRace(Race r){
        this.race = r;
    }

    public void setOnlyMinions(boolean b){
        onlyMinions = b;
    }

    public Race getRace(){
        return race;
    }

    public void setListeMecha(boolean[] mechas){
        listeMecha = mechas;
    }

    public void setListeWorries(boolean[] worries){
        listeWorries = worries;
    }

}
