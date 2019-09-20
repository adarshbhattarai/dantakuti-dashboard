package com.dantakuti.dashboard.document;

import org.springframework.data.annotation.Id;

/**
 * @author adarshbhattarai on 2019-09-09
 * @project dashboard
 */
//@Document
public class Sewa {

    @Id
    private Integer id;
//    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String name;
    private String shortDescription;
    private String picture;
    private String cost;
    private String description;

    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
