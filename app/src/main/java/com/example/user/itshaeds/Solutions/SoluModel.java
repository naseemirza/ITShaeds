package com.example.user.itshaeds.Solutions;

/**
 * Created by User on 29-Aug-18.
 */

public class SoluModel {

    private String id;
    private String name;
    private String desc;
    private String uprice;
    private String psted;
    private String evntstart;
    private String evntend;

    public SoluModel(String id, String name, String desc, String uprice, String psted, String evntstart, String evntend) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.uprice = uprice;
        this.psted = psted;
        this.evntstart = evntstart;
        this.evntend = evntend;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUprice() {
        return uprice;
    }

    public void setUprice(String uprice) {
        this.uprice = uprice;
    }

    public String getPsted() {
        return psted;
    }

    public void setPsted(String psted) {
        this.psted = psted;
    }

    public String getEvntstart() {
        return evntstart;
    }

    public void setEvntstart(String evntstart) {
        this.evntstart = evntstart;
    }

    public String getEvntend() {
        return evntend;
    }

    public void setEvntend(String evntend) {
        this.evntend = evntend;
    }
}
