package hyprloco.hyprloco_android_sdk.service;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by hyprcephers on 6/2/16.
 */
public class GCMIDService extends InstanceIDListenerService {
    private static final String TAG = "GCMIDService";

    @Override
    public void onTokenRefresh() {

        Log.i(TAG, "Refreshing GCM Registration Token");

        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);
    }

}
