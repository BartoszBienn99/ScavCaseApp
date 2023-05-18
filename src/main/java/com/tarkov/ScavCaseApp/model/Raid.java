package com.tarkov.ScavCaseApp.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "raids")
public class Raid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    private float costOfSendingScavs;
    private float valueOfReceivedItems;
    private boolean isCompleted;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "raid_items",
            joinColumns = { @JoinColumn(name = "raid_id")},
            inverseJoinColumns = { @JoinColumn(name = "item_id")}
    )
    Set<Item> items = new HashSet<>();

    public Raid(int id, User user, float costOfSendingScavs, float valueOfReceivedItems, boolean isCompleted, Set<Item> items) {
        this.id = id;
        this.user = user;
        this.costOfSendingScavs = costOfSendingScavs;
        this.valueOfReceivedItems = valueOfReceivedItems;
        this.isCompleted = isCompleted;
        this.items = items;
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

    public float getCostOfSendingScavs() {
        return costOfSendingScavs;
    }

    public void setCostOfSendingScavs(float costOfSendingScavs) {
        this.costOfSendingScavs = costOfSendingScavs;
    }

    public float getValueOfReceivedItems() {
        return valueOfReceivedItems;
    }

    public void setValueOfReceivedItems(float valueOfReceivedItems) {
        this.valueOfReceivedItems = valueOfReceivedItems;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Raid{" +
                "id=" + id +
                ", user=" + user +
                ", costOfSendingScavs=" + costOfSendingScavs +
                ", valueOfReceivedItems=" + valueOfReceivedItems +
                ", isCompleted=" + isCompleted +
                ", items=" + items +
                '}';
    }
}
