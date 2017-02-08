package hyprloco.hyprloco_android_sdk.main;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;

public final class HyprlocoSDK  {

    private static final AtomicBoolean initialized = new AtomicBoolean();

    public static void init(Application application) {
        Log.d("HyprlocoSDK is init", " application");
        init((Context) application);
    }

    public static void init(Context context) {
        //start the Communications Manager class  with cache size
        CommunicationsManager.init(context, 1000);

        if (initialized.getAndSet(true)) {
            Log.d("HyprlocoSDK is init", " context");
            return;
        }
    }

    private HyprlocoSDK() {
        throw new AssertionError("No instances of HyprLoco");
    }
}
