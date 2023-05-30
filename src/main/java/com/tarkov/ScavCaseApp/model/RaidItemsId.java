package com.tarkov.ScavCaseApp.model;

import java.io.Serializable;
import java.util.Objects;

public class RaidItemsId implements Serializable {

    private int raid;
    private int item;

    public int getRaid() {
        return raid;
    }

    public void setRaid(int raid) {
        this.raid = raid;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaidItemsId that = (RaidItemsId) o;
        return raid == that.raid && item == that.item;
    }

    @Override
    public int hashCode() {
        return Objects.hash(raid, item);
    }
}
