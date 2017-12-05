package romisfrag.whatshouldiplay.GamePackage;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import romisfrag.whatshouldiplay.Display.CardElementListe;
import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Mode;
import romisfrag.whatshouldiplay.sortList.GeneralSort;

;
//TODO :: need to complete this

public class GameInstance implements Serializable{

    //Here are all the parameters that define a game
    private Mode game_mode;
    private HeroClass game_class;
    private int turn;
    private ArrayList<CardElementListe> cardList;



    public GameInstance(ArrayList<CardElementListe> cardList, HeroClass hero, Mode mode){
        game_mode = mode;
        game_class = hero;
        turn = 0;
        // sorting list
        this.cardList = GeneralSort.sortByClass(cardList, game_class);
    }



    //getter
    public Mode get_game_mode(){
        return game_mode;
    }

    public HeroClass get_game_class(){
        return game_class;
    }

    public int get_turn(){
        return turn;
    }

    public ArrayList<CardElementListe> get_listeCard(){

        return cardList;
    }


    //setter
    public void set_game_mode(Mode m){
        game_mode = m;
    }

    public void set_game_class(HeroClass c){
        game_class = c;
    }

    public void set_turn (int t){
        turn = t;
    }










}
