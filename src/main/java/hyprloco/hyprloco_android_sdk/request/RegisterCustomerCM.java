package hyprloco.hyprloco_android_sdk.request;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;

import hyprloco.hyprloco_android_sdk.R;
import hyprloco.hyprloco_android_sdk.main.CommunicationsManager;

/**
 * Created by antonioguglielmo on 1/30/17.
 */

public class RegisterCustomerCM {
    String apiresponse = "";


    public RegisterCustomerCM(String baseurl, String keys) {


        //RequestQueue is managed by SDK Communications Manager

        String url = baseurl + R.string.api_post_register_user_device + (keys);
        Log.d("GetLocCM", url);


        JsonArrayRequest jsonArrayRequestRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Response: ", "" + response.toString());

                        try {

                            apiresponse = response.getJSONObject(0).toString();
                            Log.d("apiresponse", apiresponse);
                            if (response != null) {
                                setApiresponse(apiresponse);
                            }


                        } catch (JSONException e) {
                            Log.e("JSON types changed", "The error is : " + e);
                        }
                        ;
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error from Loc Req", "" + error.toString());

                    }
                }

                );


        //RequestQueue is managed by SDK Communications Manager
        RequestQueue requestQueue = CommunicationsManager.getRequestQueue();
        requestQueue.add(jsonArrayRequestRequest);
    }


    public String GetLocationList(String baseurl, String request) {
        if (apiresponse.length() > 1) {
            {
                new RegisterCustomerCM(baseurl, request);
            }
        } else return apiresponse;
        return apiresponse;
    }

    public void setApiresponse(String apiresponse) {
        this.apiresponse = apiresponse;
    }
}





