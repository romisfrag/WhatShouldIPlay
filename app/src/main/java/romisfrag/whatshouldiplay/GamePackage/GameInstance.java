package romisfrag.whatshouldiplay.GamePackage;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import romisfrag.whatshouldiplay.Display.CardElementListe;
import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Mode;
import romisfrag.whatshouldiplay.sortList.Filters;


;
//TODO :: need to complete this

public class GameInstance implements Serializable{

    //Here are all the parameters that define a game
    private Mode game_mode;
    private HeroClass game_class;
    private ArrayList<CardElementListe> cardList;
    private ArrayList<CardElementListe> cardListFilter;




    public GameInstance(ArrayList<CardElementListe> list, HeroClass hero, Mode mode,Filters filters){
        game_mode = mode;
        game_class = hero;
        cardList = list;
        // performing basic sorting
        this.cardList = filters.performGeneralSort(list);
        this.cardListFilter = cardList;
    }



    //getter
    public Mode get_game_mode(){
        return game_mode;
    }

    public HeroClass get_game_class(){
        return game_class;
    }

    public ArrayList<CardElementListe> get_listeCard(){

        return cardListFilter;
    }

    public void performAdvancedSort(Filters filters){
        cardListFilter = filters.performAdvancedSort(cardList);
    }





    //setter
    public void set_game_mode(Mode m){
        game_mode = m;
    }

    public void set_game_class(HeroClass c){
        game_class = c;
    }










}
