package romisfrag.whatshouldiplay.Enumerations;

/**
 * Created by delgado on 11/01/18.
 */
//rarity
public enum ERarity {
    Free, Common, Rare, Epic, Legendary;


    static public ERarity stringToRarity (String hero) {
        return ERarity.valueOf(hero);
    }
}
