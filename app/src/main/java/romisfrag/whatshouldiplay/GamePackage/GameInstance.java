package romisfrag.whatshouldiplay.GamePackage;

import java.io.Serializable;
import java.util.ArrayList;

import romisfrag.whatshouldiplay.Display.CardElementListe;
import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Mode;

;
//TODO :: need to complete this

public class GameInstance implements Serializable{

    //Here are all the parameters that define a game
    private Mode game_mode;
    private HeroClass game_class;
    private int turn;
    private ArrayList<CardElementListe> listeCard;



    public GameInstance(ArrayList<CardElementListe> listeCard){
        game_mode = Mode.STANDARD;
        game_class = HeroClass.DRUID;
        turn = 0;
        this.listeCard = listeCard;
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
        return listeCard;
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
