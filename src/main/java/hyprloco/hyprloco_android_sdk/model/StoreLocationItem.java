package hyprloco.hyprloco_android_sdk.model;

/**
 * Created by hyprcephers on 6/14/16.
 */
public class StoreLocationItem {
    private String mStoreName;
    private String mStoreAddress;
    private String mStoreNumber;
    private String mStoreDistance;

    public StoreLocationItem(String name, String address, String phone, String distance) {
        super();
        mStoreName = name;
        mStoreAddress = address;
        mStoreNumber = phone;
        mStoreDistance = distance;
    }

    public String getStoreName() {
        return mStoreName;
    }
    public void setStoreName(String name) {
        mStoreName = name;
    }
    public String getStoreAddress() {
        return mStoreAddress;
    }
    public void setStoreAddress(String address) {
        mStoreAddress = address;
    }
    public String getStoreNumber() {
        return mStoreNumber;
    }
    public void setStoreNumber(String number) {
        mStoreNumber = number;
    }
    public String getStoreDistance() {return mStoreDistance; }
    public void setStoreDistance(String distance) { mStoreDistance = distance; }
}
