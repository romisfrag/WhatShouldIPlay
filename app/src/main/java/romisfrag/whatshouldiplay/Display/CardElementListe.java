package romisfrag.whatshouldiplay.Display;

import java.io.Serializable;

/**
 * Created by delgado on 16/10/17.
 */

public class CardElementListe implements Serializable {

    String name;
    int cost;
    String image_url;

    public CardElementListe(String name,int cost,String image_url){
        this.name = name;
        this.cost = cost;
        this.image_url = image_url;
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





}
