package com.tarkov.ScavCaseApp.dto;

import com.tarkov.ScavCaseApp.model.User;

public class AddRaidDto {

    private int costOfSendingScavs;

    private String typeOfGivenItem;
    private int valueOfReceivedItems;
    private User user;

    public AddRaidDto(int costOfSendingScavs, String typeOfGivenItem, int valueOfReceivedItems, User user) {
        this.costOfSendingScavs = costOfSendingScavs;
        this.typeOfGivenItem = typeOfGivenItem;
        this.user = user;
    }

    public AddRaidDto() {
    }

    public int getCostOfSendingScavs() {
        return costOfSendingScavs;
    }

    public void setCostOfSendingScavs(int costOfSendingScavs) {
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
