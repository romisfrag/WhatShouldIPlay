package romisfrag.whatshouldiplay.GamePackage;

import java.io.Serializable;
import java.util.ArrayList;

import romisfrag.whatshouldiplay.Display.CardElementListe;

import static romisfrag.whatshouldiplay.GamePackage.HeroClass.DRUID;

/**
 * Created by delgado on 16/10/17.
 */

enum HeroClass { DRUID, HUNTER, MAGE, PALADIN, PRIEST, ROGUE, SHAMAN, WARLOCK, WARRIOR};
enum Mode {STANDARD, ARENA, WILD}
//TODO :: need to complete this

public class GameInstance implements Serializable{

    //Here are all the parameters that define a game
    Mode game_mode;
    HeroClass game_class;
    int turn;
    boolean listLoaded;
    ArrayList<CardElementListe> listeCard;



    public GameInstance(){
        game_mode = Mode.STANDARD;
        game_class = HeroClass.DRUID;
        turn = 0;
        listLoaded = false;
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

    public boolean get_listeLoaded(){
        return listLoaded;
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

    public void add_liste (ArrayList<CardElementListe> liste){
        this.listeCard = liste;
        listLoaded = true;
    }









}
