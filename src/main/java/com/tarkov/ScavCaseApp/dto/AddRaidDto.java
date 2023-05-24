package com.tarkov.ScavCaseApp.dto;

import com.tarkov.ScavCaseApp.model.User;

public class AddRaidDto {

    private float costOfSendingScavs;

    private String typeOfGivenItem;
    private float valueOfReceivedItems;
    private User user;

    public AddRaidDto(float costOfSendingScavs, String typeOfGivenItem, float valueOfReceivedItems, User user) {
        this.costOfSendingScavs = costOfSendingScavs;
        this.typeOfGivenItem = typeOfGivenItem;
        this.user = user;
    }

    public AddRaidDto() {
    }

    public float getCostOfSendingScavs() {
        return costOfSendingScavs;
    }

    public void setCostOfSendingScavs(float costOfSendingScavs) {
        this.costOfSendingScavs = costOfSendingScavs;
    }

    public String getTypeOfGivenItem() {
        return typeOfGivenItem;
    }

    public void setTypeOfGivenItem(String typeOfGivenItem) {
        this.typeOfGivenItem = typeOfGivenItem;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
