package romisfrag.whatshouldiplay.Enumerations;

/**
 * Created by delgado on 14/12/17.
 */

public enum Race {
    NORACE, MURLOC, DEMON, BEAST, TOTEM, PIRATE, DRAGON;


    public static Race raceFromString(String s) throws Exception {
        String str = s.toUpperCase();

        if(str.equals("MURLOC")){
            return MURLOC;
        }
        if(str.compareTo("DEMON") == 0){
            return DEMON;
        }
        if(str.compareTo("BEAST") == 0){
            return BEAST;
        }
        if(str.compareTo("TOTEM") == 0){
            return TOTEM;
        }
        if(str.compareTo("PIRATE") == 0){
            return PIRATE;
        }
        if(str.compareTo("DRAGON") == 0){
            return DRAGON;
        }
        throw new Exception();
    }

}
