package romisfrag.whatshouldiplay.initialActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import romisfrag.whatshouldiplay.ApplicationCustom;
import romisfrag.whatshouldiplay.Display.CardElementListe;
import romisfrag.whatshouldiplay.Interfaces.UseRequester;
import romisfrag.whatshouldiplay.JsonTransformer;
import romisfrag.whatshouldiplay.R;
import romisfrag.whatshouldiplay.input_output.Requester;
import romisfrag.whatshouldiplay.input_output.StorageManager;

public class LoadingScreen extends AppCompatActivity implements UseRequester{

    private Requester requester;
    private JsonTransformer jsonTransformer;
    private StorageManager storageManager;
    String fileName = "saveCards.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_screen_layout);

        //init
        requester = new Requester(getApplicationContext(),this);
        jsonTransformer = new JsonTransformer(getApplicationContext());
        storageManager = new StorageManager(getApplicationContext());

        //finding if the file is already here
        TextView tv = (TextView)findViewById(R.id.textLoad);
        tv.setText("File is here?");

        if (storageManager.isFileHere(fileName)){
            String temp;
            temp = storageManager.readFile(fileName);
            loadEnding(temp);
        }
        else{
            requester.sendAllCards();
            tv.setText("Starting request");
        }

    }

    private void loadEnding (String res){

        ApplicationCustom app = (ApplicationCustom)getApplication();
        //parsing the json
        jsonTransformer.addStr(res);
//        Toast.makeText(app, "length str "+ res.length(), Toast.LENGTH_SHORT).show();
        //updating the list in the app
        ArrayList<CardElementListe> l = jsonTransformer.getCardsListStandard();
//        Toast.makeText(app, "length " + l.size(), Toast.LENGTH_SHORT).show();
        app.setList(l);
        //starting the next activity
        Intent intent = new Intent(LoadingScreen.this, MainMenu.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void notifyEndRequest() {
        //getting the result of the request
        String temp = requester.getResRequest();
        //store the result in a file
        storageManager.saveString(fileName,temp);

        loadEnding(temp);
    }
}
