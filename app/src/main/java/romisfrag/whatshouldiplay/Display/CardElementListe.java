package romisfrag.whatshouldiplay.Display;

import java.io.Serializable;
import java.util.ArrayList;

import romisfrag.whatshouldiplay.Enumerations.ERarity;
import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Mechanics;
import romisfrag.whatshouldiplay.Enumerations.Race;

/**
 * Created by delgado on 16/10/17.
 */

public class CardElementListe implements Serializable {

    //Meta informations
    String name;
    int cost;
    String image_url;
    String gold_url;
    boolean minion;
    Race race;
    HeroClass heroClass;
    String set;
    boolean isCollectible;
    String flavor;
    String texte;
    ArrayList<Mechanics> mechanics;
    ERarity rarity;

    //statistics
    int attack;
    int health;


    public CardElementListe(String name,int cost,String image_url, HeroClass heroClass,
                            String set, boolean isCollectible, Race race,String gold,
                            boolean minion,int attack, int health,String flavor,
                            ArrayList<Mechanics> mechanics,String texte,ERarity rarity){
        this.name = name;
        this.cost = cost;
        this.image_url = image_url;
        this.heroClass = heroClass;
        this.set = set;
        this.gold_url = gold;
        this.isCollectible = isCollectible;
        this.race = race;
        this.minion = minion;
        this.attack = attack;
        this.health = health;
        this.flavor = flavor;
        this.mechanics = mechanics;
        this.texte = texte;
        this.rarity = rarity;
    }


    //getter
    public String getName(){
        return name;
    }

    public int getCost(){
        return cost;
    }

    public String get_imageUrl(){
        return image_url;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public String getSet() {
        return set;
    }

    public Race getRace() {
        return race;
    }

    public String getGold_url() {return gold_url;}

    public boolean getMinion(){return minion; }

    public boolean isCollectible() {
        return isCollectible;
    }

    public int getAttack(){ return attack; }
    public int getHealth(){ return health; }

    public String getFlavor(){ return flavor; }

    public ArrayList<Mechanics> getMechanics(){
        return mechanics;
    }

    public boolean hasMechanic(Mechanics m){
        for(Mechanics mprime : mechanics){
            if(m.equals(mprime)){
                return true;
            }
        }
        return false;
    }

    public String getTexte(){
        return texte;
    }


}
