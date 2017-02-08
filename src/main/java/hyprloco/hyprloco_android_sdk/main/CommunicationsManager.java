package hyprloco.hyprloco_android_sdk.main;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by antonioguglielmo on 12/22/16.
 */

public class CommunicationsManager {

    /** Internal instance variable. */
    private static CommunicationsManager sInstance;

    /** The request queue. */
    private RequestQueue mRequestQueue;

    /**
     * Volley image loader
     */
    private ImageLoader mImageLoader;

    /**
     * Image cache implementation
     */
    private ImageLoader.ImageCache mImageCache;

    public CommunicationsManager() {
        // no instances
    }

    /**
     * This is the initializer.
     * @param context Your application context.
     * @param cacheSize The size of your image cache.
     */
    public static void init(Context context, int cacheSize) {
       Log.d("HyprLocoSDK Comms", "is init");
        if (sInstance == null) {
            sInstance = new CommunicationsManager();
            sInstance.mRequestQueue = Volley.newRequestQueue(context);
            sInstance.mImageCache = new ImageLoader.ImageCache() {
                @Override
                public Bitmap getBitmap(String url) {
                    return null;
                }

                @Override
                public void putBitmap(String url, Bitmap bitmap) {

                }
            };
            sInstance.mImageLoader = new ImageLoader(CommunicationsManager.getRequestQueue(), sInstance.mImageCache);
        }
    }

    /**
     * Gets the image loader from the singleton.
     * @return The RequestQueue.
     * @throws java.lang.IllegalStateException This is thrown if init has not been called.
     */
    public static RequestQueue getRequestQueue() {
        if (sInstance == null) {
            throw new IllegalStateException("The CommunicationsManager must be initialized.");
        }
        return sInstance.mRequestQueue;
    }

    /**
     * Gets the image loader from the singleton.
     * @return The ImageLoader.
     * @throws java.lang.IllegalStateException This is thrown if init has not been called.
     */
    public static ImageLoader getImageLoader() {
        if (sInstance == null) {
            throw new IllegalStateException("The CommunicationsManager must be initialized.");
        }
        return sInstance.mImageLoader;
    }
}
