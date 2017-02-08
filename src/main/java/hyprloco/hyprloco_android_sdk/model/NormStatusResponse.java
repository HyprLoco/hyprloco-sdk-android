package hyprloco.hyprloco_android_sdk.model;

import java.util.Date;

/**
 * Created by hyprcephers on 8/9/16.
 */
public class NormStatusResponse {
    public long customerId;
    public long orderId;
    public boolean hasOrder;
    public String phoneNumber;
    public Date orderDate;
    public String name;
    public String telemetricsKey;
    public String telemetricsUrl;
}
