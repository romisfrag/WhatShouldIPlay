package romisfrag.whatshouldiplay.Enumerations;

import java.util.ArrayList;

/**
 * Created by delgado on 31/10/17.
 */
public enum Mode {
    STANDARD,
    ARENA,
    WILD;

    static public ArrayList<String> getStandardExtension() {
        ArrayList<String> extList = new ArrayList<>();
        extList.add("Basic");
        extList.add("Classic");
        extList.add("The League of Explorers");
        extList.add ("Whispers of the Old Gods");
        extList.add ("Knights of the Frozen Throne");
        extList.add ("Mean Streets of Gadgetzan");
        extList.add ("Journey to Un'Goro");
        extList.add ("One Night in Karazhan");
        return extList;
    }

    static public ArrayList<String> getWildExtension() {
        ArrayList<String> extList = new ArrayList<>();
        extList.addAll(getStandardExtension());
        extList.add("Goblins vs Gnomes");
        extList.add("Blackrock Mountain");
        extList.add("The Grand Tournament");
        extList.add ("Naxxramas");
        return extList;
    }
}
