package com.example.bruno.applibrubru;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FichierJson extends AppCompatActivity {


    JSONObject jsonObj;
    JSONArray jsonArrayUtil;
    JSONArray data;
    List myListView = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichier_json);


        String url = "http://voyage2.corellis.eu/api/v2/homev2?lat=43.14554197717751&lon=6.00246207789145&offset=0";
        RequestQueue queue = Volley.newRequestQueue(this);
        ListView listView = (ListView) findViewById(R.id.ListView);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        convertJsonToJsonList(response);

                        fillListView(jsonArrayUtil);
                    }
                },

                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //toast quand il y a une erreur

                Toast.makeText(FichierJson.this, "Erreur avec la connexion", Toast.LENGTH_SHORT).show();
                Log.e("test",error.toString());
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    private void convertJsonToJsonList (String response){

        try {
            jsonObj = new JSONObject(response.toString());
            jsonArrayUtil = new JSONArray();
            data = (jsonObj.getJSONArray("data"));
            int j=0;
            for (int i = 0; i < data.length(); i++) {
                //Log.d("data", data.getString(i));

                String type = data.getJSONObject(i).getString("type");


                if (type.equals("CITY")){
                    jsonArrayUtil.put(data.getJSONObject(i));
                    Log.d("jsonArrayUtil", jsonArrayUtil.getString(j));
                    j++;
                }

                else if (type.equals("Admin")){
                    jsonArrayUtil.put(data.getJSONObject(i));
                    Log.d("jsonArrayUtil", jsonArrayUtil.getString(j));
                    j++;
                }

                else if (type.equals("POI")) {
                    jsonArrayUtil.put(data.getJSONObject(i));
                    Log.d("jsonArrayUtil", jsonArrayUtil.getString(j));
                    j++;
                }

                else if (type.equals("Parcours")) {
                    jsonArrayUtil.put(data.getJSONObject(i));
                    Log.d("jsonArrayUtil", jsonArrayUtil.getString(j));
                    j++;
                }

            }
        }
        catch (JSONException e){
            Toast.makeText(FichierJson.this, "Problème avec l'url", Toast.LENGTH_SHORT).show();
            Log.e("test",e.toString());
        }
    }

    private void fillListView (JSONArray jsonArrayUtil) {



    }



}


