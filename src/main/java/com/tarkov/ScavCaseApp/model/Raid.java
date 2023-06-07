package com.tarkov.ScavCaseApp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "raids")
public class Raid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    private int costOfSendingScavs;

    private String typeOfGivenItem;
    private int valueOfReceivedItems;
    private boolean isCompleted;

    @OneToMany(mappedBy = "raid")
    private List<RaidItems> raidItems;

    public Raid(User user, int costOfSendingScavs, String typeOfGivenItem, int valueOfReceivedItems, boolean isCompleted) {
        this.user = user;
        this.costOfSendingScavs = costOfSendingScavs;
        this.typeOfGivenItem = typeOfGivenItem;
        this.valueOfReceivedItems = valueOfReceivedItems;
        this.isCompleted = isCompleted;

    }

    public Raid() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public int getValueOfReceivedItems() {
        return valueOfReceivedItems;
    }

    public void setValueOfReceivedItems(int valueOfReceivedItems) {
        this.valueOfReceivedItems = valueOfReceivedItems;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }

    public List<RaidItems> getRaidItems() {
        return raidItems;
    }

    public void setRaidItems(List<RaidItems> raidItems) {
        this.raidItems = raidItems;
    }

    @Override
    public String toString() {
        return "Raid{" +
                "id=" + id +
                ", user=" + user +
                ", costOfSendingScavs=" + costOfSendingScavs +
                ", typeOfGivenItem='" + typeOfGivenItem + '\'' +
                ", valueOfReceivedItems=" + valueOfReceivedItems +
                ", isCompleted=" + isCompleted +
                ", items=" + raidItems +
                '}';
    }
}
