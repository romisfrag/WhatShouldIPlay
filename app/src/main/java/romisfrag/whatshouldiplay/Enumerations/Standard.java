package romisfrag.whatshouldiplay.Enumerations;

/**
 * Created by 3364533 on 05/12/17.
 */

public enum Standard {

    basic ("Basic"),
    classic ("Classic"),
    leagueexplorers ("The League of Explorers"),
    wotog ("Whispers of the Old Gods"),
    kotfth ("Knights of the Frozen Throne"),
    gadg ("Mean Streets of Gadgetzan"),
    ungoro ("Journey to Un'Goro"),
    karazhan ("One Night in Karazhan");

    private final String name;

    private Standard(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}
