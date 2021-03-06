package romisfrag.whatshouldiplay;

import android.app.Application;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import romisfrag.whatshouldiplay.Display.CardElementListe;
import romisfrag.whatshouldiplay.Display.DisplayCards;
import romisfrag.whatshouldiplay.Interfaces.UseRequester;
import romisfrag.whatshouldiplay.input_output.Requester;
import romisfrag.whatshouldiplay.input_output.StorageManager;

/**
 * Created by delgado on 07/11/17.
 */

public class ApplicationCustom extends Application implements UseRequester{

    private ArrayList<CardElementListe> appCardElementListe;
    private boolean goldMode;

    @Override
    public void onCreate() {
        super.onCreate();
        goldMode = false;
    }


    public void setList(ArrayList<CardElementListe> list){
        appCardElementListe = list;
    }

    public ArrayList<CardElementListe> getAppCards(){
        return appCardElementListe;
    }


    @Override
    public void notifyEndRequest() {

    }

    public void switchGoldMode(){
        goldMode = !goldMode;
    }
    public boolean getGoldMode(){return goldMode;}


}
