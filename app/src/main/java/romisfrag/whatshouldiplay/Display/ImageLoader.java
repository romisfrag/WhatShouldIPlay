package romisfrag.whatshouldiplay.Display;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import pl.droidsonroids.gif.GifDrawable;

/**
 * Created by Sylux on 03/11/2017.
 */

public class ImageLoader extends AsyncTask<Void, Void, Void> {

    private String img_url;
    DisplayCardElem displayCardElem;
    Bitmap bitmap;
    GifDrawable drawable;
    boolean gif;
    boolean success;


    public ImageLoader(DisplayCardElem obj,String img_url,boolean gif) {
        this.img_url = img_url;
        this.displayCardElem = obj;
        this.gif = gif;
        this.success = true;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(img_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();

            if(gif){
                BufferedInputStream bis = new BufferedInputStream( input );
                drawable = new GifDrawable( bis );
            }
            else {
                bitmap = BitmapFactory.decodeStream(input);
            }
        } catch (IOException e) {
            success = false;
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void v) {
        super.onPostExecute(v);
        if(success) {
            if (gif) {
                displayCardElem.displayGif(drawable);
            } else {
                displayCardElem.displayImg(bitmap);
            }
        }
        else{
            displayCardElem.callImageLoader();
        }
    }
}
