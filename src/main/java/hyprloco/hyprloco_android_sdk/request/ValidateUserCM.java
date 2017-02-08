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

public class ValidateUserCM {
    String apiresponse = "";

    public ValidateUserCM(String baseurl, ValidateCustomerRequest request) {


        String url = baseurl + R.string.api_customers_base + ( request.customerId + request.phoneNumber + request.token );
        Log.d("ValidateUserCM", url);


        JsonArrayRequest jsonArrayRequestRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Response: ", "" +  response.toString());

                        try {
                            apiresponse = response.getJSONObject(0).toString();
                            Log.d("apiresponse", apiresponse);
                           if(response != null) {
                            //Necessary catch block
                           }

                        } catch (JSONException e ) {
                            Log.e("JSON types changed", "The error is : " + e);
                        };
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error from ValidateUser", ""+ error.toString());

                    }
                }
     );


        //RequestQueue is managed by SDK Communications Manager
        RequestQueue requestQueue = CommunicationsManager.getRequestQueue();
        requestQueue.add(jsonArrayRequestRequest);
    }



}




