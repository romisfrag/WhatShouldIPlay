package romisfrag.whatshouldiplay.Display;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Sylux on 03/11/2017.
 */

public class ImageLoader extends AsyncTask<Void, Void, Bitmap> {

    private String img_url;
    private ImageView v;

    public ImageLoader(String img_url, ImageView v) {
        this.img_url = img_url;
        this.v = v;
    }

    @Override
    protected Bitmap doInBackground(Void... voids) {
        try {
            URL url = new URL(img_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        if (bitmap != null) {
            v.setImageBitmap(bitmap);
        }
    }
}
