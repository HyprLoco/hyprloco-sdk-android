package hyprloco.hyprloco_android_sdk.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.microsoft.windowsazure.messaging.NotificationHub;

import hyprloco.hyprloco_android_sdk.NormAppPreferencesEnum;
import hyprloco.hyprloco_android_sdk.NotificationSettings;

/**
 * Created by hyprcephers on 6/2/16.
 */
public class RegistrationIntentService extends IntentService {
    private static final String TAG = "RegIntentService";

    private NotificationHub hub;
    private String customerId = "";

    public RegistrationIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String resultString = null;
        String regID = null;

        try {
            InstanceID instanceID = InstanceID.getInstance(this);
            String token = instanceID.getToken(NotificationSettings.SenderId,
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE);
            Log.i(TAG, "Got GCM Registration Token: " + token);

           if(hyprloco.hyprloco_android_sdk.model.NormAppPreferencesEnum.getInstance() != null) {
                customerId = String.valueOf(NormAppPreferencesEnum.getInstance().getLong(NormAppPreferencesEnum.Key.CUSTOMER_ID,0));
           }
            else hyprloco.hyprloco_android_sdk.model.NormAppPreferencesEnum.getInstance(getApplicationContext()); {
                customerId = String.valueOf(NormAppPreferencesEnum.getInstance().getLong(NormAppPreferencesEnum.Key.CUSTOMER_ID,0));
            }



            // Storing the registration id that indicates whether the generated token has been
            // sent to your server. If it is not stored, send the token to your server,
            // otherwise your server should have already received the token.
            if ((regID = sharedPreferences.getString("registrationID", null)) == null) {
                NotificationHub hub = new NotificationHub(NotificationSettings.HubName,
                        NotificationSettings.HubListenConnectionString, this);
                Log.i(TAG, "Attempting to register with NH using token : " + token);
                if(customerId != null && customerId != "0") {
                    String oisTag = "android:"
                            + NormAppPreferencesEnum.getInstance().getString(NormAppPreferencesEnum.Key.APPLICATION_ID) +":"
                            + customerId;
                    regID = hub.register(token, oisTag).getRegistrationId();
                    Log.i(TAG,"notification tag: " + oisTag);
                } else {
                    regID = hub.register(token).getRegistrationId();
                }

                // If you want to use tags...
                // Refer to : https://azure.microsoft.com/en-us/documentation/articles/notification-hubs-routing-tag-expressions/

                resultString = "Registered Successfully - RegId : " + regID;
                Log.i(TAG, resultString);
                sharedPreferences.edit().putString("registrationID", regID ).apply();
            } else {
                resultString = "Previously Registered Successfully - RegId : " + regID;
            }
        } catch (Exception e) {
            Log.e(TAG, resultString="Failed to complete token refresh", e);
            // If an exception happens while fetching the new token or updating our registration data
            // on a third-party server, this ensures that we'll attempt the update at a later time.
        }

//        // Notify UI that registration has completed.
//        if (QuickOrderActivity.isVisible && BuildConfig.DEBUG) {
//            QuickOrderActivity.mainActivity.ToastNotify(resultString);
//        }
    }
}
