package hyprloco.hyprloco_android_sdk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron on 5/27/2016.
 */
public class NormReport {
    public boolean isHubEvents = false;
    public long sourceId = 0;
    public int reportType = 0;
    public List<NormEvent> beaconEvents =  new ArrayList<NormEvent>();
}
