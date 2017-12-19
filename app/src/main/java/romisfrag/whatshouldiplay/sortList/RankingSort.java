package romisfrag.whatshouldiplay.sortList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import romisfrag.whatshouldiplay.Display.CardElementListe;

/**
 * Created by delgado on 14/12/17.
 */

public class RankingSort {

    public static class attackComparator implements Comparator<CardElementListe>{
        @Override
        public int compare(CardElementListe o1, CardElementListe o2) {
            if(o1.getAttack() > o2.getAttack()){
                return 1;
            }
            else if(o1.getAttack() < o2.getAttack()){
                return -1;
            }
            return 0;
        }
    }
    public static class healthComparator implements Comparator<CardElementListe>{
        @Override
        public int compare(CardElementListe o1, CardElementListe o2) {
            if(o1.getHealth() > o2.getHealth()){
                return 1;
            }
            else if(o1.getHealth() < o2.getHealth()){
                return -1;
            }
            return 0;
        }
    }
    public static class alphabeticalComparator implements Comparator<CardElementListe>{
        @Override
        public int compare(CardElementListe o1, CardElementListe o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }


    public static void rankByAttack(ArrayList<CardElementListe> l){
        Collections.sort(l,new attackComparator());
    }
    public static void rankByHealth(ArrayList<CardElementListe> l){
        Collections.sort(l,new healthComparator());
    }
    public static void rankByAlphabetical(ArrayList<CardElementListe> l){
        Collections.sort(l,new alphabeticalComparator());
    }


    public static void rankBy(String name,ArrayList<CardElementListe> l){
        name = name.toLowerCase();
        if(name.equals("attack")){
            rankByAttack(l);
        }
        if(name.equals("health")){
            rankByHealth(l);
        }
        if(name.equals("alphabetical")){
            rankByAlphabetical(l);
        }
    }



}
