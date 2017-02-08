package hyprloco.hyprloco_android_sdk.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import hyprloco.hyprloco_android_sdk.RegisterCustomerRequest;

/**
 * Created by aaron on 5/26/2016.
 */
public class NormCustomerResponse extends RegisterCustomerRequest {
    @SerializedName("id")
    public long customerId;
    public NormOrder order;
    public int deviceType;
    public List<String> favorites;
    public String telemetricsKey;
    public String telemetricsUrl;
}
