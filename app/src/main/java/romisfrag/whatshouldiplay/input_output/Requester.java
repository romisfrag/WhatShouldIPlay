package romisfrag.whatshouldiplay.input_output;

import android.app.DownloadManager;
import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import romisfrag.whatshouldiplay.Interfaces.UseRequester;

/**
 * Created by delgado on 16/10/17.
 */

public class Requester {

    String resRequest;

    RequestQueue queue;
    Context context;
    UseRequester toNotify;

    public Requester(Context context, UseRequester toNotify){
        this.context = context;
        resRequest = "Empty";
        queue = Volley.newRequestQueue(context);
        this.toNotify = toNotify;
    }


    // These code snippets use an open-source library.
  /*  HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards")
            .header("X-Mashape-Key", "O43ysXeVTgmshKXCifKrV9dsBrMnp1xUsaLjsnN2P3JyV04CI4")
            .asJson();

*/

  public void sendAllCards(){
      sendRequest("https://omgvamp-hearthstone-v1.p.mashape.com/cards?");
  }

    public String getResRequest(){
        return resRequest;
    }



    //This has already the hash map key in int just give the url
    public void sendRequest(String url){
        Toast.makeText(context,"Request sended",Toast.LENGTH_LONG);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        resRequest = response;
                        Toast.makeText(context, "Succes", Toast.LENGTH_SHORT).show();
                        toNotify.notifyEndRequest();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context,"Fail",Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-Mashape-Key", "O43ysXeVTgmshKXCifKrV9dsBrMnp1xUsaLjsnN2P3JyV04CI4");
                return params;
            }
        };

        queue.add(stringRequest);
    }





}
