package romisfrag.whatshouldiplay;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import romisfrag.whatshouldiplay.Display.CardElementListe;
import romisfrag.whatshouldiplay.GamePackage.GameInstance;

/**
 * Created by delgado on 16/10/17.
 */

enum StandardExtensions {Classic, WhispersOTOG}


public class JsonTransformer {

    Context context;

    JSONObject jsonObject;

    public JsonTransformer(Context context, String str){
        this.context = context;
        try {
            jsonObject = new JSONObject(str);
            Toast.makeText(context,"Success json",Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            Toast.makeText(context,"Error while parsing json",Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<CardElementListe> getCardsListStandard() {

        Toast.makeText(context, "On est la poto", Toast.LENGTH_SHORT).show();
        ArrayList<CardElementListe> res = new ArrayList<CardElementListe>();
        JSONArray tempArray = null;
        JSONObject tempElem;
        String tempName;
        int tempCost;
        String tempUrl;
        //Searching for all the card of standard extensions
        for(StandardExtensions e : StandardExtensions.values()){
            switch(e){
                case Classic:
                    try {
                        tempArray = jsonObject.getJSONArray("Classic");
                    } catch (JSONException e1) {
                        Toast.makeText(context, "getCardsListStandard Can't get classic", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case WhispersOTOG:
                    try {
                        tempArray = jsonObject.getJSONArray("Knights of the Frozen Throne");
                    } catch (JSONException e1) {
                        Toast.makeText(context, "getCardsListStandard Can't get KOTH", Toast.LENGTH_SHORT).show();

                    }
                    break;
            }

            for(int i = 0; i < tempArray.length();i++){
                try {
                    tempElem = tempArray.getJSONObject(i);
                    tempName = tempElem.getString("name");
                    tempCost = tempElem.getInt("cost");
                    tempUrl = tempElem.getString("img");
                    res.add(new CardElementListe(tempName,tempCost,tempUrl));
                } catch (JSONException e1) {
                    tempName = "";
                    try {
                        tempElem = tempArray.getJSONObject(i);
                        tempName = tempElem.getString("name");
                    } catch (JSONException e2) {
                        //Toast.makeText(context, "La fin de la fin", Toast.LENGTH_SHORT).show();
                    }
                    //Toast.makeText(context, "getCardsListStandard" + tempName, Toast.LENGTH_SHORT).show();
                }
            }
        }
        Toast.makeText(context, "finished getCardListStandard", Toast.LENGTH_SHORT).show();
        return res;
    }





}
