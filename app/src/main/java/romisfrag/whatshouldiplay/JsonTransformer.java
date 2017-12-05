package romisfrag.whatshouldiplay;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import romisfrag.whatshouldiplay.Display.CardElementListe;
import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Mode;

/**
 * Created by delgado on 16/10/17.
 */

enum StandardExtensions {Classic, WhispersOTOG}


public class JsonTransformer {

    Context context;
    boolean isThereObject;
    JSONObject jsonObject;

    public JsonTransformer(Context context){
        this.context = context;
        isThereObject = false;
    }

    public void addStr(String str){
        try {
            jsonObject = new JSONObject(str);
            isThereObject = true;
            Toast.makeText(context,"Success json",Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            Toast.makeText(context,"Error while parsing json",Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<CardElementListe> getCardsListStandard() {

        ArrayList<CardElementListe> res = new ArrayList<CardElementListe>();
        if(!isThereObject){
            return res;
        }
//        Toast.makeText(context, "On est la poto", Toast.LENGTH_SHORT).show();

        ArrayList<JSONArray> tempArray = new ArrayList<>();
        JSONObject tempElem;
        String tempName;
        int tempCost;
        String tempUrl, tempRace, tempClass, tempSet,tempGold;
        boolean tempsIsCollectible;

        //Searching for all the card of standard extensions
        for(String e : Mode.getWildExtension()){
            try {
                tempArray.add(jsonObject.getJSONArray(e));
            } catch (JSONException e1) {
                Toast.makeText(context, "error getting card: "+e, Toast.LENGTH_SHORT).show();
            }
        }

        for (JSONArray json : tempArray) {
            for (int i = 0; i < json.length(); i++) {
                try {
                    tempElem = json.getJSONObject(i);
                    tempName = tempElem.getString("name");
                    tempUrl = tempElem.getString("img");
                    try{
                        tempGold = tempElem.getString("imgGold");
                    } catch (JSONException e){
                        tempGold = tempUrl;
                    }
                    try {
                        tempCost = tempElem.getInt("cost");
                    } catch (JSONException e){
                        tempCost = 11;
                    }

                    try {
                        tempRace = tempElem.getString("race");

                    } catch (JSONException e) {
                        tempRace = "Sort";
                    }

                    tempClass = tempElem.getString("playerClass");
                    tempsIsCollectible = tempElem.getBoolean("collectible");
                    tempSet = tempElem.getString("cardSet");
                    res.add(new CardElementListe(tempName, tempCost, tempUrl,
                            HeroClass.stringToHeroClass(tempClass), tempSet, tempsIsCollectible, tempRace,tempGold));
                } catch (JSONException e1) {
                    tempName = "";
                    try {
                        tempElem = json.getJSONObject(i);
                        tempName = tempElem.getString("name");
                    } catch (JSONException e2) {

                    }

                }
            }
        }

        Toast.makeText(context, "finished getCardListStandard", Toast.LENGTH_SHORT).show();
        return res;
    }





}
