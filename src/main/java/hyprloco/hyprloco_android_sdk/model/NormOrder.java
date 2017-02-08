package hyprloco.hyprloco_android_sdk.model;

import java.util.Date;

/**
 * Created by hyprcephers on 6/16/16.
 */
public class NormOrder  {
    public String orderLabel;
    public String description;
    public String descriptionWithPrice;
    public String locationId;
    public String due;
    public String total;
    public Date orderDate;
    public int status;
    public long sessionId;
    public long orderId;
    public long checkNumber;
    public boolean getOfferBoolean;

    public String getSessionId() {
        return (String.valueOf(this.sessionId));
    }

    public String getOrderId() {
        return (String.valueOf(this.orderId));
    }

    public String getCheckNumber() {
        return (String.valueOf(this.checkNumber));
    }

    public String getStatus() {
        String status = "Pending";
        switch (this.status) {
            case 0:
                status = "Pending";
                break;
            case 1:
                status = "Preparing";
                break;
            case 2:
                status = "Ready";
                break;
            case 3:
                status = "Delivered";
                break;
            case 4:
                status = "Canceled";
                break;
        }
        return status.toUpperCase();
    }
}
