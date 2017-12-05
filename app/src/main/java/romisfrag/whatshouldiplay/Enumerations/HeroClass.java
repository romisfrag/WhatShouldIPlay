package romisfrag.whatshouldiplay.Enumerations;

/**
 * Created by delgado on 16/10/17.
 */

public enum HeroClass {
    DRUID,
    HUNTER,
    MAGE,
    PALADIN,
    PRIEST,
    ROGUE,
    SHAMAN,
    WARLOCK,
    WARRIOR,
    NEUTRAL;

    static public HeroClass stringToHeroClass (String hero) {
        return HeroClass.valueOf(hero.toUpperCase());
    }

}
