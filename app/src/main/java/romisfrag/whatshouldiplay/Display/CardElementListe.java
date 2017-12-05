package romisfrag.whatshouldiplay.Display;

import java.io.Serializable;

import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Mode;

/**
 * Created by delgado on 16/10/17.
 */

public class CardElementListe implements Serializable {

    String name;
    int cost;
    String image_url, race;
    String heroClass;
    String set;
    boolean isCollectible;

    public CardElementListe(String name,int cost,String image_url, String heroClass, String set, boolean isCollectible, String race){
        this.name = name;
        this.cost = cost;
        this.image_url = image_url;
        this.heroClass = heroClass;
        this.set = set;
        this.isCollectible = isCollectible;
        this.race = race;
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

    public String getHeroClass() {
        return heroClass;
    }

    public String getSet() {
        return set;
    }

    public String getRace() {
        return race;
    }

    public boolean isCollectible() {
        return isCollectible;
    }

}
