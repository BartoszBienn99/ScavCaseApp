package com.tarkov.ScavCaseApp.model;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;
    private String shortName;
    private String imageUrl;

    @OneToMany(mappedBy = "item")
    List<RaidItems> raidItems;

    public Item(int id, String fullName, String shortName, String imageUrl) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.imageUrl = imageUrl;

    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<RaidItems> getRaidItems() {
        return raidItems;
    }

    public void setRaidItems(List<RaidItems> raidItems) {
        this.raidItems = raidItems;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", raids=" + raidItems +
                '}';
    }
}
