package com.tarkov.ScavCaseApp.model;



import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;
    private String shortName;
    private String imageUrl;

    @ManyToMany(mappedBy = "items")
    Set<Raid> raids = new HashSet<>();

    public Item(int id, String fullName, String shortName, String imageUrl, Set<Raid> raids) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.imageUrl = imageUrl;
        this.raids = raids;
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

    public Set<Raid> getRaids() {
        return raids;
    }

    public void setRaids(Set<Raid> raids) {
        this.raids = raids;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", raids=" + raids +
                '}';
    }
}
