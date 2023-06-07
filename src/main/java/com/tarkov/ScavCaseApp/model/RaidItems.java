package com.tarkov.ScavCaseApp.model;

import javax.persistence.*;

@Entity
@Table(name = "raid_items")
public class RaidItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "raid_id", referencedColumnName = "id")
    private Raid raid;


    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;


    @Column(name = "item_value")
    private int itemValue;


    public RaidItems(Raid raid, Item item, int itemValue) {
        this.raid = raid;
        this.item = item;
        this.itemValue = itemValue;
    }

    public RaidItems() {
    }

    public Raid getRaid() {
        return raid;
    }

    public void setRaid(Raid raid) {
        this.raid = raid;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemValue() {
        return itemValue;
    }

    public void setItemValue(int itemValue) {
        this.itemValue = itemValue;
    }
}
