package com.example.foodjidelivery.models.DelhiveryBoyCreate;

import com.google.gson.annotations.SerializedName;

public class DeliveryBoyCreate {
    @SerializedName("super")
    private SuperAdminUser superAdminUser;

    private DeliveryBoyUser deliveryGuy;


    public DeliveryBoyCreate(SuperAdminUser superAdminUser , DeliveryBoyUser deliveryGuy) {
        this.superAdminUser = superAdminUser;
        this.deliveryGuy = deliveryGuy;
    }

    public SuperAdminUser getSuperAdminUser() {
        return superAdminUser;
    }

    public void setSuperAdminUser(SuperAdminUser superAdminUser) {
        this.superAdminUser = superAdminUser;
    }

    public DeliveryBoyUser getDeliveryGuy() {
        return deliveryGuy;
    }

    public void setDeliveryGuy(DeliveryBoyUser deliveryGuy) {
        this.deliveryGuy = deliveryGuy;
    }
}
