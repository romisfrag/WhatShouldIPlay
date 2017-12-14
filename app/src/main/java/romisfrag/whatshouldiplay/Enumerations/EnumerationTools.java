package romisfrag.whatshouldiplay.Enumerations;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by delgado on 14/12/17.
 */

public class EnumerationTools {

    public static ArrayList<String> ArrayListFromEnum(Enum [] e){
        ArrayList<String> res = new ArrayList<>();
        for(Enum v : e){
            res.add(v.toString());
        }
        return res;
    }

}
