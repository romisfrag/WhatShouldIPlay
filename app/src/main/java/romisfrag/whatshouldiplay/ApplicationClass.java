package romisfrag.whatshouldiplay;

import android.app.Application;
import android.widget.Toast;

import romisfrag.whatshouldiplay.Interfaces.UseRequester;

/**
 * Created by delgado on 31/10/17.
 */

/* We use this because we wan't to create the list of all cards at the start of the app */
public class ApplicationClass extends Application implements UseRequester{




    @Override
    public void onCreate(){
        super.onCreate();


    }

    @Override
    public void notifyEndRequest() {

    }
}
