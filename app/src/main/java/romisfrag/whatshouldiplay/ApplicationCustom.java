package romisfrag.whatshouldiplay;

import android.app.Application;
import android.widget.Toast;

import romisfrag.whatshouldiplay.Interfaces.UseRequester;
import romisfrag.whatshouldiplay.input_output.StorageManager;

/**
 * Created by delgado on 07/11/17.
 */

public class ApplicationCustom extends Application implements UseRequester{

    StorageManager storageManager;

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "on a change", Toast.LENGTH_SHORT).show();
        storageManager = new StorageManager(getApplicationContext());
        storageManager.saveString("lol.txt","content easy kdlfgkdflgd");

        String res = storageManager.readFile("lol.txt");
        Toast.makeText(this, "res " + res, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void notifyEndRequest() {
        Toast.makeText(this, "TODO notify end request", Toast.LENGTH_SHORT).show();
    }
}
