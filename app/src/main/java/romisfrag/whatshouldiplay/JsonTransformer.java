package romisfrag.whatshouldiplay;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import romisfrag.whatshouldiplay.Display.CardElementListe;
import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Wild;
import romisfrag.whatshouldiplay.GamePackage.GameInstance;

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
        String tempUrl, tempRace, tempClass, tempSet;
        boolean tempsIsCollectible;

        //Searching for all the card of standard extensions
        for(Wild e : Wild.values()){
            try {
                tempArray.add(jsonObject.getJSONArray(e.toString()));
            } catch (JSONException e1) {
                Toast.makeText(context, "error getting card: "+e.toString(), Toast.LENGTH_SHORT).show();
            }
        }

        for (JSONArray json : tempArray) {
            for (int i = 0; i < json.length(); i++) {
                try {
                    tempElem = json.getJSONObject(i);
                    tempName = tempElem.getString("name");
                    try {
                        tempCost = tempElem.getInt("cost");
                        tempRace = tempElem.getString("race");
                    } catch (JSONException e) {
                        tempCost = 11;
                        tempRace = "Sort";
                    }
                    tempUrl = tempElem.getString("img");
                    tempClass = tempElem.getString("playerClass");
                    tempsIsCollectible = tempElem.getBoolean("collectible");
                    tempSet = tempElem.getString("cardSet");
                    res.add(new CardElementListe(tempName, tempCost, tempUrl, tempClass, tempSet, tempsIsCollectible, tempRace));
                } catch (JSONException e1) {
                    tempName = "";
                    try {
                        tempElem = json.getJSONObject(i);
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
