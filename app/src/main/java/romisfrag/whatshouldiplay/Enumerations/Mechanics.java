package romisfrag.whatshouldiplay.Enumerations;

/**
 * Created by delgado on 09/01/18.
 */

public enum Mechanics {
    Battlecry,
    DEATHRATTLE,
    CHARGE,
    TAUNT,
    DIVINE,
    Stealth,
    Enrage,
    Windfury,
    Immune,
    Freeze,
    Silence,
    SpellDammage,
    Secret,
    Unknown;






    public static Mechanics stringToMecha(String s){
        switch (s) {
            case "Battlecry":
                return Battlecry;
            case "Deathrattle":
                return DEATHRATTLE;
            case "Charge":
                return CHARGE;
            case "Taunt":
                return TAUNT;
            case "Divine Shield":
                return DIVINE;
            case "Stealth":
                return Stealth;
            case "Enrage":
                return Enrage;
            case "Windfury":
                return Windfury;
            case "Immune":
                return Immune;
            case "Freeze":
                return Freeze;
            case "Silence":
                return Silence;
            case "Spell Dammage":
                return SpellDammage;
            case "Secret":
                return Secret;
            default:
                return Unknown;
        }
    }

}
