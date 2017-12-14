package romisfrag.whatshouldiplay.Display;

import java.io.Serializable;

import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Mode;
import romisfrag.whatshouldiplay.Enumerations.Race;

/**
 * Created by delgado on 16/10/17.
 */

public class CardElementListe implements Serializable {

    String name;
    int cost;
    String image_url;
    String gold_url;
    boolean minion;
    Race race;
    HeroClass heroClass;
    String set;
    boolean isCollectible;

    public CardElementListe(String name,int cost,String image_url, HeroClass heroClass,
                            String set, boolean isCollectible, Race race,String gold,
                            boolean minion){
        this.name = name;
        this.cost = cost;
        this.image_url = image_url;
        this.heroClass = heroClass;
        this.set = set;
        this.gold_url = gold;
        this.isCollectible = isCollectible;
        this.race = race;
        this.minion = minion;
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

}
