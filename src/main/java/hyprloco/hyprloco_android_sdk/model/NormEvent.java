package hyprloco.hyprloco_android_sdk.model;

import java.util.Date;

/**
 * Created by aaron on 5/27/2016.
 */
public class NormEvent {
    public int beaconId;
    public int duration = 0;
    public Date eventLocalTime = new Date();
    public boolean leaveBeacon = false;
    public int rssi = -32;
    public String locationId;
}
